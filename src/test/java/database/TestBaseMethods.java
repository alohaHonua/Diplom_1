package database;

import org.junit.Test;
import praktikum.Bun;
import praktikum.Database;
import praktikum.Ingredient;
import praktikum.IngredientType;

import java.util.Objects;

import static org.junit.Assert.*;

public class TestBaseMethods {
    @Test
    public void testAvailableBuns(){
        var database = new Database();
        for(Bun bun: database.availableBuns() ){
            if (Objects.equals(bun.name, Constants.BLACK_BUN_NAME)) {
                assertEquals(Constants.BLACK_BUN_PRICE, bun.price, 0.001);
            } else if (Objects.equals(bun.name, Constants.WHITE_BUN_NAME)) {
                assertEquals(Constants.WHITE_BUN_PRICE, bun.price, 0.001);
            } else if (Objects.equals(bun.name, Constants.RED_BUN_NAME)){
                assertEquals(Constants.RED_BUN_PRICE, bun.price, 0.001);
            } else {
                fail("No such bun: " + bun.name);
            }
        }
    }
    @Test
    public void testAvailableIngredients(){
        var database = new Database();
        for(Ingredient ingredient: database.availableIngredients()){
            if (Objects.equals(ingredient.name, Constants.HOT_SAUCE_NAME)) {
                assertEquals("Got wrong ingredient type", IngredientType.SAUCE, ingredient.type);
                assertEquals(Constants.HOT_SAUCE_PRICE, ingredient.price, 0.001);
            } else if (Objects.equals(ingredient.name, Constants.SOUR_CREAM_NAME)) {
                assertEquals("Got wrong ingredient type", IngredientType.SAUCE, ingredient.type);
                assertEquals(Constants.SOUR_CREAM_PRICE, ingredient.price, 0.001);
            } else if (Objects.equals(ingredient.name, Constants.CHILLI_SAUCE_NAME)) {
                assertEquals("Got wrong ingredient type", IngredientType.SAUCE, ingredient.type);
                assertEquals(Constants.CHILLI_SAUCE_PRICE, ingredient.price, 0.001);
            } else if (Objects.equals(ingredient.name, Constants.CUTLET_NAME)){
                assertEquals("Got wrong ingredient type", IngredientType.FILLING, ingredient.type);
                assertEquals(Constants.CUTLET_PRICE, ingredient.price, 0.001);
            } else if (Objects.equals(ingredient.name, Constants.DINOSAUR_NAME)){
                assertEquals("Got wrong ingredient type", IngredientType.FILLING, ingredient.type);
                assertEquals(Constants.DINOSAUR_PRICE, ingredient.price, 0.001);
            } else if (Objects.equals(ingredient.name, Constants.SAUSAGE_NAME)){
                assertEquals("Got wrong ingredient type", IngredientType.FILLING, ingredient.type);
                assertEquals(Constants.SAUSAGE_PRICE, ingredient.price, 0.001);
            } else {
                fail("Ingredient is not in a database");
            }
        }
    }
}
