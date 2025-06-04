package Praktikum;

import org.junit.After;
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

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

@RunWith(Parameterized.class)
public class BurgerParameterizedTests {

    @Mock
    private Bun bun;

    private Ingredient ingredient;
    private Burger burger;

    private final IngredientType ingredientType;
    private final String ingredientName;
    private final float ingredientPrice;

    public BurgerParameterizedTests(IngredientType ingredientType, String ingredientName, float ingredientPrice) {
        this.ingredientType = ingredientType;
        this.ingredientName = ingredientName;
        this.ingredientPrice = ingredientPrice;
    }

    @Parameterized.Parameters
    public static Object[][] dataIngredients() {
        return new Object[][]{
                {IngredientType.SAUCE, "Соус с шипами Антарианского плоскоходца", 88.0f},
                {IngredientType.FILLING, "Мясо бессмертных моллюсков Protostomia", 1337.0f},
                {IngredientType.FILLING, "Сыр с астероидной плесенью", 4142.0f},
        };
    }

    @Before
    public void setUp() {
        MockitoAnnotations.openMocks(this);
        burger = new Burger();

        when(bun.getName()).thenReturn("Краторная булка N-200i");
        when(bun.getPrice()).thenReturn(1255.0f);

        ingredient = new Ingredient(ingredientType, ingredientName, ingredientPrice);
    }

    @After
    public void tearDown() {
        ingredient = null;
    }

    @Test
    public void testAddIngredient() {
        burger.setBuns(bun);
        burger.addIngredient(ingredient);

        assertEquals(1, burger.ingredients.size());
        assertEquals(ingredient, burger.ingredients.get(0));
    }

    @Test
    public void testRemoveIngredient() {
        burger.setBuns(bun);
        burger.addIngredient(ingredient);
        burger.addIngredient(ingredient);
        burger.removeIngredient(1);

        assertEquals(1, burger.ingredients.size());
        assertEquals(ingredient, burger.ingredients.get(0));
    }

    @Test
    public void testMoveIngredient() {
        burger.setBuns(bun);
        burger.addIngredient(ingredient);
        burger.addIngredient(ingredient);
        burger.moveIngredient(0, 1);

        assertEquals(ingredient, burger.ingredients.get(0));
        assertEquals(ingredient, burger.ingredients.get(1));
    }

    @Test
    public void testGetPrice() {
        burger.setBuns(bun);
        burger.addIngredient(ingredient);
        burger.addIngredient(ingredient);

        float expectedPrice = bun.getPrice() * 2 + ingredient.getPrice() * 2;
        assertEquals(expectedPrice, burger.getPrice(), 0.01);
    }

    @Test
    public void testGetReceipt() {
        burger.setBuns(bun);
        burger.addIngredient(ingredient);
        burger.addIngredient(ingredient);

        String expectedReceipt = String.format("(==== %s ====)%n= %s %s =%n= %s %s =%n(==== %s ====)%n%nPrice: %f%n",
                bun.getName(), ingredient.getType().toString().toLowerCase(), ingredient.getName(),
                ingredient.getType().toString().toLowerCase(), ingredient.getName(),
                bun.getName(), burger.getPrice());

        assertEquals(expectedReceipt, burger.getReceipt());
    }
}