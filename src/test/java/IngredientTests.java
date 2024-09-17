import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import praktikum.Ingredient;
import praktikum.IngredientType;
@RunWith(Parameterized.class)
public class IngredientTests {


    //testData
    private final IngredientType testType; //= IngredientType.SAUCE;
    private final String testName; //= "TeestName";
    private final float testPrice; //= 0.99F;

    public IngredientTests(IngredientType testType,String testName,float testPrice){
        this.testType = testType;
        this.testName =testName;
        this.testPrice = testPrice;
    }
    @Parameterized.Parameters
    public static Object[][] getCities() {
        return new Object[][] {
                {IngredientType.SAUCE,"TeestName", 666.66F},
                {IngredientType.FILLING,"Начинка", 66.66F},
        };
    }

    Ingredient ingredient ;
    @Before
    public void setUp(){
        ingredient = new Ingredient(testType, testName, testPrice);
    }

    @Test
    public void getTypeReturnsCorrectValue() {
        Assert.assertEquals(testType, ingredient.getType());
    }

    @Test
    public void getNameReturnsCorrectValue() {
        Assert.assertEquals(testName, ingredient.getName());
    }

    @Test
    public void getPriceReturnsCorrectValue() {
        Assert.assertEquals(ingredient.getPrice(), testPrice, 0.0);
    }
}
