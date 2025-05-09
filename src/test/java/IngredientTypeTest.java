import org.junit.Test;
import praktikum.IngredientType;
import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

public class IngredientTypeTest {

    @Test
    public void ingredientTypeValuesTest() {
        IngredientType[] types = IngredientType.values();
        assertArrayEquals(new IngredientType[]{IngredientType.SAUCE, IngredientType.FILLING}, types);
    }

    @Test
    public void ingredientTypeNameTest() {
        assertEquals("SAUCE", IngredientType.SAUCE.name());
        assertEquals("FILLING", IngredientType.FILLING.name());
    }
}