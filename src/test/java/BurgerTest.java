import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import praktikum.*;


import static org.junit.Assert.*;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class BurgerTest {
    private static final float DELTA = 0.001f;
    private Burger burger;

    private Database db;

    @Mock
    private Bun bun;

    @Mock
    private Ingredient ingredient1;

    @Mock
    private Ingredient ingredient2;

    @Before
    public void setUp() {
        burger = new Burger();
    }

    @Test
    public void setBunsTest() {
        burger.setBuns(bun);

        assertSame(bun, burger.bun);
    }

    @Test
    public void addIngredientTest() {
        burger.addIngredient(ingredient1);

        assertEquals(1, burger.ingredients.size());
    }

    @Test
    public void removeIngredientTest() {
        burger.addIngredient(ingredient1);
        burger.removeIngredient(0);

        assertTrue("Список ингредиентов пуст", burger.ingredients.isEmpty());
    }

    @Test (expected = IndexOutOfBoundsException.class)
    public void removeIngredientWithInvalidIndexTest() {
        burger.removeIngredient(0);
    }


    @Test
    public void moveFirstIngredientTest() {

        burger.addIngredient(ingredient1);
        burger.addIngredient(ingredient2);

        burger.moveIngredient(0, 1);

        assertSame("Первый элемент должен измениться",
                ingredient2, burger.ingredients.get(0));
    }

    @Test
    public void moveSecondIngredientTest() {

        burger.addIngredient(ingredient1);
        burger.addIngredient(ingredient2);

        burger.moveIngredient(0, 1);

        assertSame("Второй элемент должен измениться",
                ingredient1, burger.ingredients.get(1));
    }

    @Test
    public void getPriceForBunAndAllIngredientsTest() {

        when(bun.getPrice()).thenReturn(100f);
        when(ingredient1.getPrice()).thenReturn(50f);
        when(ingredient2.getPrice()).thenReturn(75f);

        burger.setBuns(bun);
        burger.addIngredient(ingredient1);
        burger.addIngredient(ingredient2);

        float expectedPrice = 100f * 2 + 50f + 75f;
        assertEquals(expectedPrice, burger.getPrice(), DELTA);
    }

    @Test
    public void getReceiptWithAllIngredientsTest() {

        when(bun.getName()).thenReturn("white bun");
        when(bun.getPrice()).thenReturn(200f);
        when(ingredient1.getType()).thenReturn(IngredientType.SAUCE);
        when(ingredient1.getName()).thenReturn("hot sauce");
        when(ingredient2.getType()).thenReturn(IngredientType.FILLING);
        when(ingredient2.getName()).thenReturn("cutlet");
        burger.setBuns(bun);
        burger.addIngredient(ingredient1);
        burger.addIngredient(ingredient2);

        String expected = String.format("(==== %s ====)%n", bun.getName()) +
                String.format("= %s %s =%n", "sauce", "hot sauce") +
                String.format("= %s %s =%n", "filling", "cutlet") +
                String.format("(==== %s ====)%n", bun.getName()) +
                String.format("%nPrice: %f%n", burger.getPrice());

        assertEquals(expected, burger.getReceipt());
    }

}