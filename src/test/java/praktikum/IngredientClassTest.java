package praktikum;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.assertEquals;
@RunWith(Parameterized.class)
public class IngredientClassTest {
    private final IngredientType ingredientType;
    private final String name;
    private final float price;

    public IngredientClassTest(IngredientType ingredientType, String name, float price) {
        this.ingredientType = ingredientType;
        this.name = name;
        this.price = price;
    }
    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                { IngredientType.SAUCE, "Cinnamon", 1.5f},
                { IngredientType.FILLING,"Tomato", 0.75f},
        });
    }
    @Test
    public void testGetName() {
        Ingredient ingredient = new Ingredient(ingredientType,name, price);
        assertEquals(name, ingredient.getName());
    }

    @Test
    public void testGetPrice() {
        Ingredient ingredient = new Ingredient(ingredientType,name, price);
        assertEquals(price, ingredient.getPrice(), TestUtils.DELTA);
    }

    @Test
    public void testGetType() {
        Ingredient ingredient = new Ingredient(ingredientType,name, price);
        assertEquals(ingredientType, ingredient.getType());
    }

    @Test
    public void testConstructor() {
        Ingredient ingredient = new Ingredient(ingredientType,name, price);
        assertEquals(ingredientType, ingredient.getType());
        assertEquals(name, ingredient.getName());
        assertEquals(price, ingredient.getPrice(), TestUtils.DELTA);
    }
}
