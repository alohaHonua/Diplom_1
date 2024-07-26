import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import praktikum.Ingredient;
import praktikum.IngredientType;

import java.io.PrintStream;

import static org.junit.Assert.assertEquals;

@RunWith( Parameterized.class)
public class IngredientTestWithParams {

    private Ingredient ingredient;
    private static IngredientType type;
    private final String name;
    private final float price;
    private final static double DELTA = 0.0f;

    @Before
    public void createIngredient() {
        ingredient = new Ingredient(type, name, price);
    }

    public IngredientTestWithParams(IngredientType type, String name, float price) {
        this.type = type;
        this.name = name;
        this.price = price;
    }

    @Parameterized.Parameters()
    public static Object[][] getIngredientData() {
        return new Object[][] {
                {type.SAUCE, "hot sauce", (float) 100},
                {type.FILLING, "dinosaur", (float) 200},
        };
    }

    @Test
    public void checkGetPrice() {
       assertEquals(price, ingredient.getPrice(),DELTA);
    }

    @Test
    public void checkGetName() {
        assertEquals(name, ingredient.getName());
    }

    @Test
    public void checkGetType() {
        assertEquals(type, ingredient.getType());
    }


}
