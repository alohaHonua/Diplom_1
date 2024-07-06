import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import praktikum.Bun;
import praktikum.Burger;
import praktikum.Ingredient;
import praktikum.IngredientType;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class BurgerTest {

    @Mock
    private Bun bun;

    @Mock
    private Ingredient ingredient;

    private Burger burger;

    @Before
    public void setupBurger() {
        burger = new Burger();
    }

    @Test
    public void setBunsTest() {
        burger.setBuns(bun);
        assertEquals(bun, burger.bun);
    }

    @Test
    public void addIngredientTest() {
        burger.addIngredient(ingredient);
        assertEquals(1, burger.ingredients.size());
        assertEquals(ingredient, burger.ingredients.get(0));
    }

    @Test
    public void removeIngredientTest() {
        burger.addIngredient(ingredient);
        burger.removeIngredient(0);
        assertEquals(0, burger.ingredients.size());
    }

    @Test
    public void moveIngredientTest() {
        burger.addIngredient(ingredient);
        burger.addIngredient(ingredient);
        burger.moveIngredient(0, 1);
        assertEquals(ingredient, burger.ingredients.get(1));
    }

    @Test
    public void getPriceTest() {
        when(bun.getPrice()).thenReturn(10.0f);
        when(ingredient.getPrice()).thenReturn(5.0f);
        burger.setBuns(bun);
        burger.addIngredient(ingredient);
        assertEquals(25.0f, burger.getPrice(), 0.01);
    }

    @Test
    public void getReceiptTest() {
        when(bun.getName()).thenReturn("black bun");
        when(bun.getPrice()).thenReturn(100f);
        when(ingredient.getName()).thenReturn("sour cream");
        when(ingredient.getPrice()).thenReturn(200f);
        when(ingredient.getType()).thenReturn(IngredientType.SAUCE);
        burger.setBuns(bun);
        burger.addIngredient(ingredient);
        String receipt = burger.getReceipt();
        assertEquals("(==== black bun ====)\n= sauce sour cream =\n(==== black bun ====)\n\nPrice: 400,000000\n", receipt);
    }
}