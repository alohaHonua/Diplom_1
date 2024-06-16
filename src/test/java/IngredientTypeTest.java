import jdk.jfr.Description;
import org.junit.Test;
import praktikum.IngredientType;

import static org.junit.Assert.assertEquals;

public class IngredientTypeTest {

    @Test
    @Description("Проверка получения типа FILLING")
    public void getFillingCheck() {
        assertEquals(IngredientType.valueOf("FILLING"), IngredientType.FILLING);
    }

    @Test
    @Description("Проверка получения типа SAUCE")
    public void getSauceCheck() {
        assertEquals(IngredientType.valueOf("SAUCE"), IngredientType.SAUCE);
    }
}
