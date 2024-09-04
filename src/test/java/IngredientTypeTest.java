import org.junit.Assert;
import org.junit.Test;
import praktikum.IngredientType;

public class IngredientTypeTest {
    public static final String SAUCE = "SAUCE";
    public static final String FILLING = "FILLING";

    @Test
    public void sauceTest() {
        Assert.assertEquals(SAUCE, IngredientType.SAUCE.toString());
    }

    @Test
    public void fillingTest() {
        Assert.assertEquals(FILLING, IngredientType.FILLING.toString());
    }
}
