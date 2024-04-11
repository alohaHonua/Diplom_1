package praktikum;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class DatabaseTest {
    Database database = new Database();

    @Test
    public void checkAvailableBunsSize() {
        assertEquals("Количество булок не совпало",
                3,
                database.availableBuns().size());
    }

    @Test
    public void checkAvailableIngredientsSize() {
        assertEquals("Количество ингредиентов не совпало",
                6,
                database.availableIngredients().size());
    }
}