import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import praktikum.Ingredient;
import praktikum.IngredientType;

import static org.junit.Assert.*;
@RunWith(Parameterized.class)
public class IngredientTests {
    private final IngredientType ingredientType;
    private final String ingredientName;
    private final float ingredientPrice;
    private Ingredient ingredient;

    public IngredientTests(IngredientType ingredientType, String ingredientName, float ingredientPrice) {
        this.ingredientType = ingredientType;
        this.ingredientName = ingredientName;
        this.ingredientPrice = ingredientPrice;
    }
    @Before
    public void initIngredient() {
        ingredient = new Ingredient(ingredientType, ingredientName, ingredientPrice);
    }

    @Parameterized.Parameters
    public static Object [][] getIngredients() {
        return new Object[][] {
                {IngredientType.SAUCE, "Соус традиционный галактичсекий", 15F},
                {IngredientType.FILLING, "Мясо бессмертных молюсков", 1337F}
        };
    }

    @Test
    public void getIngredientNameTest() {
        assertEquals("Неверное название ингредиента", ingredientName, ingredient.getName());
    }

    @Test
    public void getIngredientPriceTest() {
        assertEquals("Неверная цена ингредиента", ingredientPrice, ingredient.getPrice(), 0);
    }

    @Test
    public void getIngredientTypeTest() {
        assertEquals("Неверный тип ингредиента", ingredientType, ingredient.getType());
    }

}
