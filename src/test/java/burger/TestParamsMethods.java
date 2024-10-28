package burger;

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
import static org.junit.Assert.fail;

@RunWith(Parameterized.class)
public class TestParamsMethods {
    @Mock
    Ingredient ingredient;
    @Mock
    Bun bun;
    int ingredientAmount;
    float ingredientPrice;
    float bunPrice;
    boolean bunInitialized;

    public TestParamsMethods(int ingredientAmount, float ingredientPrice, float bunPrice, boolean bunInitialized){
        this.ingredientAmount = ingredientAmount;
        this.ingredientPrice = ingredientPrice;
        this.bunPrice = bunPrice;
        this.bunInitialized = bunInitialized;
    }

    @Before
    public void init() {
        MockitoAnnotations.initMocks(this);
        Mockito.when(bun.getName()).thenReturn("TestName");
        Mockito.when(ingredient.getName()).thenReturn("TestIngredient");
        Mockito.when(ingredient.getType()).thenReturn(IngredientType.SAUCE);
    }

    @Parameterized.Parameters
    public static Object[][] getParamsInit(){
        return new Object[][]{
                {
                        10, 0F, 20F, true
                },
                {
                        0, 100F, 0F, true
                },
                {
                        2, 100F, 20F, false
                }

        };
    }

    private Burger prepareBurger(){
        Burger burger = new Burger();
        if (bunInitialized){
            burger.setBuns(bun);
        }
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
        try {
            float price = burger.getPrice();
            assertEquals( price, 2*bunPrice + ingredientPrice*ingredientAmount, 0.001);
        }
        catch (Exception e){
            if (!bunInitialized){
                assertEquals("Exception class is not correct", NullPointerException.class, e.getClass());
            }
            else {
                fail("Shouldn't get an exception here!");
            }
        }

    }

    @Test
    public void testGetReceipt(){
        Burger burger = prepareBurger();
        try {
            burger.getReceipt();
            Mockito.verify(ingredient, Mockito.times(ingredientAmount)).getName();
            Mockito.verify(bun, Mockito.times(2)).getName();
            Mockito.verify(ingredient, Mockito.times(ingredientAmount)).getPrice();
            Mockito.verify(bun, Mockito.times(1)).getPrice();
        }
        catch (Exception e){
            if (!bunInitialized){
                assertEquals("Exception class is not correct", NullPointerException.class, e.getClass());
            }
            else {
                fail("Shouldn't get an exception here!");
            }
        }
    }
}
