import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.mockito.Mockito;
import praktikum.Bun;
import praktikum.Burger;
import praktikum.Ingredient;
import praktikum.IngredientType;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

@RunWith(Parameterized.class)
public class BurgerTest {
    private Burger burger;
    private Bun bun;
    private Ingredient ingredient1;
    private Ingredient ingredient2;

    @Parameterized.Parameters
    public static Object[][] getBunData() {
        return new Object[][] {
                {"black bun", 100},
                {"white bun", 200},
                {"red bun", 300}
        };
    }

    public BurgerTest(String bunName, float bunPrice) {
        bun = Mockito.mock(Bun.class);
        when(bun.getName()).thenReturn(bunName);
        when(bun.getPrice()).thenReturn(bunPrice);

        ingredient1 = Mockito.mock(Ingredient.class);
        when(ingredient1.getType()).thenReturn(IngredientType.SAUCE);
        when(ingredient1.getName()).thenReturn("hot sauce");
        when(ingredient1.getPrice()).thenReturn(100f);

        ingredient2 = Mockito.mock(Ingredient.class);
        when(ingredient2.getType()).thenReturn(IngredientType.FILLING);
        when(ingredient2.getName()).thenReturn("cutlet");
        when(ingredient2.getPrice()).thenReturn(200f);
    }

    @Before
    public void setUp() {
        burger = new Burger();
        burger.setBuns(bun);
    }

    @Test
    public void testSetBuns() {
        assertEquals(bun, burger.bun);
    }

    @Test
    public void testAddIngredient() {
        burger.addIngredient(ingredient1);
        assertEquals(1, burger.ingredients.size());
        assertEquals(ingredient1, burger.ingredients.get(0));
    }

    @Test
    public void testRemoveIngredient() {
        burger.addIngredient(ingredient1);
        burger.addIngredient(ingredient2);
        burger.removeIngredient(0);
        assertEquals(1, burger.ingredients.size());
        assertEquals(ingredient2, burger.ingredients.get(0));
    }

    @Test
    public void testMoveIngredient() {
        burger.addIngredient(ingredient1);
        burger.addIngredient(ingredient2);
        burger.moveIngredient(0, 1);
        assertEquals(ingredient2, burger.ingredients.get(0));
        assertEquals(ingredient1, burger.ingredients.get(1));
    }

    @Test
    public void testGetPrice() {
        burger.addIngredient(ingredient1);
        burger.addIngredient(ingredient2);
        float expectedPrice = bun.getPrice() * 2 + ingredient1.getPrice() + ingredient2.getPrice();
        assertEquals(expectedPrice, burger.getPrice(), 0);
    }

    @Test
    public void testGetReceipt() {
        burger.addIngredient(ingredient1);
        burger.addIngredient(ingredient2);

        String expectedReceipt = String.format("(==== %s ====)%n", bun.getName()) +
                String.format("= %s %s =%n", ingredient1.getType().toString().toLowerCase(), ingredient1.getName()) +
                String.format("= %s %s =%n", ingredient2.getType().toString().toLowerCase(), ingredient2.getName()) +
                String.format("(==== %s ====)%n", bun.getName()) +
                String.format("%nPrice: %f%n", burger.getPrice());

        assertEquals(expectedReceipt, burger.getReceipt());
    }
}