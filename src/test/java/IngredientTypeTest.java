import org.junit.Test;
import praktikum.IngredientType;

import static org.junit.Assert.assertEquals;

public class IngredientTypeTest {

    @Test
    public void testEnumValueOf() {
        assertEquals("SAUCE не найден", IngredientType.SAUCE, IngredientType.valueOf("SAUCE"));
        assertEquals("FILLING не найден", IngredientType.FILLING, IngredientType.valueOf("FILLING"));
    }


}
