import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import praktikum.Ingredient;
import praktikum.IngredientType;

@RunWith(Parameterized.class)
public class IngredientParamTest {

    private final IngredientType ingredientType;
    private final String name;
    private final float price;

    public IngredientParamTest(IngredientType ingredientType, String name, float price) {
        this.ingredientType = ingredientType;
        this.name = name;
        this.price = price;
    }

    @Parameterized.Parameters
    public static Object[][] IngredientTypeTestData() {
        return new Object[][] {
                {IngredientType.SAUCE, "Соус Spicy-X", 90.0F},
                {IngredientType.FILLING, "Мясо бессмертных моллюсков Protostomia", 1337.0F},
        };
    }

    @Test
    public void getNameSuccess() throws Exception {
        Ingredient ingredient = new Ingredient(ingredientType, name, price);
        Assert.assertEquals(name, ingredient.getName());
    }

    @Test
    public void getPriceSuccess() throws Exception {
        Ingredient ingredient = new Ingredient(ingredientType, name, price);
        Assert.assertEquals(price, ingredient.getPrice(), 0.0F);
    }

    @Test
    public void getTypeSuccess() throws Exception {
        Ingredient ingredient = new Ingredient(ingredientType, name, price);
        Assert.assertEquals(ingredientType, ingredient.getType());
    }


}
