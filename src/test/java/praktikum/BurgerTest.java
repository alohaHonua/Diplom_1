package praktikum;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.Assert.assertEquals;

@RunWith(MockitoJUnitRunner.class)
public class BurgerTest {
    private Burger burger;
    @Mock
    private Bun bun;
    @Mock
    private Ingredient ingredient, ingredientForMoving;

    @Before
    public void createBurger() {
        burger = new Burger();
    }

    @Test
    public void setBunTest(){
        burger.setBuns(bun);
        assertEquals(bun.getName(), burger.bun.getName());
    }

    @Test
    public void addIngredientTest(){
        int expectedBurgerIngredientsSize = 1;
        burger.addIngredient(ingredient);

        assertEquals(expectedBurgerIngredientsSize, burger.ingredients.size());
    }

    @Test
    public void removeIngredientTest() {
        burger.addIngredient(ingredient);
        burger.removeIngredient(0);
        int expectedBurgerIngredientsSize = 0;

        assertEquals(expectedBurgerIngredientsSize, burger.ingredients.size());
    }

    @Test
    public void moveIngredientTest(){
        Burger burger = new Burger();
        burger.addIngredient(ingredient);
        burger.addIngredient(ingredientForMoving);
        int currentIndex = burger.ingredients.indexOf(ingredient);
        int newIndex = burger.ingredients.indexOf(ingredientForMoving);

        burger.moveIngredient(currentIndex, newIndex);
    }

    @Test
    public void getPriceTest(){
        burger.setBuns(bun);
        burger.addIngredient(ingredient);
        Mockito.when(bun.getPrice()).thenReturn(100f);
        Mockito.when(ingredient.getPrice()).thenReturn(250f);
        float expectedPrice = 450f;
        assertEquals(expectedPrice, burger.getPrice(),0);
    }

    @Test
    public void getReceiptTest(){
        Mockito.when(bun.getName()).thenReturn("Black bun");
        Mockito.when(bun.getPrice()).thenReturn(80f);
        burger.setBuns(bun);

        Mockito.when(ingredient.getType()).thenReturn(IngredientType.FILLING);
        Mockito.when(ingredient.getName()).thenReturn("cutlet");
        Mockito.when(ingredient.getPrice()).thenReturn(100F);
        burger.addIngredient(ingredient);

        String expected = "(==== Black bun ====)\r\n" +
                "= filling cutlet =\r\n" +
                "(==== Black bun ====)\r\n" +
                "\r\n" +
                "Price: 260,000000\r\n";
        String actual = burger.getReceipt();

        assertEquals(expected,actual);
    }
}
