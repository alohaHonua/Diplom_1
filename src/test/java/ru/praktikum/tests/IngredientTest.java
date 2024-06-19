package ru.praktikum.tests;

import org.junit.Before;
import org.junit.Test;
import ru.praktikum.Ingredient;
import ru.praktikum.IngredientType;
import static org.junit.Assert.assertEquals;

public class IngredientTest {
    private Ingredient ingredientSauce;
    private Ingredient ingredientFilling;

    @Before
    public void setUp(){
        ingredientSauce = new Ingredient(IngredientType.SAUCE, "Ketchup", 3.0F);
        ingredientFilling = new Ingredient(IngredientType.FILLING, "pork chop", 6.5F);
    }

    @Test
    public void ingredientGetPriceReturnPrice(){
        Float expected = 3.0F;
        Float actual = ingredientSauce.getPrice();
        assertEquals("Цена не совпадает!", expected, actual);
    }

    @Test
    public void ingredientGetNameReturnName(){
        String expected = "pork chop";
        String actual = ingredientFilling.getName();
        assertEquals("Названия ингредиентов не совпадают!", expected, actual);
    }

    @Test
    public void ingredientGetTypeReturnType(){
        Enum<IngredientType> expected = IngredientType.SAUCE;
        Enum<IngredientType> actual = ingredientSauce.getType();
        assertEquals("Типы ингредиентов не совпадают", expected, actual);
    }

}
