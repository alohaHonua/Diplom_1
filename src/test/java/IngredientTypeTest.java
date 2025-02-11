import org.junit.Test;
import praktikum.IngredientType;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

public class IngredientTypeTest {

    @Test
    public void testIngredientTypeValues() {
        IngredientType[] expectedTypes = {IngredientType.SAUCE, IngredientType.FILLING};
        IngredientType[] actualTypes = IngredientType.values();

        assertEquals(2, actualTypes.length);

        assertArrayEquals(expectedTypes, actualTypes);
    }
}