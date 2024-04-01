import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import praktikum.Bun;
import praktikum.Burger;
import praktikum.Ingredient;
import praktikum.IngredientType;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;


@RunWith(MockitoJUnitRunner.class)
public class BurgerTest {

    @Mock
    private Bun bun;
    @Mock
    private Ingredient ingredient1;
    @Mock
    private Ingredient ingredient2;

    private Burger burger;

    @Before
    public void createNewBurger() {
        burger = new Burger();
    }

    @Test
    public void testSetBuns() {
        burger.setBuns(bun);
        assertEquals("Incorrect bun", bun, burger.bun);
    }

    @Test
    public void testAddIngredient() {
        burger.addIngredient(ingredient1);
        List<Ingredient> expectedIngredients = List.of(ingredient1);
        assertEquals("Incorrect ingredient list after adding", expectedIngredients, burger.ingredients);
    }

    @Test
    public void testRemoveIngredient() {
        burger.addIngredient(ingredient1);
        burger.removeIngredient(0);
        assertEquals("Ingredient list should be empty after removal", 0, burger.ingredients.size());
    }

    @Test
    public void testMoveIngredient() {
        burger.addIngredient(ingredient1);
        burger.addIngredient(ingredient2);
        burger.moveIngredient(0, 1);
        assertEquals("Incorrect ingredient order after moving", ingredient1, burger.ingredients.get(1));
    }

    @Test
    public void testGetPrice() {
        when(bun.getPrice()).thenReturn(2.0f);
        when(ingredient1.getPrice()).thenReturn(1.0f);
        when(ingredient2.getPrice()).thenReturn(1.5f);
        burger.setBuns(bun);
        burger.addIngredient(ingredient1);
        burger.addIngredient(ingredient2);
        float expectedPrice = 2.0f*2 + 1.0f + 1.5f;
        assertEquals("Incorrect price", expectedPrice, burger.getPrice(), 0.001f);

    }

    @Test
    public void testGetReceipt() {
        when(bun.getName()).thenReturn("Sairis Bun");
        when(bun.getPrice()).thenReturn(4.00f);
        burger.setBuns(bun);
        when(ingredient1.getType()).thenReturn(IngredientType.SAUCE);
        when(ingredient1.getName()).thenReturn("Кисло-сладкий");
        when(ingredient1.getPrice()).thenReturn(1.00f);
        burger.addIngredient(ingredient1);
        StringBuilder receipt = new StringBuilder(String.format("(==== %s ====)%n", bun.getName()));
        List<Ingredient> ingredients = burger.ingredients;
        for (Ingredient ingredient : ingredients) {
            receipt.append(String.format("= %s %s =%n", ingredient.getType().name().toLowerCase(), ingredient.getName()));
        }
        receipt.append(String.format("(==== %s ====)%n", bun.getName()));
        receipt.append(String.format("%nPrice: %f%n", burger.getPrice()));
        String expected = receipt.toString();
        String actual = burger.getReceipt();
        assertEquals("Incorrect receipt", expected, actual);
    }
}
