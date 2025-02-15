import com.github.javafaker.Faker;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import praktikum.Ingredient;
import praktikum.IngredientType;

@RunWith(Parameterized.class)
public class IngredientTest {
    private final IngredientType type;
    private final String name;
    private final float price;
    Ingredient ingredient;
    static Faker faker = new Faker();
    public static String nameOneIngredient = faker.food().dish();
    public static String nameTwoIngredient = faker.food().dish();
    public static float priceOneIngredient  = (float) Math.random();
    public static float priceTwoIngredient  = (float) Math.random();


    public IngredientTest(IngredientType type, String name, float price) {
        this.type = type;
        this.name = name;
        this.price = price;
    }
    @Parameterized.Parameters (name = "Ингридиент {1} с типом  {0}")
    public static Object[][] getOneAndTwoIngredient() {
        return new Object[][] {
                {IngredientType.SAUCE, nameOneIngredient, priceOneIngredient},
                {IngredientType.FILLING, nameTwoIngredient, priceTwoIngredient},
        };
    }
    @Before
    public void setUp() {
        ingredient = new Ingredient(type, name, price);
    }

    @Test
    public void checkGetPrice() {
        Assert.assertEquals(price, ingredient.getPrice(), 0);
    }

    @Test
    public void checkGetName() {
        Assert.assertEquals(name, ingredient.getName());
    }

    @Test
    public void checkGetType() {
        Assert.assertEquals(type, ingredient.getType());
    }
}
