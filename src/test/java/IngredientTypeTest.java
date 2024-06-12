import org.junit.Assert;
import org.junit.Test;
import praktikum.IngredientType;


public class IngredientTypeTest {

    @Test
    public void sauceExistenceTest() {
        Assert.assertEquals(IngredientType.valueOf("SAUCE"), IngredientType.SAUCE);
    }

    @Test
    public void fillingExistenceTest() {
        Assert.assertEquals(IngredientType.valueOf("FILLING"), IngredientType.FILLING);
    }
}
