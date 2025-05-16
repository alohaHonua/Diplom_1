package praktikum;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class IngredientTypeTest {
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

