package tests;

import org.junit.Test;
import praktikum.Ingredient;
import praktikum.IngredientType;
import static org.junit.Assert.assertEquals;

public class IngredientTest {

    @Test
    public void getPriceTest(){
        float expectedPrice = 20f;
        Ingredient ingredient = new Ingredient(IngredientType.FILLING, "Test ingredient", expectedPrice);
        assertEquals(expectedPrice, ingredient.getPrice(), 0);
    }

    @Test
    public void getNameTest(){
        String expectedName = "Лук";
        Ingredient ingredient = new Ingredient(IngredientType.FILLING, expectedName, 10);
        assertEquals(expectedName, ingredient.getName());
    }

    @Test
    public void getTypeTest() {
        IngredientType expectedType = IngredientType.SAUCE;
        Ingredient ingredient = new Ingredient(expectedType, "Test ingredient", 10);
        assertEquals(expectedType, ingredient.getType());
    }
}
