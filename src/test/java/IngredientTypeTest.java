import org.junit.Test;
import ru.practikum.yandex.IngredientType;

import java.util.Arrays;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class IngredientTypeTest {

    @Test
    public void IngredientTypeValuesCountTest() {
        IngredientType[] values = IngredientType.values();
        assertEquals("Должно быть 2 значения в enum IngredientType", 2, values.length);
    }

    @Test
    public void IngredientTypeContainsSauceTest() {
        IngredientType[] values = IngredientType.values();
        assertTrue("SAUCE должен быть одним из значений IngredientType", Arrays.asList(values).contains(IngredientType.SAUCE));
    }

    @Test
    public void IngredientTypeContainsFillingTest() {
        IngredientType[] values = IngredientType.values();
        assertTrue("FILLING должен быть одним из значений IngredientType", Arrays.asList(values).contains(IngredientType.FILLING));
    }

    @Test
    public void ValueOfReturnsSauceTest() {
        assertEquals("Метод valueOf должен вернуть SAUCE для строки \"SAUCE\"", IngredientType.SAUCE, IngredientType.valueOf("SAUCE"));
    }

    @Test
    public void ValueOfReturnsFillingTest() {
        assertEquals("Метод valueOf должен вернуть FILLING для строки \"FILLING\"", IngredientType.FILLING, IngredientType.valueOf("FILLING"));
    }
}
