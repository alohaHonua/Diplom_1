import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import praktikum.IngredientType;

public class IngredientTypeTest {

    @Test
    public void ingredientTypeValuesReturnsAllTypes() {
        IngredientType[] types = IngredientType.values();
        assertNotNull(types);
        assertEquals(2, types.length);
        assertEquals(IngredientType.SAUCE, types[0]);
        assertEquals(IngredientType.FILLING, types[1]);
    }

    @Test
    public void ingredientTypeValueOfReturnsSauce() {
        IngredientType type = IngredientType.valueOf("SAUCE");
        assertNotNull(type);
        assertEquals(IngredientType.SAUCE, type);
    }

    @Test
    public void ingredientTypeValueOfReturnsFilling() {
        IngredientType type = IngredientType.valueOf("FILLING");
        assertNotNull(type);
        assertEquals(IngredientType.FILLING, type);
    }
}
