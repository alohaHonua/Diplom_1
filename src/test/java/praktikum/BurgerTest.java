package praktikum;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;


@RunWith(MockitoJUnitRunner.class)
public class BurgerTest extends ConstantData {
    Burger burger;
    @Mock
    Bun bun;
    @Mock
    Ingredient ingredient1;
    @Mock
    Ingredient ingredient2;

    @Before
    public void setUp() {
        burger = new Burger();
    }

    @Test
    public void testAddIngredient() {
        burger.addIngredient(ingredient1);
        assertFalse(burger.ingredients.isEmpty());
    }

    @Test
    public void testRemoveIngredient() {
        burger.addIngredient(ingredient1);
        burger.removeIngredient(0);
        assertTrue(burger.ingredients.isEmpty());
    }

    @Test
    public void testMoveIngredient(){
        burger.addIngredient(ingredient1);
        burger.addIngredient(ingredient2);
        Ingredient ingredientMoved = burger.ingredients.get(1);
        burger.moveIngredient(1,0);
        assertEquals(burger.ingredients.get(0), ingredientMoved);
    }

    @Test
    public void testGetPrice() {
        Mockito.when(bun.getPrice()).thenReturn(ConstantData.BUN_PRICE);
        burger.setBuns(bun);
        burger.addIngredient(ingredient1);
        burger.addIngredient(ingredient2);
        float price = bun.getPrice() * 2;

        int i = 0;
        for (Ingredient ingredient : burger.ingredients){
            Mockito.when(ingredient.getPrice()).thenReturn(ConstantData.INGREDIENT_PRICES[i]);
            price += burger.ingredients.get(i).getPrice();
            i++;
        }

        burger.getPrice();
        assertEquals(price, burger.getPrice(), 0.1);
    }

    @Test
    public void testGetReceipt(){
        Mockito.when(bun.getName()).thenReturn(ConstantData.BUN_NAME);
        burger.setBuns(bun);
        burger.addIngredient(ingredient1);
        burger.addIngredient(ingredient2);

        StringBuilder expected = new StringBuilder(String.format("(==== %s ====)", bun.getName()));
        expected.append(System.lineSeparator());

        int i = 0;
        for (Ingredient ingredient : burger.ingredients){
            Mockito.when(ingredient.getName()).thenReturn(ConstantData.INGREDIENT_NAMES[i]);
            Mockito.when(ingredient.getType()).thenReturn(ConstantData.INGREDIENT_TYPES[i]);
            expected.append(String.format("= %s %s =", ingredient.getType().toString().toLowerCase(), ingredient.getName()));
            expected.append(System.lineSeparator());
            i++;
        }

        expected.append(String.format("(==== %s ====)", bun.getName()));
        expected.append(System.lineSeparator());
        expected.append(String.format("%nPrice: %f", burger.getPrice()));
        expected.append(System.lineSeparator());

        assertEquals(expected.toString(), burger.getReceipt());
    }
}