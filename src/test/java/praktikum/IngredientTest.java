package praktikum;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import static org.junit.Assert.*;

@RunWith(Parameterized.class)
public class IngredientTest {
    Ingredient ingredient;
    private final String name;
    private final float price;
    private final IngredientType type;

    public IngredientTest(IngredientType type, String name, float price) {
        this.type = type;
        this.name = name;
        this.price = price;
    }

    @Parameterized.Parameters(name = "Ингредиент: {0} {1} {2}")
    public static Object[] createIngredient() {
        return new Object[][]{
                {IngredientType.FILLING, Names.FILLING_NAME, Price.FILLING_PRICE},
                {IngredientType.SAUCE, Names.SAUCE_NAME, Price.SAUCE_PRICE},

        };
    }

    @Before
    public void setUp() {
        ingredient = new Ingredient(type, name, price);
    }

    @Test
    public void getNameCheckNameIsCorrect() {
        assertEquals(name, ingredient.getName());
    }

    @Test
    public void getPriceCheckPriceIsCorrect() {
        assertEquals(price, ingredient.getPrice(), 0);
    }

    @Test
    public void getTypeCheckTypeIsCorrect() {
        assertEquals(type, ingredient.getType());
    }

}