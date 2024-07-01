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

    Burger burger = new Burger();

    @Mock
    Bun bun;
    Ingredient ingredient;

    @Before
    public void fillListIngredients(){
        burger.ingredients.add(new Ingredient(IngredientType.SAUCE, "Mayonnaise", 4.0f));
        burger.ingredients.add(new Ingredient(IngredientType.FILLING, "Iceberg lettuce", 3.0f));
        burger.ingredients.add(new Ingredient(IngredientType.SAUCE, "Mustard", 2.0f));
        burger.ingredients.add(new Ingredient(IngredientType.FILLING, "Tomatoes", 5.0f));
    }

    @Test
    public void addIngredientTest(){
        int count = burger.ingredients.size();
        burger.addIngredient(ingredient);
        int newCount = burger.ingredients.size();
        Assert.assertEquals(count, (newCount-1));
    }

    @Test
    public void removeIngredientTest(){
        int count = burger.ingredients.size();
        burger.removeIngredient(0);
        int newCount = burger.ingredients.size();
        Assert.assertEquals((count - 1), newCount);
    }

    @Test
    public void moveIngredientTest(){
        Ingredient expected = burger.ingredients.get(0);
        burger.moveIngredient(0, 1);
        Ingredient actual1 = burger.ingredients.get(1);
        Ingredient actual2 = burger.ingredients.get(0);
        Assert.assertEquals(expected, actual1);
        Assert.assertNotEquals(expected, actual2);
    }

    @Test
    public void getPriceTest(){
        burger.setBuns(bun);
        Mockito.when(bun.getPrice()).thenReturn(10.0f);
        float actual = burger.getPrice();
        float expected = 34.0f;
        Assert.assertEquals(expected, actual, 0);
    }

    @Test
    public void getReceiptTest(){
        burger.setBuns(bun);
        Mockito.when(bun.getName()).thenReturn("White bun");
        boolean result = burger.getReceipt().contains("White bun");
        Assert.assertTrue(result);
    }

    @After
    public void clearingListIngredients(){
        burger.ingredients.clear();
    }
}
