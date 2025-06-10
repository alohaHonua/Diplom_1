package praktikum;

import org.junit.*;

import static org.junit.Assert.*;

public class IngredientTypeTest {
    @Test
    public void testEnumValues() {
        assertNotNull(IngredientType.valueOf("SAUCE"));
        assertNotNull(IngredientType.valueOf("FILLING"));
    }
}
