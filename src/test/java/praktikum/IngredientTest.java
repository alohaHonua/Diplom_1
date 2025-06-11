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

    @Parameterized.Parameters(name = "{0}: {1}, {2}")
    public static Object[][] data() {
        return new Object[][]{
                {IngredientType.SAUCE, "Соус Spicy-X", 90f},
                {IngredientType.FILLING, "Говяжий метеорит", 3000f},
                {IngredientType.SAUCE, "Соус традиционный галактический", 15f}
        };
    }

    @Test
    public void ingredientNameIsReturnedCorrectly() {
        Ingredient ingredient = new Ingredient(type, name, price);
        assertEquals(name, ingredient.getName());
    }

    @Test
    public void ingredientPriceIsReturnedCorrectly() {
        Ingredient ingredient = new Ingredient(type, name, price);
        assertEquals(price, ingredient.getPrice(), 0.01);
    }

    @Test
    public void ingredientTypeIsReturnedCorrectly() {
        Ingredient ingredient = new Ingredient(type, name, price);
        assertEquals(type, ingredient.getType());
    }
}