package praktikum;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class IngredientTest {

    private Ingredient ingredient;

    @BeforeEach
    public void setUp() {
        // Инициализация перед каждым тестом
    }

    @Test
    public void testGetName() {
        ingredient = new Ingredient(IngredientType.FILLING, "Cheese", 2.0f);
        assertEquals("Cheese", ingredient.getName());
    }

    @Test
    public void testGetPrice() {
        ingredient = new Ingredient(IngredientType.FILLING, "Cheese", 2.0f);
        assertEquals(2.0f, ingredient.getPrice(), 0.001);
    }

    @Test
    public void testGetType() {
        ingredient = new Ingredient(IngredientType.FILLING, "Cheese", 2.0f);
        assertEquals(IngredientType.FILLING, ingredient.getType());
    }

    @ParameterizedTest
    @MethodSource("ingredientData")
    public void testIngredientConstructor(IngredientType type, String name, float price) {
        ingredient = new Ingredient(type, name, price);
        assertEquals(name, ingredient.getName());
        assertEquals(price, ingredient.getPrice(), 0.001);
        assertEquals(type, ingredient.getType());
    }

    @Test
    public void testEmptyIngredientName() {
        ingredient = new Ingredient(IngredientType.FILLING, "", 2.0f);
        assertEquals("", ingredient.getName());
        assertEquals(2.0f, ingredient.getPrice(), 0.001f);
    }

    @Test
    public void testEmptyIngredientPrice() {
        ingredient = new Ingredient(IngredientType.SAUCE, "Ketchup", 0.0f);
        assertEquals("Ketchup", ingredient.getName());
        assertEquals(0.0f, ingredient.getPrice(), 0.001f);
    }

    public static Object[][] ingredientData() {
        return new Object[][] {
                {IngredientType.SAUCE, "Ketchup", 1.5f},
                {IngredientType.SAUCE, "Mustard", 1.0f},
                {IngredientType.FILLING, "Cheese", 2.0f},
                {IngredientType.FILLING, "Lettuce", 0.8f}
        };
    }
}