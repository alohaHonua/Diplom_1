package praktikum;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class IngredientTest {

    private Ingredient ingredient;
    private IngredientType type;
    private String name;
    private float price;

    public IngredientTest(IngredientType type, String name, float price) {
        this.type = type;
        this.name = name;
        this.price = price;
    }

    @Before
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

    @Parameterized.Parameters
    public static Collection<Object[]> ingredientData() {
        return Arrays.asList(new Object[][] {
                {IngredientType.SAUCE, "Ketchup", 1.5f},
                {IngredientType.SAUCE, "Mustard", 1.0f},
                {IngredientType.FILLING, "Cheese", 2.0f},
                {IngredientType.FILLING, "Lettuce", 0.8f}
        });
    }

    @Test
    public void testIngredientConstructor() {
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
}