import org.junit.Before;
import org.junit.Test;
import praktikum.Bun;
import praktikum.Database;
import praktikum.Ingredient;
import java.util.List;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class DataBaseTest {
    private Database database;

    @Before
    public void setUp() {
        database = new Database();
    }

    @Test
    public void testAvailableBunsNotNull() {
        List<Bun> buns = database.availableBuns();
        assertNotNull(buns);
    }

    @Test
    public void testAvailableIngredientsNotNull() {
        List<Ingredient> ingredients = database.availableIngredients();
        assertNotNull(ingredients);
    }

    @Test
    public void testAvailableBunsSize() {
        List<Bun> buns = database.availableBuns();
        assertEquals(3, buns.size());
    }

    @Test
    public void testAvailableIngredientsSize() {
        List<Ingredient> ingredients = database.availableIngredients();
        assertEquals(6, ingredients.size());
    }
}