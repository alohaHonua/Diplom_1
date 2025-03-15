package praktikum;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class IngredientTests {

    @Mock
    Ingredient ingredient;


    @Test
    public void checkIngredientGetName() {
        ingredient = new Ingredient(IngredientType.SAUCE,"ingerd", 10F);
        String ingredientName = "ingerd";
        Assert.assertEquals(ingredientName, ingredient.getName());
    }

    @Test
    public void checkIngredientGetPrice() {
        ingredient = new Ingredient(IngredientType.SAUCE,"ingerd", 10F);
        float ingredientPrice = 10F;
        Assert.assertEquals(ingredientPrice, ingredient.getPrice(),0);
    }
}
