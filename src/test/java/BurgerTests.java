import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;
import praktikum.Bun;
import praktikum.Burger;
import praktikum.Ingredient;
import praktikum.IngredientType;

import static org.junit.Assert.*;

public class BurgerTests {

    private Burger burger;
    private Bun bun;
    private Ingredient ingredient;
    private Ingredient ingredient2;

    private final static String EXPECTED_BUN_NAME = "bunName";
    private final static float EXPECTED_BUN_PRICE = 24f;

    private final static String EXPECTED_INGREDIENT_NAME = "ingredientName";
    private final static IngredientType EXPECTED_INGREDIENT_TYPE = IngredientType.SAUCE;
    private final static float EXPECTED_INGREDIENT_PRICE = 24f;
    private final static float DELTA = 0.0001f;

    @Before
    public void setUp() {
        bun = Mockito.mock(Bun.class);
        Mockito.when(bun.getName()).thenReturn(EXPECTED_BUN_NAME);
        Mockito.when(bun.getPrice()).thenReturn(EXPECTED_BUN_PRICE);

        ingredient = Mockito.mock(Ingredient.class);
        Mockito.when(ingredient.getName()).thenReturn(EXPECTED_INGREDIENT_NAME);
        Mockito.when(ingredient.getType()).thenReturn(EXPECTED_INGREDIENT_TYPE);
        Mockito.when(ingredient.getPrice()).thenReturn(EXPECTED_INGREDIENT_PRICE);

        ingredient2 = Mockito.mock(Ingredient.class);
        Mockito.when(ingredient2.getName()).thenReturn(EXPECTED_INGREDIENT_NAME);
        Mockito.when(ingredient2.getType()).thenReturn(EXPECTED_INGREDIENT_TYPE);
        Mockito.when(ingredient2.getPrice()).thenReturn(EXPECTED_INGREDIENT_PRICE);

        burger = new Burger();
    }

    @Test
    public void testSetBuns() {
        burger.setBuns(bun);
        assertEquals(bun, burger.bun);
    }

    @Test
    public void testAddIngredient() {
        burger.addIngredient(ingredient);
        assertTrue(burger.ingredients.contains(ingredient));
    }

    @Test
    public void testRemoveIngredient() {
        burger.addIngredient(ingredient);
        burger.addIngredient(ingredient2);

        burger.removeIngredient(0);
        assertFalse(burger.ingredients.contains(ingredient));
        assertTrue(burger.ingredients.contains(ingredient2));
    }

    @Test
    public void testMoveIngredient() {
        burger.addIngredient(ingredient);
        burger.addIngredient(ingredient2);

        burger.moveIngredient(0, 1); // move hot sauce to index 1
        assertEquals(ingredient2, burger.ingredients.get(0)); // sour cream should be at index 0
        assertEquals(ingredient, burger.ingredients.get(1)); // hot sauce should be at index 1
    }

    @Test
    public void testGetPrice() {
        burger.setBuns(bun);
        burger.addIngredient(ingredient);
        burger.addIngredient(ingredient2);

        float expectedPrice = bun.getPrice() * 2 + ingredient.getPrice() + ingredient2.getPrice();
        assertEquals(expectedPrice, burger.getPrice(), DELTA);
    }

    @Test
    public void testGetReceipt() {
        burger.setBuns(bun);
        burger.addIngredient(ingredient);

        String expectedReceipt = String.format("(==== %s ====)%n= sauce ingredientName =%n(==== %s ====)%n%nPrice: %f%n",
                bun.getName(), bun.getName(), burger.getPrice());

        assertEquals(expectedReceipt, burger.getReceipt());
    }
}