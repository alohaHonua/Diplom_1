package praktikum;

import org.junit.Assert;
import org.junit.Test;

public class IngredientTypeTest {
    @Test
    public void ingredientTypeTest() {
        Assert.assertEquals(IngredientType.SAUCE.toString(), "SAUCE");
        Assert.assertEquals(IngredientType.FILLING.toString(), "FILLING");
    }

}