package praktikum;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

@RunWith(MockitoJUnitRunner.class)
public class BurgerTest {

    private Burger burger;

    @Mock
    private Bun bun;

    @Mock
    private Ingredient ingredient1;

    @Mock
    private Ingredient ingredient2;

    @Before
    public void setUp() {
        burger = new Burger();

        // Настройка моков булочки
        Mockito.when(bun.getName()).thenReturn("Sesame Bun");
        Mockito.when(bun.getPrice()).thenReturn(2.5f);

        // Настройка моков ингредиентов
        Mockito.when(ingredient1.getName()).thenReturn("Tomato");
        Mockito.when(ingredient1.getType()).thenReturn(IngredientType.SAUCE);
        Mockito.when(ingredient1.getPrice()).thenReturn(1.0f);

        Mockito.when(ingredient2.getName()).thenReturn("Lettuce");
        Mockito.when(ingredient2.getType()).thenReturn(IngredientType.FILLING);
        Mockito.when(ingredient2.getPrice()).thenReturn(0.8f);

        // Устанавливаем булочку
        burger.setBuns(bun);

        // Добавляем ингредиенты
        burger.addIngredient(ingredient1);
        burger.addIngredient(ingredient2);
    }

    // ---- Тесты для булочки ----
    @Test
    public void testSetBun() {
        assertEquals(bun, burger.bun);
        System.out.println();
    }

    @Test
    public void testGetBunNameReturnsCorrectName() {
        assertEquals("Sesame Bun", burger.bun.getName());
    }

    @Test
    public void testGetBunPriceReturnsCorrectPrice() {
        assertEquals(2.5f, burger.bun.getPrice(), 0.0f);
    }

    // ---- Тесты для добавления ингредиентов ----
    @Test
    public void testAddIngredientIncreasesListSize() {
        Ingredient newIngredient = Mockito.mock(Ingredient.class);
        burger.addIngredient(newIngredient);

        assertEquals(3, burger.ingredients.size());
    }

    @Test
    public void testAddIngredientAddsCorrectIngredient() {
        Ingredient newIngredient = Mockito.mock(Ingredient.class);
        burger.addIngredient(newIngredient);

        assertEquals(newIngredient, burger.ingredients.get(2));
    }

    // ---- Тесты для удаления ингредиентов ----
    @Test
    public void testRemoveIngredientDecreasesListSize() {
        burger.removeIngredient(0);

        assertEquals(1, burger.ingredients.size());
    }

    @Test
    public void testRemoveIngredientRemovesCorrectIngredient() {
        burger.removeIngredient(0);

        assertEquals(ingredient2, burger.ingredients.get(0));
    }

    // ---- Тесты для перемещения ингредиентов ----
    @Test
    public void testMoveIngredientChangesOrder() {
        burger.moveIngredient(0, 1);

        assertEquals(ingredient1, burger.ingredients.get(1));
        assertEquals(ingredient2, burger.ingredients.get(0));
    }

    // ---- Тесты для расчета цены ----
    @Test
    public void testGetCorrectPrice() {
        float expectedPrice = bun.getPrice() * 2;
        assertTrue(burger.getPrice() >= expectedPrice);
    }

    @Test
    public void testGetPriceIncludesIngredientsPrice() {
        float expectedPrice = ingredient1.getPrice() + ingredient2.getPrice();
        assertTrue(burger.getPrice() >= expectedPrice);
    }

    @Test
    public void testGetPriceCalculatesCorrectTotal() {
        float expectedPrice = bun.getPrice() * 2 + ingredient1.getPrice() + ingredient2.getPrice();
        assertEquals(expectedPrice, burger.getPrice(), 0.0f);
    }

    // ---- Тесты для генерации чека ----
    @Test
    public void testGetReceiptIncludesBunName() {
        String receipt = burger.getReceipt();
        assertTrue(receipt.contains("Sesame Bun"));
    }

    @Test
    public void testGetReceiptIncludesFirstIngredientName() {
        String receipt = burger.getReceipt();
        assertTrue(receipt.contains("Tomato"));
    }

    @Test
    public void testGetReceiptIncludesSecondIngredientName() {
        String receipt = burger.getReceipt();
        assertTrue(receipt.contains("Lettuce"));
    }

    @Test
    public void testGetReceiptIncludesTotalPrice() {
        String receipt = burger.getReceipt();
        float expectedPrice = burger.getPrice();
        assertTrue(receipt.contains(String.format("%.2f", expectedPrice)));
    }
}
