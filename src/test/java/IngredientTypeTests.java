import org.junit.Assert;
import org.junit.Test;
import praktikum.IngredientType;

import static praktikum.IngredientType.SAUCE;

public class IngredientTypeTests {
    @Test
    public void sauceTest() {
        Assert.assertEquals( "SAUCE", IngredientType.SAUCE.toString());
    }

    @Test
    public void fillingTest() {
        Assert.assertEquals( "FILLING", IngredientType.FILLING.toString());
    }
}

