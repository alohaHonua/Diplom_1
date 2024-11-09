package praktikum;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.Assert.*;

@RunWith(MockitoJUnitRunner.class)
public class BurgerTest {
    private static final int DELTA = 0;

    @Mock
    Bun testBun;

    @Mock
    Ingredient testIngredient;

    @Test
    public void setBun() {
        Burger burger = new Burger();
        burger.setBuns(testBun);
        assertEquals(testBun, burger.bun);

    }

    @Test
    public void addIngredientBurgerTest() {
        Burger burger = new Burger();
        burger.addIngredient(testIngredient);
        assertTrue(burger.ingredients.contains(testIngredient));

    }

    @Test
    public void removeIngredientBurgerTest() {
        Burger burger = new Burger();
        burger.addIngredient(testIngredient);
        burger.removeIngredient(0);
        assertFalse(burger.ingredients.contains(testIngredient));
    }

    @Test
    public void moveIngredientBurgerTest() {
        Burger burger = new Burger();
        burger.addIngredient(new Ingredient(IngredientType.FILLING, "Биокотлета из марсианской Магнолии", 424));
        burger.addIngredient(new Ingredient(IngredientType.SAUCE, "Соус Spicy-X", 90));
        burger.moveIngredient(0, 1);
        assertEquals("Биокотлета из марсианской Магнолии", burger.ingredients.get(1).name);
    }

    @Test
    public void getPriceBurgerTest() {
        Burger burger = new Burger();
        float bunPrice = 100;
        float ingredientPrice = 200;
        Mockito.when(testBun.getPrice()).thenReturn(bunPrice);
        Mockito.when(testIngredient.getPrice()).thenReturn(ingredientPrice);
        burger.setBuns(testBun);
        burger.addIngredient(testIngredient);
        assertEquals(bunPrice * 2 + ingredientPrice, burger.getPrice(), DELTA);
    }

    @Test
    public void getReceiptBurgerTest() {
        Burger burger = new Burger();
        burger.setBuns(testBun);
        burger.addIngredient(new Ingredient(IngredientType.FILLING, "cutlet", 100));
        burger.addIngredient(new Ingredient(IngredientType.SAUCE, "chili sauce", 300));
        String expectedReceipt = burger.getReceipt();
        assertEquals(expectedReceipt, burger.getReceipt());
        System.out.println(burger.getReceipt());
    }
}
