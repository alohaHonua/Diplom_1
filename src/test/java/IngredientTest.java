import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import praktikum.Ingredient;
import praktikum.IngredientType;

public class IngredientTest {

    private Ingredient ingredient;

    @Before
    public void setUp() {
        ingredient = new Ingredient(IngredientType.SAUCE, "ketchup", 150);
    }

    @Test
    public void IngredientGetPrice () {
        float getExpectedPriceIngredient = ingredient.getPrice();
        Assert.assertEquals(getExpectedPriceIngredient, 150, 0);

    }

    @Test
    public void getIngredientName() {
        String getExpectedIngredientName = ingredient.getName();
        Assert.assertEquals(getExpectedIngredientName, "ketchup");
    }
}
