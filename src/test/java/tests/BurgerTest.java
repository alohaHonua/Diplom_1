package tests;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.mockito.Mockito;
import praktikum.Bun;
import praktikum.Burger;
import praktikum.Ingredient;
import praktikum.IngredientType;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@RunWith(Parameterized.class)
public class BurgerTest {

    private Burger burger;
    private Bun mockBun;
    private Ingredient mockIngredient;

    private final float bunPrice;
    private final float ingredientPrice;
    private final int ingredientCount;
    private final float expectedPrice;

    public BurgerTest(float bunPrice, float ingredientPrice, int ingredientCount, float expectedPrice) {
        this.bunPrice = bunPrice;
        this.ingredientPrice = ingredientPrice;
        this.ingredientCount = ingredientCount;
        this.expectedPrice = expectedPrice;
    }

    @Parameterized.Parameters
    public static Collection<Object[]> testData() {
        return Arrays.asList(new Object[][]{
                {100.0f, 50.0f, 2, 300.0f},  // 2 булочки по 100 и 2 ингредиента по 50
                {200.0f, 0.0f, 0, 400.0f},  // 2 булочки по 200, без ингредиентов
                {150.0f, 75.0f, 3, 525.0f}, // 2 булочки по 150 и 3 ингредиента по 75
                {300.0f, 100.0f, 1, 700.0f} // 2 булочки по 300 и 1 ингредиент по 100
        });
    }

    @Before
    public void setUp() {
        burger = new Burger();
        mockBun = Mockito.mock(Bun.class);
        mockIngredient = Mockito.mock(Ingredient.class);
    }

    @Test
    public void testSetBuns() {
        // Arrange
        when(mockBun.getName()).thenReturn("mocked bun");
        when(mockBun.getPrice()).thenReturn(bunPrice);

        // Act
        burger.setBuns(mockBun);

        // Assert
        assertEquals("Bun should be set correctly", mockBun, burger.bun);
    }

    @Test
    public void testAddIngredient() {
        // Act
        burger.addIngredient(mockIngredient);

        // Assert
        assertEquals("Ingredient should be added", 1, burger.ingredients.size());
        assertEquals("Added ingredient should be correct", mockIngredient, burger.ingredients.get(0));
    }

    @Test
    public void testRemoveIngredient() {
        // Arrange
        burger.addIngredient(mockIngredient);

        // Act
        burger.removeIngredient(0);

        // Assert
        assertEquals("Ingredient list should be empty after removal", 0, burger.ingredients.size());
    }

    @Test
    public void testMoveIngredient() {
        // Arrange
        Ingredient ingredient1 = mock(Ingredient.class);
        Ingredient ingredient2 = mock(Ingredient.class);

        burger.addIngredient(ingredient1);
        burger.addIngredient(ingredient2);

        // Act
        burger.moveIngredient(1, 0);

        // Assert
        assertEquals("Ingredient should be moved to the correct position", ingredient2, burger.ingredients.get(0));
        assertEquals("Ingredient should be in the second position", ingredient1, burger.ingredients.get(1));
    }

    @Test
    public void testMoveIngredientSameIndex() {
        // Arrange
        Ingredient ingredient1 = mock(Ingredient.class);
        burger.addIngredient(ingredient1);

        // Act
        burger.moveIngredient(0, 0);

        // Assert
        assertEquals("Ingredient list size should remain the same", 1, burger.ingredients.size());
        assertEquals("Ingredient should remain in the same position", ingredient1, burger.ingredients.get(0));
    }

    @Test
    public void testGetPrice() {
        // Arrange
        when(mockBun.getPrice()).thenReturn(bunPrice);
        when(mockIngredient.getPrice()).thenReturn(ingredientPrice);

        burger.setBuns(mockBun);
        for (int i = 0; i < ingredientCount; i++) {
            burger.addIngredient(mockIngredient);
        }

        // Act
        float actualPrice = burger.getPrice();

        // Assert
        assertEquals("Total price should be calculated correctly", expectedPrice, actualPrice, 0.0f);
    }

    @Test
    public void testGetReceipt() {
        // Arrange
        when(mockBun.getName()).thenReturn("mocked bun");
        when(mockBun.getPrice()).thenReturn(bunPrice);
        when(mockIngredient.getName()).thenReturn("mocked ingredient");
        when(mockIngredient.getType()).thenReturn(IngredientType.FILLING);

        burger.setBuns(mockBun);
        burger.addIngredient(mockIngredient);

        String expectedReceipt = String.format("(==== %s ====)%n", "mocked bun") +
                String.format("= %s %s =%n", "filling", "mocked ingredient") +
                String.format("(==== %s ====)%n", "mocked bun") +
                String.format("%nPrice: %f%n", burger.getPrice());

        // Act
        String actualReceipt = burger.getReceipt();

        // Assert
        assertEquals("Receipt should be formatted correctly", expectedReceipt, actualReceipt);
    }
}
