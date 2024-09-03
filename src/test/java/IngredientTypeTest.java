import org.junit.Assert;
import org.junit.Test;
import praktikum.IngredientType;

public class IngredientTypeTest {


    @Test
    public void fillingTest() {

        String expectedString = "FILLING";

        IngredientType ingredientType = IngredientType.valueOf(expectedString);

        Assert.assertEquals(ingredientType.toString(), expectedString);
    }

    @Test
    public void sauceTest() {

        String expectedString = "SAUCE";

        IngredientType ingredientType = IngredientType.valueOf(expectedString);

        Assert.assertEquals(ingredientType.toString(), expectedString);
    }

    @Test(expected = IllegalArgumentException.class)
    public void illegalIngredientTest() throws IllegalArgumentException {

        String illigalString = "ILLEGAL";

        IngredientType.valueOf(illigalString);

    }

    @Test(expected = IllegalArgumentException.class)
    public void emptyIngredientTest() throws IllegalArgumentException {

        String illigalString = "";

        IngredientType.valueOf(illigalString);

    }

}
