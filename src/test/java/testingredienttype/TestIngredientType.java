package testingredienttype;

import org.junit.Assert;
import org.junit.Test;
import praktikum.IngredientType;

public class TestIngredientType {

    @Test
    public void ingredientTypeSauceTest(){
        Assert.assertNotNull(IngredientType.valueOf("SAUCE"));
    }

    @Test
    public void ingredientTypeFillingTest(){
        Assert.assertNotNull(IngredientType.valueOf("FILLING"));
    }

}
