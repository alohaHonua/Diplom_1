import org.junit.Test;
import praktikum.*;

import static org.junit.Assert.assertEquals;

public class IngredientTypeUnitTest {

    @Test
    public void testSauceIngredientType() {
        assertEquals("Ошибка: тип ингредиента SAUCE не совпадает", IngredientType.SAUCE, IngredientType.valueOf("SAUCE"));
    }

    @Test
    public void testFillingIngredientType() {
        assertEquals("Ошибка: тип ингредиента FILLING не совпадает", IngredientType.FILLING, IngredientType.valueOf("FILLING"));
    }
}