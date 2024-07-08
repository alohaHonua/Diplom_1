package praktikum;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class IngredientTypeTest {

    @Test
    public void sauceTypeTest() {
        Assert.assertEquals("SAUCE", IngredientType.SAUCE.name());
    }

    @Test
    public void fillingTypeTest() {
        assertEquals("FILLING", IngredientType.FILLING.name());
    }
}
