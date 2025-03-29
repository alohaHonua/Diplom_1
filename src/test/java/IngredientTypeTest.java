import org.junit.Assert;
import org.junit.Test;
import praktikum.IngredientType;

public class IngredientTypeTest {

    @Test
    public void ingredientTypesNumber() {
        int expectedNumberOfIngredientsType = 2;
        int actualNumberOfIngredientsType = IngredientType.values().length;
        Assert.assertEquals(expectedNumberOfIngredientsType, actualNumberOfIngredientsType);
    }

    @Test
    public void sauceIngredientType() {
        Assert.assertEquals(IngredientType.SAUCE, IngredientType.valueOf("SAUCE"));
    }

    @Test
    public void fillingIngredientType() {
        Assert.assertEquals(IngredientType.FILLING, IngredientType.valueOf("FILLING"));
    }
}
