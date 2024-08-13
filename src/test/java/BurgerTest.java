import org.hamcrest.MatcherAssert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import praktikum.Bun;
import praktikum.Burger;
import praktikum.Ingredient;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.*;
import static praktikum.IngredientType.*;


@RunWith(MockitoJUnitRunner.class)
public class BurgerTest {
    @Mock
    private Bun bun;
    @Mock
    private Ingredient ingredient1;
    @Mock
    private Ingredient ingredient2;
    Burger burger = new Burger();

    @Test
    public void testSetBuns() {
        burger.setBuns(bun);
        assertEquals(bun, burger.bun);
    }

    @Test
    public void testAddIngredient() {
        burger.addIngredient(ingredient1);
        assertTrue(burger.ingredients.contains(ingredient1));
    }

    @Test
    public void testRemoveIngredient() {
        int index = 1;
        burger.addIngredient(ingredient1);
        burger.addIngredient(ingredient2);
        burger.removeIngredient(index);
        assertEquals(index, burger.ingredients.size());
    }

    @Test
    public void testMoveIngredient() {

        burger.addIngredient(ingredient1);
        burger.addIngredient(ingredient2);
        burger.moveIngredient(0, 1);
        assertEquals(ingredient1, burger.ingredients.get(1));
    }

    @Test
    public void testGetPrice() {
        float bunPrice = 100;
        float ingredientPrice = 200;
        float expectedPrice = bunPrice * 2 + ingredientPrice;
        burger.setBuns(bun);
        burger.addIngredient(ingredient1);
        Mockito.when(bun.getPrice()).thenReturn(bunPrice);
        Mockito.when(ingredient1.getPrice()).thenReturn(ingredientPrice);
        MatcherAssert.assertThat(expectedPrice, equalTo(burger.getPrice()));
    }

    @Test
    public void testGetReceipt() {
        burger.setBuns(bun);
        burger.addIngredient(ingredient1);
        burger.addIngredient(ingredient2);
        Mockito.when(bun.getName()).thenReturn("tastyBun");
        Mockito.when(ingredient1.getName()).thenReturn("hot");
        Mockito.when(ingredient1.getType()).thenReturn(SAUCE);
        Mockito.when(ingredient2.getName()).thenReturn("carrot");
        Mockito.when(ingredient2.getType()).thenReturn(FILLING);
        Mockito.when(burger.getPrice()).thenReturn(40F);
        String expectedResult = "(==== tastyBun ====)\r\n= sauce hot =\r\n= filling carrot =\r\n(==== tastyBun ====)\r\n\r\nPrice: 40,000000\r\n";

        MatcherAssert.assertThat(burger.getReceipt(), equalTo(expectedResult));
    }
}


