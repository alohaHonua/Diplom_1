package praktikum;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class BurgerClassTests {
    private final float price = 5;
    Burger burger = new Burger();
    @Mock
    Ingredient ingredient;
    @Mock
    Bun bun;

    @Test
    public void testSetBuns() {
        burger.setBuns(bun);
        Assert.assertEquals(bun, burger.bun);
    }

    @Test
    public void testAddIngredient() {
        burger.addIngredient(ingredient);
        Assert.assertTrue(burger.ingredients.contains(ingredient));
    }

    @Test
    public void testRemoveIngredient() {
        burger.addIngredient(ingredient);
        burger.removeIngredient(0);
        Assert.assertFalse(burger.ingredients.contains(ingredient));
    }

    @Test
    public void testMoveIngredient() {
        burger.addIngredient(new Ingredient(IngredientType.FILLING,"NameFilling", price));
        burger.addIngredient(new Ingredient(IngredientType.SAUCE, "NameSauce", price));
        burger.moveIngredient(1, 0);
        String expected = "NameSauce";
        Assert.assertEquals(expected, burger.ingredients.get(0).name);
    }

    @Test
    public void testGetPrice() {
        burger.setBuns(bun);
        burger.addIngredient(ingredient);
        Mockito.when(bun.getPrice()).thenReturn(price);
        Mockito.when(ingredient.getPrice()).thenReturn(price);
        float expected = price * 2 + price;
        Assert.assertEquals(expected, burger.getPrice(), 0.0);
    }

    @Test
    public void testGetReceipt() {
        burger.setBuns(bun);
        burger.addIngredient(new Ingredient(IngredientType.FILLING,"NameFilling", price));
        burger.addIngredient(new Ingredient(IngredientType.SAUCE, "NameSauce", price));
        String expected = burger.getReceipt();
        Assert.assertEquals(expected, burger.getReceipt());
    }
}
