package unit;

import org.junit.Test;
import praktikum.IngredientType;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class IngredientTypeTest {

    @Test
    public void enumValuesShouldExist() {
        assertNotNull("The SAUCE value must exist", IngredientType.valueOf("SAUCE"));
        assertNotNull("The FILLING value must exist", IngredientType.valueOf("FILLING"));
    }

    @Test
    public void enumToStringShouldWork() {
        assertEquals("toString for SAUCE", "SAUCE", IngredientType.SAUCE.toString());
        assertEquals("toString for FILLING", "FILLING", IngredientType.FILLING.toString());
    }
}
