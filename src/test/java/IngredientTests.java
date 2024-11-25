import org.junit.Assert;
import org.junit.Test;
import praktikum.Ingredient;
import praktikum.IngredientType;

public class IngredientTests {
    private final IngredientType TYPE = IngredientType.SAUCE;
    private final String NAME = "Соус Spicy-X";
    private final float PRICE = 90.09f;

    @Test
    public void getNameReturnsIngredientName() {
        Ingredient ingredient = new Ingredient(TYPE, NAME, PRICE);
        Assert.assertEquals(NAME, ingredient.getName());
    }

    @Test
    public void getPriceReturnsIngredientPrice() {
        Ingredient ingredient = new Ingredient(TYPE, NAME, PRICE);
        Assert.assertEquals(PRICE, ingredient.getPrice(), 0.001f);
    }

    @Test
    public void getTypeReturnsIngredientType() {
        Ingredient ingredient = new Ingredient(TYPE, NAME, PRICE);
        Assert.assertEquals(TYPE, ingredient.getType());
    }
}
