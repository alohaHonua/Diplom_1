package praktikum;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class IngredientTest {

    private Ingredient ingredient;

    @Before
    public void initIngredientType() {
        ingredient = new Ingredient(
                IngredientType.SAUCE,
                "IngredientName",
                10
        );
    }

    @Test
    public void getNameTest() {
        String expected = "IngredientName";
        var actual = ingredient.getName();
        Assert.assertEquals(
                "Получено неожидаемое название"
                ,expected,
                actual);
    }

    @Test
    public void getPriceTest() {
        float expected = 10;
        float actual = ingredient.getPrice();
        Assert.assertEquals(
                "Получена неожидаемая цена",
                expected,
                actual,
                0.01);
    }

    @Test
    public void getTypeTest() {
        String expected = "SAUCE";
        String actual = String.valueOf(ingredient.getType());
        Assert.assertEquals(
                "Не ожидаемый тип ингредиента",
                expected,
                actual);
    }
}
