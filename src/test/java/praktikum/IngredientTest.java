package praktikum;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

@RunWith(Parameterized.class)
public class IngredientTest {
    private final IngredientType type;
    private final String name;
    private final float price;
    private Ingredient ingredient;

    public IngredientTest(IngredientType type, String name, float price) {
        this.type = type;
        this.name = name;
        this.price = price;

    }

    @Parameterized.Parameters(name = "Тестовые данные: type = {0}, name = {1}, price ={2}")
    public static Object[][] getIngredientData() {
        return new Object[][]{
                {IngredientType.SAUCE, "hot sauce", 100},
                {IngredientType.SAUCE, "sour cream", 200},
                {IngredientType.SAUCE, "chili sauce", 300},
                {IngredientType.FILLING, "cutlet", 100},
                {IngredientType.FILLING, "dinosaur", 200},
                {IngredientType.FILLING, "sausage", 300}
        };

    }

    @Before
    public void setUp() {
        ingredient = new Ingredient(type, name, price);
    }

    @Test
    public void getIngredientNameTest() {
        Assert.assertEquals("получено название ингридиента", name, ingredient.getName());
    }

    @Test
    public void getIngredientPriceTest() {
        Assert.assertEquals("получена цена ингридиента", price, ingredient.getPrice(), 0.001f);
    }

    @Test
    public void getIngredientTypeTest() {
        Assert.assertEquals("получен тип ингридиента", type, ingredient.getType());
    }
}
