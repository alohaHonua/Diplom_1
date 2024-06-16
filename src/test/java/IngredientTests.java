import org.junit.Assert;
import org.junit.Test;
import praktikum.Ingredient;
import praktikum.IngredientType;

public class IngredientTests {
    Ingredient ingredient = new Ingredient(IngredientType.SAUCE, "Сальса", 12F);
    @Test
    public void getPriceTest(){
        Assert.assertEquals(12F, ingredient.getPrice(), 0);
    }
    @Test
    public void getNameTest(){
        Assert.assertEquals("Сальса", ingredient.getName());
    }
    @Test
    public void getTypeTest(){
        Assert.assertEquals(IngredientType.SAUCE, ingredient.getType());
    }
}
