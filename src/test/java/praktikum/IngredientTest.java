package praktikum;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

@RunWith(Parameterized.class)
public class IngredientTest {

    private IngredientType type;
    private String name;
    private float price;

    public IngredientTest(IngredientType type, String name, float price) {
        this.type = type;
        this.name = name;
        this.price = price;
    }

    @Parameterized.Parameters
    public static Object[][] data() {
        return new Object[][]{
                {IngredientType.SAUCE, "12345", 10.0f},
                {IngredientType.FILLING, null, 9.0f},
                {IngredientType.SAUCE, "", 8.0f},
                {IngredientType.FILLING, "Onion", 7.5f},
                {IngredientType.SAUCE, "!@#", 6.0f},
                {IngredientType.FILLING, " ", 5.0f},
                {IngredientType.SAUCE, "Mustard, mayonnaise", 4.0f},
                {IngredientType.FILLING, "Iceberg lettuce", Float.MIN_VALUE},
                {IngredientType.SAUCE, "Pesto", Float.MAX_VALUE}
        };
    }

    @Test
    public void ingredientGetName() {
        Ingredient ingredient = new Ingredient(type, name, price);
        Assert.assertEquals(name, ingredient.getName());
    }

    @Test
    public void ingredientGetPrice() {
        Ingredient ingredient = new Ingredient(type, name, price);
        Assert.assertEquals(price, ingredient.getPrice(), 0);
    }

    @Test
    public void ingredientGetType(){
        Ingredient ingredient = new Ingredient(type, name, price);
        Assert.assertEquals(type, ingredient.getType());
    }
}
