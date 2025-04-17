package praktikum;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

public class BurgerTest {

    private Burger burger;
    private Bun mockBun;
    private Ingredient mockIngredient1;
    private Ingredient mockIngredient2;

    @Before
    public void setUp() {
        burger = new Burger();

        mockBun = Mockito.mock(Bun.class);
        Mockito.when(mockBun.getName()).thenReturn("Mock Bun");
        Mockito.when(mockBun.getPrice()).thenReturn(100.0f);

        mockIngredient1 = Mockito.mock(Ingredient.class);
        Mockito.when(mockIngredient1.getName()).thenReturn("Mock Sauce");
        Mockito.when(mockIngredient1.getPrice()).thenReturn(50.0f);
        Mockito.when(mockIngredient1.getType()).thenReturn(IngredientType.SAUCE);

        mockIngredient2 = Mockito.mock(Ingredient.class);
        Mockito.when(mockIngredient2.getName()).thenReturn("Mock Fill");
        Mockito.when(mockIngredient2.getPrice()).thenReturn(80.0f);
        Mockito.when(mockIngredient2.getType()).thenReturn(IngredientType.FILLING);
    }

    @Test
    public void testSetBun() {
        burger.setBuns(mockBun);
        Assert.assertEquals("Булка неправильная","Mock Bun", burger.bun.getName());
    }

    @Test
    public void testAddIngredient() {
        burger.addIngredient(mockIngredient1);
        Assert.assertEquals("Ингредиент не добавлен",1, burger.ingredients.size());
    }

    @Test
    public void testRemoveIngredient() {
        burger.addIngredient(mockIngredient1);
        burger.removeIngredient(0);
        Assert.assertTrue("Ингредиент не удалён", burger.ingredients.isEmpty());
    }

    @Test
    public void testMoveIngredient() {
        burger.addIngredient(mockIngredient1);
        burger.addIngredient(mockIngredient2);
        burger.moveIngredient(0, 1);
        Assert.assertEquals("Ингредиент не перемещён", mockIngredient1, burger.ingredients.get(1));
    }

    @Test
    public void testGetPrice() {
        burger.setBuns(mockBun);
        burger.addIngredient(mockIngredient1);
        burger.addIngredient(mockIngredient2);
        float expected = 100.0f * 2 + 50.0f + 80.0f;
        Assert.assertEquals("Цена бургера рассчитана неверно", expected, burger.getPrice(), 0.001f);
    }

    @Test
    public void testReceiptContainsBunName() {
        burger.setBuns(mockBun);
        burger.addIngredient(mockIngredient1);
        String receipt = burger.getReceipt();

        Assert.assertTrue("Чек не содержит имя булки", receipt.contains("Mock Bun"));
    }

    @Test
    public void testReceiptContainsIngredient() {
        burger.setBuns(mockBun);
        burger.addIngredient(mockIngredient1);
        String receipt = burger.getReceipt();

        Assert.assertTrue("Чек не содержит ингредиент", receipt.contains("Mock Sauce"));
    }

    @Test
    public void testReceiptContainsPrice() {
        burger.setBuns(mockBun);
        burger.addIngredient(mockIngredient1);
        String receipt = burger.getReceipt();

        Assert.assertTrue("Чек не содержит цену", receipt.contains("Price:"));
    }
}
