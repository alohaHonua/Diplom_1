package praktikum;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class IngredientTypeTests {

    @Test
    public void ingredientTypeTestValues() {
        IngredientType[] types = IngredientType.values();
        assertEquals(IngredientType.FILLING, types[1]);
        assertEquals(IngredientType.SAUCE, types[0]);
    }

    @Test
    public void ingredientTypeTestLength() {
        IngredientType[] types = IngredientType.values();
        assertEquals(2, types.length);
    }

}
