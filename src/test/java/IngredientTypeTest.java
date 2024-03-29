import org.junit.Assert;
import org.junit.Test;
import praktikum.IngredientType;

import static praktikum.Constants.FILLING;
import static praktikum.Constants.SAUCE;

public class IngredientTypeTest {
    @Test
    public void sauceTest() {
        Assert.assertEquals(SAUCE, IngredientType.SAUCE.toString());
    }

    @Test
    public void fillingTest() {
        Assert.assertEquals(FILLING, IngredientType.FILLING.toString());
    }
}
