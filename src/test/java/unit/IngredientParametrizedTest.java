package unit;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import praktikum.Ingredient;
import praktikum.IngredientType;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class IngredientParametrizedTest {

    private final IngredientType type;
    private final String name;
    private final float price;
    private final Ingredient ingredient;

    public IngredientParametrizedTest(IngredientType type, String name, float price) {
        this.type = type;
        this.name = name;
        this.price = price;
        this.ingredient = new Ingredient(type, name, price);
    }

    @Parameterized.Parameters(name = "Ingredient: type={0}, name={1}, price={2}")
    public static Object[][] getIngredientData() {
        return new Object[][]{
                {IngredientType.SAUCE, "hot sauce", 100.0f},
                {IngredientType.FILLING, "cutlet", 200.5f},
                {IngredientType.SAUCE, "sour cream", 0.0f},
                {IngredientType.FILLING, "", 50.0f},
                {IngredientType.SAUCE, "special_sauce!@#", -50.0f},
                {null, "invalid type ingredient", 10.0f}
        };
    }

    @Test
    public void getTypeShouldReturnCorrectType() {
        assertEquals("The ingredient type must match", type, ingredient.getType());
    }

    @Test
    public void getNameShouldReturnCorrectName() {
        assertEquals("The ingredient name must match", name, ingredient.getName());
    }

    @Test
    public void getPriceShouldReturnCorrectPrice() {
        assertEquals("The ingredient price must match", price, ingredient.getPrice(), 0.0f);
    }
}
