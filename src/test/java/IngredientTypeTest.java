import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import praktikum.IngredientType;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class IngredientTypeTest {

    private final IngredientType ingredientType;
    private final int expectedIndex;

    // Конструктор для инициализации параметров
    public IngredientTypeTest(IngredientType ingredientType, int expectedIndex) {
        this.ingredientType = ingredientType;
        this.expectedIndex = expectedIndex;
    }

    @Parameterized.Parameters
    public static Object[][] data() {
        return new Object[][]{
                {IngredientType.SAUCE, 0},
                {IngredientType.FILLING, 1}
        };
    }

    @Test
    public void testIngredientTypeIndex() {
        // Проверка, что индекс типа ингредиента соответствует ожидаемому
        assertEquals(expectedIndex, ingredientType.ordinal());
    }
}
