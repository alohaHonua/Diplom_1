import org.junit.Assert;
import org.junit.Test;
import praktikum.IngredientType;

public class IngredientTypeTest {
    @Test
    public void checkIngredientTypesNumber() {
        int countIngredientsType = IngredientType.values().length;
        Assert.assertEquals(2, countIngredientsType);
    }

    @Test
    public void checkSauce() {
        Assert.assertEquals(IngredientType.SAUCE, IngredientType.valueOf("SAUCE"));
    }

    @Test
    public void checkFilling() {
        Assert.assertEquals(IngredientType.FILLING, IngredientType.valueOf("FILLING"));
    }
}
