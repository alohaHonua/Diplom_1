import org.junit.Test;
import praktikum.IngredientType;

import static org.junit.Assert.assertEquals;

public class IngredientTypeTests {
    @Test
    public void sauceTest() {
        assertEquals("SAUCE", IngredientType.SAUCE.name());
    }

    @Test
    public void fillingTest() {
        assertEquals("FILLING", IngredientType.FILLING.name());
    }

    @Test
    public void countTest() {
        IngredientType[] values = IngredientType.values();
        assertEquals(2, values.length);
    }
}

