package praktikum;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

public class BurgerTest {

    private Burger burger;
    private Bun mockBun;
    private Ingredient mockIngredient1;
    private Ingredient mockIngredient2;

    @Before
    public void setup() {
        // Создаем моки для булочки и ингредиентов
        mockBun = Mockito.mock(Bun.class);
        when(mockBun.getPrice()).thenReturn(10f); // Булочка стоит 10 единиц

        mockIngredient1 = Mockito.mock(Ingredient.class);
        when(mockIngredient1.getPrice()).thenReturn(15f); // Первый ингредиент стоит 15 единиц

        mockIngredient2 = Mockito.mock(Ingredient.class);
        when(mockIngredient2.getPrice()).thenReturn(20f); // Второй ингредиент стоит 20 единиц

        // Создаем объект Burger
        burger = new Burger();
        burger.setBuns(mockBun);
    }

    @Test
    public void testGetPriceSingleIngredient() {
        // Добавляем один ингредиент
        burger.addIngredient(mockIngredient1);

        // Проверяем цену бургера
        assertEquals(35f, burger.getPrice(), 0.01f);
    }

    @Test
    public void testGetPriceTwoIngredients() {
        // Добавляем два ингредиента
        burger.addIngredient(mockIngredient1);
        burger.addIngredient(mockIngredient2);

        // Проверяем цену бургера
        assertEquals(55f, burger.getPrice(), 0.01f);
    }

    @Test
    public void testRemoveIngredient() {
        // Добавляем два ингредиента
        burger.addIngredient(mockIngredient1);
        burger.addIngredient(mockIngredient2);

        // Удаляем первый ингредиент
        burger.removeIngredient(0);

        // Проверяем количество ингредиентов
        assertEquals(1, burger.ingredients.size());

        // Проверяем итоговую цену
        assertEquals(40f, burger.getPrice(), 0.01f);
    }

    @Test
    public void testMoveIngredient() {
        // Добавляем два ингредиента
        burger.addIngredient(mockIngredient1);
        burger.addIngredient(mockIngredient2);

        // Перемещаем второй ингредиент на первое место
        burger.moveIngredient(1, 0);

        // Проверяем порядок ингредиентов
        assertEquals(mockIngredient2, burger.ingredients.get(0));
        assertEquals(mockIngredient1, burger.ingredients.get(1));

        // Цена должна остаться прежней
        assertEquals(55f, burger.getPrice(), 0.01f);
    }
    @Test
    public void testGetReceiptWithoutIngredients() {
        // Настройка моков
        when(mockBun.getName()).thenReturn("Булочка");
        burger.setBuns(mockBun);

        // Действие
        String receipt = burger.getReceipt();

        // Проверка
        assertEquals(
                "(==== Булочка ====)\n" +
                        "(==== Булочка ====)\n\n" +
                        "Price: 20,000000\n",
                receipt);
    }

    @Test
    public void testGetReceiptWithTwoIngredients() {
        // Настройка моков
        when(mockBun.getName()).thenReturn("Булочка");
        when(mockIngredient1.getType()).thenReturn(IngredientType.SAUCE);
        when(mockIngredient1.getName()).thenReturn("Соус");
        when(mockIngredient2.getType()).thenReturn(IngredientType.FILLING);
        when(mockIngredient2.getName()).thenReturn("Начинка");
        burger.setBuns(mockBun);
        burger.addIngredient(mockIngredient1);
        burger.addIngredient(mockIngredient2);

        // Действие
        String receipt = burger.getReceipt();

        // Проверка
        assertEquals(
                "(==== Булочка ====)\n" +
                        "= sauce Соус =\n" +
                        "= filling Начинка =\n" +
                        "(==== Булочка ====)\n\n" +
                        "Price: 55,000000\n",
                receipt);
    }

}