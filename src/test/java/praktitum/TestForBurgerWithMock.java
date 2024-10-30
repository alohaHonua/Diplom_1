package praktitum;

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
public class TestForBurgerWithMock {

    private Burger burger;

    @Mock
    private Bun mockForBun;

    @Mock
    private Ingredient mockForIngredient1;// filling

    @Mock
    private Ingredient mockForIngredient2;// sauce

    @Before
    public void setUp(){

        burger = new Burger();

        when(mockForBun.getName()).thenReturn("Mocked Bun");
        when(mockForBun.getPrice()).thenReturn(100f);

        when(mockForIngredient1.getName()).thenReturn("Mocked Ingredient 1");
        when(mockForIngredient1.getPrice()).thenReturn(200f);
        when(mockForIngredient1.getType()).thenReturn(IngredientType.FILLING);

        when(mockForIngredient2.getName()).thenReturn("Mocked Ingredient 2");
        when(mockForIngredient2.getPrice()).thenReturn(300f);
        when(mockForIngredient2.getType()).thenReturn(IngredientType.SAUCE);
    }

    @Test
    public void testForSetBunsMethod(){
        burger.setBuns(mockForBun);
        assertEquals(mockForBun, burger.bun);
    }

    @Test
    public void testForAddIngredientMethod(){
        burger.addIngredient(mockForIngredient1);
        assertEquals(1, burger.ingredients.size());
        assertEquals(mockForIngredient1, burger.ingredients.get(0));
    }

    @Test
    public void testForRemoveIngredientMethod(){
        burger.addIngredient(mockForIngredient1);
        burger.addIngredient(mockForIngredient2);
        burger.removeIngredient(0);
        assertEquals(1, burger.ingredients.size());
        assertEquals(mockForIngredient2, burger.ingredients.get(0));
    }

    @Test
    public void testForMoveIngredientMethod(){
        burger.addIngredient(mockForIngredient1);
        burger.addIngredient(mockForIngredient2);
        burger.moveIngredient(0, 1);
        assertEquals(mockForIngredient2, burger.ingredients.get(0));
        assertEquals(mockForIngredient1, burger.ingredients.get(1));
    }

    @Test
    public void testForGetPriceMethod(){

        float expectedPrice = (mockForBun.getPrice() * 2) +
                mockForIngredient1.getPrice() +
                mockForIngredient2.getPrice();

        burger.setBuns(mockForBun);
        burger.addIngredient(mockForIngredient1);
        burger.addIngredient(mockForIngredient2);
        assertEquals(expectedPrice, burger.getPrice(), 0);
    }

    @Test
    public void testForGetReceiptMethod(){

        String expectedReceipt = "(==== Mocked Bun ====)" + System.lineSeparator() +
            "= filling Mocked Ingredient 1 =" + System.lineSeparator() +
            "= sauce Mocked Ingredient 2 =" + System.lineSeparator() +
            "(==== Mocked Bun ====)" + System.lineSeparator() +
            System.lineSeparator() +
            "Price: 700,000000" + System.lineSeparator();

        burger.setBuns(mockForBun);
        burger.addIngredient(mockForIngredient1);
        burger.addIngredient(mockForIngredient2);
        assertEquals(expectedReceipt, burger.getReceipt());
    }
}
