import praktikum.Bun;
import praktikum.Database;
import praktikum.Ingredient;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;

@RunWith(Parameterized.class)
public class DatabaseTest {

    private int expectedBunCount;
    private int expectedIngredientCount;

    public DatabaseTest(int expectedBunCount, int expectedIngredientCount) {
        this.expectedBunCount = expectedBunCount;
        this.expectedIngredientCount = expectedIngredientCount;
    }

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][] {
                { 3, 6 },
                // Здесь можно добавить другие тестовые наборы, если потребуется
        });
    }

    @Test
    public void testAvailableBuns() {
        Database database = new Database();
        Assert.assertEquals(expectedBunCount, database.availableBuns().size());
    }

    @Test
    public void testAvailableIngredients() {
        Database database = new Database();
        Assert.assertEquals(expectedIngredientCount, database.availableIngredients().size());
    }
    @Test
    public void testAvailableBunsContent() {
        Database database = new Database();
        List<Bun> buns = database.availableBuns();
        Assert.assertTrue(buns.stream().anyMatch(b -> b.getName().equals("black bun")));
    }

    @Test
    public void testAvailableIngredientsContent() {
        Database database = new Database();
        List<Ingredient> ingredients = database.availableIngredients();
        Assert.assertTrue(ingredients.stream().anyMatch(i -> i.getName().equals("hot sauce")));
    }
}