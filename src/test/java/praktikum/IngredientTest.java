package praktikum;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import static org.junit.Assert.*;

@RunWith(Parameterized.class)
public class IngredientTest {
    private final IngredientType type;
    private final String name;
    private final float price;

    public IngredientTest(IngredientType type, String name, float price) {
        this.type = type;
        this.name = name;
        this.price = price;
    }

    @Parameterized.Parameters(name = "Тестовые данные: type={0}, name={1}, price={2}")
    public static Object[][] data() {
        return new Object[][] {
                {IngredientType.SAUCE, "Spicy Sauce", 50},
                {IngredientType.FILLING, "Beef Patty", 200},
                {null, "", -5} // Граничные случаи
        };
    }

    @Test
    public void testGetType() {
        Ingredient ingredient = new Ingredient(type, name, price);
        assertEquals("Тип ингредиента должен совпадать", type, ingredient.getType());
    }

    @Test
    public void testGetName() {
        Ingredient ingredient = new Ingredient(type, name, price);
        assertEquals("Название ингредиента должно совпадать", name, ingredient.getName());
    }

    @Test
    public void testGetPrice() {
        Ingredient ingredient = new Ingredient(type, name, price);
        assertEquals("Цена ингредиента должна совпадать", price, ingredient.getPrice(), 0.001);
    }
}