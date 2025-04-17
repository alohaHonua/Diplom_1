package praktikum;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class IngredientTypeTest {

    @Test
    public void testIngredientTypeValues() {
        IngredientType[] types = IngredientType.values();
        assertEquals(2, types.length);
        assertEquals(IngredientType.SAUCE, types[0]);
        assertEquals(IngredientType.FILLING, types[1]);
    }

    @Test
    public void testIngredientTypeToString() {
        assertEquals("SAUCE", IngredientType.SAUCE.toString());
        assertEquals("FILLING", IngredientType.FILLING.toString());
    }
} 