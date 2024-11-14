import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import praktikum.Ingredient;
import praktikum.IngredientType;

public class IngredientTest {
    private final String EXPECTED_NAME = "test sauce";
    private final float EXPECTED_PRICE = 7.77F;
    private Ingredient ingredient;

    @Before
    public void setUp() {
        ingredient = new Ingredient(IngredientType.SAUCE, EXPECTED_NAME, EXPECTED_PRICE);
    }

    @Test
    public void getPriceTest() {
        Assert.assertEquals("Не верная цена ингридиента", EXPECTED_PRICE, ingredient.getPrice(), 0);
    }

    @Test
    public void getNameTest() {
        Assert.assertEquals("Название ингридиента не совпадает", EXPECTED_NAME, ingredient.getName());
    }

    @Test
    public void getTypeTest() {
        Assert.assertEquals("Название ингридиента не совпадает", IngredientType.SAUCE, ingredient.getType());
    }
}
