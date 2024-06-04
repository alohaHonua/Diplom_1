import org.junit.Assert;
import org.junit.Test;
import praktikum.IngredientType;

public class IngredientTypeTest {
    @Test
    public void ingredientValueSauceTest() {
        IngredientType ingredient = IngredientType.valueOf("SAUCE");
        String expected = "SAUCE";
        String actual = ingredient.toString();
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void ingredientValueFillingTest() {
        IngredientType ingredient = IngredientType.valueOf("FILLING");
        String expected = "FILLING";
        String actual = ingredient.toString();
        Assert.assertEquals(expected, actual);
    }

}
