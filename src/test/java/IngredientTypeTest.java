
import org.junit.Test;
import praktikum.Ingredient;
import praktikum.IngredientType;

import static org.junit.Assert.*;

public class IngredientTypeTest {

    @Test
    public void enumShouldHaveCorrectValues() {
        // Проверяем наличие всех ожидаемых значений enum
        IngredientType[] values = IngredientType.values();
        assertEquals(2, values.length);
        assertEquals(IngredientType.SAUCE, values[0]);
        assertEquals(IngredientType.FILLING, values[1]);
    }

    @Test
    public void valueOfShouldWorkCorrectly() {
        // Проверяем корректность работы valueOf
        assertEquals(IngredientType.SAUCE, IngredientType.valueOf("SAUCE"));
        assertEquals(IngredientType.FILLING, IngredientType.valueOf("FILLING"));
    }

    @Test
    public void enumValuesShouldHaveCorrectToString() {
        // Проверяем строковое представление значений
        assertEquals("SAUCE", IngredientType.SAUCE.toString());
        assertEquals("FILLING", IngredientType.FILLING.toString());
    }
}
