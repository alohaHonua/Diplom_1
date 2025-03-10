package praktikum.test;

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
    private final String name;
    private final float price;

    public IngredientTest (IngredientType ingredientType, String name, float price){
        this.ingredientType = ingredientType;
        this.name = name;
        this.price = price;
    }


    @Parameterized.Parameters (name = "Ингредиенты - {0}, Наименование - {1}, Цена - {2}")
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

    @Test
    public void getIngredientTest() {
        Ingredient ingredient = new Ingredient(ingredientType, name, price);

        assertEquals(ingredientType, ingredient.getType());
        assertEquals(name, ingredient.getName());
        assertEquals(price, ingredient.getPrice(), DELTA);
    }
}


