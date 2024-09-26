package praktikum;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import static org.junit.Assert.assertEquals;

/**
 * Тесты для классов Ingredient и IngredientType.
 * Используется параметризация для тестирования различных вариантов данных для объекта Ingredient.
 */
@RunWith(Parameterized.class) // Аннотация указывает, что тесты будут запускаться с использованием параметризации.
public class IngredientTypeTest {

    // Объект Ingredient, который будет тестироваться.
    private Ingredient ingredient;

    // Параметры для создания объекта Ingredient.
    private final String nameBun; // Имя ингредиента.
    private final float priceBun; // Цена ингредиента.
    private final IngredientType ingredientType; // Тип ингредиента (SAUCE или FILLING).

    /**
     * Конструктор для параметризованных тестов.
     * Параметры будут переданы через метод getIngredientData() и использоваться для создания объекта Ingredient.
     *
     * @param ingredientType тип ингредиента (SAUCE или FILLING).
     * @param nameBun имя ингредиента.
     * @param priceBun цена ингредиента.
     */
    public IngredientTypeTest(IngredientType ingredientType, String nameBun, float priceBun) {
        this.nameBun = nameBun;
        this.priceBun = priceBun;
        this.ingredientType = ingredientType;
    }

    /**
     * @Parameterized.Parameters указывает метод, который будет возвращать данные для тестов.
     * Параметры передаются в формате двумерного массива.
     */
    @Parameterized.Parameters(name = "ingredientType: {0}, nameBun: {1}, priceBun: {2}")
    public static Object[][] getIngredientData() {
        return new Object[][]{
                {IngredientType.FILLING, "Меркурианская", 10.50f},
                {IngredientType.SAUCE, "Space", 0.5f},
                {null, "777", 100}, // Тест с null для ingredientType.
                {IngredientType.SAUCE, "@#$%", 1525.3999f}, // Тест с неординарным названием и высокой ценой.
                {IngredientType.FILLING, null, 0}, // Тест с null для nameBun и нулевой ценой.
                {IngredientType.SAUCE, "", 0}, // Тест с пустым именем и нулевой ценой.
        };
    }

    /**
     * @Before указывает, что метод будет выполняться перед каждым тестом.
     * В этом методе инициализируется объект Ingredient с параметрами, переданными через параметризацию.
     */
    @Before
    public void setUp() {
        ingredient = new Ingredient(ingredientType, nameBun, priceBun);
    }

    /**
     * @Test указывает, что метод является тестом.
     * Тест проверяет, что метод getPrice возвращает правильную цену ингредиента.
     */
    @Test
    public void getPriceIngredientTest() {
        float actualResult = ingredient.getPrice();
        assertEquals(priceBun, actualResult, 0);
    }

    /**
     * @Test указывает, что метод является тестом.
     * Тест проверяет, что метод getName возвращает правильное имя ингредиента.
     */
    @Test
    public void getNameIngredientTest() {
        String actualResult = ingredient.getName();
        assertEquals(nameBun, actualResult);
    }

    /**
     * @Test указывает, что метод является тестом.
     * Тест проверяет, что метод getType возвращает правильный тип ингредиента.
     */
    @Test
    public void getTypeIngredientTest() {
        IngredientType actualResult = ingredient.getType();
        assertEquals(ingredientType, actualResult);
    }

    /**
     * @Test указывает, что метод является тестом.
     * Тест проверяет, что тип SAUCE возвращается корректно с использованием valueOf.
     */
    @Test
    public void valuesSauce() {
        IngredientType actual = IngredientType.SAUCE;
        IngredientType expected = IngredientType.valueOf("SAUCE");
        assertEquals("Error valuesSauce", expected, actual);
    }

    /**
     * @Test указывает, что метод является тестом.
     * Тест проверяет, что тип FILLING возвращается корректно с использованием valueOf.
     */
    @Test
    public void valueFilling() {
        IngredientType actual = IngredientType.FILLING;
        IngredientType expected = IngredientType.valueOf("FILLING");
        assertEquals("Error valueFilling", expected, actual);
    }
}
