package praktikum;

import org.junit.Test;
import static org.junit.Assert.*;
import praktikum.IngredientType;

public class IngredientTypeTest {

    @Test
    public void testEnumValues() {
        IngredientType[] types = IngredientType.values();
        assertArrayEquals(new IngredientType[]{IngredientType.SAUCE, IngredientType.FILLING}, types);
    }
}
