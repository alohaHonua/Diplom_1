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
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class BurgerTest {

    @Mock
    private Bun bunMock;

    @Mock
    private Ingredient ingredientMock1;

    @Mock
    private Ingredient ingredientMock2;

    private Burger burger;

    @Before
    public void setUp() {
        burger = new Burger();

        // Мокаем методы булочки и ингредиентов
        when(bunMock.getPrice()).thenReturn(100.0f);
        when(bunMock.getName()).thenReturn("black bun");
        when(ingredientMock1.getPrice()).thenReturn(50.0f);
        when(ingredientMock1.getName()).thenReturn("hot sauce");
        when(ingredientMock1.getType()).thenReturn(IngredientType.SAUCE);
        when(ingredientMock2.getPrice()).thenReturn(200.0f);
        when(ingredientMock2.getName()).thenReturn("sausage");
        when(ingredientMock2.getType()).thenReturn(IngredientType.FILLING);
    }

    @Test
    public void setBunsSetsTheBunCorrectly() {
        burger.setBuns(bunMock);
        assertEquals(bunMock, burger.bun);
    }

    @Test
    public void addIngredientAddsIngredientCorrectly() {
        burger.addIngredient(ingredientMock1);
        assertEquals(1, burger.ingredients.size());
        assertEquals(ingredientMock1, burger.ingredients.get(0));
    }

    @Test
    public void removeIngredientRemovesIngredientCorrectly() {
        burger.addIngredient(ingredientMock1);
        burger.removeIngredient(0);
        assertTrue(burger.ingredients.isEmpty());
    }

    @Test
    public void moveIngredientMovesIngredientCorrectly() {
        burger.addIngredient(ingredientMock1);
        burger.addIngredient(ingredientMock2);
        burger.moveIngredient(0, 1);
        assertEquals(ingredientMock1, burger.ingredients.get(1));
        assertEquals(ingredientMock2, burger.ingredients.get(0));
    }

    @Test
    public void getPriceReturnsCorrectTotalPrice() {
        burger.setBuns(bunMock);
        burger.addIngredient(ingredientMock1);
        burger.addIngredient(ingredientMock2);
        assertEquals(450.0f, burger.getPrice(), 0.0f);
    }

    @Test
    public void getReceiptReturnsCorrectReceipt() {
        burger.setBuns(bunMock);
        burger.addIngredient(ingredientMock1);
        burger.addIngredient(ingredientMock2);

        String expectedReceipt = "(==== black bun ====)\n= sauce hot sauce =\n= filling sausage =\n(==== black bun ====)\n\nPrice: 450.000000\n";
        assertEquals(expectedReceipt, burger.getReceipt());
    }
}
