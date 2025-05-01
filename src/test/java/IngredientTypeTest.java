import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;
import praktikum.IngredientType;

import static org.junit.jupiter.api.Assertions.*;

class IngredientTypeTest {

    @ParameterizedTest
    @EnumSource(IngredientType.class)
    void testEnumValues(IngredientType type) {
        assertNotNull(type);
    }

    @Test
    void testEnumContainsCorrectValues() {
        IngredientType[] values = IngredientType.values();

        assertEquals(2, values.length);
        assertEquals(IngredientType.SAUCE, values[0]);
        assertEquals(IngredientType.FILLING, values[1]);
    }
}