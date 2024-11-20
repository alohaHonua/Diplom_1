package burger;

import database.Constants;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import praktikum.Bun;
import praktikum.Burger;
import praktikum.Ingredient;
import praktikum.IngredientType;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class TestParamsMethods {
    @Mock
    Ingredient ingredient;
    @Mock
    Bun bun;
    int ingredientAmount;
    float ingredientPrice;
    float bunPrice;

    public TestParamsMethods(int ingredientAmount, float ingredientPrice, float bunPrice){
        this.ingredientAmount = ingredientAmount;
        this.ingredientPrice = ingredientPrice;
        this.bunPrice = bunPrice;
    }

    @Before
    public void init() {
        MockitoAnnotations.initMocks(this);
        Mockito.when(bun.getName()).thenReturn(Constants.TEST_BUN_NAME);
        Mockito.when(ingredient.getName()).thenReturn(Constants.TEST_INGREDIENT_NAME);
        Mockito.when(ingredient.getType()).thenReturn(IngredientType.SAUCE);
    }

    @Parameterized.Parameters
    public static Object[][] getParamsInit(){
        return new Object[][]{
                {
                        10, 0F, 20F
                },
                {
                        0, 100F, 0F
                },
                {
                        2, 100F, 20F
                }

        };
    }

    private Burger prepareBurger(){
        Burger burger = new Burger();

        burger.setBuns(bun);

        for (int i = 0; i<ingredientAmount; i++){
            burger.addIngredient(ingredient);
        }
        Mockito.when(bun.getPrice()).thenReturn(bunPrice);
        Mockito.when(ingredient.getPrice()).thenReturn(ingredientPrice);
        return burger;
    }

    @Test
    public void testGetPrice(){
        Burger burger = prepareBurger();
        float price = burger.getPrice();
        assertEquals( price, 2*bunPrice + ingredientPrice*ingredientAmount, 0.001);
    }

    @Test
    public void testGetReceipt(){
        Burger burger = prepareBurger();
        var receipt = burger.getReceipt();
        Mockito.verify(ingredient, Mockito.times(ingredientAmount)).getName();
        Mockito.verify(bun, Mockito.times(2)).getName();
        Mockito.verify(ingredient, Mockito.times(ingredientAmount)).getPrice();
        Mockito.verify(bun, Mockito.times(1)).getPrice();
        var receiptArray = receipt.split("\r\n");
        assertEquals("Receipt length is not correct", ingredientAmount + 4,receiptArray.length);
        assertEquals("Wrong bun name", String.format("(==== %s ====)", Constants.TEST_BUN_NAME) ,receiptArray[0]);
        for (int i = 0; i < ingredientAmount; i++){
            assertEquals("Wrong ingredient name", String.format("= %s %s =", IngredientType.SAUCE.toString().toLowerCase(),Constants.TEST_INGREDIENT_NAME), receiptArray[i +1]);
        }
        assertEquals("Wrong bun name", String.format("(==== %s ====)", Constants.TEST_BUN_NAME), receiptArray[ingredientAmount + 1]);
        assertEquals("There should be a space ", "", receiptArray[ingredientAmount + 2]);
        assertEquals("Wrong price string", String.format("Price: %f", burger.getPrice()) , receiptArray[ingredientAmount + 3]);
    }
}
