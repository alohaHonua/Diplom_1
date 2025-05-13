package praktikum;

import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

public class IngredientTypeTest {

    @Test
    public void valueFilling() {
        assertEquals("FILLING", IngredientType.FILLING.name());
    }

    @Test
    public void valueSauce() {
        assertEquals("SAUCE", IngredientType.SAUCE.name());
    }
}

