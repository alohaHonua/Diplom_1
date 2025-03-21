package praktikum;

import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import static org.junit.Assert.*;

@RunWith(JUnitParamsRunner.class) // Включаем параметризацию
public class IngredientTest {

    private Ingredient ingredient;

    @Before
    public void setUp() {
        // Инициализация объекта Ingredient для непараметризованных тестов
        ingredient = new Ingredient(IngredientType.SAUCE, "bulochka", 2.4f);
    }

    // Метод для генерации параметров
    private Object[] provideIngredients() {
        return new Object[]{
                new Object[]{IngredientType.SAUCE, "Tomato Sauce", 0.5f},
                new Object[]{IngredientType.FILLING, "Cheese", 0.7f},
                new Object[]{IngredientType.SAUCE, "Hot Sauce", 1.0f}
        };
    }

    // Параметризованный тест для проверки инициализации Ingredient
    @Test
    @Parameters(method = "provideIngredients") // Указываем метод для параметров
    public void testIngredientInitializationWithParameters(IngredientType type, String name, float price) {
        // Создаем объект Ingredient с переданными параметрами
        Ingredient ingredient = new Ingredient(type, name, price);

        // Проверяем, что поля объекта инициализированы корректно
        assertEquals("Имя ингредиента должно совпадать", name, ingredient.name);
        assertEquals("Цена ингредиента должна совпадать", price, ingredient.price, 0.001);
        assertEquals("Тип ингредиента должен совпадать", type, ingredient.type);
    }

    // Непараметризованные тесты (оставлены для примера)
    @Test
    public void testIngredientInitialization() {
        assertEquals("bulochka", ingredient.name);
        assertEquals(2.4f, ingredient.price, 0.001);
        assertEquals(IngredientType.SAUCE, ingredient.type);
    }

    @Test
    public void testGetName() {
        assertEquals("bulochka", ingredient.getName());
    }

    @Test
    public void testGetPrice() {
        assertEquals(2.4f, ingredient.getPrice(), 0.001);
    }

    @Test
    public void testGetType() {
        assertEquals(IngredientType.SAUCE, ingredient.getType());
    }
}