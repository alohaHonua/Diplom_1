package praktikum;

import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;

public class DataBaseSizeTest {
    private Database database;

    @Before
    public void setUp() {
        database = new Database();
    }

    @Test
    public void testAvailableBunsSize() {
        List<Bun> buns = database.availableBuns();
        assertEquals("There should be 3 buns in database", 3, buns.size());
    }

    @Test
    public void testAvailableIngredientsSize() {
        List<Ingredient> ingredients = database.availableIngredients();
        assertEquals("There should be 6 ingredients in database", 6, ingredients.size());
    }
}
