package praktikum;

import com.github.javafaker.Faker;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class IngredientTest {

    private final Faker faker = new Faker();
    Ingredient ingredient;
    private final String ingredientName = faker.funnyName().name();
    private final float ingredientPrice = (float) faker.random().nextDouble();
    private final IngredientType ingredientType;

    public IngredientTest(IngredientType ingredientType) {
        this.ingredientType = ingredientType;
    }

    @Before
    public void setUp() throws Exception {
        ingredient = new Ingredient(ingredientType, ingredientName, ingredientPrice);
    }

    @Parameterized.Parameters
    public static Object[][] getIngredientTypeForTests() {
        return new Object[][]{
                {IngredientType.SAUCE},
                {IngredientType.FILLING},
        };
    }

    @Test
    public void getPrice() {
        assertEquals("Ingredient price is not that we installed", 0, Float.compare(ingredientPrice,
                ingredient.getPrice()));

    }

    @Test
    public void getName() {
        assertEquals("Ingredient name is not that we installed", ingredientName, ingredient.getName());
    }

    @Test
    public void getType() {
        assertEquals("Ingredient type is not that we installed", ingredientType, ingredient.getType());
    }
}