
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;
import praktikum.IngredientType;

import java.util.Arrays;
import java.util.Collection;

@RunWith(Parameterized.class)
public class IngredientTypeTests {

    private final IngredientType ingredientType;

    public IngredientTypeTests(IngredientType ingredientType) {
        this.ingredientType = ingredientType;
    }

    @Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {IngredientType.SAUCE},
                {IngredientType.FILLING}
        });
    }

    @Test
    public void testIngredientTypeToString() {
        String expectedName = ingredientType.name();
        String actualName = ingredientType.toString();
        Assert.assertEquals("Метод вернул неправильное название ингредиента", expectedName, actualName);
    }
}
