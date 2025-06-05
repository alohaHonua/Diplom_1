
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import praktikum.Ingredient;
import praktikum.IngredientType;
import static org.junit.Assert.*;


@RunWith(Parameterized.class)
public class IngredientTest {

    @Parameterized.Parameters(name = "{index}: Type={0}, Name=''{1}'', Price={2}")
    public static Object[][] getTestData() {
        return new Object[][]{
                // Основные тестовые случаи
                {IngredientType.SAUCE, "hot sauce", 100.0f},
                {IngredientType.FILLING, "cutlet", 200.0f},

                // Граничные случаи
                {IngredientType.SAUCE, "", 0.0f},
                {IngredientType.FILLING, " ", Float.MAX_VALUE},
                {IngredientType.SAUCE, "long name with spaces", Float.MIN_VALUE},
                {IngredientType.FILLING, "special@chars!#", 999.99f}
        };
    }

    @Parameterized.Parameter(0)
    public IngredientType inputType;

    @Parameterized.Parameter(1)
    public String inputName;

    @Parameterized.Parameter(2)
    public float inputPrice;

    @Test
    public void getType_shouldReturnCorrectType() {
        Ingredient ingredient = new Ingredient(inputType, inputName, inputPrice);
        assertEquals(inputType, ingredient.getType());
    }

    @Test
    public void getName_shouldReturnCorrectName() {
        Ingredient ingredient = new Ingredient(inputType, inputName, inputPrice);
        assertEquals(inputName, ingredient.getName());
    }

    @Test
    public void getPrice_shouldReturnCorrectPrice() {
        Ingredient ingredient = new Ingredient(inputType, inputName, inputPrice);
        assertEquals(inputPrice, ingredient.getPrice(), 0.001f);
    }
}
