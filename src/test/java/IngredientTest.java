import org.junit.Before;
import org.junit.Test;
import praktikum.Ingredient;
import praktikum.IngredientType;

import static org.junit.Assert.assertEquals;

public class IngredientTest {

    private Ingredient ingredient;

    @Before
    public void setUp() {
        // Инициализация тестового ингредиента перед каждым тестом
        ingredient = new Ingredient(IngredientType.FILLING, "Lettuce", 0.5f);
    }

    @Test
    public void testGetName() {
        // Проверка, что метод getName возвращает правильное имя
        assertEquals("Lettuce", ingredient.getName());
    }

    @Test
    public void testGetPrice() {
        // Проверка, что метод getPrice возвращает правильную цену
        assertEquals(0.5f, ingredient.getPrice(), 0.0001);
    }

    @Test
    public void testGetType() {
        // Проверка, что метод getType возвращает правильный тип
        assertEquals(IngredientType.FILLING, ingredient.getType());
    }
}
