package praktikum;

import org.junit.Assert;
import org.junit.Test;

public class IngredientTest {

    private static final String NAME = "Ингредиент";
    public static final float PRICE = 20.5f;
    private static final IngredientType TYPE_INGREDIENT = IngredientType.valueOf("SAUCE");

    @Test
    public void checkGetPrice(){
        Ingredient ingredient = new Ingredient(TYPE_INGREDIENT, NAME, PRICE);
        Assert.assertEquals("Не совпадает цена", PRICE, ingredient.getPrice(), 0);
    }

    @Test
    public void checkGetName() {
        Ingredient ingredient = new Ingredient(TYPE_INGREDIENT, NAME, PRICE);
        Assert.assertEquals("Не совпадает название", NAME, ingredient.getName());
    }

    @Test
    public void checkGetType() {
        Ingredient ingredient = new Ingredient(TYPE_INGREDIENT, NAME, PRICE);
        Assert.assertEquals("Не совпадает тип ингредиента", TYPE_INGREDIENT, ingredient.getType());
    }
}
