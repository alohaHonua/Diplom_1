import org.junit.Test;
import praktikum.IngredientType;

import static org.junit.Assert.assertEquals;

public class IngredientTypeTest {

    @Test
    public void sauceIngredientTypeTest() {
        assertEquals(IngredientType.SAUCE, IngredientType.valueOf("SAUCE"));
    }

    @Test
    public void fillingIngredientTypeTest() {
        assertEquals(IngredientType.FILLING, IngredientType.valueOf("FILLING"));
    }
}