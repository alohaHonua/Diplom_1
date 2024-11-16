package praktikum;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.mockito.Mockito;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.Arrays;
import java.util.List;

@RunWith(Parameterized.class)
public class BurgerTest {

    private Burger burger;
    private Bun bun;
    private Ingredient ingredient;
    private Ingredient ingredient2;
    private float expectedPrice;
    private String ingredientName;
    private IngredientType ingredientType;
    private Database database;

    // Конструктор для параметризации
    public BurgerTest(String ingredientName, IngredientType ingredientType, float expectedPrice) {
        this.ingredientName = ingredientName;
        this.ingredientType = ingredientType;
        this.expectedPrice = expectedPrice;
    }

    // Параметризованный набор данных
    @Parameterized.Parameters
    public static List<Object[]> data() {
        return Arrays.asList(new Object[][] {
                {"hot sauce", IngredientType.SAUCE, 250.0f},
                {"cheese", IngredientType.FILLING, 270.0f},
                {"lettuce", IngredientType.FILLING, 250.0f},
                {"bbq sauce", IngredientType.SAUCE, 250.0f}
        });
    }

    @Before
    public void setUp() {
        burger = new Burger();
        database = new Database();
        bun = database.availableBuns().get(1);
        ingredient = Mockito.mock(Ingredient.class); // Мокаем объект вручную
        ingredient2 = database.availableIngredients().get(1);
    }


            @Test
    public void testSetBuns() {
        burger.setBuns(bun);
        assertEquals(bun, burger.bun);
    }

    @Test
    public void testAddIngredient() {
        burger.addIngredient(ingredient);
        assertEquals(1, burger.ingredients.size());
    }

    @Test
    public void testRemoveIngredient() {
        burger.addIngredient(ingredient);
        burger.removeIngredient(0);
        assertEquals(0, burger.ingredients.size());
    }

    @Test
    public void testMoveIngredient() {
        burger.addIngredient(ingredient);
        burger.addIngredient(ingredient2);

        // Переместим второй ингредиент на первое место
        burger.moveIngredient(1, 0);

        // Проверяем, что ингредиенты переместились
        assertEquals(ingredient2, burger.ingredients.get(0));
        assertEquals(ingredient, burger.ingredients.get(1));
    }

    @Test
    public void testGetPrice() {
        burger.setBuns(bun);
        burger.addIngredient(ingredient);

        // Цена = 200 (булочка) + 100 (ингредиент)
        assertEquals(300, burger.getPrice(), 0);
    }

    @Test
    public void testGetReceipt() {
        burger.setBuns(bun);

        // Мокаем поведение ингредиента для параметризации
        Mockito.when(ingredient.getPrice()).thenReturn(expectedPrice - 200); // 200 для булочки
        Mockito.when(ingredient.getName()).thenReturn(ingredientName);
        Mockito.when(ingredient.getType()).thenReturn(ingredientType);

        burger.addIngredient(ingredient);

        // Форматируем цену до одного знака после запятой
        String formattedPrice = String.format("%.1f", expectedPrice);

        // Ожидаемый результат без точности до запятой
        String expectedReceipt = "(==== white bun ====)\n= " + ingredientType.toString().toLowerCase() + " " + ingredientName + " =\n(==== white bun ====)\nPrice: " + formattedPrice + "\n";

        // Получаем реальный результат
        String actualReceipt = burger.getReceipt();

        // Нормализуем строки для сравнения
        expectedReceipt = expectedReceipt.trim().replace("\n", "").replace(" ", "");
        actualReceipt = actualReceipt.trim().replace("\n", "").replace(" ", "");

        // Выводим ожидаемый и фактический результат
        System.out.println("Expected: " + expectedReceipt);
        System.out.println("Actual: " + actualReceipt);

        // Сравниваем строки без учета точности (если нужно, можно использовать trim() или другие методы для нормализации строк)
        assertEquals(expectedReceipt, actualReceipt);
    }

    @Test
    public void testAddMultipleIngredients() {
        burger.setBuns(bun);
        burger.addIngredient(ingredient);
        burger.addIngredient(ingredient2);

        // Цена = 200 (булочка) + 100 (ингредиент 1) + 200 (ингредиент 2)
        assertEquals(500, burger.getPrice(), 0);
    }

    @Test
    public void testGetPriceWithMultipleIngredients() {
        burger.setBuns(bun);
        burger.addIngredient(ingredient);
        burger.addIngredient(ingredient2);

        // Цена = 200 (булочка) + 100 (ингредиент 1) + 200 (ингредиент 2)
        assertEquals(500, burger.getPrice(), 0);
    }
}


