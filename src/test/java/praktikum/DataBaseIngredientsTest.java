package praktikum;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import static org.junit.Assert.*;
import static praktikum.IngredientType.FILLING;
import static praktikum.IngredientType.SAUCE;

@RunWith(Parameterized.class)
public class DataBaseIngredientsTest {

    private Database database;
    private IngredientType type;
    private String name;
    private float price;

    public DataBaseIngredientsTest(IngredientType type, String name, float price) {
        this.type = type;
        this.name = name;
        this.price = price;
    }

    @Before
    public void setUp() {
        database = new Database();
    }



    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {SAUCE, "hot sauce", 100}, {SAUCE, "sour cream", 200}, {SAUCE, "chili sauce", 300},
                {FILLING, "cutlet", 100}, {FILLING, "dinosaur", 200}, {FILLING, "sausage", 300}
        });
    }

    @Test
    public void testAvailableIngredientsContainsHotSauce() {
        List<Ingredient> ingredients = database.availableIngredients();
        assertTrue("Ingredients should contain " + name,
                ingredients.stream().anyMatch(i ->
                        i.getType() == type &&
                                i.getName().equals(name) &&
                                i.getPrice() == price));
    }

}