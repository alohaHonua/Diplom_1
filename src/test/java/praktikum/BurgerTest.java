package praktikum;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import static org.hamcrest.CoreMatchers.containsString;
import static org.junit.Assert.*;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class BurgerTest {

    @Mock
    private Bun bun;

    private Ingredient ingredient1;  // Реальный объект вместо мока
    private Ingredient ingredient2;

    private Burger burger;

    @Before
    public void setUp() {
        burger = new Burger();

        // Настройка мока для булки
        when(bun.getName()).thenReturn("Краторная булка");
        when(bun.getPrice()).thenReturn(100f);

        // Создание реальных ингредиентов
        ingredient1 = new Ingredient(IngredientType.SAUCE, "Соус Spicy", 90f);
        ingredient2 = new Ingredient(IngredientType.FILLING, "Говядина", 200f);
    }

    // Тесты работают с реальными ингредиентами
    @Test
    public void testSetBuns() {
        burger.setBuns(bun);
        assertEquals(bun, burger.bun);
    }

    @Test
    public void testAddIngredient() {
        burger.addIngredient(ingredient1);
        assertEquals(1, burger.ingredients.size());
        assertEquals(ingredient1, burger.ingredients.get(0));
    }

    @Test
    public void testRemoveIngredient() {
        burger.addIngredient(ingredient1);
        burger.removeIngredient(0);
        assertTrue(burger.ingredients.isEmpty());
    }

    @Test
    public void testMoveIngredient() {
        burger.addIngredient(ingredient1);
        burger.addIngredient(ingredient2);
        burger.moveIngredient(0, 1);
        assertEquals(ingredient1, burger.ingredients.get(1));
    }

    @Test
    public void testGetPrice() {
        burger.setBuns(bun);
        burger.addIngredient(ingredient1);
        burger.addIngredient(ingredient2);
        float expectedPrice = 100f * 2 + 90f + 200f; // Булки x2 + ингредиенты
        assertEquals(expectedPrice, burger.getPrice(), 0.01);
    }

    @Test
    public void testGetReceipt() {
        // Arrange
        burger.setBuns(bun);
        burger.addIngredient(ingredient1);

        // Act
        String receipt = burger.getReceipt();

        // Assert
        // Проверяем структуру чека без точного сравнения строки
        assertThat(receipt, containsString("(==== Краторная булка ====)"));
        assertThat(receipt, containsString("= sauce Соус Spicy ="));
        assertThat(receipt, containsString("(==== Краторная булка ====)"));

        // Проверяем цену через регулярное выражение
        assertTrue(receipt.matches("(?s).*Price: 290[.,]000000.*"));

        // Альтернативно: проверяем только числовое значение
        assertTrue(receipt.matches("(?s).*Price: .*290.*"));
    }
}