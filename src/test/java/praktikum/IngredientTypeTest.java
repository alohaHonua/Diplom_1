package praktikum;

import org.junit.Test;
import static org.junit.Assert.*;

public class IngredientTypeTest {

    @Test
    public void testSauceEnumValue() {
        assertEquals("SAUCE", IngredientType.SAUCE.name());
    }

    @Test
    public void testFillingEnumValue() {
        assertEquals("FILLING", IngredientType.FILLING.name());
    }
}
