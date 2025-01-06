import org.junit.Assert;
import org.junit.Test;
import praktikum.Ingredient;
import praktikum.IngredientType;

public class IngredientTest {
    private String ingredientName = "Ketchup";
    private float ingredientPrice = 100.5f;

    @Test
    public void getNameTest() {
        Ingredient ingredient = new Ingredient(IngredientType.SAUCE, ingredientName, ingredientPrice);
        Assert.assertEquals(ingredientName, ingredient.getName());
    }

    @Test
    public void getPriceTest() {
        float delta = 0.01f;
        Ingredient ingredient = new Ingredient(IngredientType.SAUCE, ingredientName, ingredientPrice);
        Assert.assertEquals(ingredientPrice, ingredient.getPrice(), delta);
    }
}
