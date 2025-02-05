package praktikum;

import org.junit.Test;
import static org.junit.Assert.*;

public class IngredientTypeTest {

    @Test
    public void testSAUCE() {
        assertEquals("SAUCE", IngredientType.SAUCE.name());
        assertEquals(IngredientType.SAUCE, IngredientType.valueOf("SAUCE"));
    }

    @Test
    public void testFILLING() {
        assertEquals("FILLING", IngredientType.FILLING.name());
        assertEquals(IngredientType.FILLING, IngredientType.valueOf("FILLING"));
    }

    @Test
    public void testValues() {
        IngredientType[] values = IngredientType.values();
        assertEquals(2, values.length);
        assertTrue(values[0] == IngredientType.SAUCE || values[1] == IngredientType.SAUCE);
        assertTrue(values[0] == IngredientType.FILLING || values[1] == IngredientType.FILLING);
    }

    @Test
    public void testEnumToString() {
        assertEquals("SAUCE", IngredientType.SAUCE.toString());
        assertEquals("FILLING", IngredientType.FILLING.toString());
    }
}