import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import praktikum.Ingredient;
import praktikum.IngredientType;

@RunWith(Parameterized.class)
public class IngredientTests {

    IngredientType type;
    String name;
    float price;

    public IngredientTests(IngredientType type, String name, float price) {
        this.type = type;
        this.name = name;
        this.price = price;
    }

    @Parameterized.Parameters
    public static Object[][] ingredientTestsData() {
        return new Object[][]{
                {IngredientType.SAUCE, "FirstIngredient", 10},
                {IngredientType.FILLING, "SecondIngredient", 5.55F},
        };
    }

    @Test
    public void checkIngredientWithParameters() {
        Ingredient ingredient = new Ingredient(type, name, price);
        Assert.assertEquals("Метод возвращает неправильный тип ингредиента", type, ingredient.getType());
        Assert.assertEquals("Метод возвращает неправильное имя ингредиента", name, ingredient.getName());
        Assert.assertEquals("Метод возвращает неправильную цену ингридеента", price, ingredient.getPrice(),0.01F);
    }
}
