import org.junit.Assert;
import org.junit.Test;
import praktikum.IngredientType;

public class IngredientTypeTest {
    @Test
    public void testSauce(){
        Assert.assertEquals(IngredientType.SAUCE, IngredientType.valueOf("SAUCE"));
    }
    @Test
    public void testFilling(){
        Assert.assertEquals(IngredientType.FILLING, IngredientType.valueOf("FILLING"));
    }
}
