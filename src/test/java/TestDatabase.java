

import org.junit.Before;
import org.junit.Test;
import praktikum.Bun;
import praktikum.Database;
import praktikum.Ingredient;
import praktikum.IngredientType;

import static org.junit.Assert.*;
import java.util.List;

public class TestDatabase {

    private Database database;

    @Before
    public void setUp() {
        database = new Database();
    }

    @Test
    public void testAvailableBuns() {
        List<Bun> expectedBuns = List.of(
                new Bun("black bun", 100),
                new Bun("white bun", 200),
                new Bun("red bun", 300)
        );

        List<Bun> actualBuns = database.availableBuns();

        assertEquals("Buns size should match", expectedBuns.size(), actualBuns.size(), 0);
        for (int i = 0; i < expectedBuns.size(); i++) {
            assertEquals("Bun names should match", expectedBuns.get(i).getName(), actualBuns.get(i).getName());
            assertEquals("Bun prices should match", expectedBuns.get(i).getPrice(), actualBuns.get(i).getPrice(), 0);
        }
    }

    @Test
    public void testAvailableIngredients() {
        List<Ingredient> expectedIngredients = List.of(
                new Ingredient(IngredientType.SAUCE, "hot sauce", 100),
                new Ingredient(IngredientType.SAUCE, "sour cream", 200),
                new Ingredient(IngredientType.SAUCE, "chili sauce", 300),
                new Ingredient(IngredientType.FILLING, "cutlet", 100),
                new Ingredient(IngredientType.FILLING, "dinosaur", 200),
                new Ingredient(IngredientType.FILLING, "sausage", 300)
        );

        List<Ingredient> actualIngredients = database.availableIngredients();

        assertEquals("Ingredients size should match", expectedIngredients.size(), actualIngredients.size(), 0);
        for (int i = 0; i < expectedIngredients.size(); i++) {
            assertEquals("Ingredient names should match", expectedIngredients.get(i).getName(), actualIngredients.get(i).getName());
            assertEquals("Ingredient prices should match", expectedIngredients.get(i).getPrice(), actualIngredients.get(i).getPrice(), 0);
            assertEquals("Ingredient types should match", expectedIngredients.get(i).getType(), actualIngredients.get(i).getType());
        }
    }
}
