package praktikum;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class BurgerTest {
    @Mock
    Bun bun;
    @Mock
    Ingredient ingredient;
    @Mock
    Ingredient anotherIngredient;
    @Mock
    Burger burger;

    @Before
    public void start() {
        burger = new Burger();
    }

    @Test // выбор булки
    public void testSetBuns() {
        burger.setBuns(bun);
        Assert.assertEquals(bun, burger.bun);
    }
    @Test
    public void testAddIngredient(){
        burger.addIngredient(ingredient);
        Assert.assertEquals(ingredient, burger.ingredients.get(0));
    }
    @Test
    public void testRemoveIngredient(){
        burger.addIngredient(ingredient);
        burger.removeIngredient(0);
        Assert.assertTrue(burger.ingredients.isEmpty());
    }
    @Test
    public void testMoveIngredient(){
        burger.addIngredient(ingredient);
        burger.addIngredient(anotherIngredient);
        burger.moveIngredient(0,1);
        Assert.assertEquals(1, burger.ingredients.lastIndexOf(ingredient));
    }
    @Test
    public void testGetPrice(){
        burger.setBuns(bun);
        burger.addIngredient(ingredient);
        Mockito.when(bun.getPrice()).thenReturn(988.0f);
        Mockito.when(ingredient.getPrice()).thenReturn(3000.0f);
        Assert.assertEquals(4976.0f, burger.getPrice(), 0);
    }
    @Test
    public void testGetReceipt() {
        burger.setBuns(bun);
        burger.addIngredient(ingredient);
        burger.addIngredient(anotherIngredient);
        Mockito.when(bun.getName()).thenReturn("Флюоресцентная булка R2-D3");
        Mockito.when(bun.getPrice()).thenReturn(988.0f);
        Mockito.when(ingredient.getName()).thenReturn("Соус Spicy-X");
        Mockito.when(ingredient.getPrice()).thenReturn(90.0f);
        Mockito.when(ingredient.getType()).thenReturn(IngredientType.SAUCE);
        Mockito.when(anotherIngredient.getName()).thenReturn("Мясо бессмертных моллюсков Protostomia");
        Mockito.when(anotherIngredient.getPrice()).thenReturn(1337.0f);
        Mockito.when(anotherIngredient.getType()).thenReturn(IngredientType.FILLING);
        String expected = String.format(
                "(==== Флюоресцентная булка R2-D3 ====)%n" +
                        "= sauce Соус Spicy-X =%n" +
                        "= filling Мясо бессмертных моллюсков Protostomia =%n" +
                        "(==== Флюоресцентная булка R2-D3 ====)%n%n" +
                        "Price: 3403,000000%n");
        Assert.assertEquals(expected, burger.getReceipt());
    }
}
