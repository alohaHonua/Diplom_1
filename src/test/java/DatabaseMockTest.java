import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import praktikum.Bun;
import praktikum.Database;
import praktikum.Ingredient;
import praktikum.IngredientType;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class DatabaseMockTest {
    @Mock
    private Database mockDatabase;

    @Before
    public void setUp() {
        mockDatabase = mock(Database.class);
    }

    @Test
    public void testAvailableBuns() {
        // Создаем список мокованных булочек
        List<Bun> mockBuns = new ArrayList<>();
        mockBuns.add(new Bun("black bun", 100));
        mockBuns.add(new Bun("white bun", 200));
        mockBuns.add(new Bun("red bun", 300));

        // Определяем поведение мока: когда вызывается метод availableBuns(), возвращаем список мокованных булочек
        when(mockDatabase.availableBuns()).thenReturn(mockBuns);

        // Вызываем метод, который тестируем
        List<Bun> actualBuns = mockDatabase.availableBuns();

        // Проверяем, что возвращенный список булочек правильный
        assertEquals(mockBuns.size(), actualBuns.size());
        for (int i = 0; i < mockBuns.size(); i++) {
            assertEquals(mockBuns.get(i).getName(), actualBuns.get(i).getName());
            assertEquals(mockBuns.get(i).getPrice(), actualBuns.get(i).getPrice(), 0.001);
        }
    }

    @Test
    public void testAvailableIngredients() {
        // Создаем список мокованных ингредиентов
        List<Ingredient> mockIngredients = new ArrayList<>();
        mockIngredients.add(new Ingredient(IngredientType.SAUCE, "hot sauce", 100));
        mockIngredients.add(new Ingredient(IngredientType.SAUCE, "sour cream", 200));
        mockIngredients.add(new Ingredient(IngredientType.SAUCE, "chili sauce", 300));

        // Устанавливаем поведение мока: когда вызывается метод availableIngredients(), возвращаем наш список замоканых ингредиентов
        when(mockDatabase.availableIngredients()).thenReturn(mockIngredients);

        // Вызываем метод, который мы тестируем
        List<Ingredient> actualIngredients = mockDatabase.availableIngredients();

        // Проверяем, что возвращенный список ингредиентов соответствует ожидаемому
        assertEquals(mockIngredients.size(), actualIngredients.size());
        for (int i = 0; i < mockIngredients.size(); i++) {
            assertEquals(mockIngredients.get(i).getName(), actualIngredients.get(i).getName());
            assertEquals(mockIngredients.get(i).getPrice(), actualIngredients.get(i).getPrice(), 0.001);
        }
    }
}