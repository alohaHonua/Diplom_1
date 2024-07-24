import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.mockito.junit.MockitoJUnitRunner;
import praktikum.IngredientType;

import static junit.framework.TestCase.assertEquals;
import static org.junit.Assert.assertArrayEquals;
import static praktikum.IngredientType.FILLING;
import static praktikum.IngredientType.SAUCE;

@RunWith(Parameterized.class)
public class IngredientTypeTest {

    private IngredientType ingredientType;
    private String ingredientName;

    public IngredientTypeTest(IngredientType ingredientType, String ingredientName) {
        this.ingredientType = ingredientType;
        this.ingredientName = ingredientName;
    }

    @Parameterized.Parameters
    public static Object[][] getTestData() {
        return new Object[][]{
                {FILLING, "FILLING"},
                {SAUCE, "SAUCE"}
        };
    }
    @Test
    public void ingredientTypeTest() {
        assertEquals(ingredientName, ingredientType.name());
    }
}
