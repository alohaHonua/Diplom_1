import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import praktikum.Ingredient;
import praktikum.IngredientType;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class IngredientTest {

    // Параметры для каждого теста
    private final IngredientType expectedType;      // Ожидаемый тип ингредиента
    private final String expectedName;              // Ожидаемое имя ингредиента
    private final float expectedPrice;              // Ожидаемая цена ингредиента

    // Конструктор для инициализации параметров
    public IngredientTest(IngredientType type, String name, float price) {
        this.expectedType = type;
        this.expectedName = name;
        this.expectedPrice = price;
    }

    // Набор параметров для тестов
    @Parameterized.Parameters(name = "Тестируемый ингредиент: {1}, тип: {0}, цена: {2}")
    public static Object[][] data() {
        return new Object[][]{
                {IngredientType.SAUCE, "Кетчуп", 1.25f},
                {IngredientType.FILLING, "Сыр", 3.75f},
                {IngredientType.SAUCE, "Горчица", 2.50f}
        };
    }


    @Test
    public void checkIngredientType() {
        // Создание нового ингредиента с заданными параметрами
        Ingredient ingredient = new Ingredient(expectedType, expectedName, expectedPrice);

        // Получение фактического типа ингредиента
        IngredientType actualType = ingredient.getType();


        assertEquals("Некорректный тип ингредиента", expectedType, actualType);
    }


    @Test
    public void verifyIngredientName() {

        Ingredient ingredient = new Ingredient(expectedType, expectedName, expectedPrice);

        // Получение фактического имени ингредиента
        String actualName = ingredient.getName();


        assertEquals("Некорректное имя ингредиента", expectedName, actualName);
    }


    @Test
    public void validateIngredientPrice() {

        Ingredient ingredient = new Ingredient(expectedType, expectedName, expectedPrice);

        // Получение фактической цены ингредиента
        float actualPrice = ingredient.getPrice();

        assertEquals("Некорректная цена ингредиента", expectedPrice, actualPrice, 0.005f);
    }
}
