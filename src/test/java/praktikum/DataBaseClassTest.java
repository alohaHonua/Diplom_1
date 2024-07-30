package praktikum;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class DataBaseClassTest {

    @Test
    public void testAvailableBuns() {
        Database database = new Database();
        assertNotNull(database.availableBuns());
        assertEquals(3, database.availableBuns().size());
    }

    @Test
    public void testAvailableIngredients() {
        Database database = new Database();
        assertNotNull(database.availableIngredients());
        assertEquals(6, database.availableIngredients().size());
    }
}


