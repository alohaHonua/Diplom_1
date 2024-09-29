import org.junit.Test;
import praktikum.IngredientType;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNotEquals;

public class IngredientTypeTest {

    @Test
    public void testSauceValue() {
        assertNotNull(IngredientType.SAUCE);
    }

    @Test
    public void testFillingValue() {
        assertNotNull(IngredientType.FILLING);
    }

    @Test
    public void testUniqueValues() {
        assertNotEquals(IngredientType.SAUCE, IngredientType.FILLING);
    }
}