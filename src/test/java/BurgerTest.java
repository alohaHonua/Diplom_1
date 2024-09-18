
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import praktikum.Bun;
import praktikum.Burger;
import praktikum.Ingredient;

import static org.junit.Assert.assertEquals;
import static praktikum.IngredientType.*;

@RunWith(MockitoJUnitRunner.class)
public class BurgerTest {

    Burger burger;

    @Mock
    private Bun bun;

    @Mock
    private Ingredient firstIngredient, secondIngredient, thirdIngredient, fourthIngredient, fifthIngredient;

    @Before
    public void setUp() {
        burger = new Burger();

    }

    @Test
    public void setBunsTest() {
        burger.setBuns(bun);
        System.out.println(burger.bun);
        System.out.println(burger.bun);
        assertEquals(bun, burger.bun);
    }

    @Test
    public void addIngredientTest() {
        burger.addIngredient(firstIngredient);
        burger.addIngredient(secondIngredient);
        burger.addIngredient(thirdIngredient);
        burger.addIngredient(fourthIngredient);
        burger.addIngredient(fifthIngredient);
        assertEquals(5, burger.ingredients.size());

    }

    @Test
    public void removeIngredientTest() {
        burger.addIngredient(firstIngredient);
        burger.addIngredient(secondIngredient);
        burger.addIngredient(thirdIngredient);
        burger.addIngredient(fourthIngredient);
        burger.addIngredient(fifthIngredient);
        burger.removeIngredient(3);
        assertEquals(4, burger.ingredients.size());

    }

    @Test
    public void moveIngredientTest() {
        burger.addIngredient(firstIngredient);
        burger.addIngredient(secondIngredient);
        burger.addIngredient(thirdIngredient);

        burger.moveIngredient(1, 0);
        assertEquals(secondIngredient, burger.ingredients.get(0));
        assertEquals(firstIngredient, burger.ingredients.get(1));

    }

    @Test
    public void getPriceTest() {
        Mockito.when(bun.getPrice()).thenReturn(111F);
        Mockito.when(firstIngredient.getPrice()).thenReturn(23F);
        Mockito.when(secondIngredient.getPrice()).thenReturn(30F);
        Mockito.when(thirdIngredient.getPrice()).thenReturn(5F);
        burger.setBuns(bun);
        burger.addIngredient(firstIngredient);
        burger.addIngredient(secondIngredient);
        burger.addIngredient(thirdIngredient);
        float expected = (111F * 2) + 23F + 30F + 5F;
        assertEquals(expected, burger.getPrice(), 0);

    }

    @Test
    public void getReceiptTest() {
        Mockito.when(bun.getName()).thenReturn("Бургер");
        Mockito.when(firstIngredient.getName()).thenReturn("Булочка");
        Mockito.when(secondIngredient.getName()).thenReturn("Соус");
        Mockito.when(thirdIngredient.getName()).thenReturn("Мясо");
        Mockito.when(bun.getPrice()).thenReturn(111F);
        Mockito.when(firstIngredient.getPrice()).thenReturn(23F);
        Mockito.when(secondIngredient.getPrice()).thenReturn(30F);
        Mockito.when(thirdIngredient.getPrice()).thenReturn(5F);
        Mockito.when(firstIngredient.getType()).thenReturn(FILLING);
        Mockito.when(secondIngredient.getType()).thenReturn(SAUCE);
        Mockito.when(thirdIngredient.getType()).thenReturn(FILLING);
        burger.setBuns(bun);
        burger.addIngredient(firstIngredient);
        burger.addIngredient(secondIngredient);
        burger.addIngredient(thirdIngredient);
        String expected = String.format(
                "(==== Бургер ====)%n" +
                "= filling Булочка =%n" +
                "= sauce Соус =%n" +
                "= filling Мясо =%n" +
                "(==== Бургер ====)%n" +
                "%nPrice: 280,000000%n");

        assertEquals(expected, burger.getReceipt());
    }
}