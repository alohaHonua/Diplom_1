package praktikum;

import org.junit.Test;
import static org.junit.Assert.*;

public class IngredientTypeTest {
    @Test
    public void testEnumValues() {
        assertEquals("Должно быть 2 значения enum", 2, IngredientType.values().length);
    }

    @Test
    public void testEnumSauce() {
        assertEquals("Должно существовать значение SAUCE", IngredientType.SAUCE, IngredientType.valueOf("SAUCE"));
    }

    @Test
    public void testEnumFilling() {
        assertEquals("Должно существовать значение FILLING", IngredientType.FILLING, IngredientType.valueOf("FILLING"));
    }
}