import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import praktikum.Bun;
import praktikum.Burger;
import praktikum.Ingredient;
import praktikum.IngredientType;

import static org.junit.Assert.*;

@RunWith(MockitoJUnitRunner.class)
public class BurgerTest {
    @Mock
    private Bun bunMock;
    @Mock
    private Ingredient firstIngredientMock;
    @Mock
    private Ingredient secondIngredientMock;

    Burger burger = new Burger();

    @Test
    public void setBunTest() {
        burger.setBuns(bunMock);
        assertEquals(bunMock, burger.bun);
    }

    @Test
    public void addIngredientTest() {
        burger.addIngredient(firstIngredientMock);
        burger.addIngredient(secondIngredientMock);
        assertEquals(2, burger.ingredients.size());
    }

    @Test
    public void removeIngredientTest() {
        burger.addIngredient(firstIngredientMock);
        burger.addIngredient(secondIngredientMock);
        burger.removeIngredient(1);
        assertEquals(1, burger.ingredients.size());
        assertFalse(burger.ingredients.contains(secondIngredientMock));
        assertTrue(burger.ingredients.contains(firstIngredientMock));
    }

    @Test
    public void moveIngredientTest() {
        burger.addIngredient(firstIngredientMock);
        burger.addIngredient(secondIngredientMock);
        burger.moveIngredient(1,0);
        assertEquals(2, burger.ingredients.size());
        assertEquals(secondIngredientMock, burger.ingredients.get(0));
        assertEquals(firstIngredientMock, burger.ingredients.get(1));
    }

    @Test
    public void getRecieptTest() {
        burger.addIngredient(firstIngredientMock);
        burger.addIngredient(secondIngredientMock);
        burger.bun = bunMock;

        Mockito.when(bunMock.getName()).thenReturn("black bun");
        Mockito.when(firstIngredientMock.getType()).thenReturn(IngredientType.SAUCE);
        Mockito.when(secondIngredientMock.getType()).thenReturn(IngredientType.FILLING);
        Mockito.when(firstIngredientMock.getName()).thenReturn("chili sauce");
        Mockito.when(secondIngredientMock.getName()).thenReturn("cutlet");
        Mockito.when(bunMock.getPrice()).thenReturn(10f);
        Mockito.when(firstIngredientMock.getPrice()).thenReturn(5f);
        Mockito.when(secondIngredientMock.getPrice()).thenReturn(5f);

        String expectedReceipt =
                String.format("(==== black bun ====)%n") +
                        String.format("= sauce chili sauce =%n") +
                        String.format("= filling cutlet =%n") +
                        String.format("(==== black bun ====)%n") +
                        String.format("%nPrice: %f%n", 30f);
        assertEquals(expectedReceipt, burger.getReceipt());
    }
}
