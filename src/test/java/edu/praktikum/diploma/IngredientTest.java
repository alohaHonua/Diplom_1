package edu.praktikum.diploma;

import com.github.javafaker.Faker;
import org.junit.Before;
import org.junit.Test;
import praktikum.Ingredient;
import praktikum.IngredientType;

import static org.junit.Assert.assertEquals;

public class IngredientTest {
    private Ingredient sauce;
    private Ingredient filling;
    private String ingredientName;
    private float ingredientPrice;

    @Before
    public void setUp() {
        Faker faker = new Faker();
        ingredientName = faker.funnyName().name();
        double ingredientPriceSample = faker.number().randomDouble(2, 100,501);
        ingredientPrice = (float) (ingredientPriceSample);
        sauce = new Ingredient(IngredientType.SAUCE, ingredientName, ingredientPrice);
        filling = new Ingredient(IngredientType.FILLING, ingredientName, ingredientPrice);
    }

    @Test
    public void testConstructorForFilling() {
        assertEquals("Ингредиент не является наполнением",IngredientType.FILLING, filling.getType());
        assertEquals("Название наполнения не совпадает", ingredientName, filling.getName());
        assertEquals(ingredientPrice, filling.getPrice(), 0);
    }

    @Test
    public void testConstructorForSauce() {
        assertEquals("Ингредиент не является соусом", IngredientType.SAUCE, sauce.getType());
        assertEquals("Название соуса не совпадает", ingredientName, sauce.getName());
        assertEquals(ingredientPrice, sauce.getPrice(), 0);
    }

    @Test
    public void testGetName() {
        assertEquals("Название соуса не совпадает", ingredientName, sauce.getName());
        assertEquals("Название наполнения не совпадает", ingredientName, filling.getName());
    }

    @Test
    public void testGetPrice() {
        assertEquals(ingredientPrice, sauce.getPrice(), 0);
        assertEquals(ingredientPrice, filling.getPrice(), 0);
    }

    @Test
    public void testGetType() {
        assertEquals("Ингредиент не является наполнением",IngredientType.FILLING, filling.getType());
        assertEquals("Ингредиент не является соусом", IngredientType.SAUCE, sauce.getType());
    }
}
