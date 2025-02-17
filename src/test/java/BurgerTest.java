import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import praktikum.Bun;
import praktikum.Burger;
import praktikum.Ingredient;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static praktikum.IngredientType.*;

@RunWith(MockitoJUnitRunner.class)
public class BurgerTest {

    @Mock
    Bun bun;

    private Ingredient cheeseSauce = new Ingredient(SAUCE, "cheesy", 2.5F);
    private Ingredient cucumberFilling = new Ingredient(FILLING, "cucumber", 1.5F);


    @Test
    public void checkAddIngridient() {
        Burger burger = new Burger();
        burger.addIngredient(cheeseSauce);
        boolean result = burger.ingredients.contains(cheeseSauce);
        assertTrue(result);
    }

    @Test
    public void checkRemoveIngredient() {
        Burger burger = new Burger();
        burger.addIngredient(cucumberFilling);
        burger.removeIngredient(0);
        int actualSize = burger.ingredients.size();
        assertEquals(0, actualSize);
    }

    @Test
    public void checkMoveIngredient() {
        Burger burger = new Burger();
        burger.addIngredient(cheeseSauce);
        burger.addIngredient(cucumberFilling);
        Ingredient firstIngredient = burger.ingredients.get(0);
        burger.moveIngredient(0, 1);
        assertEquals(firstIngredient, burger.ingredients.get(1));
    }

    @Test
    public void checkGetPrice() {
        Burger burger = new Burger();
        burger.setBuns(bun);
        Mockito.when(burger.bun.getPrice()).thenReturn(50F);
        burger.addIngredient(cucumberFilling);
        burger.addIngredient(cheeseSauce);
        float actualsPrice = burger.getPrice();
        float delta = 0.1F;
        assertEquals(104, actualsPrice, delta);
    }

    @Test
    public void checkGetReceipt() {
        Burger burger = new Burger();
        burger.setBuns(bun);
        Mockito.when(burger.bun.getName()).thenReturn("White bun");
        burger.addIngredient(cucumberFilling);
        burger.addIngredient(cheeseSauce);
        String actualReceipt = burger.getReceipt();
        String exeptionReceipt = String.format("(==== White bun ====)%n" +
                "= filling cucumber =%n" +
                "= sauce cheesy =%n" +
                "(==== White bun ====)%n" +
                "%n" +
                "Price: 4,000000%n");
        System.out.println(actualReceipt);
        assertEquals(exeptionReceipt, actualReceipt);
    }
}