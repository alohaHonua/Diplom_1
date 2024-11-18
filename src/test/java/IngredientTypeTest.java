import org.junit.Test;
import praktikum.IngredientType;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;



public class IngredientTypeTest {

    @Test
    public void testValues() {
        IngredientType[] values = IngredientType.values();
        assertEquals(2, values.length);
        assertEquals(IngredientType.SAUCE, values[0]);
        assertEquals(IngredientType.FILLING, values[1]);
    }

    @Test
    public void testValueOf() {
        assertEquals(IngredientType.SAUCE, IngredientType.valueOf("SAUCE"));
        assertEquals(IngredientType.FILLING, IngredientType.valueOf("FILLING"));
    }

    @Test(expected = IllegalArgumentException.class)
    public void testValueOf_invalidInput() {
        IngredientType.valueOf("INVALID");
    }

    @Test
    public void testToString() {
        assertEquals("SAUCE", IngredientType.SAUCE.toString());
        assertEquals("FILLING", IngredientType.FILLING.toString());
    }

    @Test
    public void testEquals() {
        assertEquals(IngredientType.SAUCE, IngredientType.SAUCE);
        assertNotEquals(IngredientType.SAUCE, IngredientType.FILLING);
    }

    @Test
    public void testName() {
        assertEquals("SAUCE", IngredientType.SAUCE.name());
        assertEquals("FILLING", IngredientType.FILLING.name());
    }

    @Test
    public void testOrdinal() {
        assertEquals(0, IngredientType.SAUCE.ordinal());
        assertEquals(1, IngredientType.FILLING.ordinal());
    }
}