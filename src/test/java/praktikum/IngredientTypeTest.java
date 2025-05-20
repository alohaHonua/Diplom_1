package praktikum;

import org.junit.Test;
import static org.junit.Assert.*;

public class IngredientTypeTest {

    @Test
    public void valueOfSauceTest(){
        assertEquals("Значения не совпадают", IngredientType.SAUCE, IngredientType.valueOf("SAUCE"));
    }

    @Test
    public void valueOfFillingTest(){
        assertEquals("Значения не совпадают", IngredientType.FILLING, IngredientType.valueOf("FILLING"));
    }
}
