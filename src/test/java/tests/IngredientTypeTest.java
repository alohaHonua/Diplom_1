package tests;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import praktikum.IngredientType;
import tests.base.ConstantsIngredientType;

@RunWith(Parameterized.class)
public class IngredientTypeTest {

    private final String input;
    private final IngredientType expected;

    public IngredientTypeTest(String input, IngredientType expected) {
        this.input = input;
        this.expected = expected;
    }

    @Parameterized.Parameters
    public static Object[][] data() {
        return new Object[][]{
                {ConstantsIngredientType.SAUCE.name(), IngredientType.SAUCE},
                {ConstantsIngredientType.FILLING.name(), IngredientType.FILLING}
        };
    }

    @Test
    public void valueOf() {
        Assert.assertEquals(expected, IngredientType.valueOf(input));
    }
}