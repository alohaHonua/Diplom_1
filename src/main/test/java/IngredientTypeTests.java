import praktikum.IngredientType;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class IngredientTypeTests {

    public static final String SAUCE = "SAUCE";
    public static final String FILLING = "FILLING";

    @Test
    public void sauceTest() {
        assertEquals("Ожидаемый тип ингредиента - " + SAUCE + ", получен тип " + IngredientType.SAUCE.toString(), SAUCE, IngredientType.SAUCE.toString());
    }
    @Test
    public void fillingTest() {
        assertEquals("Ожидаемый тип ингредиента - " + FILLING + ", получен тип " + IngredientType.FILLING.toString(), FILLING, IngredientType.FILLING.toString());
    }

}
