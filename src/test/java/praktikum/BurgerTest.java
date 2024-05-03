package praktikum;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;


@RunWith(MockitoJUnitRunner.class)

public class BurgerTest {

    @Before
    public void init() {
        MockitoAnnotations.initMocks(this);
        burger = new Burger();
        mockIngredient = Mockito.mock(Ingredient.class);
    }

    @Mock
    private Bun mockBun;
    private Ingredient mockIngredient;
    private Burger burger;


    @Test
    public void testSetBuns() {
        burger.setBuns(mockBun);
        Assert.assertEquals(mockBun, burger.bun);
    }

    @Test
    public void testAddIngredient() {
        burger.addIngredient(mockIngredient);
        Assert.assertTrue(burger.ingredients.contains(mockIngredient));
    }

    @Test
    public void testRemoveIngredient() {
        burger.addIngredient(mockIngredient);
        burger.removeIngredient(0);
        Assert.assertFalse(burger.ingredients.contains(mockIngredient));
    }

    @Test
    public void testMoveIngredient() {
        Ingredient ingredient1 = new Ingredient(IngredientType.FILLING, "Cheese", 2.5f);
        Ingredient ingredient2 = new Ingredient(IngredientType.FILLING, "Salade", 1.0f);
        burger.addIngredient(ingredient1);
        burger.addIngredient(ingredient2);
        burger.moveIngredient(0, 1);
        Assert.assertEquals(ingredient1, burger.ingredients.get(1));
        Assert.assertEquals(ingredient2, burger.ingredients.get(0));
    }

    @Test
    public void testGetPrice() {
        Mockito.when(mockBun.getPrice()).thenReturn(1.5f);
        Mockito.when(mockIngredient.getPrice()).thenReturn(2.0f);
        burger.setBuns(mockBun);
        burger.addIngredient(mockIngredient);
        Assert.assertEquals(5.0f, burger.getPrice(), 0.001);
    }

    @Test
    public void testGetReceipt() {
        Mockito.when(mockBun.getName()).thenReturn("red bun");
        Mockito.when(mockIngredient.getType()).thenReturn(IngredientType.FILLING);
        Mockito.when(mockIngredient.getName()).thenReturn("cutlet");
        Mockito.when(mockBun.getPrice()).thenReturn(300F);
        Mockito.when(mockIngredient.getPrice()).thenReturn(100f);
        burger.setBuns(mockBun);
        burger.addIngredient(mockIngredient);
        String expectedReceipt = "(==== red bun ====)\r\n= filling cutlet =\r\n(==== red bun ====)\r\n\r\nPrice: 700,000000\r\n";
        Assert.assertEquals("Получен неверный рецепт",expectedReceipt, burger.getReceipt());
    }
}
