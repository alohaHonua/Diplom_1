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
    private Ingredient ingredient, ingredient2, ingredient3;

    @Before
    public void createBurger() {
        burger = new Burger();
    }

    @Test
    public void setBunsTest(){
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
        burger.addIngredient(ingredient);
        burger.addIngredient(ingredient2);
        burger.addIngredient(ingredient3);
        burger.moveIngredient(0, 1);

        assertEquals(ingredient, burger.ingredients.get(1));
        assertEquals(ingredient2, burger.ingredients.get(0));
    }

    @Test
    public void getPriceTest(){
        burger.setBuns(bun);
        burger.addIngredient(ingredient);
        Mockito.when(bun.getPrice()).thenReturn(100F);
        Mockito.when(ingredient.getPrice()).thenReturn(100F);
        float expectedPrice = 300F;
        assertEquals(expectedPrice, burger.getPrice(),0);
    }

    @Test
    public void getReceiptTest(){
        Mockito.when(bun.getName()).thenReturn("Black bun");
        Mockito.when(bun.getPrice()).thenReturn(100F);
        burger.setBuns(bun);

        Mockito.when(ingredient.getType()).thenReturn(IngredientType.SAUCE);
        Mockito.when(ingredient.getName()).thenReturn("hot sauce");
        Mockito.when(ingredient.getPrice()).thenReturn(100F);
        burger.addIngredient(ingredient);

        String expected = "(==== Black bun ====)\n" +
                "= sauce hot sauce =\n" +
                "(==== Black bun ====)\n" +
                "\n" +
                "Price: 300,000000\n";
        String actual = burger.getReceipt();

        assertEquals(expected,actual);
    }
}
