import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import praktikum.Ingredient;
import praktikum.IngredientType;

@RunWith(Parameterized.class)
public class IngredientTest {

    public IngredientType ingredientType;
    public String name;
    public float price;

    public IngredientTest(IngredientType ingredientType, String name, float price) {

        this.ingredientType = ingredientType;
        this.name = name;
        this.price = price;
    }
    @Parameterized.Parameters
    public static Object[][] ingredient() {
        return new Object[][]{
                {IngredientType.SAUCE, "hot sauce", 100},
                {IngredientType.SAUCE, "sour cream", 200},
                {IngredientType.SAUCE, "chili sauce", 300},

                {IngredientType.FILLING, "cutlet", 100},
                {IngredientType.FILLING, "dinosaur", 200},
                {IngredientType.FILLING, "sausage", 300},
        };
    }

    // Проверка типа ингредиента
    @Test
    public void getIngredientType() {
        Ingredient testIngredient = new Ingredient(ingredientType, name, price);
        IngredientType actualType = testIngredient.getType();
        Assert.assertEquals(ingredientType, actualType);

    }
    // Проверка имени ингредиента
    @Test
    public void getIngredientName() {
        Ingredient testIngredient = new Ingredient(ingredientType, name, price);
        String actualName = testIngredient.getName();
        Assert.assertEquals(name, actualName);
    }
    // Проверка цены ингредиента
    @Test
    public void getIngredientPrice() {
        Ingredient testIngredient = new Ingredient(ingredientType, name, price);
        float actualPrice = testIngredient.getPrice();
        Assert.assertEquals(price, actualPrice, 0);
    }
}
