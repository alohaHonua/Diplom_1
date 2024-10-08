package praktikum;

import org.junit.Test;
import static org.junit.Assert.*;

public class IngredientTypeTest {

    @Test
    public void shouldBeTypeSause() {
        assertEquals(IngredientType.valueOf("SAUCE"),IngredientType.SAUCE);
    }

    @Test
    public void shouldBeTypeFilling() {
        assertEquals(IngredientType.valueOf("FILLING"),IngredientType.FILLING);
    }

    @Test
    public void shouldBeLenghtIngredientType() {
        int actualResult= IngredientType.values().length;
        assertEquals(2,actualResult);
    }
}
