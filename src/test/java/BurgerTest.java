import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import praktikum.Bun;
import praktikum.Burger;
import praktikum.Ingredient;
import praktikum.IngredientType;

import java.text.DecimalFormat;
import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

@RunWith(Parameterized.class)
public class BurgerTest {

    @Mock
    private Bun bun;

    @Mock
    private Ingredient ingredient1;

    @Mock
    private Ingredient ingredient2;

    private Burger burger;

    @Parameterized.Parameter(0)
    public IngredientType ingredientType1;

    @Parameterized.Parameter(1)
    public String ingredientName1;

    @Parameterized.Parameter(2)
    public float ingredientPrice1;

    @Parameterized.Parameter(3)
    public IngredientType ingredientType2;

    @Parameterized.Parameter(4)
    public String ingredientName2;

    @Parameterized.Parameter(5)
    public float ingredientPrice2;

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {IngredientType.SAUCE, "Ketchup", 0.5f, IngredientType.FILLING, "Lettuce", 0.3f},
                {IngredientType.SAUCE, "Mustard", 0.4f, IngredientType.FILLING, "Tomato", 0.7f},
                {IngredientType.SAUCE, "Mayonnaise", 0.6f, IngredientType.FILLING, "Onion", 0.2f}
        });
    }

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        burger = new Burger();
        burger.setBuns(bun);

        when(bun.getName()).thenReturn("Sesame");
        when(bun.getPrice()).thenReturn(1.0f);

        when(ingredient1.getType()).thenReturn(ingredientType1);
        when(ingredient1.getName()).thenReturn(ingredientName1);
        when(ingredient1.getPrice()).thenReturn(ingredientPrice1);

        when(ingredient2.getType()).thenReturn(ingredientType2);
        when(ingredient2.getName()).thenReturn(ingredientName2);
        when(ingredient2.getPrice()).thenReturn(ingredientPrice2);

        burger.addIngredient(ingredient1);
        burger.addIngredient(ingredient2);
    }

    @Test
    public void testGetPrice() {
        float expectedPrice = 2.0f + ingredientPrice1 + ingredientPrice2;
        assertEquals(expectedPrice, burger.getPrice(), 0.0f);
    }

    @Test
    public void testGetReceipt() {
        // Ожидаемая строка с рецептом
        String expectedReceipt = String.format(
                "(==== Sesame ====)%n" +
                        "= %s %s =%n" +
                        "= %s %s =%n" +
                        "(==== Sesame ====)%n" +
                        "%nPrice: %.6f%n",
                ingredientType1.toString().toLowerCase(), ingredientName1,
                ingredientType2.toString().toLowerCase(), ingredientName2,
                2.0f + ingredientPrice1 + ingredientPrice2
        );

        assertEquals(expectedReceipt, burger.getReceipt());
    }

    @Test
    public void testAddIngredient() {
        Ingredient ingredient3 = new Ingredient(IngredientType.FILLING, "Bacon", 1.0f);
        burger.addIngredient(ingredient3);
        assertEquals(3, burger.ingredients.size());
        assertEquals("Bacon", burger.ingredients.get(2).getName());
    }

    @Test
    public void testRemoveIngredient() {
        burger.removeIngredient(0);
        assertEquals(1, burger.ingredients.size());
        assertEquals(ingredientName2, burger.ingredients.get(0).getName());
    }

    @Test
    public void testMoveIngredient() {
        burger.moveIngredient(0, 1);
        assertEquals(ingredientName2, burger.ingredients.get(0).getName());
        assertEquals(ingredientName1, burger.ingredients.get(1).getName());
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testMoveIngredientOutOfBounds() {
        burger.moveIngredient(0, 2);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testRemoveIngredientOutOfBounds() {
        burger.removeIngredient(2);
    }
}
