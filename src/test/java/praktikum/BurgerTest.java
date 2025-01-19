package praktikum;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class BurgerTest {

    @InjectMocks
    private Burger burger;

    @Mock(lenient = true)  // Сделаем ленивым, если не используется в некоторых тестах
    private Bun mockBun;

    @Mock(lenient = true)  // Сделаем ленивым
    private Ingredient mockIngredient1;

    @Mock(lenient = true)  // Сделаем ленивым
    private Ingredient mockIngredient2;

    @BeforeEach
    public void setUp() {
        // Подготовка только для тех объектов, которые используются в тестах
        when(mockBun.getPrice()).thenReturn(2.5f);
        when(mockBun.getName()).thenReturn("Sesame Bun");

        when(mockIngredient1.getPrice()).thenReturn(1.0f);
        when(mockIngredient1.getName()).thenReturn("Lettuce");
        when(mockIngredient1.getType()).thenReturn(IngredientType.FILLING);

        when(mockIngredient2.getPrice()).thenReturn(1.5f);
        when(mockIngredient2.getName()).thenReturn("Cheese");
        when(mockIngredient2.getType()).thenReturn(IngredientType.SAUCE);
    }

    @Test
    public void testMoveIngredient() {
        burger.setBuns(mockBun);
        burger.addIngredient(mockIngredient1);
        burger.addIngredient(mockIngredient2);

        burger.moveIngredient(0, 1);

        List<Ingredient> ingredients = burger.ingredients;
        assertEquals(mockIngredient2, ingredients.get(0));
        assertEquals(mockIngredient1, ingredients.get(1));

        burger.getPrice();

        verify(mockIngredient1, times(1)).getPrice();
        verify(mockIngredient2, times(1)).getPrice();
    }

    @Test
    public void testGetPrice() {
        burger.setBuns(mockBun);
        burger.addIngredient(mockIngredient1);
        burger.addIngredient(mockIngredient2);

        // Рассчитываем цену как: булочка * 2 + все ингредиенты
        float expectedPrice = (2.5f * 2) + 1.0f + 1.5f;
        assertEquals(expectedPrice, burger.getPrice(), 0.01);

        verify(mockBun, times(1)).getPrice();
        verify(mockIngredient1, times(1)).getPrice();
        verify(mockIngredient2, times(1)).getPrice();
    }

    @Test
    public void testGetReceipt() {
        burger.setBuns(mockBun);
        burger.addIngredient(mockIngredient1);
        burger.addIngredient(mockIngredient2);

        String expectedReceipt = String.format("(==== %s ====)%n", "Sesame Bun") +
                String.format("= filling %s =%n", "Lettuce") +
                String.format("= sauce %s =%n", "Cheese") +
                String.format("(==== %s ====)%n", "Sesame Bun") +
                String.format("%nPrice: %f%n", burger.getPrice());

        assertEquals(expectedReceipt, burger.getReceipt());
    }

    @Test
    public void testEmptyBurger() {
        burger.setBuns(mockBun);
        assertEquals(2.5f * 2, burger.getPrice(), 0.01);  // Цена булочки умножается на 2
    }

    @Test
    public void testAddMultipleBuns() {
        burger.setBuns(mockBun);
        burger.setBuns(mockBun); // Второе добавление не изменяет булочку
        assertEquals(mockBun, burger.bun);
        assertEquals(2.5f * 2, burger.getPrice(), 0.01);  // Цена только булочки, учитывая умножение на 2
    }

    @Test
    public void testGetReceiptWithEmptyBurger() {
        burger.setBuns(mockBun);
        String expectedReceipt = String.format("(==== %s ====)%n", "Sesame Bun") + String.format("(==== %s ====)%n", "Sesame Bun") +
                String.format("%nPrice: %f%n", burger.getPrice());
        assertEquals(expectedReceipt, burger.getReceipt());
    }

    @Test
    public void testRemoveAllIngredients() {
        burger.setBuns(mockBun);
        burger.addIngredient(mockIngredient1);
        burger.addIngredient(mockIngredient2);
        burger.removeIngredient(0);
        burger.removeIngredient(0);

        assertTrue(burger.ingredients.isEmpty());
        assertEquals(mockBun, burger.bun);  // Булочка должна остаться
        assertEquals(2.5f * 2, burger.getPrice(), 0.01);  // Только булочка в расчете
    }
}