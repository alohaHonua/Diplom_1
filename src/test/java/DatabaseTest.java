import org.junit.Test;
import praktikum.Bun;
import praktikum.Database;
import praktikum.Ingredient;
import praktikum.IngredientType;

import java.util.List;

import static org.junit.Assert.assertEquals;

public class DatabaseTest {
    @Test
    public void testAvailableBuns() {
        Database database = new Database();
        List<Bun> actualBuns = database.availableBuns();

        // Создаем ожидаемый список булочек
        List<Bun> expectedBuns = List.of(
                new Bun("black bun", 100),
                new Bun("white bun", 200),
                new Bun("red bun", 300)
        );

        // Проверяем, что возвращенный список булочек соответствует ожидаемому
        assertEquals(expectedBuns, actualBuns);
    }

    @Test
    public void testAvailableIngredients() {
        Database database = new Database();
        List<Ingredient> actualIngredients = database.availableIngredients();

        // Создаем ожидаемый список ингредиентов
        List<Ingredient> expectedIngredients = List.of(
                new Ingredient(IngredientType.SAUCE, "hot sauce", 100),
                new Ingredient(IngredientType.SAUCE, "sour cream", 200),
                new Ingredient(IngredientType.SAUCE, "chili sauce", 300),
                new Ingredient(IngredientType.FILLING, "cutlet", 100),
                new Ingredient(IngredientType.FILLING, "dinosaur", 200),
                new Ingredient(IngredientType.FILLING, "sausage", 300)
        );

        // Проверяем, что возвращенный список ингредиентов соответствует ожидаемому
        assertEquals(expectedIngredients, actualIngredients);
    }
}
