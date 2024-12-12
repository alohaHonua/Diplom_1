import org.junit.Assert;
import org.junit.Test;
import praktikum.Ingredient;
import praktikum.IngredientType;

public class IngredientTest {

    @Test
    public void getPriceIngredientTest() {
        Ingredient ingredient = new Ingredient(IngredientType.FILLING, "Sriracha",21.002F);
        float expectedPrice = ingredient.getPrice();
        Assert.assertEquals(expectedPrice, ingredient.getPrice(), 0.001);
    }

    @Test
    public void getNameIngredientTest() {
        Ingredient ingredient = new Ingredient(IngredientType.FILLING, "Sriracha", 21.002F);
        String expectedName = ingredient.getName();
        Assert.assertEquals(expectedName, ingredient.getName());
    }

    @Test
    public void getTypeIngredientTest() {
        Ingredient ingredient = new Ingredient(IngredientType.FILLING, "Sriracha", 21.002F);
        String expectedType = String.valueOf(ingredient.getType());
        Assert.assertEquals(expectedType, String.valueOf(ingredient.getType()));
    }
}
