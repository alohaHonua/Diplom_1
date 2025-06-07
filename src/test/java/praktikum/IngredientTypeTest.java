package praktikum;

import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;
import static praktikum.IngredientType.*;

public class IngredientTypeTest {
    @Test
    public void testEnumValues() {
        IngredientType[] expectedValues = {SAUCE, FILLING};
        IngredientType[] actualValues = IngredientType.values();
        assertArrayEquals(expectedValues, actualValues);
    }
}
