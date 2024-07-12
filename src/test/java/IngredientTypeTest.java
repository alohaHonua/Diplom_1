import org.junit.Test;
import praktikum.IngredientType;

import static org.junit.Assert.*;


public class IngredientTypeTest {

    @Test
    public void ingredientTypeTest() {
        for (IngredientType ingredientType : IngredientType.values()) {
            assertTrue(ingredientType.name() != null);
        }
    }
}
