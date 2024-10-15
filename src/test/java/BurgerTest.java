import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import praktikum.Bun;
import praktikum.Burger;
import praktikum.Ingredient;

import java.util.ArrayList;
import java.util.List;

@RunWith(MockitoJUnitRunner.class)

public class BurgerTest {

    @Mock
    Bun bun;
    @Mock
    Ingredient ingredient;
    @Mock
    List<Ingredient> ingredients;

    @Test
    public void setBunTest() {
        Mockito.when(bun.getName()).thenReturn(Credentials.BUN_NAME);
        Mockito.when(bun.getPrice()).thenReturn(Credentials.BUN_PRICE);
        Burger burger = new Burger();
        burger.setBuns(bun);
        Assert.assertEquals(Credentials.BUN_NAME, bun.getName());
        Assert.assertEquals(Credentials.BUN_PRICE, bun.getPrice(), Credentials.DELTA);
        Assert.assertEquals(bun, burger.bun);
    }

    @Test
    public void addIngredientTest() {
        Burger burger = new Burger();
        burger.ingredients = ingredients;
        burger.addIngredient(ingredient);
        Mockito.verify(ingredients, Mockito.times(1)).add(ingredient);
    }

    @Test
    public void removeIngredientTest() {
        Burger burger = new Burger();
        burger.ingredients = ingredients;
        burger.removeIngredient(Credentials.INDEX);
        Mockito.verify(ingredients, Mockito.times(1)).remove(Credentials.INDEX);
    }

    @Test
    public void moveIngredientTest() {
        Burger burger = new Burger();
        burger.ingredients = ingredients;
        burger.moveIngredient(Credentials.INDEX, Credentials.NEW_INDEX);
        Mockito.verify(ingredients, Mockito.times(1))
                .add(Credentials.NEW_INDEX, ingredients.remove(Credentials.INDEX));
    }

    @Test
    public void getPriceTest() {
        Burger burger = new Burger();
        burger.setBuns(bun);
        Mockito.when(bun.getPrice()).thenReturn(Credentials.BUN_PRICE);
        List<Ingredient> ingredients = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            ingredients.add(ingredient);
        }
        burger.ingredients = ingredients;
        Mockito.when(ingredient.getPrice()).thenReturn(Credentials.INGREDIENT_PRICE);
        burger.getPrice();
        Mockito.verify(ingredient, Mockito.times(5)).getPrice();
        Assert.assertEquals(Credentials.TOTAL_PRICE, burger.getPrice(), Credentials.DELTA);

    }

}
