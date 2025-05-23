package praktikum;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import static org.junit.Assert.assertEquals;

import praktikum.Ingredient;
import praktikum.IngredientType;

@RunWith(org.junit.runners.Parameterized.class)
public class IngredientTest {

    private final IngredientType type;
    private final String name;
    private final float price;

    public IngredientTest(IngredientType type, String name, float price) {
        this.type = type;
        this.name = name;
        this.price = price;
    }

    @Parameterized.Parameters
    public static Object[][] testData() {
        return new Object[][] {
                {IngredientType.SAUCE, "BBQ", 99.99f},
                {IngredientType.FILLING, "Chicken", 123.45f}
        };
    }

    @Test
    public void getNameReturnsCorrectValue() {
        Ingredient ingredient = new Ingredient(type, name, price);
        assertEquals(name, ingredient.getName());
    }

    @Test
    public void getPriceReturnsCorrectValue() {
        Ingredient ingredient = new Ingredient(type, name, price);
        assertEquals(price, ingredient.getPrice(), 0.001f);
    }

    @Test
    public void getTypeReturnsCorrectValue() {
        Ingredient ingredient = new Ingredient(type, name, price);
        assertEquals(type, ingredient.getType());
    }
}
