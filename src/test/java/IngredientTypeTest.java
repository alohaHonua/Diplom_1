import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;
import praktikum.Ingredient;
import praktikum.IngredientType;

import static praktikum.IngredientType.FILLING;
import static praktikum.IngredientType.SAUCE;

@RunWith(MockitoJUnitRunner.class)

public class IngredientTypeTest {

    @Test
    public void getTypeIngredientSauceTest() {
        Ingredient ingredient = new Ingredient(SAUCE, "Shitracha", 35.234F);
        IngredientType type = ingredient.getType();
        Assert.assertEquals(SAUCE, type);
    }

    @Test
    public void getTypeIngredientFillingTest() {
        Ingredient ingredient = new Ingredient(FILLING, "Shitracha", 30.634F);
        IngredientType type = ingredient.getType();
        Assert.assertEquals(FILLING, type);
    }
}
