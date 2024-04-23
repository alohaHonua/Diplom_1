import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import praktikum.IngredientType;
import java.util.Arrays;
import java.util.Collection;
import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class IngredientTypeTest {
    private final IngredientType ingredientType;
    private final String expectedTypeName;

    public IngredientTypeTest(IngredientType ingredientType, String expectedTypeName) {
        this.ingredientType = ingredientType;
        this.expectedTypeName = expectedTypeName;
    }

    @Parameterized.Parameters(name = "{index}: IngredientType {0} should have name {1}")
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {IngredientType.SAUCE, "SAUCE"},
                {IngredientType.FILLING, "FILLING"}
        });
    }

    @Test
    public void testGetName() {
        assertEquals(expectedTypeName, ingredientType.name());
    }
}