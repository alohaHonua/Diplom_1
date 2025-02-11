package praktikum;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;
import static praktikum.IngredientType.SAUCE;

public class IngredientTest {
    private final IngredientType ingredientType = SAUCE; // заменить на мок
    private final String name = "Tobasco";
    private final float price = 2.4F;
    private Ingredient ingredient;


    //Перед каждым тестом создаем новый объект ингридиент
    @Before
    public void setUp() {
        ingredient = new Ingredient(ingredientType, name, price);
    }

    @Test
    public void testGetPrice() {
        assertEquals(price, ingredient.getPrice(), 0);
    }

    @Test
    public void testGetName() {
        assertEquals(name, ingredient.getName());
    }


}