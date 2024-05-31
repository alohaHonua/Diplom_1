import org.junit.Test;
import praktikum.IngredientType;
import static org.junit.Assert.*;
public class IngredientTypeTest {


    @Test
    public void ingredientTypeSuceTest(){
        assertEquals(IngredientType.SAUCE,IngredientType.valueOf("SAUCE"));
    }

    @Test
    public void ingredientTypeFillingTest(){
        assertEquals(IngredientType.FILLING,IngredientType.valueOf("FILLING"));
    }
}
