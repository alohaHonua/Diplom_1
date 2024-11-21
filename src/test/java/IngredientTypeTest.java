import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import praktikum.IngredientType;

public class IngredientTypeTest {

    @Test
    public void sauceTest() {
        assertNotNull(IngredientType.SAUCE);
    }

    @Test
    public void fillingTest() {
        assertNotNull(IngredientType.FILLING);
    }
}