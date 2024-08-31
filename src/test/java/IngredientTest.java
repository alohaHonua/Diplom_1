import com.github.javafaker.Faker;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import praktikum.Ingredient;
import praktikum.IngredientType;
import java.util.Locale;
import static org.junit.Assert.assertEquals;
import static praktikum.IngredientType.*;

@RunWith(Parameterized.class)
public class IngredientTest {

    static Faker faker = new Faker(Locale.US);
    private Ingredient ingredient;
    private final IngredientType ingredientType;
    private final String name;
    private final float price;

    public IngredientTest(IngredientType ingredientType, String name, float price) {
        this.ingredientType = ingredientType;
        this.name = name;
        this.price = price;
    }

    @Parameterized.Parameters
    public static Object[][] getParameter() {
        return new Object[][] {
                {SAUCE, faker.food().dish(), faker.number().randomNumber()},
                {FILLING, faker.food().dish(), faker.number().randomNumber()},
                {null, faker.food().dish(), faker.number().randomNumber()},
                {SAUCE, null, faker.number().randomNumber()},
                {FILLING, faker.food().dish(), 0}
        };
    }

    @Before
    public void setUp() {
        ingredient = new Ingredient(ingredientType, name, price);
    }

    @Test
    public void typeTest() {
        assertEquals("Поле type сохранилось некорректно",
                ingredientType, ingredient.type);
    }

    @Test
    public void nameTest() {
        assertEquals("Поле name сохранилось некорректно",
                name, ingredient.getName());
    }

    @Test
    public void priceTest() {
        assertEquals("Поле price сохранилось некорректно",
                price, ingredient.getPrice(), 0);
    }

}


