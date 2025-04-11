import org.junit.Test;
import org.mockito.Mockito;
import java.util.Arrays;
import java.util.List;
import static org.junit.Assert.*;
import praktikum.Ingredient;

public class BurgerRegularTest extends BurgerBaseTest {

    @Test
    public void testSetBuns() {
        burger.setBuns(bun);
        assertEquals(bun, burger.bun);
    }

    @Test
    public void addIngredientTest() {
        burger.addIngredient(ingredient1);
        assertEquals(1, burger.ingredients.size());
        assertTrue(burger.ingredients.contains(ingredient1));
    }

    @Test
    public void removeIngredientTest() {
        burger.ingredients.add(ingredient1);
        burger.removeIngredient(0);
        assertEquals(0, burger.ingredients.size());
    }

    @Test
    public void testMoveIngredient() {
        burger.addIngredient(ingredient1);
        burger.addIngredient(ingredient2);

        burger.moveIngredient(0, 1);

        List<Ingredient> ingredients = burger.ingredients;
        assertEquals(ingredient2, ingredients.get(0));
        assertEquals(ingredient1, ingredients.get(1));
    }
}