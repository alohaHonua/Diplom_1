import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.mockito.Mockito;
import praktikum.Bun;
import praktikum.Burger;
import praktikum.Ingredient;
import praktikum.IngredientType;

import static praktikum.IngredientType.FILLING;
import static praktikum.IngredientType.SAUCE;

@RunWith(Parameterized.class)
public class BurgerTest {
    private final Ingredient stabIngredient = Mockito.mock(Ingredient.class);
    private final String ingredientName;
    private final float cheesePrice;
    private final IngredientType ingredientType;
    private Burger testBurger;
    private final Bun stabBun = Mockito.mock(Bun.class);
    private final float bunPrice;
    private final String bunName;

    public BurgerTest(float bunPrice, String bunName, String ingredientName, float ingredientPrice, IngredientType ingredientType) {
        this.bunPrice = bunPrice;
        this.bunName = bunName;
        this.ingredientName = ingredientName;
        this.cheesePrice = ingredientPrice;
        this.ingredientType = ingredientType;
    }

    @Parameterized.Parameters
    public static Object[] getProperty(){
        return new Object[][]{
                {10, "Just bun", "Cheese", 10, FILLING},
                {20, "No_bug_Bun", "Meat", 0, SAUCE},
        };
    }


    @Before
    public void setUp(){
        testBurger = new Burger();
    }

    @Test
    public void addIngredient(){
        testBurger.addIngredient(stabIngredient);
        Assert.assertEquals(1,testBurger.ingredients.size());
    }

    @Test
    public void removeIngredient(){
        testBurger.ingredients.add(stabIngredient);
        testBurger.removeIngredient(0);
        Assert.assertEquals(0,testBurger.ingredients.size());
    }

    @Test
    public void moveIngredient(){
        testBurger.ingredients.add(stabIngredient);
        testBurger.ingredients.add(stabIngredient);
        testBurger.ingredients.add(stabIngredient);

        String expectedIngredient = testBurger.ingredients.get(0).toString();
        testBurger.moveIngredient(0,2);
        Assert.assertEquals(expectedIngredient, testBurger.ingredients.get(2).toString());
    }

    @Test
    public void burgerGetPrice(){
        testBurger.setBuns(stabBun);
        testBurger.addIngredient(stabIngredient);
        Mockito.when(stabBun.getPrice()).thenReturn(bunPrice);
        Mockito.when(stabIngredient.getPrice()).thenReturn(cheesePrice);
        float expectedPrice = bunPrice * 2 + cheesePrice;
        Assert.assertEquals(expectedPrice, testBurger.getPrice(),0.0);
    }

    @Test
    public void burgerGetReceipt(){
        testBurger.setBuns(stabBun);
        testBurger.ingredients.add(stabIngredient);
        testBurger.ingredients.add(stabIngredient);

        Mockito.when(stabBun.getName()).thenReturn(bunName);
        Mockito.when(stabBun.getPrice()).thenReturn(bunPrice);

        Mockito.when(stabIngredient.getPrice()).thenReturn(cheesePrice);
        Mockito.when(stabIngredient.getName()).thenReturn(ingredientName);
        Mockito.when(stabIngredient.getType()).thenReturn(ingredientType);

        String burgerReceipt = testBurger.getReceipt();
        Assert.assertTrue(
                burgerReceipt.contains(bunName) &&
                burgerReceipt.contains(ingredientName) &&
                burgerReceipt.contains(ingredientType.toString().toLowerCase()) &&
                burgerReceipt.contains("Price"));
    }
}
