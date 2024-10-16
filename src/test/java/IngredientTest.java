import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import praktikum.Ingredient;
import praktikum.IngredientType;

public class IngredientTest {

    private Ingredient ingredient;


    @Before
    public void setUp() {
        ingredient = new Ingredient(IngredientType.SAUCE, Credentials.INGREDIENT_NAME, Credentials.INGREDIENT_PRICE);
    }

    @Test
    public void getPriceTest() {
        float actual = ingredient.getPrice();
        Assert.assertEquals(Credentials.INGREDIENT_PRICE, actual, Credentials.DELTA);
    }

    @Test
    public void getNameTest() {
        String actual = ingredient.getName();
        Assert.assertEquals(Credentials.INGREDIENT_NAME, actual);
    }

    @Test
    public void getTypeTest() {
        IngredientType actual = ingredient.getType();
        Assert.assertEquals(IngredientType.SAUCE, actual);
    }

}
