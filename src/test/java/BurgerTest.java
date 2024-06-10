import org.junit.Before;
import org.junit.Test;
import praktikum.Bun;
import praktikum.Ingredient;
import praktikum.Burger;
import praktikum.IngredientType;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

public class BurgerTest {

    private Burger burger;
    private Bun bun;
    private Ingredient ingredient1;
    private Ingredient ingredient2;

    @Before
    public void setUp() {
        burger = new Burger();
        bun = mock(Bun.class);
        ingredient1 = mock(Ingredient.class);
        ingredient2 = mock(Ingredient.class);

        when(bun.getPrice()).thenReturn(1.0f);
        when(ingredient1.getPrice()).thenReturn(0.5f);
        when(ingredient2.getPrice()).thenReturn(0.75f);

        when(bun.getName()).thenReturn("Brioche");
        when(ingredient1.getName()).thenReturn("Cheese");
        when(ingredient1.getType()).thenReturn(IngredientType.SAUCE);
        when(ingredient2.getName()).thenReturn("Lettuce");
        when(ingredient2.getType()).thenReturn(IngredientType.FILLING);

        burger.setBuns(bun);
    }

    @Test
    public void addIngredientIncreasesPrice() {
        float initialPrice = bun.getPrice() * 2;
        assertEquals(initialPrice, burger.getPrice(), 0.001);

        burger.addIngredient(ingredient1);
        assertEquals(initialPrice + ingredient1.getPrice(), burger.getPrice(), 0.001);
    }

    @Test
    public void getReceiptReturnsCorrectFormat() {
        burger.addIngredient(ingredient1);

        String expectedReceipt = "(==== Brioche ====)\n= sauce Cheese =\n(==== Brioche ====)\n\nPrice: 2.500000\n";
        assertEquals(expectedReceipt, burger.getReceipt());
    }

    @Test
    public void addingIngredientShouldIncreaseIngredientsListSize() {
        int initialSize = burger.ingredients.size();
        burger.addIngredient(ingredient1);
        assertEquals(initialSize + 1, burger.ingredients.size());
    }

    @Test
    public void removingIngredientShouldDecreaseIngredientsListSize() {
        burger.addIngredient(ingredient1);
        int sizeAfterAddition = burger.ingredients.size();
        burger.removeIngredient(0);
        assertEquals(sizeAfterAddition - 1, burger.ingredients.size());
    }

    @Test
    public void movingIngredientShouldNotChangeListSizeButChangeOrder() {
        burger.addIngredient(ingredient1);
        burger.addIngredient(ingredient2);
        Ingredient firstIngredientBeforeMove = burger.ingredients.get(0);
        burger.moveIngredient(0, 1);
        Ingredient firstIngredientAfterMove = burger.ingredients.get(0);
        assertNotEquals(firstIngredientBeforeMove, firstIngredientAfterMove);
        assertEquals(2, burger.ingredients.size());
    }
}