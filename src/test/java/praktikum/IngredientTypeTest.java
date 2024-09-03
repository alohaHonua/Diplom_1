package praktikum;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

public class IngredientTypeTest {

    @Test
    public void ingredientTypesTest() {
        String expectedListAsString = Arrays.asList("SAUCE", "FILLING").toString();
        String actualListAsString = Arrays.toString(IngredientType.values());
        Assert.assertEquals(
                "Состав типов ингредиентов не соответствует ожидаемому",
                expectedListAsString,
                actualListAsString);
    }
}
