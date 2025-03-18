package praktikum.test;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import praktikum.Ingredient;
import praktikum.IngredientType;

import static org.junit.Assert.assertEquals;
import static praktikum.IngredientType.FILLING;
import static praktikum.IngredientType.SAUCE;
import static praktikum.constants.Constants.*;


@RunWith(Parameterized.class)
public class IngredientTest {
    private final IngredientType ingredientType;
    private Ingredient ingredient;
    private final String name;
    private final float price;

    public IngredientTest (IngredientType ingredientType, String name, float price){
        this.ingredientType = ingredientType;
        this.name = name;
        this.price = price;
    }


    @Parameterized.Parameters (name = "Тип: - {0}, Ингредиент: - {1}, Цена: - {2}")
    public static Object[][] testDateGen() {
        return new Object[][]{
                {SAUCE, CLASSIC_SAUCE, PRICE_15f},
                {SAUCE, SPICY_SAUCE, PRICE_90f},
                {FILLING, HOT_SAUCE, PRICE_100f},
                {FILLING, null, PRICE_3000f},
                {null,FILLING_CUTLET, PRICE_3000f},
                {null, null, PRICE_0f}
        };
    }

    @Before
    public void setUp() {
        ingredient = new Ingredient(ingredientType, name, price);
    }

    @Test
    public void getIngredientTest() {
        assertEquals(ingredientType, ingredient.getType());
    }

    @Test
    public void getNameTest() {
        assertEquals(name, ingredient.getName());
    }

    @Test
    public void getPriceTest() {
        assertEquals(price, ingredient.getPrice(), DELTA);
    }
}


