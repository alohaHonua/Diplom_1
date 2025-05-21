import org.junit.Test;
import praktikum.IngredientType;

import static org.junit.Assert.*;

public class IngredientTypeTest {
    @Test
    public void ingredientTypeContainsSauceTest() {
        assertNotNull(IngredientType.SAUCE);
    }

    @Test
    public void ingredientTypeContainsFillingTest() {
        assertNotNull(IngredientType.FILLING);
    }
}