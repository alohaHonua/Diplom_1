import praktikum.Ingredient;
import praktikum.IngredientType;
import org.junit.Assert;
import org.junit.Test;


public class IngredientTest {

    @Test
    public void testIngredientConstructor() {
        Ingredient ingredient = new Ingredient(IngredientType.FILLING, "Cheese", 0.75f);
        Assert.assertEquals(IngredientType.FILLING, ingredient.getType());
        Assert.assertEquals("Cheese", ingredient.getName());
        Assert.assertEquals(0.75f, ingredient.getPrice(), 0.01f);
    }
}
