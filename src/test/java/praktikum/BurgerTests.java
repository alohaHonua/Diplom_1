package praktikum;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.Spy;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class BurgerTests {
    @Spy
    private Burger newBurger;
    @Mock
    private Bun bun;
    @Mock
    private Ingredient ingredient;
    @Test
    public void setBunsTest() {
        newBurger.setBuns(bun);
        Mockito.verify(newBurger, Mockito.times(1)).setBuns(bun);
    }
    @Test
    public void addIngredientTest() {
        int ingredientsSize = 1;
        newBurger.addIngredient(ingredient);
        int result = newBurger.ingredients.size();
        Mockito.verify(newBurger, Mockito.times(1)).addIngredient(ingredient);
        Assert.assertEquals(ingredientsSize, result);
    }
    @Test
    public void removeIngredientTest() {
        int ingredientsSize = 1;
        newBurger.addIngredient(ingredient);
        newBurger.addIngredient(ingredient);
        newBurger.removeIngredient(1);
        int result = newBurger.ingredients.size();
        Mockito.verify(newBurger, Mockito.times(1)).removeIngredient(1);
        Assert.assertEquals(ingredientsSize, result);
    }
    @Test
    public void moveIngredientTest() {
        newBurger.addIngredient(ingredient);
        newBurger.addIngredient(ingredient);
        newBurger.moveIngredient(1, 0);
        Mockito.verify(newBurger, Mockito.times(1)).moveIngredient(1, 0);
    }
}
