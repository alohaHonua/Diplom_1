package praktikum;

import org.junit.Assert;
import org.junit.Test;
import org.junit.jupiter.api.DisplayName;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

@RunWith(Parameterized.class)
public class IngredientParameterizedTest {
    IngredientType type;
    String name;
    float price;

    @Parameterized.Parameters
    public static Object[][] ingredients() {
        return new Object[][]{
                {IngredientType.SAUCE, "Cheesy", 5.10F},
                {IngredientType.FILLING, "Pork", 9.80F},
                {IngredientType.SAUCE, "Curry", 4.90F},
                {IngredientType.FILLING, "Fish", 15.00F},
        };
    }

    public IngredientParameterizedTest(IngredientType type, String name, float price) {
        this.type = type;
        this.name = name;
        this.price = price;
    }

    @Test
    @DisplayName("Получение цены ингредиента")
    public void getPrice() {
        Ingredient ingredient = new Ingredient(type, name, price);
        Assert.assertEquals(price, ingredient.getPrice(), 0.01F);
    }

    @Test
    @DisplayName("Получение названия ингредиента")
    public void getName() {
        Ingredient ingredient = new Ingredient(type, name, price);
        Assert.assertTrue(name.equals(ingredient.getName()));
    }

    @Test
    @DisplayName("Получение типа ингредиента")
    public void getType() {
        Ingredient ingredient = new Ingredient(type, name, price);
        Assert.assertTrue(type.equals(ingredient.getType()));
    }

}
