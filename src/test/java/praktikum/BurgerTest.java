import praktikum.*;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class BurgerTest {
    private Burger burger;

    @Mock
    private Bun bun;
    @Mock
    private Ingredient ingredient;
    @Mock
    private Ingredient ingredient2;
    @Mock
    private Ingredient ingredient3;

    @Before
    public void createBurger() {
        burger = new Burger();
    }

    @Test
    public void setBunTest() {
        burger.setBuns(bun);

        assertEquals(bun.getName(), burger.bun.getName());
    }

    @Test
    public void addIngredientTest() {
        burger.addIngredient(ingredient);

        assertEquals(1, burger.ingredients.size());
    }

    @Test
    public void removeIngredientTest() {
        burger.addIngredient(ingredient);
        burger.addIngredient(ingredient2);
        burger.addIngredient(ingredient3);
        assertEquals(3, burger.ingredients.size());

        burger.removeIngredient(2);
        assertEquals(2, burger.ingredients.size());
    }

    @Test
    public void moveIngredientTest() {
        burger.addIngredient(ingredient);
        burger.addIngredient(ingredient2);
        burger.addIngredient(ingredient3);

        burger.moveIngredient(1, 2);

        assertEquals(ingredient2, burger.ingredients.get(2));
        assertEquals(ingredient3, burger.ingredients.get(1));
    }

    @Test
    public void getPriceTest() {
        burger.setBuns(bun);
        burger.addIngredient(ingredient);
        burger.addIngredient(ingredient2);

        when(bun.getPrice()).thenReturn(30F);
        when(ingredient.getPrice()).thenReturn(15F);
        when(ingredient2.getPrice()).thenReturn(3F);

        float expected = (30F * 2) + 15F + 3F;

        assertEquals(expected, burger.getPrice(), 0);
    }

    @Test
    public void getReceiptTest() {
        burger.setBuns(bun);
        burger.addIngredient(ingredient);
        burger.addIngredient(ingredient2);

        when(bun.getName()).thenReturn("burger");
        when(ingredient.getName()).thenReturn("ingredient1");
        when(ingredient2.getName()).thenReturn("ingredient2");
        when(bun.getPrice()).thenReturn(20F);
        when(ingredient.getPrice()).thenReturn(10F);
        when(ingredient2.getPrice()).thenReturn(2F);
        when(ingredient.getType()).thenReturn(IngredientType.SAUCE);
        when(ingredient2.getType()).thenReturn(IngredientType.FILLING);

        String expected = "(==== burger ====)\r\n" +
                "= sauce ingredient1 =\r\n" +
                "= filling ingredient2 =\r\n"    +
                "(==== burger ====)\r\n" +
                "\r\n" +
                "Price: 52,000000\r\n";

        assertEquals(expected, burger.getReceipt());
    }

}