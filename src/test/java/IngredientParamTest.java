import org.apache.commons.lang3.RandomStringUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import praktikum.Ingredient;
import praktikum.IngredientType;
import java.util.Random;
import static org.junit.Assert.assertEquals;
import static praktikum.Constants.*;

@RunWith(Parameterized.class)
public class IngredientParamTest {
    private final static RandomStringUtils randomStringUtils = new RandomStringUtils();
    private final static Random random = new Random();
    private final IngredientType type;
    private String name;
    private float price;

    public IngredientParamTest(IngredientType type, String name, float price) {
        this.type = type;
        this.name = name;
        this.price = price;
    }

    @Parameterized.Parameters
    public static Object[][] getBunNameTest() {
        return new Object[][]{
                {IngredientType.SAUCE, randomStringUtils.randomAlphabetic(10), random.nextFloat()},
                {IngredientType.FILLING, randomStringUtils.randomAlphabetic(10), random.nextFloat()}
        };
    }
    @Test
    public void ingredientNameTest() {
        Ingredient ingredient = new Ingredient(type, name, price);
        assertEquals(NAME_ERROR, name, ingredient.getName());
    }
    @Test
    public void ingredientPriceTest() {
        Ingredient ingredient = new Ingredient(type, name, price);
        assertEquals(PRICE_ERROR, price, ingredient.getPrice(), 0.0f);
    }
    @Test
    public void ingredientTypeTest() {
        Ingredient ingredient = new Ingredient(type, name, price);
        assertEquals(TYPE_ERROR, type, ingredient.getType());
    }
}
