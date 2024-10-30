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
    Burger burger;
    @Mock
    Bun testBun;
    @Mock
    Ingredient patty;
    @Mock
    Ingredient salad;

    @Before
    public void setUpBurger() {
        burger = new Burger();
    }

    @Test
    public void setBunsTest() {
        burger.setBuns(testBun);
        assertEquals(testBun, burger.bun);
    }

    @Test
    public void addIngredientTest() {
        burger.addIngredient(patty);
        assertEquals(1, burger.ingredients.size());
        assertEquals(patty, burger.ingredients.get(0));
    }

    @Test
    public void removeIngredientTest() {
        burger.addIngredient(patty);
        int ingredientsSize = burger.ingredients.size();
        System.out.println("LOG INFO: "+ingredientsSize);
        burger.removeIngredient(0);
        assertEquals(ingredientsSize-1, burger.ingredients.size());
    }

    @Test
    public void moveIngredientTest() {
        burger.addIngredient(patty);
        burger.addIngredient(salad);
        burger.moveIngredient(0, 1);
        assertEquals(salad, burger.ingredients.get(0));
        assertEquals(patty, burger.ingredients.get(1));
    }

    @Test
    public void getPriceTest() {
        when(testBun.getPrice()).thenReturn(3.0f);
        when(patty.getPrice()).thenReturn(4.0f);
        when(salad.getPrice()).thenReturn(2.0f);
        burger.setBuns(testBun);
        burger.addIngredient(patty);
        burger.addIngredient(salad);
        float expectedPrice = (testBun.getPrice() * 2) + patty.getPrice() + salad.getPrice();
        assertEquals(expectedPrice, burger.getPrice(), 0.0f);
    }

    @Test
    public void getReceiptTest() {
        when(testBun.getName()).thenReturn("black bun");
        when(testBun.getPrice()).thenReturn(3.0f);
        when(patty.getName()).thenReturn("space patty");
        when(patty.getType()).thenReturn(IngredientType.FILLING);
        when(patty.getPrice()).thenReturn(4.5f);

        burger.setBuns(testBun);
        burger.addIngredient(patty);


        String expectedReceipt = String.format(
                "(==== black bun ====)%n" +
                "= filling space patty =%n" +
                "(==== black bun ====)%n" +
                "%nPrice: 10,500000%n"
        );
        System.out.println("Actual receipt:\n" +burger.getReceipt());
        assertEquals(expectedReceipt, burger.getReceipt());
    }
}
