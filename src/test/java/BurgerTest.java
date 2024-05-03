import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import praktikum.Bun;
import praktikum.Burger;
import praktikum.Ingredient;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;
import static praktikum.IngredientType.*;

@RunWith(MockitoJUnitRunner.class)
public class BurgerTest {
    private Burger burger;

    @Mock
    private Bun bun;
    @Mock
    private Ingredient ingredient1;
    @Mock
    private Ingredient ingredient2;

    @Before
    public void setUp() {
        burger = new Burger();
    }

    @Test
    public void setBunsTest() {
        burger.setBuns(bun);
        assertEquals(bun.getName(), burger.bun.getName());
    }

    @Test
    public void addIngredientTest() {
        burger.addIngredient(ingredient1);
        assertEquals(1, burger.ingredients.size());
    }

    @Test
    public void removeIngredientTest() {
        burger.addIngredient(ingredient1);
        burger.addIngredient(ingredient2);
        burger.removeIngredient(0);
        assertEquals(1, burger.ingredients.size());
    }

    @Test
    public void moveIngredientTest() {
        burger.addIngredient(ingredient1);
        burger.addIngredient(ingredient2);
        burger.moveIngredient(0, 1);
        assertEquals(ingredient1, burger.ingredients.get(1));
        assertEquals(ingredient2, burger.ingredients.get(0));
    }

    @Test
    public void getPriceTest() {
        burger.setBuns(bun);
        burger.addIngredient(ingredient1);
        burger.addIngredient(ingredient2);
        when(bun.getPrice()).thenReturn(100F);
        when(ingredient1.getPrice()).thenReturn(200F);
        when(ingredient2.getPrice()).thenReturn(300F);
        float expectedPrice = (100F*2)+200F+300F;
        assertEquals(expectedPrice, burger.getPrice(), 0);
    }

    @Test
    public void getReceiptTest() {
        burger.setBuns(bun);
        burger.addIngredient(ingredient1);
        burger.addIngredient(ingredient2);
        when(bun.getName()).thenReturn("black bun");
        when(ingredient1.getName()).thenReturn("hot sauce");
        when(ingredient2.getName()).thenReturn("cutlet");
        when(bun.getPrice()).thenReturn(100F);
        when(ingredient1.getPrice()).thenReturn(100F);
        when(ingredient2.getPrice()).thenReturn(100F);
        when(ingredient1.getType()).thenReturn(SAUCE);
        when(ingredient2.getType()).thenReturn(FILLING);
        String expectedReceipt = String.format("(==== black bun ====)%n" + ("= sauce hot sauce =%n") + ("= filling cutlet =%n") + "(==== black bun ====)%n" + "%n" + "Price: 400,000000%n");
        assertEquals(expectedReceipt, burger.getReceipt());
    }
}
