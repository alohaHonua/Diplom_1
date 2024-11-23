import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import praktikum.Ingredient;
import praktikum.IngredientType;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class IngredientTest {
    private IngredientType type;
    private String name;
    private float price;

    public IngredientTest(IngredientType type, String name, float price) {
        this.type = type;
        this.name = name;
        this.price = price;
    }

    @Parameterized.Parameters
    public static Object[][] getParameters() {
        return new Object[][]{
                {IngredientType.FILLING, "hot sauce", 100},
                {IngredientType.FILLING, "sour cream", 200},
                {IngredientType.FILLING, "chili sauce", 300},
                {IngredientType.SAUCE, "cutlet", 100},
                {IngredientType.SAUCE, "dinosaur", 200},
                {IngredientType.SAUCE, "sausage", 300}
        };
    }

    @Test
    public void getIngredientTypeTest() {
        Ingredient ingredient = new Ingredient(type, name, price);
        IngredientType actualType = ingredient.getType();

        assertEquals(type, actualType);
    }

    @Test
    public void getIngredientNameTest() {
        Ingredient ingredient = new Ingredient(type, name, price);
        String actualName = ingredient.getName();

        assertEquals(name, actualName);
    }

    @Test
    public void getIngredientPriceTest() {
        Ingredient ingredient = new Ingredient(type, name, price);
        float actualPrice = ingredient.getPrice();

        assertEquals(price, actualPrice,0);
    }
}
