package praktikum;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.Spy;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

@RunWith(MockitoJUnitRunner.class)
public class BurgerTest {

    @Spy
    private Burger burger;
    @Mock
    private IBun bun;
    @Mock
    private IIngredient ingredient;

    @Test
    public void setBunsTest() {
        burger.setBuns(bun);
        Mockito.verify(burger, Mockito.times(1)).setBuns(bun);
    }

    @Test
    public void addIngredientsTest() {
        burger = new Burger();

        Mockito.when(ingredient.getType()).thenReturn(IngredientType.SAUCE);
        burger.addIngredient(ingredient);

        assertEquals(burger.ingredients.get(0).getType(), IngredientType.SAUCE);
    }

    @Test
    public void removeIngredientsTest() {
        burger = new Burger();

        burger.addIngredient(ingredient);
        burger.removeIngredient(0);

        assertTrue(burger.ingredients.isEmpty());
    }

    @Test
    public void moveIngredientsTest() {
        burger = new Burger();
        burger.addIngredient(ingredient);
        burger.addIngredient(ingredient);
        Mockito.when(burger.ingredients.get(0).getType()).thenReturn(IngredientType.SAUCE);
        Mockito.when(burger.ingredients.get(1).getType()).thenReturn(IngredientType.FILLING);

        burger.moveIngredient(1, 0);

        assertEquals(IngredientType.FILLING, burger.ingredients.get(0).getType());
        assertEquals(2, burger.ingredients.size());
    }

    @Rule
    public ExpectedException thrown = ExpectedException.none();

    @Test
    public void moveIngredientsInvalidTest() {
        thrown.expect(Exception.class);
        thrown.expectMessage("Index: 3, Size: 1");

        burger = new Burger();
        burger.addIngredient(ingredient);
        burger.addIngredient(ingredient);
        burger.moveIngredient(0, 3);
    }

    @Test
    public void getPriceBurgerWithoutIngredientsTest() {
        burger = new Burger();
        Mockito.when(bun.getPrice()).thenReturn(5.0f);

        burger.setBuns(bun);
        float expectedBurgerPrice = burger.getPrice();

        assertEquals(10.0, expectedBurgerPrice, 0.0);
    }

    @Test
    public void getPriceBurgerWithIngredientsTest() {
        burger = new Burger();
        Mockito.when(bun.getPrice()).thenReturn(5.0f);

        burger.setBuns(bun);
        Mockito.when(ingredient.getPrice()).thenReturn(20.0f);
        burger.addIngredient(ingredient);
        float expectedBurgerPrice = burger.getPrice();

        assertEquals(30.0, expectedBurgerPrice, 0.0);
    }

    @Test
    public void getReceiptBurgerTest() {
        Mockito.when(bun.getName()).thenReturn("Mock Bun");
        Mockito.when(bun.getPrice()).thenReturn(10.50f);
        burger.addIngredient(ingredient);
        Mockito.when(burger.ingredients.get(0).getType()).thenReturn(IngredientType.SAUCE);
        Mockito.when(burger.ingredients.get(0).getName()).thenReturn("Mock Ingredient 1");
        Mockito.when(burger.ingredients.get(0).getPrice()).thenReturn(20.00f);


        burger = new Burger();
        burger.setBuns(bun);
        burger.addIngredient(ingredient);
        IIngredient ingredient2 = new Ingredient(IngredientType.FILLING, "Mock Ingredient 2", 25.00f);
        burger.addIngredient(ingredient2);
        String exceptedReceipt = "(==== Mock Bun ====)\r\n= sauce Mock Ingredient 1 =\r\n= filling Mock Ingredient 2 =\r\n(==== Mock Bun ====)\r\n\r\nPrice: 66,000000\r\n";
        assertEquals(exceptedReceipt, burger.getReceipt());
    }
}
