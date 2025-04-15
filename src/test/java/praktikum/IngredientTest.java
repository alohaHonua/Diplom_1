package praktikum;

import lombok.AllArgsConstructor;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

@RunWith(Parameterized.class)
@AllArgsConstructor
public class IngredientTest {
    private final IngredientType ingredientType;
    private final String name;
    private final float price;

    @Parameterized.Parameters(name = "{index} : IngredientType = {0}, name = {1}, price = {2}")
    public static Object[][] getData() {
        return new Object[][]{
                {IngredientType.FILLING, "tomato", 20},
                {IngredientType.SAUCE, "salsa", 30}
        };
    }

    @Test
    public void getPrice() {
        Ingredient ingredient = new Ingredient(ingredientType, name, price);
        Assert.assertEquals(price, ingredient.getPrice(), 0.0f);
    }

    @Test
    public void getName() {
        Ingredient ingredient = new Ingredient(ingredientType, name, price);
        Assert.assertEquals(name, ingredient.getName());
    }

    @Test
    public void getType() {
        Ingredient ingredient = new Ingredient(ingredientType, name, price);
        Assert.assertEquals(ingredientType, ingredient.getType());
    }
}