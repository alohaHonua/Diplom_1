import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import praktikum.Bun;
import praktikum.Burger;
import praktikum.Ingredient;
import praktikum.IngredientType;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

@RunWith(Parameterized.class)
public class BurgerTest {

    private final Bun bun;
    private final Ingredient ingredient;
    private Burger burger;

    // Конструктор для передачи параметров
    public BurgerTest(Bun bun, Ingredient ingredient) {
        this.bun = bun;
        this.ingredient = ingredient;
    }

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {mockBun("Флюоресцентная булка R2-D3", 988), mockIngredient(IngredientType.SAUCE, "Spicy-X", 90)},
                {mockBun("Флюоресцентная булка R2-D3", 988), mockIngredient(IngredientType.FILLING, "Мясо бессмертных моллюсков Protostomia", 1337)},
                {mockBun("Флюоресцентная булка R2-D3", 988), mockIngredient(IngredientType.SAUCE, "Традиционный галактический", 15)},
                {mockBun("Флюоресцентная булка R2-D3", 988), mockIngredient(IngredientType.SAUCE, "С шипами Антарианского плоскоходца", 88)},
        });
    }

    private static Ingredient mockIngredient(IngredientType type, String name, float price) {
        Ingredient mockIngredient = mock(Ingredient.class);
        when(mockIngredient.getType()).thenReturn(type);
        when(mockIngredient.getName()).thenReturn(name);
        when(mockIngredient.getPrice()).thenReturn(price);
        return mockIngredient;
    }

    private static Bun mockBun(String name, float price) {
        Bun mockBun = mock(Bun.class);
        when(mockBun.getName()).thenReturn(name);
        when(mockBun.getPrice()).thenReturn(price);
        return mockBun;
    }

    @Before
    public void setUp() {
        burger = new Burger(); // Создаем бургер
        burger.setBuns(bun); // Добавляем булочку
    }

    @Test // Проверяем, что ингредиент добавляется в бургер
    public void testAddIngredient() {
        burger.addIngredient(ingredient); // Добавление ингредиента
        assertTrue(burger.ingredients.contains(ingredient)); // Проверяем, что ингредиент добавлен
    }

    @Test // Проверяем, что цена рассчитывается правильно
    public void testGetPrice() {
        burger.addIngredient(ingredient); // Добавление ингредиента
        float expectedPrice = bun.getPrice() * 2 + ingredient.getPrice();
        assertEquals(expectedPrice, burger.getPrice(), 0.0f); // Сравниваем фактическую стоимость с ожидаемой
    }

    @Test // Проверяем, что ингредиент удаляется из бургера
    public void testRemoveIngredient() {
        burger.addIngredient(ingredient); // Добавление ингредиента
        burger.removeIngredient(0); // Удаляем ингредиент по индексу
        assertFalse(burger.ingredients.contains(ingredient)); // Проверяем, что ингредиент удалён
    }

    @Test // Проверяем, что ингредиент перемещается в бургер
    public void testMoveIngredient() {
        burger.addIngredient(ingredient); // Добавляем ингредиент
        Ingredient secondIngredient = mockIngredient(IngredientType.FILLING, "Говяжий метеорит (отбивная)", 3000);
        burger.addIngredient(secondIngredient); // Добавляем второй ингредиент

        burger.moveIngredient(0, 1); // Перемещаем первый ингредиент на вторую позицию

        assertEquals(secondIngredient, burger.ingredients.get(0)); // Проверяем, что теперь на первой позиции второй ингредиент
        assertEquals(ingredient, burger.ingredients.get(1)); // Проверяем, что на второй позиции теперь первый ингредиент
    }

    @Test
    public void testGetReceipt() {
        burger.addIngredient(ingredient); // Добавление ингредиента
        String ingredientType = ingredient.getType() == IngredientType.SAUCE ? "Соус:" : "Начинка:";

        String expectedReceipt =
                "(==== " + bun.getName() + " ====)\n" +
                        "= " + ingredientType + " " + ingredient.getName() + " =\n" +
                        "(==== " + bun.getName() + " ====)\n" +
                        "\nЦена: " + String.format("%.2f", burger.getPrice());

        // Сравниваем ожидаемый результат с фактическим
        assertEquals(expectedReceipt, burger.getReceipt());
    }
}