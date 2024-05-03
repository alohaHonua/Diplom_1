import org.junit.Test;
import praktikum.IngredientType;

import static praktikum.IngredientType.*;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class IngredientTypeTest {

    @Test
    public void sauceTest() {
        assertEquals("SAUCE", SAUCE.toString());
    }

    @Test
    public void fillingTest() {
        assertEquals("FILLING", FILLING.toString());
    }

    @Test
    public void sauceNotNullTest() {
        assertNotNull(IngredientType.valueOf("SAUCE"));
    }

    @Test
    public void fillingNotNullTest() {
        assertNotNull(IngredientType.valueOf("FILLING"));
    }
}