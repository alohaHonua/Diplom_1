package praktikum;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import static org.junit.Assert.assertEquals;


@RunWith(Parameterized.class)
public class ParametrizedIngredientToStringTest {
    private final String expectedIngredient;


    public ParametrizedIngredientToStringTest(String expectedIngredient) {
        this.expectedIngredient = expectedIngredient;
    }


    @Parameterized.Parameters()
    public static Object[][] switchBetweenEnumParams() {
        return new Object[][]{
                {"SAUCE"},
                {"FILLING"}
        };
    }

    @Test
    public void IngredientTypeTest(){
        assertEquals(expectedIngredient, IngredientType.valueOf(expectedIngredient).toString());
    }
}