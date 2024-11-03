import org.junit.Assert;
import org.junit.Test;
import praktikum.Ingredient;

public class IngredientTest {
    Ingredient ingredient = new Ingredient(Config.INGREDIENT_TYPE_FILLING,
            Config.INGREDIENT_NAME, Config.INGREDIENT_PRICE);


    @Test
    public void getNameTest() {
        Assert.assertEquals(Config.INGREDIENT_NAME, ingredient.getName());
    }
    @Test
    public void getPriceTest() {
        Assert.assertEquals(Config.INGREDIENT_PRICE, ingredient.getPrice(), Config.DEF_ASSERT_DELTA);
    }
    @Test
    public void getTypeTest() {
        Assert.assertEquals(Config.INGREDIENT_TYPE_FILLING, ingredient.getType());
    }
}
