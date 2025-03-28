package praktikum;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class BurgerTests {

    private Burger burger;

    @Mock
    private Bun bun;

    @Mock
    private Ingredient testIngredient_1;

    @Mock
    private Ingredient testIngredient_2;


    @Before
    public void setUp() {
        burger = new Burger();
        burger.setBuns(bun);
    }

    @Test
    public void setBunsTest() {
        when(bun.getPrice()).thenReturn(100.00f);
        assertEquals(200.00f, burger.getPrice(), 0.0);
    }

    @Test
    public void addIngredientTest() {
        burger.addIngredient(testIngredient_1);
        burger.addIngredient(testIngredient_2);
        Assert.assertEquals(2, burger.ingredients.size());
    }

    @Test
    public void removeIngredientTest() {
        burger.addIngredient(testIngredient_1);
        burger.addIngredient(testIngredient_2);
        burger.removeIngredient(0);
        Assert.assertEquals(1, burger.ingredients.size());
    }

    @Test
    public void moveIngredientTest() {
        burger.addIngredient(testIngredient_1);
        burger.addIngredient(testIngredient_2);
        burger.moveIngredient(0, 1);

        Assert.assertEquals(testIngredient_1, burger.ingredients.get(1));
        Assert.assertEquals(testIngredient_2, burger.ingredients.get(0));
    }

    @Test
    public void getPriceTest() {
        when(bun.getPrice()).thenReturn(100.00f);
        when(testIngredient_1.getPrice()).thenReturn(50.00f);
        when(testIngredient_2.getPrice()).thenReturn(30.00f);

        burger.addIngredient(testIngredient_1);
        burger.addIngredient(testIngredient_2);

        float expectedPrice = bun.getPrice() * 2 + testIngredient_1.getPrice() + testIngredient_2.getPrice();
        assertEquals(expectedPrice, burger.getPrice(), 0.0);
    }

    @Test
    public void getReceiptTest() {
        when(bun.getName()).thenReturn("Name_1");
        Mockito.when(bun.getPrice()).thenReturn(100.00f);

        Mockito.when(testIngredient_1.getType()).thenReturn(IngredientType.FILLING);
        Mockito.when(testIngredient_1.getName()).thenReturn("Name_testIngredient_1");
        Mockito.when(testIngredient_1.getPrice()).thenReturn(50.00f);

        burger.addIngredient(testIngredient_1);
        burger.getPrice();

        String actualReceipt = burger.getReceipt();

        Assert.assertTrue(actualReceipt.contains("(==== Name_1 ====)"));
        Assert.assertTrue(actualReceipt.contains("= filling Name_testIngredient_1 ="));
        Assert.assertTrue(actualReceipt.contains("Price: 250,000000"));
    }
}

