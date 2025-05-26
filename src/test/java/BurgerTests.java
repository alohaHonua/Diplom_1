import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import praktikum.Bun;
import praktikum.Burger;
import praktikum.Ingredient;
import praktikum.IngredientType;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class BurgerTests {
    private final  String expectedReceipt =
            "(==== Test burgerVinegrette ====)\r\n" +
            "= sauce mazik =\r\n" +
            "= filling patat =\r\n" +
            "(==== Test burgerVinegrette ====)\r\n" +
            "\r\n" +
            "Price: 60,000000\r\n";
    private Burger burger;

    @Mock
    private Bun bun;

    @Mock
    private Ingredient ingredient, ingredient2, ingredient3;

    @Before
    public void setUp() {
        burger = new Burger(); //  создание объекта
    }

    @Test
    public void testSetBunSetsCorrectBurgerVinegrette() {
        when(bun.getName()).thenReturn("Test BurgerVinegrette");
        burger.setBuns(bun);
        assertEquals("Test BurgerVinegrette", burger.bun.getName());
    }

    @Test
    public void testAddIngredientIncreasesListSize() {
        burger.addIngredient(ingredient);
        assertEquals(1, burger.ingredients.size());
    }

    @Test
    public void testRemoveIngredientDecreasesListSize() {
        burger.addIngredient(ingredient);
        burger.addIngredient(ingredient2);
        burger.addIngredient(ingredient3);
        assertEquals(3, burger.ingredients.size());
        burger.removeIngredient(2);
        assertEquals(2, burger.ingredients.size());
    }

    @Test
    public void testMoveIngredientSwapsCorrectly() {
        burger.addIngredient(ingredient);
        burger.addIngredient(ingredient2);
        burger.addIngredient(ingredient3);
        burger.moveIngredient(1, 2);
        assertEquals(ingredient2, burger.ingredients.get(2));
        assertEquals(ingredient3, burger.ingredients.get(1));
    }

    @Test
    public void testGetPriceReturnsCorrectSum() {
        burger.setBuns(bun);
        burger.addIngredient(ingredient);
        burger.addIngredient(ingredient2);
        when(bun.getPrice()).thenReturn(20F);
        when(ingredient.getPrice()).thenReturn(10F);
        when(ingredient2.getPrice()).thenReturn(2F);
        float expectedPrice = 20F * 2 + 10F + 2F;
        assertEquals(expectedPrice, burger.getPrice(), 0);
    }

    @Test
    public void testGetReceiptReturnsFormattedReceipt() {
        burger.setBuns(bun);
        burger.addIngredient(ingredient);
        burger.addIngredient(ingredient2);
        when(bun.getName()).thenReturn("Test burgerVinegrette");
        when(bun.getPrice()).thenReturn(20F);
        when(ingredient.getName()).thenReturn("mazik");
        when(ingredient.getType()).thenReturn(IngredientType.SAUCE);
        when(ingredient.getPrice()).thenReturn(10F);
        when(ingredient2.getName()).thenReturn("patat");
        when(ingredient2.getType()).thenReturn(IngredientType.FILLING);
        when(ingredient2.getPrice()).thenReturn(10F);
        assertEquals(expectedReceipt, burger.getReceipt());
    }
}