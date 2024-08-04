import org.junit.Test;
import static org.junit.Assert.assertEquals;
import praktikum.IngredientType;

public class IngredientTypeTest {

    @Test
    public void testAllValues() {
        assertEquals(2, IngredientType.values().length);
        assertEquals(IngredientType.SAUCE, IngredientType.values()[0]);
        assertEquals(IngredientType.FILLING, IngredientType.values()[1]);
    }
}
