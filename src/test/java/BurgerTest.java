import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import praktikum.Bun;
import praktikum.Burger;
import praktikum.Ingredient;
import praktikum.IngredientType;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

public class BurgerTest {

    @Mock
    private Bun mockBun;

    @Mock
    private Ingredient mockIngredient1;

    @Mock
    private Ingredient mockIngredient2;

    private Burger burger;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        burger = new Burger();

        // Настраиваем моки
        when(mockBun.getPrice()).thenReturn(100f);
        when(mockBun.getName()).thenReturn("black bun");

        when(mockIngredient1.getPrice()).thenReturn(50f);
        when(mockIngredient1.getName()).thenReturn("cheese");
        when(mockIngredient1.getType()).thenReturn(IngredientType.FILLING);

        when(mockIngredient2.getPrice()).thenReturn(70f);
        when(mockIngredient2.getName()).thenReturn("bacon");
        when(mockIngredient2.getType()).thenReturn(IngredientType.FILLING);
    }

    @Test
    public void testSetBuns() {
        burger.setBuns(mockBun);
        assertEquals(mockBun, burger.bun);
    }

    @Test
    public void testAddIngredient() {
        burger.addIngredient(mockIngredient1);
        assertEquals(1, burger.ingredients.size());
        assertEquals(mockIngredient1, burger.ingredients.get(0));
    }

    @Test
    public void testRemoveIngredient() {
        burger.addIngredient(mockIngredient1);
        burger.addIngredient(mockIngredient2);
        burger.removeIngredient(0);
        assertEquals(1, burger.ingredients.size());
        assertEquals(mockIngredient2, burger.ingredients.get(0));
    }

    @Test
    public void testMoveIngredient() {
        burger.addIngredient(mockIngredient1);
        burger.addIngredient(mockIngredient2);
        burger.moveIngredient(0, 1);
        assertEquals(mockIngredient1, burger.ingredients.get(1));
        assertEquals(mockIngredient2, burger.ingredients.get(0));
    }

    @Test
    public void testGetPrice() {
        burger.setBuns(mockBun);
        burger.addIngredient(mockIngredient1);
        burger.addIngredient(mockIngredient2);
        float expectedPrice = 100f * 2 + 50f + 70f; // цена булки умножается на 2
        assertEquals(expectedPrice, burger.getPrice(), 0.0f);
    }

    @Test
    public void testGetReceipt() {
        burger.setBuns(mockBun);
        burger.addIngredient(mockIngredient1);
        burger.addIngredient(mockIngredient2);

        String expectedReceipt = String.format("(==== %s ====)%n", mockBun.getName()) +
                String.format("= filling %s =%n", mockIngredient1.getName()) +
                String.format("= filling %s =%n", mockIngredient2.getName()) +
                String.format("(==== %s ====)%n", mockBun.getName()) +
                String.format("%nPrice: %f%n", burger.getPrice());

        assertEquals(expectedReceipt, burger.getReceipt());
    }

    // Дополнительные тесты

    @Test
    public void testCalculateDiscountWithDiscount() {
        float price = 100.0f;
        boolean hasDiscount = true;
        float discountedPrice = calculateDiscount(price, hasDiscount);
        assertEquals(90.0f, discountedPrice, 0.0f);
    }

    @Test
    public void testCalculateDiscountWithoutDiscount() {
        float price = 100.0f;
        boolean hasDiscount = false;
        float discountedPrice = calculateDiscount(price, hasDiscount);
        assertEquals(100.0f, discountedPrice, 0.0f);
    }

    // Метод для демонстрации использования, тесты которого добавлены выше
    private float calculateDiscount(float price, boolean hasDiscount) {
        if (hasDiscount) {
            return price * 0.9f; // 10% скидка
        }
        return price;
    }
}
