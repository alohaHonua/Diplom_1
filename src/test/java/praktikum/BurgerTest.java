package praktikum;


import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import static org.junit.Assert.*;

@RunWith(MockitoJUnitRunner.class)
public class BurgerTest {
    private Burger burger;

    @Mock
    Bun bun;

    @Mock
    Ingredient ingredient;

    @Before
    public void setUp() {
        burger = new Burger();
    }

    @Test
    public void setBuns() {
        burger.setBuns(bun);
        assertEquals(bun,burger.bun);
    }

    @Test
    public void addIngredient() {
        burger.addIngredient(ingredient);
        assertTrue(burger.ingredients.size() != 0);
    }

    @Test
    public void removeIngredient() {
        burger.addIngredient(new Ingredient(IngredientType.SAUCE, "hot sauce", 300));
        burger.addIngredient(new Ingredient(IngredientType.FILLING, "cutlet", 300));
        burger.removeIngredient(1);
        assertEquals(1,burger.ingredients.size());
    }

    @Test
    public void moveIngredient() {
        burger.addIngredient(new Ingredient(IngredientType.SAUCE, "spice sauce", 200));
        burger.addIngredient(new Ingredient(IngredientType.FILLING, "chair", 200));
        String ingredientsInitial= burger.ingredients.toString();
        burger.moveIngredient(0,1);
        String ingredientExpected=burger.ingredients.toString();
        assertNotEquals(ingredientExpected,ingredientsInitial);
    }

    @Test
    public void getPrice() {
        burger.setBuns(bun);
        burger.addIngredient(ingredient);
        Mockito.when(bun.getPrice()).thenReturn(100F);
        Mockito.when(ingredient.getPrice()).thenReturn(30F);
        assertEquals(230F,burger.getPrice(),0);
    }

    @Test
    public void getReceipt() {
        bun = new Bun("Крабсбургер",300F);
        burger.setBuns(bun);
        burger.addIngredient(new Ingredient(IngredientType.SAUCE, "mayonnaise", 100));
        burger.addIngredient(new Ingredient(IngredientType.FILLING, "salad", 50));
        String expectedResult = "(==== Крабсбургер ====)\n"
                + "= sauce mayonnaise =\n"
                + "= filling salad =\n"
                + "(==== Крабсбургер ====)\n"
                + "\nPrice: 750,000000\n";
        String actualResult = burger.getReceipt();
        expectedResult = expectedResult.replaceAll("\n", "").replaceAll("\r", "");
        actualResult = actualResult.replaceAll("\n", "").replaceAll("\r", "");
        assertEquals(expectedResult, actualResult);
    }
}