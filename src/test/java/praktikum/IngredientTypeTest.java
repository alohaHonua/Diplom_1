package praktikum;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class IngredientTypeTest {
    //Проверяем, что значения перечисления IngredientType корректно возвращают свои имена.
    @Test
    public void enumValuesTest() {
        assertEquals("Имя типа SAUCE не совпадает","SAUCE", IngredientType.SAUCE.name());
        assertEquals("Имя типа FILLING не совпадает","FILLING", IngredientType.FILLING.name());
    }

    //Проверяем, что метод valueOf возвращает правильные enum-константы по строковому имени.
    @Test
    public void enumValueOfTest() {
        assertEquals("Enum по имени SAUCE возвращает неверное значение", IngredientType.SAUCE, IngredientType.valueOf("SAUCE"));
        assertEquals("Enum по имени FILLING возвращает неверное значение",IngredientType.FILLING, IngredientType.valueOf("FILLING"));
    }
}
