package praktikum;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class IngredientTypeTest {
    private final String ingredientType;

    @Parameterized.Parameters(name = "Наличие типа {0}")
    public static Object[][] paramsForTest() {
        return new Object[][] {
                {"SAUCE"},
                {"FILLING"}
        };
    }
    public IngredientTypeTest(String ingredientType) {
        this.ingredientType = ingredientType;
    }
    @Test
    public void ingredientTypePresentedTest() {
        assertEquals(ingredientType, IngredientType.valueOf(ingredientType.toUpperCase()).toString());
    }
}