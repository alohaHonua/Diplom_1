import org.junit.Test;
import praktikum.Ingredient;
import static praktikum.IngredientType.SAUCE;
import static org.junit.Assert.assertEquals;

public class IngredientTest {
    Ingredient ingredient = new Ingredient(SAUCE, "Сыр", 100.54f);

     @Test
    public void testGetPrice(){
         assertEquals(100.54f, ingredient.getPrice(), 7000);
     }

     @Test
    public void testGetName(){
         assertEquals("Сыр", ingredient.getName());
     }

}
