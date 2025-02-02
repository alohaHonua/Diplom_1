import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import praktikum.Ingredient;
import praktikum.IngredientType;
import java.util.Arrays;
import java.util.Collection;
import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class IngredientTest {
    private final IngredientType ingredientType;
    private final String ingredientName;
    private final float ingredientPrice;

    public IngredientTest(IngredientType ingredientType, String ingredientName, float ingredientPrice) {
        this.ingredientType = ingredientType;
        this.ingredientName = ingredientName;
        this.ingredientPrice = ingredientPrice;
    }
    @Parameterized.Parameters
    public static Collection<Object[]> dataForTest() {
        return Arrays.asList(new Object[][]{
                {IngredientType.SAUCE, "hot sauce", 100},
                {IngredientType.SAUCE, "sour cream", 200},
                {IngredientType.SAUCE, "chili sauce", 300},

                {IngredientType.FILLING, "cutlet", 100},
                {IngredientType.FILLING, "dinosaur", 200},
                {IngredientType.FILLING, "sausage", 300}
        });
    }
    @Test
    public void checkIngredientType() {
        Ingredient ingredient = new Ingredient(ingredientType, ingredientName, ingredientPrice);
        assertEquals(ingredientType, ingredient.getType());
    }
    @Test
    public void checkIngredientName() {
        Ingredient ingredient = new Ingredient(ingredientType, ingredientName, ingredientPrice);
        assertEquals(ingredientName, ingredient.getName());
    }
    @Test
    public void checkIngredientPrice() {
        Ingredient ingredient = new Ingredient(ingredientType, ingredientName, ingredientPrice);
        assertEquals(ingredientPrice, ingredient.getPrice(), 0.0);
    }
}