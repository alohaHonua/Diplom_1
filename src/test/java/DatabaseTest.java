import org.junit.Before;
import org.junit.Test;
import praktikum.Bun;
import praktikum.Database;
import praktikum.Ingredient;
import praktikum.IngredientType;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class DatabaseTest {

    @Test
    public void testAvailableBuns() {
        // Создаём экземпляр класса Database
        Database database = new Database();

        // Проверяем, что метод availableBuns() возвращает список из трёх булочек
        List<Bun> expectedBuns = new ArrayList<>();
        expectedBuns.add(new Bun("black bun", 100));
        expectedBuns.add(new Bun("white bun", 200));
        expectedBuns.add(new Bun("red bun", 300));

        List<Bun> actualBuns = database.availableBuns();

        // Сравниваем ожидаемый и фактический результат
        assertEquals(expectedBuns, actualBuns);
    }
    @Test
    public void testAvailableIngredients() {
        Database database = new Database();
        List<Ingredient> expectedIngredients = new ArrayList<>();
        expectedIngredients.add(new Ingredient(IngredientType.SAUCE, "hot sauce", 100));
        expectedIngredients.add(new Ingredient(IngredientType.SAUCE, "sour cream", 200));
        expectedIngredients.add(new Ingredient(IngredientType.SAUCE, "chili sauce", 300));
        expectedIngredients.add(new Ingredient(IngredientType.FILLING, "cutlet", 100));
        expectedIngredients.add(new Ingredient(IngredientType.FILLING, "dinosaur", 200));
        expectedIngredients.add(new Ingredient(IngredientType.FILLING, "sausage", 300));
        List<Ingredient> actualIngredients = database.availableIngredients();
        assertEquals(expectedIngredients, actualIngredients);
    }
}

//тесты не проходят из случайной генерации