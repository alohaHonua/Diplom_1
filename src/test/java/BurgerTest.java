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
    private Bun mockBun;

    @Mock
    private Ingredient ingredientMeatMock;
    @Mock
    private Ingredient ingredientLettuceMock;
    @Mock
    private Ingredient ingredientKetchupMock;

    private Burger burger;

    @Before
    public void setUp() {
        burger = new Burger();


    }

    @Test
    public void setBunsTest() {
        burger.setBuns(mockBun);
        assertEquals(mockBun, burger.bun);
    }

    @Test
    public void addOneIngredientTest() {
        burger.addIngredient(ingredientMeatMock);
        assertTrue("Добавление ингредиента", burger.ingredients.contains(ingredientMeatMock));
    }

    @Test
    public void addIngredientCheckSizeTest() {
        burger.addIngredient(ingredientMeatMock);
        assertEquals("Добавление 1 ингредиента", 1, burger.ingredients.size());
    }

    @Test
    public void removeLastIngredientTest() {
        burger.addIngredient(ingredientMeatMock);
        burger.addIngredient(ingredientLettuceMock);
        int listSize = burger.ingredients.size();
        burger.removeIngredient(listSize  - 1);
        assertEquals("Удаление последнего ингредиента", listSize - 1, burger.ingredients.size());
    }

    @Test
    public void moveIngredientTest() {
        burger.addIngredient(ingredientMeatMock);
        burger.addIngredient(ingredientLettuceMock);
        burger.addIngredient(ingredientKetchupMock);
        burger.moveIngredient(0, 2);
        assertEquals(ingredientMeatMock, burger.ingredients.get(2));
        assertEquals(ingredientKetchupMock, burger.ingredients.get(1));
    }

    @Test
    public void getPriceTest() {
        when(mockBun.getPrice()).thenReturn(1.0f);
        when(ingredientMeatMock.getPrice()).thenReturn(2.0f);
        when(ingredientLettuceMock.getPrice()).thenReturn(3.0f);
        when(ingredientKetchupMock.getPrice()).thenReturn(4.0f);

        burger.setBuns(mockBun);
        burger.addIngredient(ingredientMeatMock);
        burger.addIngredient(ingredientLettuceMock);
        burger.addIngredient(ingredientKetchupMock);

        float expectedPrice = 1.0f * 2 + 2.0f + 3.0f + 4.0f;

        assertEquals("Общая стоимость", expectedPrice, burger.getPrice(), Constants.DELTA);

    }

    @Test
    public void getReceiptTest() {
        when(mockBun.getName()).thenReturn("Cosmic bun");
        when(mockBun.getPrice()).thenReturn(1.0f);

        when(ingredientMeatMock.getName()).thenReturn("Chicken");
        when(ingredientMeatMock.getType()).thenReturn(IngredientType.FILLING);
        when(ingredientMeatMock.getPrice()).thenReturn(2.0f);

        when(ingredientLettuceMock.getName()).thenReturn("Lettuce");
        when(ingredientLettuceMock.getType()).thenReturn(IngredientType.SAUCE);
        when(ingredientLettuceMock.getPrice()).thenReturn(3.0f);

        burger.setBuns(mockBun);
        burger.addIngredient(ingredientMeatMock);
        burger.addIngredient(ingredientLettuceMock);

        String expectedReceipt = "(==== Cosmic bun ====)\r\n" +
                "= filling Chicken =\r\n" +
                "= sauce Lettuce =\r\n" +
                "(==== Cosmic bun ====)\r\n" +
                "\r\nPrice: 7,000000\r\n";

        assertEquals("Чек", expectedReceipt, burger.getReceipt());
    }


}


