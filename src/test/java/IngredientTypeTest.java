import org.junit.Test;
import static org.junit.Assert.assertEquals;
import static praktikum.IngredientType.*;

public class IngredientTypeTest {

    @Test
    public void testIngredientTypeValues() {
        assertEquals("SAUCE", SAUCE.name());
        assertEquals("FILLING", FILLING.name());
    }

}
