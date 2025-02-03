package praktikum;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

public class BurgerTest {

    private Burger burger;
    private Bun mockBun;
    private Ingredient mockIngredient1;
    private Ingredient mockIngredient2;

    @Before
    public void setUp() {
        burger = new Burger();
        mockBun = Mockito.mock(Bun.class);
        mockIngredient1 = Mockito.mock(Ingredient.class);
        mockIngredient2 = Mockito.mock(Ingredient.class);
    }

    @Test
    public void testSetBuns() {
        // Arrange
        when(mockBun.getName()).thenReturn("Sesame Bun");
        when(mockBun.getPrice()).thenReturn(1.99f);

        // Act
        burger.setBuns(mockBun);

        // Assert
        assertEquals(mockBun, burger.bun);
    }

    @Test
    public void testAddIngredient() {
        // Arrange
        when(mockIngredient1.getName()).thenReturn("Lettuce");
        when(mockIngredient1.getPrice()).thenReturn(0.50f);

        // Act
        burger.addIngredient(mockIngredient1);

        // Assert
        assertEquals(1, burger.ingredients.size());
        assertEquals(mockIngredient1, burger.ingredients.get(0));
    }

    @Test
    public void testRemoveIngredient() {
        // Arrange
        when(mockIngredient1.getName()).thenReturn("Lettuce");
        when(mockIngredient1.getPrice()).thenReturn(0.50f);
        burger.addIngredient(mockIngredient1);
        burger.addIngredient(mockIngredient2); // добавим второй ингредиент

        // Act
        burger.removeIngredient(0);

        // Assert
        assertEquals(1, burger.ingredients.size());
        assertEquals(mockIngredient2, burger.ingredients.get(0));
    }

    @Test
    public void testMoveIngredient() {
        // Arrange
        when(mockIngredient1.getName()).thenReturn("Lettuce");
        when(mockIngredient1.getPrice()).thenReturn(0.50f);
        when(mockIngredient2.getName()).thenReturn("Tomato");
        when(mockIngredient2.getPrice()).thenReturn(0.75f);
        burger.addIngredient(mockIngredient1);
        burger.addIngredient(mockIngredient2);

        // Act
        burger.moveIngredient(0, 1); // переместим Lettuce на вторую позицию

        // Assert
        assertEquals(mockIngredient2, burger.ingredients.get(0));
        assertEquals(mockIngredient1, burger.ingredients.get(1));
    }

    @Test
    public void testGetPrice() {
        // Arrange
        when(mockBun.getPrice()).thenReturn(1.99f);
        when(mockIngredient1.getPrice()).thenReturn(0.50f);
        when(mockIngredient2.getPrice()).thenReturn(0.75f);
        burger.setBuns(mockBun);
        burger.addIngredient(mockIngredient1);
        burger.addIngredient(mockIngredient2);

        // Act
        float price = burger.getPrice();

        // Assert
        assertEquals(1.99f * 2 + 0.50f + 0.75f, price, 0.001);
    }

    @Test
    public void testGetReceipt() {

        when(mockBun.getName()).thenReturn("Sesame Bun");
        when(mockIngredient1.getName()).thenReturn("Lettuce");
        when(mockIngredient1.getType()).thenReturn(IngredientType.FILLING);
        burger.setBuns(mockBun);
        burger.addIngredient(mockIngredient1);

        String receipt = burger.getReceipt();

        StringBuilder expectedReceipt = new StringBuilder(String.format("(==== %s ====)%n", mockBun.getName()));

        expectedReceipt.append(String.format("= %s %s =%n", mockIngredient1.getType().toString().toLowerCase(),
                mockIngredient1.getName()));
        expectedReceipt.append(String.format("(==== %s ====)%n", mockBun.getName()));
        expectedReceipt.append(String.format("%nPrice: %f%n", burger.getPrice()));

        assertEquals("Не соответствует чек с информацией о бургере",expectedReceipt.toString(),burger.getReceipt());
    }
}