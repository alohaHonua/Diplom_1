package praktikum;

import org.junit.Before;
import org.junit.Test;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

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
    }

    @Test
    public void testSetBuns() {
        when(bun.getName()).thenReturn("black bun");
        when(bun.getPrice()).thenReturn(100f);
        burger.setBuns(bun);
        assertNotNull(burger.bun);
        assertEquals(bun, burger.bun);
    }

    @Test
    public void testAddIngredient() {
        when(ingredient1.getName()).thenReturn("hot sauce");
        when(ingredient1.getPrice()).thenReturn(50f);
        burger.setBuns(bun);
        burger.addIngredient(ingredient1);
        assertEquals(1, burger.ingredients.size());
        assertEquals(ingredient1, burger.ingredients.get(0));
    }

    @Test
    public void testRemoveIngredient() {
        when(ingredient1.getName()).thenReturn("hot sauce");
        when(ingredient1.getPrice()).thenReturn(50f);
        burger.setBuns(bun);
        burger.addIngredient(ingredient1);
        burger.removeIngredient(0);
        assertEquals(0, burger.ingredients.size());
    }

    @Test
    public void testMoveIngredient() {
        when(ingredient1.getName()).thenReturn("hot sauce");
        when(ingredient1.getPrice()).thenReturn(50f);
        when(ingredient2.getName()).thenReturn("cheese");
        when(ingredient2.getPrice()).thenReturn(30f);
        burger.setBuns(bun);
        burger.addIngredient(ingredient1);
        burger.addIngredient(ingredient2);
        burger.moveIngredient(0, 1);
        assertEquals(ingredient2, burger.ingredients.get(0));
        assertEquals(ingredient1, burger.ingredients.get(1));
    }

    @Test
    public void testGetPrice() {
        when(bun.getPrice()).thenReturn(100f);
        when(ingredient1.getPrice()).thenReturn(50f);
        when(ingredient2.getPrice()).thenReturn(30f);
        burger.setBuns(bun);
        burger.addIngredient(ingredient1);
        burger.addIngredient(ingredient2);
        float expectedPrice = (100f * 2) + 50f + 30f; // 200 + 50 + 30
        assertEquals(expectedPrice, burger.getPrice(), 0.01);
    }

    @Test
    public void testGetReceipt() {
        Burger burger = new Burger();
        Bun bun = new Bun("black bun", 100);
        Ingredient ingredient = new Ingredient(IngredientType.SAUCE, "hot sauce", 100);
        burger.setBuns(bun);
        burger.addIngredient(ingredient);

        String actual = burger.getReceipt();
        String expected = String.format("(==== %s ====)\r\n= sauce %s =\r\n(==== %s ====)\r\n\r\nPrice: %.6f\r\n",
                bun.getName(), ingredient.getName(), bun.getName(), burger.getPrice());

        assertThat(actual, equalTo(expected));
    }
}