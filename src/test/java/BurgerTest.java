import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import praktikum.*;

@RunWith(MockitoJUnitRunner.class)

public class BurgerTest {

    Burger burger = new Burger();

    @Mock
    Bun bun;
    @Mock
    Ingredient ingredient;

    @Test
    public void getPriceTest() {
        Mockito.when(bun.getPrice()).thenReturn(200F);
        Mockito.when(ingredient.getPrice()).thenReturn(100F);

        burger.addIngredient(ingredient);
        float actual = bun.getPrice() * 2 + ingredient.getPrice();
        burger.setBuns(bun);
        float priceBurger = burger.getPrice();
        Assert.assertEquals("Стоимость расчитана не верно", priceBurger, actual, 0);
    }

    @Test
    public void getReceiptTest() {
        Mockito.when(bun.getName()).thenReturn("white bun");
        Mockito.when(bun.getPrice()).thenReturn(200F);
        Mockito.when(ingredient.getType()).thenReturn(IngredientType.SAUCE);
        Mockito.when(ingredient.getName()).thenReturn("hot sauce");
        Mockito.when(ingredient.getPrice()).thenReturn(100F);

        burger.setBuns(bun);
        burger.addIngredient(ingredient);
        String receiptExpected = "(==== white bun ====)\n" +
                "= sauce hot sauce =\n" +
                "(==== white bun ====)\n" +
                "\n" +
                "Price: 500,000000\n";
        String receiptActual = burger.getReceipt();
        Assert.assertEquals("Чек сформирован не верно", receiptActual, receiptExpected);
    }
}

