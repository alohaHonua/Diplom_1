import static org.junit.Assert.*;
import org.junit.Test;
import praktikum.IngredientType;
public class TestIngredientType {

    @Test
    public void testEnumValues() {
        // Проверяем, что все значения перечисления корректны
        IngredientType[] expectedValues = {IngredientType.SAUCE, IngredientType.FILLING};
        assertArrayEquals(expectedValues, IngredientType.values());
    }

    @Test
    public void testEnumNames() {
        // Проверяем имена значений перечисления
        assertEquals("SAUCE", IngredientType.SAUCE.name());
        assertEquals("FILLING", IngredientType.FILLING.name());
    }

    @Test
    public void testValueOf() {
        // Проверяем, что можно получить значение enum по имени
        assertEquals(IngredientType.SAUCE, IngredientType.valueOf("SAUCE"));
        assertEquals(IngredientType.FILLING, IngredientType.valueOf("FILLING"));
    }

    @Test(expected = IllegalArgumentException.class)
    public void testValueOfInvalid() {
        // Проверяем, что при попытке получить несуществующее значение выбрасывается исключение
        IngredientType.valueOf("INVALID_TYPE");
    }
}
