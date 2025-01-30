package praktikum;

import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;

public class DatabaseTest {

    Database database = new Database();

    @Test
    public void availableBuns() {
        assertNotNull("List of buns is null", database.availableBuns());
        assertFalse("List of buns is empty", database.availableBuns().isEmpty());
    }

    @Test
    public void availableIngredients() {
        assertNotNull("List of ingredients is null", database.availableIngredients());
        assertFalse("List of ingredients is empty", database.availableIngredients().isEmpty());
    }
}