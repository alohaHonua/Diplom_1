import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import praktikum.Bun;
import praktikum.Burger;
import praktikum.Ingredient;

@RunWith(MockitoJUnitRunner.class)
public class BurgerTest {
    @Mock
    Burger burger;
    Bun bun;
    Ingredient ingredient;

    @Test
    public void setBunsTest() {
        burger.setBuns(bun);
        Mockito.verify(burger, Mockito.times(1)).setBuns(bun);
    }

    @Test
    public void addIngredientTest() {
        burger.addIngredient(ingredient);
        Mockito.verify(burger, Mockito.times(1)).addIngredient(ingredient);
    }

    @Test
    public void removeIngredientTest() {
        burger.removeIngredient(1);
        Mockito.verify(burger, Mockito.times(1)).removeIngredient(1);
    }

    @Test
    public void moveIngredientTest() {
        burger.moveIngredient(1,2);
        Mockito.verify(burger, Mockito.times(1)).moveIngredient(1, 2);
    }

    @Test
    public void getPriceTest() {
        burger.getPrice();
        Mockito.verify(burger, Mockito.times(1)).getPrice();
    }
    @Test
    public void getReceiptTest() {
        burger.getReceipt();
        Mockito.verify(burger, Mockito.times(1)).getReceipt();
    }

}
