import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;
import praktikum.Bun;
import praktikum.Burger;
import praktikum.Ingredient;
import praktikum.IngredientType;

import static org.junit.Assert.assertEquals;

public class BurgerTest {

    private Burger burger;
    private Bun bun;
    private Ingredient ingredient1;
    private Ingredient ingredient2;

    @Before
    public void setUp() {
        burger = new Burger();
        bun = Mockito.mock(Bun.class);
        ingredient1 = Mockito.mock(Ingredient.class);
        ingredient2 = Mockito.mock(Ingredient.class);
    }

    @Test
    public void testSetBuns() {
        // Настройка мока
        Mockito.when(bun.getPrice()).thenReturn(1.5f);
        Mockito.when(bun.getName()).thenReturn("Sesame Bun");

        // Установка булочки
        burger.setBuns(bun);

        // Проверка, что булочка установлена
        assertEquals(bun, burger.bun);
    }

    @Test
    public void testAddIngredient() {
        // Настройка мока
        Mockito.when(ingredient1.getPrice()).thenReturn(0.5f);
        Mockito.when(ingredient1.getName()).thenReturn("Lettuce");
        Mockito.when(ingredient1.getType()).thenReturn(IngredientType.FILLING); // Используем IngredientType

        // Добавление ингредиента
        burger.addIngredient(ingredient1);

        // Проверка, что ингредиент добавлен
        assertEquals(1, burger.ingredients.size());
        assertEquals(ingredient1, burger.ingredients.get(0));
    }

    @Test
    public void testRemoveIngredient() {
        // Настройка мока
        Mockito.when(ingredient1.getPrice()).thenReturn(0.5f);
        Mockito.when(ingredient2.getPrice()).thenReturn(0.7f);
        burger.addIngredient(ingredient1);
        burger.addIngredient(ingredient2); // Добавляем второй ингредиент

        // Удаление ингредиента
        burger.removeIngredient(0);

        // Проверка, что ингредиент удален
        assertEquals(1, burger.ingredients.size());
        assertEquals(ingredient2, burger.ingredients.get(0));
    }

    @Test
    public void testMoveIngredient() {
        // Настройка мока
        Mockito.when(ingredient1.getPrice()).thenReturn(0.5f);
        Mockito.when(ingredient2.getPrice()).thenReturn(0.7f);
        burger.addIngredient(ingredient1);
        burger.addIngredient(ingredient2);

        // Перемещение ингредиента
        burger.moveIngredient(0, 1);

        // Проверка, что ингредиенты перемещены
        assertEquals(ingredient2, burger.ingredients.get(0));
        assertEquals(ingredient1, burger.ingredients.get(1));
    }

    @Test
    public void testGetPrice() {
        // Настройка мока
        Mockito.when(bun.getPrice()).thenReturn(1.5f);
        Mockito.when(ingredient1.getPrice()).thenReturn(0.5f);
        burger.setBuns(bun);
        burger.addIngredient(ingredient1);

        // Проверка цены
        assertEquals(3.5f, burger.getPrice(), 0.01);
    }

    @Test
    public void testGetReceipt() {
        // Настройка мока для булки
        Mockito.when(bun.getPrice()).thenReturn(1.5f);
        Mockito.when(bun.getName()).thenReturn("Sesame Bun");

        // Настройка мока для первого ингредиента
        Mockito.when(ingredient1.getName()).thenReturn("Lettuce");
        Mockito.when(ingredient1.getType()).thenReturn(IngredientType.FILLING);
        Mockito.when(ingredient1.getPrice()).thenReturn(0.5f);

        // Настройка мока для второго ингредиента
        Ingredient ingredient2 = Mockito.mock(Ingredient.class);
        Mockito.when(ingredient2.getName()).thenReturn("Tomato");
        Mockito.when(ingredient2.getType()).thenReturn(IngredientType.FILLING);
        Mockito.when(ingredient2.getPrice()).thenReturn(0.3f);

        // Установка булки и ингредиентов в бургер
        burger.setBuns(bun);
        burger.addIngredient(ingredient1);
        burger.addIngredient(ingredient2);

        // Получение чека
        String expectedReceipt = "(==== Sesame Bun ====)\n" +
                "= filling Lettuce =\n" +
                "= filling Tomato =\n" +
                "(==== Sesame Bun ====)\n" +
                "\nPrice: 3,800000\n";

        // Проверка
        String actualReceipt = burger.getReceipt();

        // Вывод для отладки
        System.out.println("Expected:\n" + expectedReceipt);
        System.out.println("Actual:\n" + actualReceipt);
        System.out.println("Expected length: " + expectedReceipt.length());
        System.out.println("Actual length: " + actualReceipt.length());

        // Проверка
        assertEquals(expectedReceipt.replaceAll("\\s+", ""), actualReceipt.replaceAll("\\s+", ""));
    }
}