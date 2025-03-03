import org.junit.Test;
import org.junit.Before;
import ru.practikum.yandex.Ingredient;
import ru.practikum.yandex.IngredientType;

import static org.junit.Assert.assertEquals;

public class IngredientTest {
    private Ingredient ingredient;

    @Before
    public void setUp() {
        // Инициализация объекта Ingredient перед каждым тестом
        ingredient = new Ingredient(IngredientType.FILLING, "Cheese", 50.0f);
    }

    @Test
    public void GetPriceTest() {
        // Проверка, что метод getPrice возвращает правильную цену
        float expectedPrice = 50.0f;
        assertEquals(expectedPrice, ingredient.getPrice(), 0.001);
    }

    @Test
    public void GetTypeTest() {
        // Проверка, что метод getType возвращает правильный тип
        IngredientType expectedType = IngredientType.FILLING;
        assertEquals(expectedType, ingredient.getType());
    }

    @Test
    public void GetNameTest() {
        // Проверка, что метод getName возвращает правильное название
        String expectedName = "Cheese";
        assertEquals(expectedName, ingredient.getName());
    }
}
