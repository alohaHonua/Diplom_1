import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import praktikum.Ingredient;
import praktikum.IngredientType;
import service.TestConstants;

public class IngredientTests {
    private static final IngredientType TYPE = IngredientType.SAUCE;
    private static final String NAME = "Соус Spicy-X";
    private static final float PRICE = 90.09f;
    private Ingredient ingredient;

    @Before
    public void initIngredient() {
        ingredient = new Ingredient(TYPE, NAME, PRICE);
    }

    @Test
    public void getNameReturnsIngredientName() {
        Assert.assertEquals(NAME, ingredient.getName());
    }

    @Test
    public void getPriceReturnsIngredientPrice() {
        Assert.assertEquals(PRICE, ingredient.getPrice(), TestConstants.DELTA);
    }

    @Test
    public void getTypeReturnsIngredientType() {
        Assert.assertEquals(TYPE, ingredient.getType());
    }
}
