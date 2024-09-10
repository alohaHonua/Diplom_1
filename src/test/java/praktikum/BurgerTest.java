package praktikum;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)

public class BurgerTest {
    private Burger burger;
    @Mock
    private Bun bun;
    @Mock
    private Ingredient ingredient;

    @Before
    public void setUp() {
        burger = new Burger();
        burger.setBuns(bun);
        Mockito.when(bun.getName()).thenReturn("BunName");
        Mockito.when(bun.getPrice()).thenReturn(42.0f);
        Mockito.when(ingredient.getPrice()).thenReturn(20.0f);
        Mockito.when(ingredient.getName()).thenReturn("IngredientName");
        Mockito.when(ingredient.getType()).thenReturn(IngredientType.SAUCE);
        burger.ingredients.clear();
        burger.addIngredient(ingredient);
    }

    @After
    public void clearIngredients() {
        burger.ingredients.clear();
    }

    @Test
    public void addIngredient() {
        int size = burger.ingredients.size();
        Assert.assertEquals(1, size);
    }

    @Test
    public void removeIngredient() {
        burger.removeIngredient(0);
        int size = burger.ingredients.size();
        Assert.assertEquals(0, size);
    }

    @Test
    public void moveIngredient() {
        burger.ingredients.add(ingredient);
        burger.moveIngredient(1, 0);
        Ingredient ingredient = burger.ingredients.get(0);
        int size = burger.ingredients.size();
        Assert.assertEquals(2, size);
        Assert.assertNotNull(ingredient);
    }

    @Test
    public void getPrice() {
        float price = burger.getPrice();
        Assert.assertEquals(104.0f, price, 0.05);
    }

    @Test
    public void getReceipt() {
        String receipt = burger.getReceipt();
        Assert.assertTrue(receipt.contains("BunName"));
        Assert.assertTrue(receipt.contains("IngredientName"));
        Assert.assertTrue(receipt.contains("104,0"));
    }
}