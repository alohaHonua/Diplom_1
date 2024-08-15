import org.junit.Before;
import org.junit.Test;
import praktikum.Bun;
import praktikum.Database;
import praktikum.Ingredient;
import praktikum.IngredientType;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class DatabaseTest {

    private Database database;

    @Before
    public void setUp() {
        // Создаем экземпляр базы данных перед каждым тестом
        database = new Database();
    }

    @Test
    public void testAvailableBunsSize() {
        // Проверяем, что в базе данных есть 3 булочки
        int expectedBunCount = 3;
        List<Bun> buns = database.availableBuns();
        assertEquals(expectedBunCount, buns.size());
    }

    @Test
    public void testAvailableIngredientsSize() {
        // Проверяем, что в базе данных есть 6 ингредиентов
        int expectedIngredientCount = 6;
        List<Ingredient> ingredients = database.availableIngredients();
        assertEquals(expectedIngredientCount, ingredients.size());
    }

    @Test
    public void testFirstBunName() {
        // Проверяем, что первая булочка в списке имеет имя "black bun"
        String expectedFirstBunName = "black bun";
        List<Bun> buns = database.availableBuns();
        assertEquals(expectedFirstBunName, buns.get(0).getName());
    }

    @Test
    public void testSecondIngredientType() {
        // Проверяем, что второй ингредиент в списке имеет тип SAUCE
        IngredientType expectedSecondIngredientType = IngredientType.SAUCE;
        List<Ingredient> ingredients = database.availableIngredients();
        assertEquals(expectedSecondIngredientType, ingredients.get(1).getType());
    }

    @Test
    public void testIngredientPrice() {
        // Проверяем, что у ингредиента с именем "cutlet" цена равна 100
        float expectedCutletPrice = 100.0f;
        List<Ingredient> ingredients = database.availableIngredients();
        for (Ingredient ingredient : ingredients) {
            if (ingredient.getName().equals("cutlet")) {
                assertEquals(expectedCutletPrice, ingredient.getPrice(), 0.0);
                break;
            }
        }
    }

    @Test
    public void testAvailableBunsContainWhiteBun() {
        // Проверяем, что среди доступных булочек есть булочка с именем "white bun"
        String expectedBunName = "white bun";
        List<Bun> buns = database.availableBuns();
        boolean containsWhiteBun = buns.stream().anyMatch(bun -> expectedBunName.equals(bun.getName()));
        assertTrue(containsWhiteBun);
    }

    @Test
    public void testAvailableIngredientsContainSourCream() {
        // Проверяем, что среди доступных ингредиентов есть ингредиент с именем "sour cream"
        String expectedIngredientName = "sour cream";
        List<Ingredient> ingredients = database.availableIngredients();
        boolean containsSourCream = ingredients.stream().anyMatch(ingredient -> expectedIngredientName.equals(ingredient.getName()));
        assertTrue(containsSourCream);
    }

    @Test
    public void testBunPrice() {
        // Проверяем, что цена булочки с именем "red bun" равна 300
        float expectedRedBunPrice = 300.0f;
        List<Bun> buns = database.availableBuns();
        for (Bun bun : buns) {
            if (bun.getName().equals("red bun")) {
                assertEquals(expectedRedBunPrice, bun.getPrice(), 0.0);
                break;
            }
        }
    }
}
