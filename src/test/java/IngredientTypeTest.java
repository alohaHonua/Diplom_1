import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static praktikum.IngredientType.FILLING;
import static praktikum.IngredientType.SAUCE;

public class IngredientTypeTest {

    private final static String sauce = "SAUCE";
    private final static String filling = "FILLING";

    @Test
    public void sauceTest(){
        assertEquals(String.format("Тип ингредиента отличается от %s",SAUCE.toString()),sauce, SAUCE.toString());
    }

    @Test
    public void fillingTest(){
        assertEquals(String.format("Тип ингредиента отличается от %s",FILLING.toString()),filling, FILLING.toString());
    }
}
