import org.junit.Test;
import praktikum.IngredientType;
import static org.junit.Assert.*;

public class IngredientTypeTest {

    @Test
    public void testToString_Sauce() {
        assertEquals("SAUCE", IngredientType.SAUCE.toString());
    }

    @Test
    public void testToString_Filling() {
        assertEquals("FILLING", IngredientType.FILLING.toString());
    }

    @Test
    public void testValues() {
        IngredientType[] values = IngredientType.values();
        assertEquals(2, values.length);
    }
}
