import org.junit.jupiter.api.Test;
import praktikum.IngredientType;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class IngredientTypeTest {
    @Test
    void testSAUCE() {
        IngredientType sauce = IngredientType.SAUCE;
        assertNotNull(sauce);
        assertEquals("SAUCE", sauce.name());
    }

    @Test
    void testFILLING() {
        IngredientType filling = IngredientType.FILLING;
        assertNotNull(filling);
        assertEquals("FILLING", filling.name());
    }
}
