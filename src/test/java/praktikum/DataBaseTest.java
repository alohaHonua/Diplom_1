package praktikum;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class DataBaseTest {
    @Test
    public void availableBunsReturnsCorrectValue() {
        Database database = new Database();
        assertEquals(3, database.availableBuns().size());
    }

    @Test
    public void availableIngredientsReturnsCorrectValue() {
        Database database = new Database();
        assertEquals(6, database.availableIngredients().size());
    }
}
