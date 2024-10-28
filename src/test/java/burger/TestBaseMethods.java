package burger;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import praktikum.Bun;
import praktikum.Burger;
import praktikum.Ingredient;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

public class TestBaseMethods {
    @Mock
    Bun bun;
    @Mock
    Ingredient ingredient;
    @Mock
    Ingredient secondIngredient;

    @Before
    public void init() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testSetBun(){
        Burger burger = new Burger();
        burger.setBuns(bun);
        assertEquals("Bun is not the same", bun, burger.bun);
        assertEquals("Bun name is not correct", bun.getName(), burger.bun.getName());
        assertEquals(bun.getPrice(), burger.bun.getPrice(), 0.001);
    }

    @Test
    public void testAddIngredient(){
        Burger burger = new Burger();
        burger.addIngredient(ingredient);
        assertEquals("Burger ingredients are not same", 1, burger.ingredients.size());
        assertEquals("Ingredient is not the same", ingredient, burger.ingredients.get(0));
    }
    @Test
    public void TestRemoveIngredient(){
        Burger burger = new Burger();
        burger.addIngredient(ingredient);
        burger.removeIngredient(0);
        assertEquals("Burger ingredients are not empty", 0, burger.ingredients.size());
    }
    @Test
    public void testMoveIngredients(){
        Burger burger = new Burger();
        burger.addIngredient(ingredient);
        burger.addIngredient(secondIngredient);
        burger.moveIngredient(0, 1);
        assertEquals("Got wrong first ingredient", secondIngredient, burger.ingredients.get(0));
        assertEquals("Got wrong second ingredient", ingredient, burger.ingredients.get(1));
    }
    @Test
    public void testMoveIngredientsToWrongIndex(){
        Burger burger = new Burger();
        burger.addIngredient(ingredient);
        try {
            burger.moveIngredient(0, 2);
            fail("Should cause an error");
        } catch (Exception e){
            assertEquals("Got wrong error class!", IndexOutOfBoundsException.class, e.getClass());
        }
    }
}
