package praktikum;

import org.junit.Test;

import static org.junit.Assert.*;

public class IngredientTypeTest {

    @Test
    public void valuesTest() {
        IngredientType[] values = IngredientType.values();
        assertEquals("Количество значений должно быть 2", 2, values.length);
    }

    @Test
    public void valueOfSauceTest() {
        assertEquals(String.format("Значение должно соответствовать %s", IngredientType.SAUCE), IngredientType.SAUCE, IngredientType.valueOf("SAUCE"));
    }

    @Test
    public void valueOfFillingTest() {
        assertEquals(String.format("Значение должно соответствовать %s", IngredientType.FILLING), IngredientType.FILLING, IngredientType.valueOf("FILLING"));
    }
}