import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import praktikum.Ingredient;
import praktikum.IngredientType;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class IngredientTests {
    private final IngredientType type;
    private final String name;
    private final float price;

    public IngredientTests(IngredientType type, String name, float price) {
        this.type = type;
        this.name = name;
        this.price = price;
    }

    @Parameterized.Parameters(name = "Ingredient  type {0} named {1} with price {2}")
    public static Object[][] getParameters() {
        return new Object[][] {
                {IngredientType.FILLING, "hot sauce", 100.0F},
                {IngredientType.FILLING, "sour cream", 200.0F},
                {IngredientType.FILLING, "chili sauce", 300.0F},
                {IngredientType.SAUCE, "cutlet", 100.0F},
                {IngredientType.SAUCE, "dinosaur", 200.0F},
                {IngredientType.SAUCE, "sausage", 300.0F},
        };
    }

    @Test
    public void getIngredientTypeTest() {
        Ingredient ingredient = new Ingredient(type, name, price);
        IngredientType actualType = ingredient.getType();
        assertEquals("Type expected: " + type + ", actual type: " + actualType, type, actualType);
    }

    @Test
    public void getNameTest() {
        Ingredient ingredient = new Ingredient(type, name, price);
        String actualName = ingredient.getName();
        assertEquals("Name expected: " + name + ", actual name: " + actualName, name, actualName);
    }

    @Test
    public void getPriceTest() {
        Ingredient ingredient = new Ingredient(type, name, price);
        float actualPrice = ingredient.getPrice();
        assertEquals("Price expected: " + price + ", actual price: " + actualPrice, price, actualPrice, 0);
    }

}
