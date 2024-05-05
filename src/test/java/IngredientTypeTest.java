import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import praktikum.Ingredient;
import praktikum.IngredientType;

import static org.junit.Assert.assertEquals;
import static praktikum.IngredientType.FILLING;
import static praktikum.IngredientType.SAUCE;
@RunWith(Parameterized.class)
public class IngredientTypeTest {

    final private IngredientType type;
    final private String name;
    final private float price;

    public IngredientTypeTest(IngredientType type, String name, float price) {
        this.type = type;
        this.name = name;
        this.price = price;
    }

    @Parameterized.Parameters
    public static Object[][] getData() {
        return new Object[][] {
                {SAUCE, "hot sauce", 100},
                {FILLING, "dinosaur", 200},
        };
    }

    @Test
    public void getTypeTest() {
        Ingredient ingredient = new Ingredient(type, name, price);
        assertEquals(type, ingredient.getType());
    }

}
