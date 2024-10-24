import org.junit.Assert;
import org.junit.Test;
import praktikum.Ingredient;
import praktikum.IngredientType;

public class IngredientTest {
    Ingredient ingredient = new Ingredient(IngredientType.SAUCE, "Сальса", 12F);

    @Test
    public void getPriceTest() {
        Assert.assertEquals(12F, ingredient.getPrice(), 0.001F); // Использование дельты
    }

    @Test
    public void getNameTest() {
        Assert.assertEquals("Сальса", ingredient.getName());
    }

    @Test
    public void getTypeTest() {
        Assert.assertEquals(IngredientType.SAUCE, ingredient.getType());
    }
}