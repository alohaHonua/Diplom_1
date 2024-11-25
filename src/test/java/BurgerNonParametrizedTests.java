import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import praktikum.Bun;
import praktikum.Burger;
import praktikum.Ingredient;

@RunWith(MockitoJUnitRunner.class)
public class BurgerNonParametrizedTests {

    @Mock
    private Burger burger;
    @Mock
    private Bun bun;
    @Mock
    private Ingredient ingredient;

    @Test
    public void setBunSetsBunOnce() {
        burger.setBuns(bun);
        Mockito.verify(burger, Mockito.times(1)).setBuns(bun);
    }

    @Test
    public void addIngredientAddsIngredientOnce() {
        burger.addIngredient(ingredient);
        Mockito.verify(burger, Mockito.times(1)).addIngredient(ingredient);
    }

    @Test
    public void removeIngredientRemovesIngredientOnce() {
        final int INDEX = 0;
        burger.removeIngredient(INDEX);
        Mockito.verify(burger, Mockito.times(1)).removeIngredient(INDEX);
    }

    @Test
    public void moveIngredientMovesIngredientOnce() {
        final int INDEX = 1;
        final int NEW_INDEX = 0;
        burger.moveIngredient(INDEX, NEW_INDEX);
        Mockito.verify(burger, Mockito.times(1)).moveIngredient(INDEX, NEW_INDEX);
    }

    @Test
    public void getPriceCalculatesOnce() {
        burger.getPrice();
        Mockito.verify(burger, Mockito.times(1)).getPrice();
    }
}
