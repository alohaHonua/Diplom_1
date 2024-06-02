import org.junit.Test;
import praktikum.IngredientType;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class IngredientTypeTest {

    // Тест для проверки, что тип SAUCE не является null и корректно возвращается
    @Test
    public void testSauceType() {
        IngredientType type = IngredientType.SAUCE;
        assertNotNull("Тип SAUCE не должен быть null", type);
        assertEquals("Тип должен быть SAUCE", IngredientType.SAUCE, type);
    }

    // Тест для проверки, что тип FILLING не является null и корректно возвращается
    @Test
    public void testFillingType() {
        IngredientType type = IngredientType.FILLING;
        assertNotNull("Тип FILLING не должен быть null", type);
        assertEquals("Тип должен быть FILLING", IngredientType.FILLING, type);
    }
}
