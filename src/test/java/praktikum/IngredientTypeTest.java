package praktikum;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class IngredientTypeTest {
    @Test
    public void testSauceIngredient() {
        assertEquals(IngredientType.valueOf("SAUCE"), IngredientType.SAUCE);
    }

    @Test
    public void testFillingIngredient() {
        assertEquals(IngredientType.valueOf("FILLING"), IngredientType.FILLING);
    }
}
