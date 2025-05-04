import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.mockito.Spy;
import praktikum.Ingredient;
import praktikum.IngredientType;

import java.util.Random;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class IngredientGetTypeTest {
    private final String testType;

    public IngredientGetTypeTest(String testType){
        this.testType = testType;
    }

    @Parameterized.Parameters
    public static Object[][] getData(){
        return new Object[][]{
                { "SAUCE" },
                { "FILLING" }
        };
    }

    @Spy
    IngredientType spyType;

    @Test
    public void getTypeTest(){

        if ( testType.equals("SAUCE")){
            spyType = IngredientType.SAUCE;
        } else if (testType.equals("FILLING")) {
            spyType = IngredientType.FILLING;
        }
        Random random = new Random();
        String testName = "testName" + random.nextInt(100000);
        float testPrice = random.nextFloat();

        Ingredient ingredient = new Ingredient(spyType, testName, testPrice);
        assertEquals( testType, ingredient.getType().toString() );
    }
}