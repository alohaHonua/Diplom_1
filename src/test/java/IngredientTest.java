import org.junit.*;
import static org.junit.Assert.*;

import praktikum.Ingredient;
import praktikum.IngredientType;

public class IngredientTest {
    private static final IngredientType TEST_SAUCE_TYPE = IngredientType.SAUCE;
    private static final IngredientType TEST_FILLING_TYPE = IngredientType.FILLING;
    private static final String TEST_SAUCE_NAME = "Соус Spicy-X";
    private static final float TEST_SAUCE_PRICE = 90.0f;
    private static final String TEST_FILLING_NAME = "Говяжий метеорит (отбивная)";
    private static final float TEST_FILLING_PRICE = 3000.0f;
    private static final float DELTA = 0.001f;

    private Ingredient createTestSauceIngredient() {
        return new Ingredient(TEST_SAUCE_TYPE, TEST_SAUCE_NAME, TEST_SAUCE_PRICE);
    }
    private Ingredient createTestFillingIngredient() {
        return new Ingredient(TEST_FILLING_TYPE, TEST_FILLING_NAME, TEST_FILLING_PRICE);
    }

    @Test
    public void testGetTypeSauce() { // проверяет, что метод getType() возвращает тип Соус, переданный в конструктор
        Ingredient ingredient = createTestSauceIngredient();
        assertEquals("Тип ингредиента должен быть SAUCE", TEST_SAUCE_TYPE, ingredient.getType());
    }
    @Test
    public void testGetTypeFilling() { // проверяет, что метод getType() возвращает тип Соус, переданный в конструктор
        Ingredient filling = createTestFillingIngredient();
        assertEquals("Тип ингредиента должен быть FILLING", TEST_FILLING_TYPE, filling.getType());
    }
    @Test
    public void testGetName() { // проверяет, что метод getName() возвращает корректное название ингредиента, переданное в конструктор
        Ingredient ingredient = createTestSauceIngredient();
        assertEquals("Название ингредиента не совпадает", TEST_SAUCE_NAME, ingredient.getName());
    }
    @Test
    public void testGetPrice() { // проверяет, что метод getPrice() возвращает корректный тип, переданный в конструктор
        Ingredient ingredient = createTestSauceIngredient();
        assertEquals("Цена ингредиента не совпадает", TEST_SAUCE_PRICE, ingredient.getPrice(), DELTA);
    }
}