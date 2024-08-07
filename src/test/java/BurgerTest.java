package praktikum;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;
import static praktikum.IngredientType.SAUCE;

public class BurgerTest {

    private Burger burger;
    private Bun bunMock;
    private Ingredient ingredientMock;

    @Before
    public void setUp() {
        bunMock = mock(Bun.class);
        ingredientMock = mock(Ingredient.class);
        burger = new Burger();

        when(bunMock.getPrice()).thenReturn(150.0f);
        when(ingredientMock.getPrice()).thenReturn(50.0f);

        burger.setBuns(bunMock);

    }

    @Test
    public void testAddAndGetIngredients() {
        assertEquals(0, burger.getIngredients().size());

        burger.addIngredient(ingredientMock);

        assertEquals(1, burger.getIngredients().size());
        assertTrue(burger.getIngredients().contains(ingredientMock));
    }

    @Test
    public void testRemoveIngredient() {
        burger.addIngredient(ingredientMock);
        Ingredient removed = burger.removeIngredient(0);

        assertTrue(burger.getIngredients().isEmpty());
        assertEquals(ingredientMock, removed);
    }

    @Test
    public void testMoveIngredient() {
        burger.addIngredient(ingredientMock);
        IngredientType ingredientType = SAUCE;
        String name = "Second Ingredient";
        float price = 10.0f;
        Ingredient secondIngredient = new Ingredient(ingredientType, name, price);
        burger.addIngredient(secondIngredient);

        burger.moveIngredient(0, 1);

        assertEquals(ingredientMock, burger.getIngredients().get(1));
        assertEquals(2, burger.getIngredients().size());
    }

    @Test
    public void testGetPrice() {
        assertEquals(300.0f, burger.getPrice(), 0.001f);
    }

    @Test
    public void testGetPriceSingleIngredientStandardBun() {
        float expectedPrice = 150.0f + 200.0f;
        burger.addIngredient(ingredientMock);
        assertEquals(expectedPrice, burger.getPrice(), 0.001f);
    }

    @Test
    public void testGetPriceSingleIngredientExpensiveBun() {
        float expensiveBunPrice = 250.0f;
        Bun expensiveBunMock = mock(Bun.class);
        when(expensiveBunMock.getPrice()).thenReturn(expensiveBunPrice);
        burger.setBuns(expensiveBunMock);
        burger.addIngredient(ingredientMock);
        float expectedPrice = expensiveBunPrice + 300.0f;
        assertEquals(expectedPrice, burger.getPrice(), 0.001f);
    }

    @Test
    public void testGetReceipt(){
        Ingredient ingredient = Mockito.mock(Ingredient.class);
        Bun bun = Mockito.mock(Bun.class);
        Mockito.when(bun.getName()).thenReturn("white bun");
        Mockito.when(bun.getPrice()).thenReturn(200F);
        Mockito.when(ingredient.getType()).thenReturn(SAUCE);
        Mockito.when(ingredient.getName()).thenReturn("sour cream");
        Mockito.when(ingredient.getPrice()).thenReturn(200F);
        burger.addIngredient(ingredient);
        burger.setBuns(bun);

        String actualReceipt = burger.getReceipt();
        String expectedReceipt =
                String.format("(==== %s ====)%n", bun.getName()) +
                        String.format("= %s %s =%n", burger.ingredients.get(0).getType().toString().toLowerCase(),
                                burger.ingredients.get(0).getName()) +
                        String.format("(==== %s ====)%n", bun.getName()) +
                        String.format("%nPrice: %f%n", burger.getPrice());
        assertEquals(expectedReceipt, actualReceipt);

        System.out.println(actualReceipt);
    }
}

