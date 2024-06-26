import org.junit.Assert;
import org.junit.Test;
import praktikum.Ingredient;
import praktikum.IngredientType;

public class IngredientTest {

    @Test
    public void getPriceTest() {
        float expected = 300f;
        Ingredient ingredient = new Ingredient(IngredientType.SAUCE, "chili sauce", 300f);
        float actual = ingredient.getPrice();
        Assert.assertEquals(expected, actual, 0);
    }

    @Test
    public void getNameTest() {
        String expected = "chili sauce";
        Ingredient ingredient = new Ingredient(IngredientType.SAUCE, "chili sauce", 300f);
        String actual = ingredient.getName();
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void getTypeTest() {
        IngredientType expected = IngredientType.SAUCE;
        Ingredient ingredient = new Ingredient(IngredientType.SAUCE, "chili sauce", 300f);
        IngredientType actual = ingredient.getType();
        Assert.assertEquals(expected, actual);
    }
}