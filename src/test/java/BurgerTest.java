import org.junit.Test;
import org.mockito.Mockito;
import org.mockito.Spy;
import praktikum.Bun;
import praktikum.Burger;
import praktikum.Ingredient;
import praktikum.IngredientType;

import java.util.Random;

import static org.junit.Assert.*;

public class BurgerTest {
    private final float expectedBunPrice = 10.25F;
    private final String expectedBunName = "testBunName";
    private final float expectedIngredientPrice = 15.29F;
    private final String expectedIngredientNameSauce = "testIngredientSauce";
    private final String expectedIngredientNameFilling = "testIngredientFilling";
    private final float expectedIngredientPriceSauce = 25.31F;
    private final float expectedIngredientPriceFilling = 52.213F;
    private final String expectedIngredientTypeSauce = "sauce";
    private final String expectedIngredientTypeFilling = "filling";


    @Spy
    Bun spyBun;
    @Test
    public void setBunsTest(){

        Random random = new Random();
        String testName = "testName" + random.nextInt(100000);
        float testPrice = random.nextFloat();

        spyBun = new Bun(testName, testPrice);
        Burger burger = new Burger() ;

        burger.setBuns(spyBun);
        assertEquals( testName, burger.bun.getName() );
        assertEquals( testPrice, burger.bun.getPrice(), 0.000001 );
    }

    @Test
    public void addIngredientTest(){
        Ingredient ingredientMock = Mockito.mock();

        Burger burger = new Burger() ;
        burger.addIngredient(ingredientMock);

        assertTrue(burger.ingredients.contains(ingredientMock));
    }

    @Test
    public void removeIngredientTest(){
        Ingredient ingredientMock = Mockito.mock();

        Burger burger = new Burger() ;
        burger.addIngredient(ingredientMock);
        assertTrue(burger.ingredients.contains(ingredientMock));

        int ingredientIndex = burger.ingredients.indexOf(ingredientMock);
        System.out.println(ingredientIndex);
        burger.removeIngredient(ingredientIndex);
        assertFalse(burger.ingredients.contains(ingredientMock));
    }

    @Test
    public void moveIngredientTest(){
        Ingredient ingredientMock = Mockito.mock();
        Ingredient ingredientMock1 = Mockito.mock();
        Ingredient ingredientMock2 = Mockito.mock();

        Burger burger = new Burger() ;

        burger.addIngredient(ingredientMock);
        burger.addIngredient(ingredientMock1);
        burger.addIngredient(ingredientMock2);

        burger.moveIngredient( burger.ingredients.indexOf(ingredientMock), burger.ingredients.size() - 1 );
        assertEquals(burger.ingredients.size() - 1, burger.ingredients.indexOf(ingredientMock));
    }

    @Test
    public void getPriceTest(){
        Bun bun = Mockito.mock();
        Ingredient ingredient = Mockito.mock();
        Mockito.when(bun.getPrice()).thenReturn(expectedBunPrice);
        Mockito.when(ingredient.getPrice()).thenReturn(expectedIngredientPrice);

        Burger burger = new Burger();
        burger.setBuns(bun);
        burger.addIngredient(ingredient);

        assertEquals(expectedBunPrice * 2 + expectedIngredientPrice, burger.getPrice(), 0.000001);
    }

    @Spy
    Ingredient SpyIngredientSauce = new Ingredient(IngredientType.SAUCE, expectedIngredientNameSauce, expectedIngredientPriceSauce);
    @Spy
    Ingredient SpyIngredientFilling = new Ingredient(IngredientType.FILLING, expectedIngredientNameFilling, expectedIngredientPriceFilling);

    @Test
    public void getReceiptTest(){
        Burger burger = new Burger();

        spyBun = new Bun(expectedBunName, expectedBunPrice);
        burger.setBuns(spyBun);

        burger.addIngredient(SpyIngredientSauce);
        burger.addIngredient(SpyIngredientFilling);

        StringBuilder expectedString = new StringBuilder();
        expectedString.append(String.format("(==== %s ====)%n", expectedBunName));
        expectedString.append(String.format("= %s %s =%n", expectedIngredientTypeSauce, expectedIngredientNameSauce));
        expectedString.append(String.format("= %s %s =%n", expectedIngredientTypeFilling, expectedIngredientNameFilling));
        expectedString.append(String.format("(==== %s ====)%n", expectedBunName));
        float test = expectedBunPrice * 2 + expectedIngredientPriceSauce + expectedIngredientPriceFilling;
        expectedString.append(String.format("%nPrice: %f%n",test));

        assertEquals(expectedString.toString(), burger.getReceipt());
    }
}
