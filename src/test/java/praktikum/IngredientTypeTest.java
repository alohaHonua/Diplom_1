package praktikum;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class IngredientTypeTest {

    @Test
    public void testSAUCE() {
        // Проверка, что константа SAUCE правильно определяется
        assertEquals("SAUCE", IngredientType.SAUCE.name());
        assertEquals(IngredientType.SAUCE, IngredientType.valueOf("SAUCE"));
    }

    @Test
    public void testFILLING() {
        // Проверка, что константа FILLING правильно определяется
        assertEquals("FILLING", IngredientType.FILLING.name());
        assertEquals(IngredientType.FILLING, IngredientType.valueOf("FILLING"));
    }

    @Test
    public void testValues() {
        // Проверка, что возвращаемые значения корректны
        IngredientType[] values = IngredientType.values();
        assertEquals(2, values.length);
        assertTrue(values[0] == IngredientType.SAUCE || values[1] == IngredientType.SAUCE);
        assertTrue(values[0] == IngredientType.FILLING || values[1] == IngredientType.FILLING);
    }

    @Test
    public void testEnumToString() {
        // Проверка, что методы toString() работают корректно
        assertEquals("SAUCE", IngredientType.SAUCE.toString());
        assertEquals("FILLING", IngredientType.FILLING.toString());
    }
}