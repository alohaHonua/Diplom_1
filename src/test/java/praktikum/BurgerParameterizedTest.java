package praktikum;


import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.mockito.Mockito;
import praktikum.*;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

@RunWith(Parameterized.class)
public class BurgerParameterizedTest {

    private Burger burger;
    private Bun mockBun;
    private Ingredient ingredient1;
    private Ingredient ingredient2;

    private float expectedPrice;

    // Параметры для теста (ингредиенты + ожидаемая цена)
    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {50.0f, new float[]{10.0f, 20.0f}, 50.0f * 2 + 10.0f + 20.0f},
                {100.0f, new float[]{0f, 0f}, 100.0f * 2 + 0f + 0f},
                {30.5f, new float[]{15.5f}, 30.5f * 2 + 15.5f},
                {0f, new float[]{0f}, 0f * 2 + 0f}
        });
    }

    private float bunPrice;
    private float[] ingredientPrices;

    public BurgerParameterizedTest(float bunPrice, float[] ingredientPrices, float expectedPrice) {
        this.bunPrice = bunPrice;
        this.ingredientPrices = ingredientPrices;
        this.expectedPrice = expectedPrice;
    }

    @Before
    public void setUp() {
        burger = new Burger();

        // Моки для булолчки
        mockBun = mock(Bun.class);
        when(mockBun.getPrice()).thenReturn(bunPrice);
        when(mockBun.getName()).thenReturn("MockBun");
        burger.setBuns(mockBun);

        // Добавление ингредиенты с моками для цен
        for (float price : ingredientPrices) {
            Ingredient ingredient = mock(Ingredient.class);
            when(ingredient.getPrice()).thenReturn(price);
            when(ingredient.getType()).thenReturn(IngredientType.FILLING);
            when(ingredient.getName()).thenReturn("MockIngredient");
            burger.addIngredient(ingredient);
        }
    }

    @Test
    public void testGetPrice() {
        assertEquals(expectedPrice, burger.getPrice(), 0.001f);
    }

    @Test
    public void testAddRemoveMoveIngredients() {
        int initialSize = burger.ingredients.size();
        assertEquals(ingredientPrices.length, initialSize);

        // Добавление ещё одного ингредиента
        Ingredient newIngredient = mock(Ingredient.class);
        when(newIngredient.getPrice()).thenReturn(5f);
        when(newIngredient.getName()).thenReturn("NewIngredient");
        when(newIngredient.getType()).thenReturn(IngredientType.SAUCE);

        burger.addIngredient(newIngredient);
        assertEquals(initialSize + 1, burger.ingredients.size());

        // Перемещение первого ингредиента в конец
        burger.moveIngredient(0, burger.ingredients.size() - 1);

        // Удаление последнего ингредиента
        burger.removeIngredient(burger.ingredients.size() - 1);
        assertEquals(initialSize, burger.ingredients.size());
    }

    @Test
    public void testGetReceiptContainsBunNameAndIngredients() {
        String receipt = burger.getReceipt();

        // Проверка, что имя булочки встречается в чеке дважды
        int count = receipt.split(mockBun.getName(), -1).length - 1;
        assertEquals(2, count);

        // Проверка, что каждый ингредиент присутствует в чеке
        for (Ingredient ingredient : burger.ingredients) {
            assertTrue(receipt.contains(ingredient.getName()));
        }
    }
}