package practikum;

import org.junit.Test;
import praktikum.IngredientType;

import static org.junit.Assert.assertEquals;

public class IngredientTypeTest {

    @Test
    public void checkSauce() {
        assertEquals("SAUCE", IngredientType.SAUCE.toString());
    }

    @Test
    public void checkFilling() {
        assertEquals("FILLING", IngredientType.FILLING.toString());
    }
}