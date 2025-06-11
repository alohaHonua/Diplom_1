package praktikum;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.Assert.assertEquals;
import static praktikum.IngredientType.SAUCE;

@RunWith(MockitoJUnitRunner.class)
public class BurgerTest {
    Burger burger = new Burger();

    @Mock
    Bun bun;
    @Mock
    Ingredient ingredient1;
    Ingredient ingredient2;

    @Test
    public void testSetBuns() {
        burger.setBuns(bun);
        assertEquals("ошибка установки булки", bun, burger.bun);
    }

    @Test
    public void testAddAndCheckIngredient() {
        burger.addIngredient(ingredient1);
        assertEquals(1, burger.ingredients.size());
        assertEquals(ingredient1, burger.ingredients.get(0));
    }

    @Test
    public void testRemoveOneofTwoIngredient() {
        burger.addIngredient(ingredient1);
        burger.addIngredient(ingredient2);
        burger.removeIngredient(0);
        assertEquals(1, burger.ingredients.size());
        assertEquals(ingredient2, burger.ingredients.get(0));
    }

    @Test
    public void moveIngredient() {
        burger.addIngredient(ingredient1);
        burger.addIngredient(ingredient2);
        burger.moveIngredient(0, 1);
        assertEquals(ingredient1, burger.ingredients.get(1));
    }

    @Test
    public void testGetPriceBurger() {
        Mockito.when(bun.getPrice()).thenReturn(2F);
        Mockito.when(ingredient1.getPrice()).thenReturn(3F);
        burger.setBuns(bun);
        burger.addIngredient(ingredient1);
        float expected = 2F * 2 + 3F;
        Assert.assertEquals(expected, burger.getPrice(), 0.0001f);
    }

}