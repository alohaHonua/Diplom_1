import org.junit.Test;
import praktikum.IngredientType;
import static org.junit.Assert.assertEquals;


public class TestIngredientType {
    @Test
    public void ingredientTypeValuesTest() {
        assertEquals(IngredientType.SAUCE.toString(), "SAUCE");
        assertEquals(IngredientType.FILLING.toString(), "FILLING");
    }
}
