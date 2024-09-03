import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import praktikum.Ingredient;
import praktikum.IngredientType;

@RunWith(Parameterized.class)
public class IngredientTest {

    private final IngredientType type;
    private final String name;
    private final Float price;

    public IngredientTest(IngredientType type, String name, float price) {
        this.type = type;
        this.name = name;
        this.price = price;
    }

    @Parameterized.Parameters
    public static Object[][] getData() {
        return new Object[][] {
                {IngredientType.SAUCE, "", 1 },
                {IngredientType.FILLING, "n", 0 },
                {IngredientType.SAUCE, "name 12312", -1776.22f },
                {IngredientType.FILLING, "namedfghdgfhdfghdfgh12312", 2777.222f },
        };
    }


    @Test
    public void getPriceReturnsSamePriceTest() {

        Ingredient ingredient = new Ingredient(type, name, price);

        Assert.assertEquals(price, ingredient.getPrice(), 0.001);

    }

    @Test
    public void getNameReturnsSameNameTest() {
        Ingredient ingredient = new Ingredient(type, name, price);

        Assert.assertEquals(name, ingredient.getName());
    }

    @Test
    public void getTypeReturnsSameTypeTest() {
        Ingredient ingredient = new Ingredient(type, name, price);

        Assert.assertEquals(type, ingredient.getType());
    }


}
