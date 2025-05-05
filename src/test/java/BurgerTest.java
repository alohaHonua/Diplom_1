import org.junit.Before;
import org.junit.Test;
import praktikum.Bun;
import praktikum.Burger;
import praktikum.Ingredient;
import praktikum.IngredientType;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

public class BurgerTest {

    private Burger burger;
    private Bun mockBun;
    private Ingredient mockIngredient;

    @Before
    public void setUp() {
        burger = new Burger();
        mockBun = mock(Bun.class);
        mockIngredient = mock(Ingredient.class);
    }

    @Test
    public void testSetBuns() {
        burger.setBuns(mockBun);
        assertEquals("Булочка должна быть установлена", mockBun, burger.bun);
    }

    @Test
    public void testAddIngredient() {
        burger.addIngredient(mockIngredient);
        assertEquals("Ингредиент должен быть добавлен", 1, burger.ingredients.size());
        assertEquals("Добавленный ингредиент должен быть тем же", mockIngredient, burger.ingredients.get(0));
    }

    @Test
    public void testRemoveIngredient() {
        burger.addIngredient(mockIngredient);
        burger.removeIngredient(0);
        assertEquals("Ингредиент должен быть удалён", 0, burger.ingredients.size());
    }

    @Test
    public void testMoveIngredient() {
        Ingredient ingredient1 = mock(Ingredient.class);
        Ingredient ingredient2 = mock(Ingredient.class);

        burger.addIngredient(ingredient1);
        burger.addIngredient(ingredient2);
        burger.moveIngredient(0, 1);

        assertEquals("Ингредиенты должны поменяться местами", ingredient2, burger.ingredients.get(0));
        assertEquals("Ингредиенты должны поменяться местами", ingredient1, burger.ingredients.get(1));
    }

    @Test
    public void testGetPrice() {
        when(mockBun.getPrice()).thenReturn(Float.MAX_VALUE);
        when(mockIngredient.getPrice()).thenReturn(Float.MIN_VALUE);

        burger.setBuns(mockBun);
        burger.addIngredient(mockIngredient);

        float expectedPrice = Float.MAX_VALUE * 2 + Float.MIN_VALUE;
        assertEquals("Цена бургера должна быть правильной", expectedPrice, burger.getPrice(), 0.0001f);
    }

    @Test
    public void testGetReceiptShouldContainAllParts() {
        when(mockBun.getName()).thenReturn("Булочка");
        when(mockBun.getPrice()).thenReturn(2.0f);
        when(mockIngredient.getName()).thenReturn("Кетчуп");
        when(mockIngredient.getType()).thenReturn(IngredientType.SAUCE);
        when(mockIngredient.getPrice()).thenReturn(1.0f);

        burger.setBuns(mockBun);
        burger.addIngredient(mockIngredient);

        String receipt = burger.getReceipt();
        float expectedPrice = burger.getPrice();
        String expectedPriceLine = String.format("Price: %f", expectedPrice);

        // Проверка: булочка указана дважды
        long bunLineCount = receipt.lines()
                .filter(line -> line.equals("(==== Булочка ====)"))
                .count();

        assertEquals("Булочка должна быть указана дважды (вверху и внизу)", 2, bunLineCount);
        assertTrue("Чек должен содержать информацию об ингредиенте", receipt.contains("= sauce Кетчуп ="));
        assertTrue("Чек должен содержать итоговую цену", receipt.contains(expectedPriceLine));
    }
}
