import org.junit.Test;
import praktikum.IngredientType;

import static org.junit.Assert.assertEquals;

public class TestIngredientType {

    public static final String SAUCE = "SAUCE";
    public static final String FILLING = "FILLING";

    @Test
    public void TestSauce() {
        assertEquals(SAUCE, IngredientType.SAUCE.toString());
    }

    @Test
    public void TestFilling() {

        assertEquals(FILLING, IngredientType.FILLING.toString());
    }

}
