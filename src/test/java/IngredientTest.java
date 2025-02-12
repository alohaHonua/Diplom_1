import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import praktikum.Ingredient;
import praktikum.IngredientType;

@RunWith(Parameterized.class)
public class IngredientTest {
    private IngredientType ingredientType;
    private String name;
    private float price;

    public IngredientTest(IngredientType ingredientType, String name, float price) {
        this.ingredientType = ingredientType;
        this.name = name;
        this.price = price;
    }

    @Parameterized.Parameters
    public static Object[][] setParams() {
        return new Object[][] {
                {IngredientType.SAUCE, "Соус Spicy-X", 90},
                {IngredientType.FILLING, "Говяжий метеорит (отбивная)", 3000 },
        };
    }

    @Test
    public void getIngredientTest() {
        Ingredient ingredient = new Ingredient(ingredientType, name, price);
        Assert.assertEquals(name, ingredient.getName());
        Assert.assertEquals(Float.valueOf(price), ingredient.getPrice(),0);
        Assert.assertEquals(ingredientType, ingredient.getType());
    }
}
