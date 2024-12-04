import org.junit.Test;
import praktikum.Ingredient;
import static org.junit.Assert.assertEquals;
import static praktikum.IngredientType.*;

public class IngredientTest {

    @Test
    public void testGetIngredientPrice(){
        Ingredient ingredient = new Ingredient(SAUCE, "ketchup", 100);
        assertEquals(100, ingredient.getPrice(), 0.01);
    }

    @Test
    public void testGetIngredientName(){
        Ingredient ingredient = new Ingredient(FILLING, "cheese", 120);
        assertEquals("cheese", ingredient.getName());
    }

    @Test
    public void testIngredientGetType(){
        Ingredient ingredient = new Ingredient(FILLING, "onion", 80);
        assertEquals(FILLING, ingredient.getType());
    }

}
