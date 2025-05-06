import org.junit.Test;
import praktikum.Ingredient;
import praktikum.IngredientType;

import static org.junit.Assert.*;

public class IngredientTest {

    private static final float DELTA = 0.001f;

    @Test
    public void ingredientConstructorTest() {
        Ingredient ingredient = new Ingredient(IngredientType.SAUCE, "hot sauce", 100);

        assertEquals(IngredientType.SAUCE, ingredient.getType());
        assertEquals("hot sauce", ingredient.getName());
        assertEquals(100, ingredient.getPrice(), DELTA);
    }

    @Test
    public void getPriceTest() {
        Ingredient ingredient = new Ingredient(IngredientType.FILLING, "cutlet", 200);
        assertEquals(200, ingredient.getPrice(), DELTA);
    }

    @Test
    public void getNameTest() {
        Ingredient ingredient = new Ingredient(IngredientType.SAUCE, "chili sauce", 300);
        assertEquals("chili sauce", ingredient.getName());
    }

    @Test
    public void getTypeTest() {
        Ingredient ingredient = new Ingredient(IngredientType.FILLING, "dinosaur", 400);
        assertEquals(IngredientType.FILLING, ingredient.getType());
    }
}