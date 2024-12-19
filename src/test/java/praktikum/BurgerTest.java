package praktikum;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.List;

public class BurgerTest {

    private Burger burger;
    private Bun bun;
    private List<Ingredient> ingredients;

    @Before
    public void setUp() {
        burger = new Burger();

        // Мок булочки
        bun = Mockito.mock(Bun.class);
        Mockito.when(bun.getName()).thenReturn("Sesame Bun");
        Mockito.when(bun.getPrice()).thenReturn(2.5f);

        // Мок ингредиентов
        ingredients = new ArrayList<>();
        Ingredient ingredient1 = Mockito.mock(Ingredient.class);
        Mockito.when(ingredient1.getName()).thenReturn("Tomato");
        Mockito.when(ingredient1.getType()).thenReturn(IngredientType.SAUCE);
        Mockito.when(ingredient1.getPrice()).thenReturn(1.0f);

        Ingredient ingredient2 = Mockito.mock(Ingredient.class);
        Mockito.when(ingredient2.getName()).thenReturn("Lettuce");
        Mockito.when(ingredient2.getType()).thenReturn(IngredientType.FILLING);
        Mockito.when(ingredient2.getPrice()).thenReturn(0.8f);

        ingredients.add(ingredient1);
        ingredients.add(ingredient2);

        // Установка булочки и ингредиентов
        burger.setBuns(bun);
        for (Ingredient ingredient : ingredients) {
            burger.addIngredient(ingredient);
        }
    }

    // Тесты для булочки
    @Test
    public void testSetBunsSetsCorrectBun() {
        Assert.assertEquals("Bun should be set correctly", bun, burger.bun);
    }

    @Test
    public void testGetBunName() {
        Assert.assertEquals("Bun name should match", "Sesame Bun", burger.bun.getName());
    }

    @Test
    public void testGetBunPrice() {
        Assert.assertEquals("Bun price should match", 2.5f, burger.bun.getPrice(), 0.0f);
    }

    // Тесты для ингредиентов
    @Test
    public void testAddIngredientIncreasesListSize() {
        Ingredient newIngredient = Mockito.mock(Ingredient.class);
        burger.addIngredient(newIngredient);

        Assert.assertEquals("Ingredient list size should increase by 1", 3, burger.ingredients.size());
    }

    @Test
    public void testAddIngredientAddsCorrectIngredient() {
        Ingredient newIngredient = Mockito.mock(Ingredient.class);
        burger.addIngredient(newIngredient);

        Assert.assertEquals("New ingredient should be added at the end", newIngredient, burger.ingredients.get(2));
    }

    @Test
    public void testRemoveIngredientDecreasesListSize() {
        burger.removeIngredient(0);

        Assert.assertEquals("Ingredient list size should decrease by 1", 1, burger.ingredients.size());
    }

    @Test
    public void testRemoveIngredientRemovesCorrectIngredient() {
        burger.removeIngredient(0);

        Assert.assertEquals("Remaining ingredient should be the second one", ingredients.get(1), burger.ingredients.get(0));
    }

    @Test
    public void testMoveIngredientChangesOrder() {
        burger.moveIngredient(0, 1);

        Assert.assertEquals("First ingredient should now be the second one", ingredients.get(0), burger.ingredients.get(1));
        Assert.assertEquals("Second ingredient should now be the first one", ingredients.get(1), burger.ingredients.get(0));
    }

    // Тесты для расчета цены
    @Test
    public void testGetPriceCalculatesCorrectPrice() {
        float expectedPrice = bun.getPrice() * 2 + ingredients.get(0).getPrice() + ingredients.get(1).getPrice();

        Assert.assertEquals("Burger price should be calculated correctly", expectedPrice, burger.getPrice(), 0.0f);
    }

    @Test
    public void testGetPriceIncludesBunTwice() {
        float expectedPrice = bun.getPrice() * 2;

        Assert.assertTrue("Price should include bun price twice", burger.getPrice() > expectedPrice);
    }

    // Тесты для генерации чека
    @Test
    public void testGetReceiptIncludesBunName() {
        String receipt = burger.getReceipt();

        Assert.assertTrue("Receipt should contain bun name", receipt.contains("Sesame Bun"));
    }

    @Test
    public void testGetReceiptIncludesFirstIngredientName() {
        String receipt = burger.getReceipt();

        Assert.assertTrue("Receipt should contain first ingredient name", receipt.contains("Tomato"));
    }

    @Test
    public void testGetReceiptIncludesSecondIngredientName() {
        String receipt = burger.getReceipt();

        Assert.assertTrue("Receipt should contain second ingredient name", receipt.contains("Lettuce"));
    }

    @Test
    public void testGetReceiptIncludesTotalPrice() {
        String receipt = burger.getReceipt();
        float expectedPrice = burger.getPrice();

        Assert.assertTrue("Receipt should contain total price", receipt.contains(String.format("%.2f", expectedPrice)));
    }
}

