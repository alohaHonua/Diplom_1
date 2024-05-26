import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import praktikum.Ingredient;
import praktikum.IngredientType;

import static org.junit.Assert.*;

@RunWith(Parameterized.class)
public class IngParamTest {

    private Ingredient ingredient;
    private static IngredientType type;
    private final String name;
    private final float price;
    private final static double DELTA = 0.0f;

    @Before
    public void beforeBenTest() {
        ingredient = new Ingredient(type, name, price);
    }

    public IngParamTest(IngredientType type, String name, float price) {
        this.type = type;
        this.name = name;
        this.price = price;
    }

    @Parameterized.Parameters()
    public static Object[][] getTypeNameAndPrice() {
        return new Object[][] {
                {type.SAUCE, "Sausage", (float) 69.88},
                {type.FILLING, "Кетчуп", (float) 55.99}
        };
    }

    @Test
    public void getPriceTest() {
        assertEquals("Price of ingredient is not correct", price, ingredient.getPrice(), DELTA);
    }

    @Test
    public void getNameTest() {
        assertEquals("Name of ingredient is not correct", name, ingredient.getName());
    }

    @Test
    public void getTypeTest() {
        assertEquals("Type of ingredient is not correct", type, ingredient.getType());
    }
}