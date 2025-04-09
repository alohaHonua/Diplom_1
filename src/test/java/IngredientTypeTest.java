import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.Test;
import praktikum.IngredientType;

import static org.junit.Assert.*;

@RunWith(Parameterized.class)
public class IngredientTypeTest {

    private final IngredientType ingredientType;
    private final String expectedName;

    public IngredientTypeTest(IngredientType ingredientType, String expectedName) {
        this.ingredientType = ingredientType;
        this.expectedName = expectedName;
    }

    @Parameterized.Parameters
    public static Object[][] data() {
        return new Object[][]{
                {IngredientType.SAUCE, "SAUCE"},
                {IngredientType.FILLING, "FILLING"}
        };
    }

    @Test
    public void testIngredientTypeName() {
        assertEquals(expectedName, ingredientType.name());
    }
}
