package praktikum;

import io.qameta.allure.Description;
import io.qameta.allure.junit4.DisplayName;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class IngredientTypeTest {



    @Test
    @DisplayName("тест IngredientType valueOf(\"SAUCE\")")
    public void testValueOfShouldReturnSauce() {
        assertEquals(String.format("Ожидался: %s, но получили: %s", IngredientType.SAUCE, IngredientType.valueOf("SAUCE")),
                IngredientType.SAUCE,
                IngredientType.valueOf("SAUCE"));
    }

    @Test
    @DisplayName("тест IngredientType valueOf(\"FILLING\")")
    public void testValueOfShouldReturnFilling() {
        assertEquals(String.format("Ожидался: %s, но получили: %s", IngredientType.FILLING, IngredientType.valueOf("FILLING")),
                IngredientType.FILLING,
                IngredientType.valueOf("FILLING"));
    }

    @Test(expected = IllegalArgumentException.class)
    @DisplayName("тест IngredientType valueOf(\"SPICES\")")
    @Description("Ожидается ошибка")
    public void testValueOfShouldThrowIllegalArgumentException() {
        IngredientType.valueOf("SPICES");
    }
}