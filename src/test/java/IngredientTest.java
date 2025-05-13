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

    // проверка создания ингредиента
    @Test
    public void testIngredientCreation() {
        Ingredient ingredient = new Ingredient(TEST_SAUCE_TYPE, TEST_SAUCE_NAME, TEST_SAUCE_PRICE);
        assertNotNull("Объект ингредиента не создан", ingredient);
        assertEquals("Тип ингредиента не совпадает", TEST_SAUCE_TYPE, ingredient.getType());
        assertEquals("Название ингредиента не совпадает", TEST_SAUCE_NAME, ingredient.getName());
        assertEquals("Цена ингредиента не совпадает", TEST_SAUCE_PRICE, ingredient.getPrice(), 0.001f);
    }

    // проверка геттеров
    @Test
    public void testGetters() {
        Ingredient ingredient = new Ingredient(TEST_SAUCE_TYPE, TEST_SAUCE_NAME, TEST_SAUCE_PRICE);
        assertEquals("getType() вернул неверный тип", TEST_SAUCE_TYPE, ingredient.getType());
        assertEquals("getName() вернул неверное название", TEST_SAUCE_NAME, ingredient.getName());
        assertEquals("getPrice() вернул неверную цену", TEST_SAUCE_PRICE, ingredient.getPrice(), 0.001f);
    }

    // проверка работы с разными типами (SAUCE и FILLING)
    @Test
    public void testIngredientTypeSauce() {
        Ingredient sauce = new Ingredient(TEST_SAUCE_TYPE, TEST_SAUCE_NAME, TEST_SAUCE_PRICE);
        assertEquals("Тип ингредиента должен быть SAUCE", TEST_SAUCE_TYPE, sauce.getType());
    }
    @Test
    public void testIngredientTypeFilling() {
        Ingredient filling = new Ingredient(TEST_FILLING_TYPE, TEST_FILLING_NAME, TEST_FILLING_PRICE);
        assertEquals("Тип ингредиента должен быть FILLING", TEST_FILLING_TYPE, filling.getType());
    }
}