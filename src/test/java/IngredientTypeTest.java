import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import praktikum.IngredientType;
import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class IngredientTypeTest {

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][] {
                { IngredientType.SAUCE, "SAUCE" },
                { IngredientType.FILLING, "FILLING" }
        });
    }

    private final IngredientType expected;
    private final String input;

    public IngredientTypeTest(IngredientType expected, String input) {
        this.expected = expected;
        this.input = input;
    }

    @Test
    public void testIngredientType() {
        assertEquals(expected, IngredientType.valueOf(input));
    }
}
