package praktikum.ingredient;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import praktikum.Ingredient;
import praktikum.IngredientType;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class IngredientParameterizedTest {

    private final IngredientType type;
    private final String name;
    private final float price;
    private Ingredient ingredient;

    public IngredientParameterizedTest(IngredientType type, String name, float price) {
        this.type = type;
        this.name = name;
        this.price = price;
    }

    @Before
    public void setUp() {
        ingredient = new Ingredient(type, name, price);
    }

    @Parameterized.Parameters
    public static Object[][] data() {
        return new Object[][]{
                {IngredientType.SAUCE, "Ketchup", 100},
                {IngredientType.FILLING, "Chicken", 150},
                {IngredientType.SAUCE, "Mayo", 50}
        };
    }

    // Тест: проверка имени ингредиента для различных наборов данных
    @Test
    public void testGetIngredientName() {
        assertEquals(name, ingredient.getName());
    }

    // Тест: проверка типа ингредиента для различных наборов данных
    @Test
    public void testGetIngredientType() {
        assertEquals(type, ingredient.getType());
    }

    // Тест: проверка цены ингредиента для различных наборов данных
    @Test
    public void testGetIngredientPrice() {
        assertEquals(price, ingredient.getPrice(), 0.01);
    }
}
