package praktikum;

import org.junit.Assert;
import org.junit.Test;

public class IngredientTypeTest {

    @Test
    public void testEnum() {
        Assert.assertNotNull(IngredientType.valueOf("SAUCE"));
    }
}