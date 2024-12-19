package praktikum;

import org.junit.Assert;
import org.junit.Test;


public class IngredientTypeTest {

    @Test
    public void testIngredientTypeValues() {
        Assert.assertEquals("First type should be SAUCE", IngredientType.SAUCE, IngredientType.valueOf("SAUCE"));
        Assert.assertEquals("Second type should be FILLING", IngredientType.FILLING, IngredientType.valueOf("FILLING"));
    }


}
