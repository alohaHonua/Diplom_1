import org.junit.Test;
import praktikum.Ingredient;
import praktikum.IngredientType;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;

public class IngredientTest {

    @Test
    public void ingredientConstructorTest() {
        Ingredient ingredient = new Ingredient(IngredientType.SAUCE, "Соус", 2.5f);
        assertEquals(IngredientType.SAUCE, ingredient.getType());
        assertEquals("Соус", ingredient.getName());
        assertEquals(2.5f, ingredient.getPrice(), 0.01f);
    }


    @Test
    public void ingredientGetTypeTest() {
        Ingredient ingredient = new Ingredient(IngredientType.SAUCE, "Соус", 2.5f);
        assertEquals(IngredientType.SAUCE, ingredient.getType());
    }

    @Test
    public void ingredientGetNameTest() {
        Ingredient ingredient = new Ingredient(IngredientType.SAUCE, "Соус", 2.5f);
        assertEquals("Соус", ingredient.getName());
    }

    @Test
    public void ingredientGetPriceTest() {
        Ingredient ingredient = new Ingredient(IngredientType.SAUCE, "Соус", 2.5f);
        assertEquals(2.5f, ingredient.getPrice(), 0.01f);
    }

    @Test
    public void ingredientEmptyNameTest() {
        Ingredient ingredient = new Ingredient(IngredientType.SAUCE, "", 2.5f);
        assertEquals("", ingredient.getName());
    }

    @Test
    public void ingredientZeroPriceTest() {
        Ingredient ingredient = new Ingredient(IngredientType.SAUCE, "Соус", 0.0f);
        assertEquals(0.0f, ingredient.getPrice(), 0.01f);
    }
}
