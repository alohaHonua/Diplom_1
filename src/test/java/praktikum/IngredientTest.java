package praktikum;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class IngredientTest {

    private final String name;
    private final float price;
    private final IngredientType type;

    public IngredientTest(String name, float price, IngredientType type) {
        this.name = name;
        this.price = price;
        this.type = type;
    }

    @Parameterized.Parameters
    public static Object[][] getData() {
        return new Object[][]{
                {"Соус", 50.0f, IngredientType.SAUCE},
                {"Котлета", 100.0f, IngredientType.FILLING},
                {"Томат", 30.0f, IngredientType.FILLING}
        };
    }

    @Test
    public void testCreateIngredientWithCorrectParameters() {
        Ingredient ingredient = new Ingredient(type, name, price);
        assertEquals(name, ingredient.getName());
        assertEquals(price, ingredient.getPrice(), 0.0f);
        assertEquals(type, ingredient.getType());
    }

    @Test
    public void testReturnCorrectNameFromGetter() {
        Ingredient ingredient = new Ingredient(type, name, price);
        assertEquals(name, ingredient.getName());
    }

    @Test
    public void testReturnCorrectPriceFromGetter() {
        Ingredient ingredient = new Ingredient(type, name, price);
        assertEquals(price, ingredient.getPrice(), 0.0f);
    }

    @Test
    public void testReturnCorrectTypeFromGetter() {
        Ingredient ingredient = new Ingredient(type, name, price);
        assertEquals(type, ingredient.getType());
    }
}
