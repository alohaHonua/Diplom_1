package praktikum;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class IngredientTypeTest {
    @Test
    public void ingredientTypeIsSauceTest() {
        assertEquals("SAUCE", IngredientType.SAUCE.name());
    }

    @Test
    public void ingredientTypeIsFillingTest() {
        assertEquals("FILLING", IngredientType.FILLING.name());
    }

    @Test
    public void ingredientTypeOrderTest() {
        assertEquals(0, IngredientType.SAUCE.ordinal());
        assertEquals(1, IngredientType.FILLING.ordinal());
    }

    @Test
    public void ingredientTypeValuesTest() {
        assertEquals(IngredientType.SAUCE, IngredientType.valueOf("SAUCE"));
        assertEquals(IngredientType.FILLING, IngredientType.valueOf("FILLING"));
    }

    @Test(expected = IllegalArgumentException.class)
    public void ingredientTypeInvalidValueTest() {
        IngredientType.valueOf("TEST");
    }
}
