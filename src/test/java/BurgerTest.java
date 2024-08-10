import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import praktikum.Bun;
import praktikum.Burger;
import praktikum.Ingredient;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static praktikum.IngredientType.FILLING;
@RunWith(MockitoJUnitRunner.class)
public class BurgerTest {
    private Burger burger;
    @Mock
    private Bun mockBun;
    @Mock
    private Ingredient mockIngredient1;
    @Mock
    private Ingredient mockIngredient2;

    @Before
    public void createObject() {
        burger = new Burger(); // Создать бургер
    }


    @Test
    public void setBunsTest() {
        burger.setBuns(mockBun); // Мок булки
        Bun actualBun = burger.bun;
        assertEquals(mockBun, actualBun);
    }

    @Test
    public void addIngredientTest() {
        burger.addIngredient(mockIngredient1); // Мок ингредиента
        assertTrue("Ингредиент не добавлен в список", burger.ingredients.contains(mockIngredient1)); // Проверка, что в спеске есть ингредиент
        assertEquals("В списке есть лишние ингредиенты", 1, burger.ingredients.size()); // Проверка, что в спеске только добавленный ингредиент
    }

    @Test
    public void removeIngredientTest() {
        burger.addIngredient(mockIngredient1);
        burger.removeIngredient(0); // Вызов метода удаления ингредиента по индексу
        assertTrue("Ингредиент не удалён из списка", burger.ingredients.isEmpty()); // Проверка, что ингридиент удаелен (пустой список)
    }

    @Test
    public void moveIngredientTest() {
        burger.addIngredient(mockIngredient1);
        burger.addIngredient(mockIngredient2); // Второй мок ингредиента
        burger.moveIngredient(0, 1); // Удалили мок по индексу и добавили его на новую позицию
        assertEquals("Неверное расположение ингредиента", mockIngredient1, burger.ingredients.get(1)); // Проверка смены индекса моков
        assertEquals("Неверное расположение ингредиента", mockIngredient2, burger.ingredients.get(0)); // Проверка смены индекса моков
    }

    @Test
    public void getPriceTest() {
        burger.setBuns(mockBun);
        burger.addIngredient(mockIngredient1);
        Mockito.when(mockBun.getPrice()).thenReturn(75.5F); // Стаб для геттера цены булки
        Mockito.when(mockIngredient1.getPrice()).thenReturn(120.5F); // Стаб для геттера цены ингредиента
        float expectedBurgerPrice = 271.5F; // Ожидаемая цена бургера
        float actualBurgerPrice = burger.getPrice(); // Фактическая цена бургера
        assertEquals("Неверная цена бургера", expectedBurgerPrice, actualBurgerPrice, 0.0001F); // Сравнение ожидаемой и фактической цены
    }

    @Test
    public void getReceiptTest() {
        Mockito.when(mockBun.getName()).thenReturn("Stellar burger"); //Стаб для геттера названия булки
        Mockito.when(mockBun.getPrice()).thenReturn(75.5F); // Стаб для геттера цены булки
        Mockito.when(mockIngredient1.getType()).thenReturn(FILLING); // Стаб для геттера типа ингредиента
        Mockito.when(mockIngredient1.getName()).thenReturn("Сыр с астероидной плесенью"); // Стаб для названия ингредиента
        Mockito.when(mockIngredient1.getPrice()).thenReturn(120.5F); // Стаб для геттера цены ингредиента
        burger.setBuns(mockBun);
        burger.addIngredient(mockIngredient1);
        String actualReceipt = burger.getReceipt(); // Фактический формат и текст чека
        // Ожидаемый формат и текст чека
        String expectedReceipt = "(==== Stellar burger ====)\n" +
                "= filling Сыр с астероидной плесенью =\n" +
                "(==== Stellar burger ====)\n" +
                "\n" +
                "Price: 271,500000\n";
        assertEquals("Некорректный чек",expectedReceipt, actualReceipt);
    }
}
