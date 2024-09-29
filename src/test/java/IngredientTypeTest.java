import org.junit.Test;
import praktikum.IngredientType;

import static org.junit.Assert.assertEquals;

public class IngredientTypeTest {

    @Test
    public void testIngredientTypeSauce() {
        IngredientType type = IngredientType.SAUCE;
        assertEquals(IngredientType.SAUCE, type);
        assertEquals("SAUCE", type.name());
    }

    @Test
    public void testIngredientTypeFilling() {
        IngredientType type = IngredientType.FILLING;
        assertEquals(IngredientType.FILLING, type);
        assertEquals("FILLING", type.name());
    }

    @Test
    public void testValuesMethod() {
        IngredientType[] expectedValues = {IngredientType.SAUCE, IngredientType.FILLING};
        assertEquals(2, IngredientType.values().length);
        assertEquals(expectedValues[0], IngredientType.values()[0]);
        assertEquals(expectedValues[1], IngredientType.values()[1]);
    }

    @Test
    public void testValueOfMethod() {
        assertEquals(IngredientType.SAUCE, IngredientType.valueOf("SAUCE"));
        assertEquals(IngredientType.FILLING, IngredientType.valueOf("FILLING"));
    }
}
