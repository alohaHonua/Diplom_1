package ingredientType;

import org.junit.Test;
import praktikum.IngredientType;

import static org.junit.Assert.*;

public class IngredientTypeTest {
    @Test
    public void ingredientIsExist() {
        assertNotNull(IngredientType.valueOf("SAUCE"));
        assertNotNull(IngredientType.valueOf("FILLING"));
    }
}
