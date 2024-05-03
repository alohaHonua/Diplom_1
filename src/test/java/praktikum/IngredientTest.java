package praktikum;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

@RunWith(Parameterized.class)

public class IngredientTest {
    private Ingredient ingredient;
    private IngredientType type;
    private String name;
    private float price;

    public IngredientTest(IngredientType type, String name, float price) {
        this.type = type;
        this.name = name;
        this.price = price;
    }

    @Parameterized.Parameters(name = "Тип, наименование и цена ингредиента. Тестовые данные: {0}, {1}, {2}")
    public static Object[][] getData() {
        return new Object[][] {
                {IngredientType.SAUCE, "test", 100},
                {IngredientType.FILLING, "teest", 200},
                {IngredientType.FILLING, "", 50},
                {IngredientType.FILLING, "тест", 50},
                {IngredientType.SAUCE, "hot spicy", 0},
                {IngredientType.FILLING, "sausage", -1}
        };
    }

    @Before
    public void init() {
        ingredient = new Ingredient(type, name, price);
    }

    @Test
    public void checkGetName() {
        String actual = ingredient.getName();
        Assert.assertEquals("Наименование булки не совпадает с ожидаемым значением",name, actual);
    }

    @Test
    public void checkGetPrice() {
        float actual = ingredient.getPrice();
        Assert.assertEquals("Цена булки не совпадает с ожидаемым значением",price, actual, 0.001);
    }

    @Test
    public void checkGetType() {
        IngredientType actual = ingredient.getType();
        Assert.assertEquals("тип булки не совпадает с ожидаемым значением",type, actual);
    }
}