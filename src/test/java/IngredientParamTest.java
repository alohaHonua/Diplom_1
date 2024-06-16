import jdk.jfr.Description;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import praktikum.Ingredient;
import praktikum.IngredientType;

import static org.junit.Assert.assertEquals;
import static praktikum.IngredientType.FILLING;
import static praktikum.IngredientType.SAUCE;

@RunWith(Parameterized.class)
public class IngredientParamTest {

    Ingredient ingredient;
    private IngredientType ingredientType;
    private String ingredientName;
    private float ingredientPrice;

    public IngredientParamTest(IngredientType ingredientType, String ingredientName, float ingredientPrice) {
        this.ingredientType = ingredientType;
        this.ingredientName = ingredientName;
        this.ingredientPrice = ingredientPrice;
    }

    @Parameterized.Parameters
    public static Object[][] testData() {
        return new Object[][]{
                {FILLING,TestDataCreator.getName(), TestDataCreator.getPrice()},
                {SAUCE,TestDataCreator.getName(), TestDataCreator.getPrice()}
        };
    }

    @Before
    public void before() {
        ingredient = new Ingredient(ingredientType, ingredientName, ingredientPrice);
    }

    @Test
    @Description("Проверка получения стоимости")
    public void getPriceCheck() {
        assertEquals(ingredientPrice, ingredient.getPrice(), 0);
    }

    @Test
    @Description("Проверка получения наименования")
    public void getNameCheck() {
        assertEquals(ingredientName, ingredient.getName());
    }

    @Test
    @Description("Проверка получения типа")
    public void getTypeCheck() {
        assertEquals(ingredientType, ingredient.getType());
    }
}
