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
    Ingredient ingredientInd0;

    @Mock
    Ingredient ingredientInd1;

    @Test
    public void getPriceTest() {
        Mockito.when(bun.getPrice()).thenReturn(200F);
        Mockito.when(ingredientInd0.getPrice()).thenReturn(100F);

        burger.addIngredient(ingredientInd0);
        float actual = bun.getPrice() * 2 + ingredientInd0.getPrice();
        burger.setBuns(bun);
        float priceBurger = burger.getPrice();
        Assert.assertEquals("Стоимость расчитана не верно", priceBurger, actual, 0);
    }

    @Test
    public void getReceiptTest() {
        Mockito.when(bun.getName()).thenReturn("white bun");
        Mockito.when(bun.getPrice()).thenReturn(200F);
        Mockito.when(ingredientInd0.getType()).thenReturn(IngredientType.SAUCE);
        Mockito.when(ingredientInd0.getName()).thenReturn("hot sauce");
        Mockito.when(ingredientInd0.getPrice()).thenReturn(100F);

        burger.setBuns(bun);
        burger.addIngredient(ingredientInd0);
        String receiptExpected = "(==== white bun ====)\n" +
                "= sauce hot sauce =\n" +
                "(==== white bun ====)\n" +
                "\n" +
                "Price: 500,000000\n";
        String receiptActual = burger.getReceipt();
        Assert.assertEquals("Чек сформирован не верно", receiptActual, receiptExpected);
    }

    @Test
    public void addIngredientTest() {
        burger.addIngredient(ingredientInd0);
        Assert.assertTrue("Ингредиент не добавлен", burger.ingredients.contains(ingredientInd0));
    }

    @Test
    public void removeIngredientTest() {
        burger.addIngredient(ingredientInd0);
        burger.removeIngredient(0);
        Assert.assertFalse("Ингредиент не удален", burger.ingredients.contains(ingredientInd0));
    }

    @Test
    public void moveIngredientTest() {
        burger.addIngredient(ingredientInd0);
        burger.addIngredient(ingredientInd1);
        burger.moveIngredient(0, 1);
        Assert.assertEquals("Ингредиент не перемещен", ingredientInd1, burger.ingredients.get(0));
    }
}

