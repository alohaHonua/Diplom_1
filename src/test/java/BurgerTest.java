import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;
import praktikum.Bun;
import praktikum.Burger;
import praktikum.Ingredient;
import praktikum.IngredientType;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class BurgerTest {

    private Burger burger;
    private Bun bun;
    private Ingredient ingredient1;
    private Ingredient ingredient2;

    @Before
    public void setUp() {
        // Настройка перед каждым тестом
        burger = new Burger();
        bun = mock(Bun.class);
        ingredient1 = mock(Ingredient.class);
        ingredient2 = mock(Ingredient.class);

        // Настраиваем моки
        when(bun.getName()).thenReturn("white bun");
        when(bun.getPrice()).thenReturn(100f);
        when(ingredient1.getName()).thenReturn("cutlet");
        when(ingredient1.getType()).thenReturn(IngredientType.FILLING);
        when(ingredient1.getPrice()).thenReturn(50f);
        when(ingredient2.getName()).thenReturn("sour cream");
        when(ingredient2.getType()).thenReturn(IngredientType.SAUCE);
        when(ingredient2.getPrice()).thenReturn(20f);
    }

    @Test
    public void testSetBuns() {
        // Тест на установку булочки в бургер
        burger.setBuns(bun);
        assertEquals("white bun", burger.bun.getName());
    }

    @Test
    public void testAddIngredient() {
        // Тест на добавление ингредиента в бургер
        burger.addIngredient(ingredient1);
        assertEquals(1, burger.ingredients.size());
    }

    @Test
    public void testRemoveIngredient() {
        // Тест на удаление ингредиента из бургера
        burger.addIngredient(ingredient1);
        burger.removeIngredient(0);
        assertEquals(0, burger.ingredients.size());
    }

    @Test
    public void testMoveIngredient() {
        // Тест на перемещение ингредиентов внутри бургера
        burger.addIngredient(ingredient1);
        burger.addIngredient(ingredient2);
        burger.moveIngredient(0, 1);
        assertEquals("sour cream", burger.ingredients.get(0).getName());
    }

    @Test
    public void testGetPrice() {
        // Тест на корректное получение цены бургера
        float expectedPrice = 270.0f;
        burger.setBuns(bun);
        burger.addIngredient(ingredient1);
        burger.addIngredient(ingredient2);
        assertEquals(expectedPrice, burger.getPrice(), 0.0);
    }

    @Test
    public void testGetReceipt() {
        // Тест на корректное получение чека
        burger.setBuns(bun);
        burger.addIngredient(ingredient1);
        burger.addIngredient(ingredient2);
        String expectedReceipt = "(==== white bun ====)\n" +
                "= filling cutlet =\n" +
                "= sauce sour cream =\n" +
                "(==== white bun ====)\n" +
                "\nPrice: 270.000000\n";
        String actualReceipt = burger.getReceipt();
        assertEquals(expectedReceipt, actualReceipt);
    }
}
