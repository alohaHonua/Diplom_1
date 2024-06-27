package praktikum;

import org.junit.Assert;
import org.junit.Test;

public class IngredientTypeTest {

    @Test
    public void checkValueSauceTest() {
        String sauce = "SAUCE";
        String actual = IngredientType.valueOf(sauce).toString();
        Assert.assertEquals(sauce, actual);

    }
    @Test
    public void checkValueFillingTest() {
        String filling = "FILLING";
        String actual = IngredientType.valueOf(filling).toString();
        Assert.assertEquals(filling, actual);
    }

    @Test
    public void checkSizeEnum() {
        int actual = IngredientType.values().length;
        Assert.assertEquals(2, actual);
    }
}
