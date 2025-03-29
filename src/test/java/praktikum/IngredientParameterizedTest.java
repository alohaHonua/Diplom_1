package praktikum;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import java.util.Arrays;
import java.util.Collection;
import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class IngredientParameterizedTest {

    private IngredientType expectedType;
    private String expectedName;
    private float expectedPrice;

    public IngredientParameterizedTest(IngredientType expectedType, String expectedName, float expectedPrice) {
        this.expectedType = expectedType;
        this.expectedName = expectedName;
        this.expectedPrice = expectedPrice;
    }

    @Parameterized.Parameters(name = "Тестовые данные: тип ингредиента = {0}, название = {1}, цена = {2}")
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][] {
                {IngredientType.SAUCE, "hot sauce", 100.0f},
                {IngredientType.SAUCE, "sour cream", 200.0f},
                {IngredientType.SAUCE, "chili sauce", 300.0f},
                {IngredientType.FILLING, "cutlet", 100.0f},
                {IngredientType.FILLING, "dinosaur", 200.0f},
                {IngredientType.FILLING, "sausage", 300.0f}
        });
    }

    @Test
    public void testIngredientGetPrice() {
        Ingredient ingredient = new Ingredient(expectedType, expectedName, expectedPrice);
        float actualPrice = ingredient.getPrice();
        assertEquals("Цена ингредиента не соответствует ожидаемой", expectedPrice, actualPrice, 0.01f);
    }

    @Test
    public void testIngredientGetName() {
        Ingredient ingredient = new Ingredient(expectedType, expectedName, expectedPrice);
        String actualName = ingredient.getName();
        assertEquals("Название ингредиента не соответствует ожидаемому", expectedName, actualName);
    }

    @Test
    public void testIngredientGetType() {
        Ingredient ingredient = new Ingredient(expectedType, expectedName, expectedPrice);
        IngredientType actualType = ingredient.getType();
        assertEquals("Тип ингредиента не соответствует ожидаемому", expectedType, actualType);
    }
}
