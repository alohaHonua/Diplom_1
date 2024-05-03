package praktikum;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import java.util.List;

public class DatabaseTest {
    private Database database;

    @Before
    public void setUp() {
        database = new Database();
    }

    @Test
    public void testAvailableBuns() {
        List<Bun> buns = database.availableBuns();
        Assert.assertFalse(buns.isEmpty());
    }
    @Test
    public void testAvailableIngredients() {
        List<Ingredient> ingredients = database.availableIngredients();
        Assert.assertFalse(ingredients.isEmpty());
    }
}