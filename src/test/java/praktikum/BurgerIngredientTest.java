package praktikum;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.mockito.Spy;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.Assert.assertEquals;
import static praktikum.enums.Ingredients.FILLING_BEEF;
import static praktikum.enums.Ingredients.SAUCE_SPACE;

@RunWith(MockitoJUnitRunner.class)
public class BurgerIngredientTest {
    @Spy
    Burger burger = new Burger();
    Ingredient ingredient0 = new Ingredient(IngredientType.FILLING, SAUCE_SPACE.getName(), SAUCE_SPACE.getPrice());
    Ingredient ingredient1 = new Ingredient(IngredientType.SAUCE, FILLING_BEEF.getName(), FILLING_BEEF.getPrice());

    @Test
    public void addIngredientTest() {
        burger.addIngredient(ingredient0);
        burger.addIngredient(ingredient1);
        Mockito.verify(burger, Mockito.times(1)).addIngredient(ingredient0);
        Mockito.verify(burger, Mockito.times(1)).addIngredient(ingredient1);
    }

    @Test
    public void removeIngredient() {
        addIngredientTest();
        burger.removeIngredient(0);
        burger.removeIngredient(0);
        Mockito.verify(burger, Mockito.times(2)).removeIngredient(0);
    }

    @Test
    public void moveIngredient() {
        addIngredientTest();
        burger.moveIngredient(1, 0);
        assertEquals("Ошибка в перемещении ингредиентов", ingredient0, burger.ingredients.get(1));
        assertEquals("Ошибка в перемещении ингредиентов", ingredient1, burger.ingredients.get(0));
    }
}
