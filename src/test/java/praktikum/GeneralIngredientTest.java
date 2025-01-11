package praktikum;

import datagenerator.DataGenerator;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class GeneralIngredientTest {
    private final IngredientType ingredientType;
    private final String ingredientName;
    private final float ingredientPrice;

    public GeneralIngredientTest(IngredientType ingredientType, String ingredientName, float ingredientPrice) {
        this.ingredientType = ingredientType;
        this.ingredientName = ingredientName;
        this.ingredientPrice = ingredientPrice;
    }

    @Parameterized.Parameters (name = "Тип ингредиента {0}, Назание ингредиента {1}, Цена ингредиента {2}")
    public static Object[][] getTestData() {
        return new Object[][] {
                {IngredientType.SAUCE, DataGenerator.generateIngredientName(), DataGenerator.generateRandomIngredientPrice()},
                {IngredientType.FILLING, DataGenerator.generateIngredientName(), DataGenerator.generateRandomIngredientPrice()},
        };
    }

    @Test
    public void getNameTest() {
        Ingredient ingredient = new Ingredient(ingredientType, ingredientName, ingredientPrice);
        assertEquals("Не соответствует название ингредиентов", ingredientName, ingredient.getName());
    }

    @Test
    public void getPriceTest() {
        Ingredient ingredient = new Ingredient(ingredientType, ingredientName, ingredientPrice);
        assertEquals("Не соответствует цена ингредиентов", ingredientPrice, ingredient.getPrice(), 0.0);
    }

    @Test
    public void getTypeTest() {
        Ingredient ingredient = new Ingredient(ingredientType, ingredientName, ingredientPrice);
        assertEquals("Не соответствует тип ингредиентов", ingredientType, ingredient.getType());
    }
}
