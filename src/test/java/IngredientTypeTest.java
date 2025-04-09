import org.junit.Test;
import praktikum.IngredientType;

import static org.junit.Assert.assertEquals;

public class IngredientTypeTest {

    @Test
    public void verifySauceTest() {
        // Проверяем, что строковое представление категории 'SAUCE' совпадает с ожидаемым значением
        assertEquals(String.format("Категория 'SAUCE' должна соответствовать значению 'Соус'", IngredientType.SAUCE),
                Constants.EXPECTED_INGREDIENT_TYPE_SAUCE,
                IngredientType.SAUCE.toString());
    }

    @Test
    public void verifyFillingTest() {
        // Проверяем, что строковое представление категории 'FILLING' совпадает с ожидаемым значением
        assertEquals(String.format("Категория 'FILLING' должна соответствовать значению 'Начинка'", IngredientType.FILLING),
                Constants.EXPECTED_INGREDIENT_TYPE_FILLING,
                IngredientType.FILLING.toString());

    }
}
