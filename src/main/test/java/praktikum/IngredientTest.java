package praktikum;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)

public class IngredientTest {

    String testFillingName = "onion";
    String testSauceName = "ketchup";
    float testFillingPrice = 0.23f;
    float testSaucePrice = 0.13f;

    Ingredient onion = new Ingredient(IngredientType.FILLING, testFillingName, testFillingPrice);
    Ingredient ketchup = new Ingredient(IngredientType.SAUCE, testSauceName, testSaucePrice);

    @Test
    public void getPrice() {
        Assert.assertEquals(testFillingPrice, onion.getPrice(), 0);
    }

    @Test
    public void getName() {
        Assert.assertEquals(testFillingName, onion.getName());

    }

    @Test
    public void getType() {
        Assert.assertEquals(IngredientType.FILLING, onion.getType());
    }
}
