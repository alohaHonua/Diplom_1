package edu.praktikum.diploma;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import praktikum.Database;
import praktikum.Ingredient;
import praktikum.IngredientType;

import java.util.Arrays;

import static org.junit.Assert.assertEquals;

public class IngredientTest {

    @Mock
    private Database database;

    @Before
    public void setUp() {
        MockitoAnnotations.openMocks(this);

        Ingredient sauce = new Ingredient(IngredientType.SAUCE, "sour cream", 200);
        Ingredient filling = new Ingredient(IngredientType.FILLING, "cutlet", 100);

        Mockito.when(database.availableIngredients()).thenReturn(Arrays.asList(sauce, filling));

    }

    @Test
    public void testGetName() {
        Ingredient sauce = database.availableIngredients().get(0);
        Ingredient filling = database.availableIngredients().get(1);
        assertEquals("Название соуса не совпадает", "sour cream", sauce.getName());
        assertEquals("Название наполнения не совпадает", "cutlet", filling.getName());
    }

    @Test
    public void testGetPrice() {
        Ingredient sauce = database.availableIngredients().get(0);
        Ingredient filling = database.availableIngredients().get(1);
        assertEquals(200f, sauce.getPrice(), 0);
        assertEquals(100f, filling.getPrice(), 0);
    }

    @Test
    public void testGetType() {
        Ingredient sauce = database.availableIngredients().get(0);
        Ingredient filling = database.availableIngredients().get(1);
        assertEquals("Ингредиент не является соусом", IngredientType.SAUCE, sauce.getType());
        assertEquals("Ингредиент не является наполнением",IngredientType.FILLING, filling.getType());
    }
}
