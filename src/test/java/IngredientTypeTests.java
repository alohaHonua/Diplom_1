import org.junit.Assert;
import org.junit.Test;
import praktikum.IngredientType;

public class IngredientTypeTests {

    @Test
    public void testEnumLength(){
        // Проверяем, что у нас именно два перечисления
        int EnumLength = 2;
        Assert.assertEquals(EnumLength, IngredientType.values().length);
    }

    @Test
    public void testEnumValuesSauce() {
        // Проверяем, что все ожидаемые значения перечисления существуют
        Assert.assertTrue(IngredientType.SAUCE instanceof IngredientType);
    }

    @Test
    public void testEnumValuesFilling() {
        // Проверяем, что все ожидаемые значения перечисления существуют
        Assert.assertTrue(IngredientType.FILLING instanceof IngredientType);
    }

    @Test
    public void testEnumNamesSauce() {
        // Проверяем правильность строковых представлений
        Assert.assertEquals("SAUCE", IngredientType.SAUCE.name());
    }

    @Test
    public void testEnumNamesFilling() {
        // Проверяем правильность строковых представлений
        Assert.assertEquals("FILLING", IngredientType.FILLING.name());
    }

    @Test
    public void testValueOfSauce() {
        // Проверяем, что метод valueOf возвращает правильное значение
        Assert.assertEquals(IngredientType.SAUCE, IngredientType.valueOf("SAUCE"));
    }

    @Test
    public void testValueOfFilling() {
        // Проверяем, что метод valueOf возвращает правильное значение
        Assert.assertEquals(IngredientType.FILLING, IngredientType.valueOf("FILLING"));
    }

    @Test(expected = IllegalArgumentException.class)
    public void testValueOfInvalidName() {
        // Проверяем, что передача неверного имени выбрасывает исключение
        String invName = "INVALID";
        IngredientType.valueOf(invName);
    }
}
