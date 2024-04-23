import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.mockito.Mockito;
import praktikum.Bun;
import praktikum.Burger;
import praktikum.Ingredient;

import static praktikum.IngredientType.FILLING;
import static praktikum.IngredientType.SAUCE;

@RunWith(Parameterized.class)
public class BurgerTest {
    private Ingredient ingredientCheese;
    private Ingredient ingredientMeet;
    private Ingredient ingredientKetchup;

    private float cheesePrice;
    private float meetPrice;
    private float ketchupPrice;
    private Burger testBurger;
    private Bun stabBun = Mockito.mock(Bun.class);
    private float bunPrice;
    private String bunName;

    public BurgerTest(float bunPrice, String bunName, float cheesePrice, float meetPrice, float ketchupPrice) {
        this.bunPrice = bunPrice;
        this.bunName = bunName;
        this.cheesePrice = cheesePrice;
        this.meetPrice = meetPrice;
        this.ketchupPrice = ketchupPrice;
    }

    @Parameterized.Parameters
    public static Object[] getProperty(){
        return new Object[][]{
                {10, "Just bun", 10, 20, 5},
                {20, "No bug Bun", 10, 100, 1},
        };
    }


    @Before
    public void setUp(){
        testBurger = new Burger();
        ingredientCheese = new Ingredient(FILLING,"Cheese", cheesePrice);
        ingredientMeet = new Ingredient(FILLING,"Meet", meetPrice);
        ingredientKetchup = new Ingredient(SAUCE,"Ketchup", ketchupPrice);
    }

    @Test
    public void addIngredient(){
        testBurger.addIngredient(ingredientCheese);
        Assert.assertEquals(1,testBurger.ingredients.size());
    }

    @Test
    public void removeIngredient(){
        testBurger.ingredients.add(ingredientMeet);
        testBurger.removeIngredient(0);
        Assert.assertEquals(0,testBurger.ingredients.size());
    }

    @Test
    public void moveIngredient(){
        testBurger.ingredients.add(ingredientMeet);
        testBurger.ingredients.add(ingredientCheese);
        testBurger.ingredients.add(ingredientKetchup);

        String expectedIngredient = testBurger.ingredients.get(0).toString();
        testBurger.moveIngredient(0,2);
        Assert.assertEquals(expectedIngredient, testBurger.ingredients.get(2).toString());
    }

    @Test
    public void burgerGetPrice(){
        testBurger.setBuns(stabBun);
        Mockito.when(stabBun.getPrice()).thenReturn(bunPrice);
        float expectedPrice = bunPrice * 2;
        Assert.assertEquals(expectedPrice, testBurger.getPrice(),0.0);
    }

    @Test
    public void burgerGetReceipt(){
        testBurger.setBuns(stabBun);
        testBurger.ingredients.add(ingredientMeet);

        Mockito.when(stabBun.getName()).thenReturn(bunName);
        Mockito.when(stabBun.getPrice()).thenReturn(bunPrice);
        String burgerReceipt = testBurger.getReceipt();

        System.out.println(burgerReceipt);
        Assert.assertTrue(
                burgerReceipt.contains(bunName) &&
                burgerReceipt.contains("Meet") &&
                burgerReceipt.contains("filling") &&
                burgerReceipt.contains("Price"));
    }
}
