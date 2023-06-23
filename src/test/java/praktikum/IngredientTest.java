package praktikum;

import org.junit.Test;

import static org.junit.Assert.*;

public class IngredientTest {

    @Test
    public void getPrice() {
        Ingredient ingredient = new Ingredient(IngredientType.SAUCE, "hot sauce", 100);
        float expected=ingredient.getPrice();
        assertEquals(expected,ingredient.getPrice(),0);
    }

    @Test
    public void getName() {
        Ingredient ingredient = new Ingredient(IngredientType.FILLING, "cutlet", 100);
        String expectedResult = ingredient.getName();
        assertEquals(expectedResult,ingredient.getName());
    }

    @Test
    public void getType() {
        Ingredient ingredient = new Ingredient(IngredientType.SAUCE, "sour cream", 200);
        assertEquals(IngredientType.SAUCE,ingredient.getType());
    }
}