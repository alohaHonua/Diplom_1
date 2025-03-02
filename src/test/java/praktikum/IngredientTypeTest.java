package praktikum;

import org.junit.Assert;
import org.junit.Test;

public class IngredientTypeTest {

    @Test
    public void checkTypeSauce() {
        Assert.assertEquals("Не совпадает соус", IngredientType.SAUCE, IngredientType.valueOf("SAUCE"));
    }

    @Test
    public void checkTypeFilling() {
        Assert.assertEquals("Не совпадает начинка", IngredientType.FILLING, IngredientType.valueOf("FILLING"));
    }
}