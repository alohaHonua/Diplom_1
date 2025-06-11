package praktikum;

import org.junit.Test;

import static org.junit.Assert.*;

public class IngredientTypeTest {
    @Test
    public void ingredientTypeSauceExists() {
        assertEquals("SAUCE", IngredientType.SAUCE.name());
    }

    @Test
    public void ingredientTypeFillingExists() {
        assertEquals("FILLING", IngredientType.FILLING.name());
    }
}