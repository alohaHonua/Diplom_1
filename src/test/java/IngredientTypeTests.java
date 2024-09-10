import org.junit.Test;
import praktikum.IngredientType;

import static org.junit.Assert.assertEquals;
public class IngredientTypeTests {
    @Test
    public void ingredientSauceTypeTest() {
        assertEquals(IngredientType.valueOf("SAUCE"), IngredientType.SAUCE);
    }

    @Test
    public void ingredientFillingTypeTest() {
        assertEquals(IngredientType.valueOf("FILLING"), IngredientType.FILLING);
    }

}
