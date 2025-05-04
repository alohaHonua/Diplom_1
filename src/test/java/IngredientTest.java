import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import praktikum.Ingredient;
import praktikum.IngredientType;
import java.util.Random;
import static org.junit.Assert.assertEquals;

public class IngredientTest {
    private String testName;
    private float testPrice;

    @Mock
    IngredientType mockType = IngredientType.SAUCE;

    @Before
    public void setTestData(){
        Random random = new Random();
        testName = "testName" + random.nextInt(1000000);
        testPrice = random.nextFloat();
    }

    @Test
    public void getPriceTest(){
        Ingredient ingredient = new Ingredient(mockType, testName, testPrice);
        assertEquals(testPrice, ingredient.getPrice(), 0.000001);

    }

    @Test
    public void getNameTest(){
        Ingredient ingredient = new Ingredient(mockType, testName, testPrice);
        assertEquals(testName, ingredient.getName());
    }

}
