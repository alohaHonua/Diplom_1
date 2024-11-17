import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import praktikum.Bun;
import praktikum.Burger;
import praktikum.Ingredient;
import praktikum.IngredientType;

import java.util.ArrayList;
import java.util.List;

public class BurgerTest {

    private Bun bun;
    private Burger burger;
    private List<Ingredient> ingredients;

    @Before
    public void setUp() {
        ingredients = new ArrayList<>();
        bun = mock(Bun.class);
        burger = new Burger();
    }

    @Test
    public void testGetPrice() {
        when(bun.getPrice()).thenReturn(100.0f);
        burger.setBuns(bun);

        Ingredient ingredient1 = mock(Ingredient.class);
        when(ingredient1.getPrice()).thenReturn(50.0f);
        ingredients.add(ingredient1);

        Ingredient ingredient2 = mock(Ingredient.class);
        when(ingredient2.getPrice()).thenReturn(75.0f);
        ingredients.add(ingredient2);

        burger.ingredients = ingredients;

        // Важно: price вычисляется корректно.
        float price = burger.getPrice();
        assertEquals(325.0f, price, 0.01f); // Используем 0.01f для сравнения float
    }

    @Test
    public void testGetReceipt() {
        when(bun.getName()).thenReturn("white bun");
        burger.setBuns(bun);

        Ingredient ingredient1 = mock(Ingredient.class);
        when(ingredient1.getType()).thenReturn(IngredientType.FILLING);
        when(ingredient1.getName()).thenReturn("cutlet");
        when(ingredient1.getPrice()).thenReturn(100.0f);
        ingredients.add(ingredient1);

        Ingredient ingredient2 = mock(Ingredient.class);
        when(ingredient2.getType()).thenReturn(IngredientType.SAUCE);
        when(ingredient2.getName()).thenReturn("hot sauce");
        when(ingredient2.getPrice()).thenReturn(200.0f);
        ingredients.add(ingredient2);

        burger.ingredients = ingredients;

        String expectedReceipt = "(==== white bun ====)\n= filling cutlet =\n= sauce hot sauce =\n(==== white bun ====)\n\nPrice: 300,000000\n";
        assertEquals(expectedReceipt, burger.getReceipt());
    }
}