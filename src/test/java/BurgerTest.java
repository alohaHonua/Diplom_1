import org.junit.Test;
import org.mockito.junit.MockitoJUnitRunner;
import org.mockito.Mock;
import org.junit.runner.RunWith;
import org.junit.Before;
import praktikum.Bun;
import praktikum.Burger;
import praktikum.Ingredient;
import praktikum.IngredientType;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class BurgerTest {
    public Burger burger;

    @Mock
    private Bun bun;
    @Mock
    private Ingredient TheoreticalIngredient_1;
    @Mock
    private Ingredient TheoreticalIngredient_2;
    @Mock
    private Ingredient TheoreticalIngredient_3;

    @Before
    public void makeBurger() {
        burger = new Burger();
    }

    @Test
    public void setBunsTest() {
        burger.setBuns(bun);
        when(bun.getName()).thenReturn("Theoretical bun");

        assertEquals("Theoretical bun", burger.bun.getName());
    }

    @Test
    public void addIngredientTest() {
        burger.addIngredient(TheoreticalIngredient_1);

        assertEquals(1, burger.ingredients.size());
        assertTrue(burger.ingredients.contains(TheoreticalIngredient_1));
    }

    @Test
    public void removeIngredientTest() {
        burger.ingredients.add(TheoreticalIngredient_1);
        burger.ingredients.add(TheoreticalIngredient_2);
        burger.ingredients.add(TheoreticalIngredient_3);
        burger.removeIngredient(2);

        assertEquals(2, burger.ingredients.size());
        assertTrue(burger.ingredients.contains(TheoreticalIngredient_1) & burger.ingredients.contains(TheoreticalIngredient_2) & !burger.ingredients.contains(TheoreticalIngredient_3));
    }

    @Test
    public void moveIngredientTest() {
        burger.ingredients.add(TheoreticalIngredient_1);
        burger.ingredients.add(TheoreticalIngredient_2);
        burger.ingredients.add(TheoreticalIngredient_3);
        burger.moveIngredient(1, 0);

        assertEquals(burger.ingredients.get(0), TheoreticalIngredient_2);
        assertEquals(burger.ingredients.get(1), TheoreticalIngredient_1);
    }

    @Test
    public void getPrice() {
        burger.bun = bun;
        burger.ingredients.add(TheoreticalIngredient_1);
        burger.ingredients.add(TheoreticalIngredient_2);
        burger.ingredients.add(TheoreticalIngredient_3);

        when(bun.getPrice()).thenReturn(100F);
        when(TheoreticalIngredient_1.getPrice()).thenReturn(50F);
        when(TheoreticalIngredient_2.getPrice()).thenReturn(40F);
        when(TheoreticalIngredient_3.getPrice()).thenReturn(10F);

        float expected = bun.getPrice() * 2 + TheoreticalIngredient_1.getPrice() + TheoreticalIngredient_2.getPrice() + TheoreticalIngredient_3.getPrice();

        assertEquals(expected, burger.getPrice(), 0);
    }

    @Test
    public void getReceiptTest() {
        burger.bun = bun;
        burger.ingredients.add(TheoreticalIngredient_1);
        burger.ingredients.add(TheoreticalIngredient_2);
        burger.ingredients.add(TheoreticalIngredient_3);

        when(bun.getName()).thenReturn("bun");
        when(TheoreticalIngredient_1.getType()).thenReturn(IngredientType.SAUCE);
        when(TheoreticalIngredient_2.getType()).thenReturn(IngredientType.FILLING);
        when(TheoreticalIngredient_3.getType()).thenReturn(IngredientType.SAUCE);
        when(TheoreticalIngredient_1.getName()).thenReturn("TheoreticalIngredient_1");
        when(TheoreticalIngredient_2.getName()).thenReturn("TheoreticalIngredient_2");
        when(TheoreticalIngredient_3.getName()).thenReturn("TheoreticalIngredient_3");
        when(bun.getPrice()).thenReturn(100F);
        when(TheoreticalIngredient_1.getPrice()).thenReturn(50F);
        when(TheoreticalIngredient_2.getPrice()).thenReturn(40F);
        when(TheoreticalIngredient_3.getPrice()).thenReturn(10F);

        String expected = "(==== bun ====)\r\n" +
                "= sauce TheoreticalIngredient_1 =\r\n"+
                "= filling TheoreticalIngredient_2 =\r\n"+
                "= sauce TheoreticalIngredient_3 =\r\n"+
                "(==== bun ====)\r\n"+
                "\r\n"+
                "Price: 300,000000\r\n";

        assertEquals(expected, burger.getReceipt());
    }

}
