package praktikum;

import org.junit.Before;
import org.junit.Test;

import java.util.List;
import static org.junit.Assert.*;

public class DataBaseTest {

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
    public void testAvailableBunsContainsBlackBun() {
        List<Bun> buns = database.availableBuns();
        assertTrue("Buns should contain black bun",
                buns.stream().anyMatch(b -> b.getName().equals("black bun") && b.getPrice() == 100));
    }

    @Test
    public void testAvailableBunsContainsWhiteBun() {
        List<Bun> buns = database.availableBuns();
        assertTrue("Buns should contain white bun",
                buns.stream().anyMatch(b -> b.getName().equals("white bun") && b.getPrice() == 200));
    }

    @Test
    public void testAvailableBunsContainsRedBun() {
        List<Bun> buns = database.availableBuns();
        assertTrue("Buns should contain red bun",
                buns.stream().anyMatch(b -> b.getName().equals("red bun") && b.getPrice() == 300));
    }


    @Test
    public void testAvailableIngredientsSize() {
        List<Ingredient> ingredients = database.availableIngredients();
        assertEquals("There should be 6 ingredients in database", 6, ingredients.size());
    }

    @Test
    public void testAvailableIngredientsContainsHotSauce() {
        List<Ingredient> ingredients = database.availableIngredients();
        assertTrue("Ingredients should contain hot sauce",
                ingredients.stream().anyMatch(i ->
                        i.getType() == IngredientType.SAUCE &&
                                i.getName().equals("hot sauce") &&
                                i.getPrice() == 100));
    }

    @Test
    public void testAvailableIngredientsContainsSourCream() {
        List<Ingredient> ingredients = database.availableIngredients();
        assertTrue("Ingredients should contain sour cream",
                ingredients.stream().anyMatch(i ->
                        i.getType() == IngredientType.SAUCE &&
                                i.getName().equals("sour cream") &&
                                i.getPrice() == 200));
    }

    @Test
    public void testAvailableIngredientsContainsChiliSauce() {
        List<Ingredient> ingredients = database.availableIngredients();
        assertTrue("Ingredients should contain chili sauce",
                ingredients.stream().anyMatch(i ->
                        i.getType() == IngredientType.SAUCE &&
                                i.getName().equals("chili sauce") &&
                                i.getPrice() == 300));
    }

    @Test
    public void testAvailableIngredientsContainsCutlet() {
        List<Ingredient> ingredients = database.availableIngredients();
        assertTrue("Ingredients should contain cutlet",
                ingredients.stream().anyMatch(i ->
                        i.getType() == IngredientType.FILLING &&
                                i.getName().equals("cutlet") &&
                                i.getPrice() == 100));
    }

    @Test
    public void testAvailableIngredientsContainsDinosaur() {
        List<Ingredient> ingredients = database.availableIngredients();
        assertTrue("Ingredients should contain dinosaur",
                ingredients.stream().anyMatch(i ->
                        i.getType() == IngredientType.FILLING &&
                                i.getName().equals("dinosaur") &&
                                i.getPrice() == 200));
    }

    @Test
    public void testAvailableIngredientsContainsSausage() {
        List<Ingredient> ingredients = database.availableIngredients();
        assertTrue("Ingredients should contain sausage",
                ingredients.stream().anyMatch(i ->
                        i.getType() == IngredientType.FILLING &&
                                i.getName().equals("sausage") &&
                                i.getPrice() == 300));
    }

}