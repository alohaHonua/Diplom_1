import praktikum.IngredientType;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class IngredientTypeTest {

    @Test
    public void testSauceType() {
        assertEquals("SAUCE", IngredientType.SAUCE.name());
        System.out.println("Тест пройден успешно: значение SAUCE соответствует ожидаемой строке");
    }

    @Test
    public void testFillingType() {
        assertEquals("FILLING", IngredientType.FILLING.name());
        System.out.println("Тест пройден успешно: значение FILLING соответствует ожидаемой строке");

    }
}