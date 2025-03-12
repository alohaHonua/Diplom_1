import org.junit.Test;
import praktikum.IngredientType;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertSame;

public class IngredientTypeTest {

    @Test
    public void testEnumNamesSauces() {
        assertEquals("SAUCE", IngredientType.SAUCE.name());
    }

    @Test
    public void testEnumNamesFilling() {
        assertEquals("FILLING", IngredientType.FILLING.name());
    }

    @Test
    public void testEnumValues() {
        IngredientType[] values = IngredientType.values();
        assertEquals(2, values.length);
        assertSame(IngredientType.SAUCE, values[0]);
        assertSame(IngredientType.FILLING, values[1]);
    }
}