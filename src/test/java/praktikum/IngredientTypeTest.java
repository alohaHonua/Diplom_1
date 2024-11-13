package praktikum;

import org.junit.Test;
import static org.junit.Assert.*;

public class IngredientTypeTest {

    @Test
    public void testSauceType() {
        IngredientType type = IngredientType.SAUCE;
        assertNotNull("Тип SAUCE не null", type);
        assertEquals("Тип SAUCE", IngredientType.SAUCE, type);
    }

    @Test
    public void testFillingType() {
        IngredientType type = IngredientType.FILLING;
        assertNotNull("Тип FILLING не null", type);
        assertEquals("Тип должен быть FILLING", IngredientType.FILLING, type);
    }

    @Test
    public void testIngredientTypeEnumValues() {
        IngredientType[] expectedValues = {IngredientType.SAUCE, IngredientType.FILLING};
        assertArrayEquals("Проверка значений перечисления", expectedValues, IngredientType.values());
    }
}
