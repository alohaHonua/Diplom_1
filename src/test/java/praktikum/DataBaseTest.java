package praktikum;

import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;
import static praktikum.IngredientType.*;

public class DataBaseTest {

    private Database database;

    @Before
    public void setUp() {
        database = new Database();
    }

    @Test
    public void availableBunsSizeTest() {
        List<Bun> buns = database.availableBuns();
        assertEquals(3, buns.size());
    }

    @Test
    public void availableBunsContentTest() {
        List<Bun> buns = database.availableBuns();
        assertEquals("black bun", buns.get(0).getName());
        assertEquals(100, buns.get(0).getPrice(), 0.001);
        assertEquals("white bun", buns.get(1).getName());
        assertEquals(200, buns.get(1).getPrice(), 0.001);
        assertEquals("red bun", buns.get(2).getName());
        assertEquals(300, buns.get(2).getPrice(), 0.001);
    }

    @Test
    public void availableIngredientsSizeTest() {
        List<Ingredient> ingredients = database.availableIngredients();
        assertEquals(6, ingredients.size());
    }

    @Test
    public void availableIngredientsContentTest() {
        List<Ingredient> ingredients = database.availableIngredients();

        // Test sauces
        assertEquals(SAUCE, ingredients.get(0).getType());
        assertEquals("hot sauce", ingredients.get(0).getName());
        assertEquals(100, ingredients.get(0).getPrice(), 0.001);

        assertEquals(SAUCE, ingredients.get(1).getType());
        assertEquals("sour cream", ingredients.get(1).getName());
        assertEquals(200, ingredients.get(1).getPrice(), 0.001);

        assertEquals(SAUCE, ingredients.get(2).getType());
        assertEquals("chili sauce", ingredients.get(2).getName());
        assertEquals(300, ingredients.get(2).getPrice(), 0.001);

        // Test fillings
        assertEquals(FILLING, ingredients.get(3).getType());
        assertEquals("cutlet", ingredients.get(3).getName());
        assertEquals(100, ingredients.get(3).getPrice(), 0.001);

        assertEquals(FILLING, ingredients.get(4).getType());
        assertEquals("dinosaur", ingredients.get(4).getName());
        assertEquals(200, ingredients.get(4).getPrice(), 0.001);

        assertEquals(FILLING, ingredients.get(5).getType());
        assertEquals("sausage", ingredients.get(5).getName());
        assertEquals(300, ingredients.get(5).getPrice(), 0.001);
    }

    @Test
    public void availableBunsReturnsSameInstanceTest() {
        List<Bun> firstCall = database.availableBuns();
        List<Bun> secondCall = database.availableBuns();
        assertSame(firstCall, secondCall);
    }

    @Test
    public void availableIngredientsReturnsSameInstanceTest() {
        List<Ingredient> firstCall = database.availableIngredients();
        List<Ingredient> secondCall = database.availableIngredients();
        assertSame(firstCall, secondCall);
    }
}