package praktikum;

import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;


public class BurgerTest {
    private Burger burger;
    Ingredient ingredient1 = new Ingredient(IngredientType.FILLING, "cheese", 10);
    Ingredient ingredient2 = new Ingredient(IngredientType.FILLING, "salad", 7);

    @Before
    public void createNewBurger(){
        burger = new Burger();
    }

    @Test
    public void checkAddIngredientTest(){
        burger.addIngredient(ingredient1);
        burger.addIngredient(ingredient2);
        List<Ingredient> expectedIngredients = List.of(ingredient1, ingredient2);
        List<Ingredient> actualIngredients =  burger.ingredients;
        assertEquals("Ожидаемые и фактические ингредиенты не совпадают",expectedIngredients, actualIngredients);
    }

    @Test
    public void checkRemoveIngredientTest(){
        burger.addIngredient(ingredient1);
        burger.addIngredient(ingredient2);
        burger.removeIngredient(0);
        List<Ingredient> expectedIngredients = List.of(ingredient2);
        List<Ingredient> actualIngredients =  burger.ingredients;
        assertEquals("Ожидаемые и фактические ингредиенты не совпадают",expectedIngredients, actualIngredients);
    }

    @Test
    public void checkMoveIngredientTest(){
        burger.addIngredient(ingredient1);
        burger.addIngredient(ingredient2);
        burger.moveIngredient(0, 1);
        List<Ingredient> expectedIngredients = List.of(ingredient2, ingredient1);
        List<Ingredient> actualIngredients =  burger.ingredients;
        assertEquals("Ожидаемые и фактические ингредиенты не совпадают",expectedIngredients, actualIngredients);
    }

}
