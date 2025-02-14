import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import praktikum.Burger;
import praktikum.Ingredient;

import static praktikum.IngredientType.*;

@RunWith(MockitoJUnitRunner.class)
public class MockTest {

    @Mock
    Burger burger;

    @Test
    public void checkAddIngridient() {
        Ingredient cheeseSauce = new Ingredient(SAUCE, "cheesy", 2.5F);
        burger.addIngredient(cheeseSauce);
        Mockito.verify(burger, Mockito.times(1)).addIngredient(cheeseSauce);
    }

    @Test
    public void checkRemoveIngredient() {
        Ingredient cucumberFilling = new Ingredient(FILLING, "cucumber", 1.5F);
        burger.addIngredient(cucumberFilling);
        burger.removeIngredient(0);
        Mockito.verify(burger, Mockito.times(1)).removeIngredient(0);
    }

    @Test
    public void checkMoveIngredient() {
        Ingredient cheeseSauce = new Ingredient(SAUCE, "cheesy", 2.5F);
        burger.addIngredient(cheeseSauce);
        burger.moveIngredient(1, 0);
        Mockito.verify(burger).moveIngredient(1, 0);
    }
}
