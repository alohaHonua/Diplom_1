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
    public void testEnumValues() {
        // Проверяем, что все ожидаемые значения перечисления существуют
        Assert.assertTrue(IngredientType.SAUCE instanceof IngredientType);
        Assert.assertTrue(IngredientType.FILLING instanceof IngredientType);
    }

    @Test
    public void testEnumNames() {
        // Проверяем правильность строковых представлений
        Assert.assertEquals("SAUCE", IngredientType.SAUCE.name());
        Assert.assertEquals("FILLING", IngredientType.FILLING.name());
    }

    @Test
    public void testValueOf() {
        // Проверяем, что метод valueOf возвращает правильное значение
        Assert.assertEquals(IngredientType.SAUCE, IngredientType.valueOf("SAUCE"));
        Assert.assertEquals(IngredientType.FILLING, IngredientType.valueOf("FILLING"));
    }

    @Test(expected = IllegalArgumentException.class)
    public void testValueOfInvalidName() {
        // Проверяем, что передача неверного имени выбрасывает исключение
        String invName = "INVALID";
        IngredientType.valueOf(invName);
    }
}
