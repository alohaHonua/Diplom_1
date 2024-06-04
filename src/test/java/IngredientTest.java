import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import praktikum.*;

import static praktikum.IngredientType.FILLING;
import static praktikum.IngredientType.SAUCE;

@RunWith(Parameterized.class)
public class IngredientTest {
    private final IngredientType type;
    private final String name;
    private final float price;

    public IngredientTest(IngredientType type, String name, float price) {
        this.type = type;
        this.name = name;
        this.price = price;
    }

    @Parameterized.Parameters
    public static Object[][] testData() {
        return new Object[][]{
                {SAUCE, "test1", 1F},
                {FILLING, "test2", 2F},
                {SAUCE, "123", 123},
        };
    }


    @Test
    public void getTypeTest() {
        Ingredient ingredient = new Ingredient(type, name, price);
        String actual = ingredient.getType().toString();
        Assert.assertEquals(type.toString(), actual);
    }

    @Test
    public void getNameTest() {
        Ingredient ingredient = new Ingredient(type, name, price);
        String actual = ingredient.getName();
        Assert.assertEquals(name, actual);
    }

    @Test
    public void getPriceTest() {
        Ingredient ingredient = new Ingredient(type, name, price);
        float actual = ingredient.getPrice();
        Assert.assertEquals(price, actual, 0);
    }
}
