import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import praktikum.IngredientType;

@RunWith(Parameterized.class)
public class IngredientTypeTest {

    private final IngredientType type;
    private final IngredientType expected;

    public IngredientTypeTest(IngredientType type, IngredientType expected) {
        this.type = type;
        this.expected = expected;
    }

    @Parameterized.Parameters
    public static Object[][] ingredientTypeValues() {
        return new Object[][] {
                {IngredientType.SAUCE, IngredientType.valueOf("SAUCE")},
                {IngredientType.FILLING, IngredientType.valueOf("FILLING")},
        };
    }

    @Test
    public void ingredientTypeTest() {
        Assert.assertEquals(expected, type);
    }
}
