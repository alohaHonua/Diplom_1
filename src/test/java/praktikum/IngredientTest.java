package praktikum;

import junit.framework.TestCase;

public class IngredientTest extends TestCase {

    private static final String NAME = "Tomato";
    private static final float PRICE = 10f;
    private static final IngredientType TYPE = IngredientType.SAUCE;

    private static final Ingredient INGREDIENT = new Ingredient(TYPE, NAME, PRICE);

    public void testGetPrice() {
        assertEquals(PRICE, INGREDIENT.getPrice());
    }

    public void testGetName() {
        assertEquals(NAME, INGREDIENT.getName());
    }

    public void testGetType() {
        assertEquals(TYPE, INGREDIENT.getType());
    }
}