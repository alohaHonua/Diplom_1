package praktikum;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

@RunWith(Parameterized.class)
public class IngredientTypeTest {

    private final IngredientType ingredientType;
    private final String name;
    private final int number;

    @Parameterized.Parameters
    public static Object[][] data() {
        return new Object[][] {
                {IngredientType.SAUCE, "SAUCE", 0},
                {IngredientType.FILLING, "FILLING", 1},
        };
    }

    public IngredientTypeTest(IngredientType ingredientType, String name, int number) {
        this.ingredientType = ingredientType;
        this.name = name;
        this.number = number;
    }

    @Test
    public void ingredientTypeOrdinalTest() {
        int expected = number;
        int actual = ingredientType.ordinal();
        Assert.assertEquals("Порядковый номер не совпадает", expected, actual);
    }

    @Test
    public void ingredientTypeNamesTest() {
        String expected = name;
        String actual = ingredientType.name();
        Assert.assertEquals("Тип ингредиента не совпадает", expected, actual);
    }
}