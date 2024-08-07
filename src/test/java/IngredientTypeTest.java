import org.junit.Test;
import praktikum.IngredientType;

import static org.junit.Assert.assertEquals;

public class IngredientTypeTest {

    @Test
    public void typeSouseTest() {
        assertEquals( "SAUCE", IngredientType.SAUCE.name());
    }

    @Test
    public void typeFillingTest() {
        assertEquals( "FILLING", IngredientType.FILLING.name());
    }
}
