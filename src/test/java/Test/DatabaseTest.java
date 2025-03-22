package Test;

import org.junit.Test;
import praktikum.Bun;
import praktikum.Database;
import praktikum.Ingredient;

import java.util.List;
import static org.junit.Assert.*;

public class DatabaseTest {
    @Test
    public void testAvailableBuns() {
        Database database = new Database();
        List<Bun> buns = database.availableBuns();
        assertNotNull(buns);
        assertEquals(3, buns.size());
        assertEquals("black bun", buns.get(0).getName());
    }

    @Test
    public void testAvailableIngredients() {
        Database database = new Database();
        List<Ingredient> ingredients = database.availableIngredients();
        assertNotNull(ingredients);
        assertEquals(6, ingredients.size());
        assertEquals("hot sauce", ingredients.get(0).getName());
    }
}
