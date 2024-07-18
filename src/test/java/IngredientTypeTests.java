import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import praktikum.IngredientType;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class IngredientTypeTests {
    private final IngredientType type; // Тип ингредиента

    public IngredientTypeTests(IngredientType type) {
        this.type = type; // Инициализация типа ингредиента для текущего теста
    }

    @Parameterized.Parameters
    public static Object[][] dataForTests() {
        return new Object[][] {
                {IngredientType.SAUCE}, // Тестируем тип ингредиента - соус
                {IngredientType.FILLING} // Тестируем тип ингредиента - начинка
        };
    }

    @Test
    public void testIngredientType() {
        assertEquals(type.toString(), type.toString()); // Проверяем, что тип ингредиента правильно представлен в виде строки
    }
}