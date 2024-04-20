package praktikum;
import org.junit.Test;
import java.util.List;
import static org.junit.Assert.assertFalse;
public class DatabaseTest {
    @Test
    public void availableBunsTest() {
        List<Bun> buns = new Database().availableBuns();
        assertFalse(buns.isEmpty());
    }
    @Test
    public void availableIngredientsTest() {
        List<Ingredient> ingredients = new Database().availableIngredients();
        assertFalse(ingredients.isEmpty());
    }
}
