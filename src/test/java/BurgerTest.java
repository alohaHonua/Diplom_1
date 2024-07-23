import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import praktikum.*;

import java.util.ArrayList;
import java.util.List;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class BurgerTest {
    private Burger burger;

    @Mock
    private Database mockDatabase;

    @Mock
    private Bun mockBun;

    @Mock
    private Ingredient mockIngredient1;

    @Mock
    private Ingredient mockIngredient2;

    @Before
    public void setUp() {
        burger = new Burger();

        List<Bun> buns = new ArrayList<>();
        buns.add(new Bun("black bun", 100));
        buns.add(new Bun("white bun", 200));

        List<Ingredient> ingredients = new ArrayList<>();
        ingredients.add(new Ingredient(IngredientType.SAUCE, "hot sauce", 100));
        ingredients.add(new Ingredient(IngredientType.FILLING, "cutlet", 150));

        when(mockDatabase.availableBuns()).thenReturn(buns);
        when(mockDatabase.availableIngredients()).thenReturn(ingredients);

        burger.setBuns(mockDatabase.availableBuns().get(0));
        burger.addIngredient(mockDatabase.availableIngredients().get(0));
        burger.addIngredient(mockDatabase.availableIngredients().get(1));
    }

    @Test
    public void testSetBuns() {
        Burger testBurger = new Burger();
        testBurger.setBuns(mockBun);
        assertEquals(mockBun, testBurger.bun);
    }

    @Test
    public void testAddIngredient() {
        assertEquals(2, burger.ingredients.size());
    }

    @Test
    public void testRemoveIngredient() {
        burger.removeIngredient(0);
        assertEquals(1, burger.ingredients.size());
    }

    @Test
    public void testMoveIngredient() {
        String expected = burger.ingredients.get(0).name;
        burger.moveIngredient(0, 1);
        assertEquals(expected, burger.ingredients.get(1).name);
    }

    @Test
    public void testGetPrice() {
        when(mockBun.getPrice()).thenReturn(100f);
        when(mockIngredient1.getPrice()).thenReturn(100f);
        when(mockIngredient2.getPrice()).thenReturn(150f);
        float expectedPrice = 200f + 100f + 150f;
        assertEquals(expectedPrice, burger.getPrice(), 1);
    }

    @Test
    public void testGetReceipt() {
        when(mockBun.getName()).thenReturn("black bun");
        when(mockIngredient1.getType()).thenReturn(IngredientType.SAUCE);
        when(mockIngredient1.getName()).thenReturn("hot sauce");
        when(mockIngredient2.getType()).thenReturn(IngredientType.FILLING);
        when(mockIngredient2.getName()).thenReturn("cutlet");
        String expectedReceipt = "(==== black bun ====)\r\n" +
                "= sauce hot sauce =\r\n" +
                "= filling cutlet =\r\n" +
                "(==== black bun ====)\r\n" +
                "\r\n" +
                "Price: 450,000000\r\n";
        String Burger = burger.getReceipt();
        assertEquals(expectedReceipt, burger.getReceipt());
    }
}