package praktikum;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class IngredientTypeTest {

    @Test
    public void testIngredientTypeLength() {
        IngredientType[] types = IngredientType.values();
        assertEquals(2, types.length);
    }

    @Test
    public void testIngredientTypeValues() {
        IngredientType[] types = IngredientType.values();
        assertEquals(IngredientType.SAUCE, types[0]);
        assertEquals(IngredientType.FILLING, types[1]);
    }

}