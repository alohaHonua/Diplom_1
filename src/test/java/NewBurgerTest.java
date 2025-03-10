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

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static praktikum.IngredientType.*;

@RunWith(MockitoJUnitRunner.class)
public class NewBurgerTest {

    @Mock
    Bun bun;

    @Mock
    Ingredient sauce;

    @Mock
    Ingredient filling;

    private Burger burger;

    @Before
    public void createBurger() {
        burger = new Burger();
    }

    @Test
    public void checkAddIngridient() {
        burger.addIngredient(sauce);
        boolean result = burger.ingredients.contains(sauce);
        assertTrue(result);
    }

    @Test
    public void checkRemoveIngredient() {
        burger.addIngredient(filling);
        burger.removeIngredient(0);
        int actualSize = burger.ingredients.size();
        assertEquals(0, actualSize);
    }

    @Test
    public void checkMoveIngredient() {
        burger.addIngredient(sauce);
        burger.addIngredient(filling);
        Ingredient firstIngredient = burger.ingredients.get(0);
        burger.moveIngredient(0, 1);
        assertEquals(firstIngredient, burger.ingredients.get(1));
    }

    @Test
    public void checkGetPrice() {
        burger.setBuns(bun);
        Mockito.when(burger.bun.getPrice()).thenReturn(50F);
        Mockito.when(sauce.getPrice()).thenReturn(2.5F);
        Mockito.when(filling.getPrice()).thenReturn(1.5F);
        burger.addIngredient(filling);
        burger.addIngredient(sauce);
        float actualsPrice = burger.getPrice();
        float delta = 0.1F;
        assertEquals(104, actualsPrice, delta);
    }

    @Test
    public void checkGetReceipt() {
        burger.setBuns(bun);
        Mockito.when(burger.bun.getName()).thenReturn("White bun");
        Mockito.when(sauce.getType()).thenReturn(SAUCE);
        Mockito.when(filling.getType()).thenReturn(FILLING);
        Mockito.when(sauce.getName()).thenReturn("cheesy");
        Mockito.when(filling.getName()).thenReturn("cucumber");
        Mockito.when(sauce.getPrice()).thenReturn(2.5F);
        Mockito.when(filling.getPrice()).thenReturn(1.5F);
        burger.addIngredient(filling);
        burger.addIngredient(sauce);
        String sumIngredient = String.format("%f", sauce.getPrice() + filling.getPrice());
        String actualReceipt = burger.getReceipt();
        String exeptionReceipt = String.format("(==== %s ====)%n" +
                        "= %s %s =%n" +
                        "= %s %s =%n" +
                        "(==== %s ====)%n" +
                        "%n" +
                        "Price: %s%n", burger.bun.getName(), filling.getType().toString().toLowerCase(),
                filling.getName(), sauce.getType().toString().toLowerCase(), sauce.getName(), burger.bun.getName(), sumIngredient);
//        System.out.println(actualReceipt);
        assertEquals(exeptionReceipt, actualReceipt);
    }
}