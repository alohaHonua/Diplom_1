import org.junit.Assert;
import org.junit.Test;
import praktikum.IngredientType;

public class IngredientTypeTest {

    @Test
    public void ingredientTypeValuesShouldContainTwoElementsTest() {
        IngredientType[] expected = {IngredientType.SAUCE, IngredientType.FILLING};
        Assert.assertArrayEquals("IngredientType.values() содержит неверный набор значений",
                expected, IngredientType.values());
    }

    @Test
    public void valueOfShouldReturnSauce() {
        Assert.assertEquals("Неверное значение для SAUCE",
                IngredientType.SAUCE, IngredientType.valueOf("SAUCE"));
    }

    @Test
    public void valueOfShouldReturnFilling() {
        Assert.assertEquals("Неверное значение для FILLING",
                IngredientType.FILLING, IngredientType.valueOf("FILLING"));
    }

    @Test(expected = IllegalArgumentException.class)
    public void valueOfInvalidNameShouldThrowException() {
        // Ожидаем, что при несуществующем значении выбросится IllegalArgumentException
        IngredientType.valueOf("INVALID");
    }
}
