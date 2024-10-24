package praktikum;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;

import static org.mockito.Mockito.mock;

@RunWith(MockitoJUnitRunner.class)
public class BurgerTest {

    @Mock
    Bun bun;

    @Mock
    Ingredient ingredient1;

    @Mock
    Ingredient ingredient2;

    @Before
    public void init() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void setBunsTest() {
        Burger burger = new Burger();
        bun = mock(Bun.class);

        burger.setBuns(bun);

        Assert.assertEquals(bun, burger.bun);
    }

    @Test
    public void addIngredientTest() {
        Burger burger = new Burger();
        ingredient1 = mock(Ingredient.class);

        burger.addIngredient(ingredient1);

        Assert.assertEquals(ingredient1, burger.ingredients.get(0));
    }

    @Test
    public void removeIngredientTest() {

        Burger burger = new Burger();
        ingredient1 = mock(Ingredient.class);

        burger.addIngredient(ingredient1);
        burger.removeIngredient(0);

        Assert.assertEquals(0, burger.ingredients.size());
    }

    @Test
    public void moveIngredientTest() {

        Burger burger = new Burger();
        ingredient1 = mock(Ingredient.class);
        ingredient2 = mock(Ingredient.class);

        burger.addIngredient(ingredient1);
        burger.addIngredient(ingredient2);
        burger.moveIngredient(1, 0);

        Assert.assertEquals(ingredient2, burger.ingredients.get(0));
    }

    @Test
    public void getPriceTest() {
        Burger burger = new Burger();
        bun = mock(Bun.class);
        ingredient1 = mock(Ingredient.class);

        Mockito.when(bun.getPrice()).thenReturn(10.00F);
        Mockito.when(ingredient1.getPrice()).thenReturn(5.00F);

        burger.bun = bun;
        burger.ingredients.add(ingredient1);

        Assert.assertEquals(25.00F, burger.getPrice(), 0.0F);
    }

    @Test
    public void getReceiptTest() {
        Burger burger = new Burger();
        bun = mock(Bun.class);
        ingredient1 = mock(Ingredient.class);

        Mockito.when(bun.getName()).thenReturn("Тестовая булочка");
        Mockito.when(bun.getPrice()).thenReturn(10.00F);

        Mockito.when(ingredient1.getType()).thenReturn(IngredientType.FILLING);
        Mockito.when(ingredient1.getName()).thenReturn("Тестовый бургер");
        Mockito.when(ingredient1.getPrice()).thenReturn(5.00F);

        burger.bun = bun;
        burger.ingredients.add(ingredient1);

        StringBuilder testReceipt = new StringBuilder("(==== Тестовая булочка ====)\r\n");
        testReceipt.append("= filling Тестовый бургер =\r\n");
        testReceipt.append("(==== Тестовая булочка ====)\r\n");
        testReceipt.append("\r\nPrice: 25,000000\r\n");

        Assert.assertEquals(testReceipt.toString(), burger.getReceipt());
    }
}