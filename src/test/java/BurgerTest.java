import praktikum.*;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

public class BurgerTest {

    private Burger burger;
    private Bun mockBun;
    private Ingredient mockIngredient1;
    private Ingredient mockIngredient2;

    @Before
    public void setUp() {
        // Создаем объект тестируемого класса
        burger = new Burger();

        // Создаем моки для булочки и ингредиентов
        mockBun = Mockito.mock(Bun.class);
        mockIngredient1 = Mockito.mock(Ingredient.class);
        mockIngredient2 = Mockito.mock(Ingredient.class);

        // Настраиваем моки
        Mockito.when(mockBun.getName()).thenReturn("Булочка тестовая");
        Mockito.when(mockBun.getPrice()).thenReturn(5.0f);

        Mockito.when(mockIngredient1.getName()).thenReturn("Биокотлета из марсианской Магнолии");
        Mockito.when(mockIngredient1.getPrice()).thenReturn(2.5f);
        Mockito.when(mockIngredient1.getType()).thenReturn(IngredientType.FILLING);

        Mockito.when(mockIngredient2.getName()).thenReturn("Соус традиционный галактический");
        Mockito.when(mockIngredient2.getPrice()).thenReturn(3.0f);
        Mockito.when(mockIngredient2.getType()).thenReturn(IngredientType.SAUCE);
    }

    //Делаем всякое с ингредиентами))
    @Test
    public void testSetBuns() {

        burger.setBuns(mockBun);

        Assert.assertEquals("Метод setBuns() правильно устанавливает булочку", mockBun, burger.bun);
    }

    @Test
    public void testAddIngredient() {

        burger.addIngredient(mockIngredient1);

        Assert.assertEquals("Метод addIngredient() добавляет ингредиент в список", 1, burger.ingredients.size());
        Assert.assertEquals("ингредиент должен быть добавлен корректно", mockIngredient1, burger.ingredients.get(0));
    }

    @Test
    public void testRemoveIngredient() {

        burger.addIngredient(mockIngredient1);
        burger.addIngredient(mockIngredient2);

        burger.removeIngredient(0);

        Assert.assertEquals("Метод removeIngredient() удаляет ингредиент из списка", 1, burger.ingredients.size());
        Assert.assertEquals("ингредиент удаляется корректно", mockIngredient2, burger.ingredients.get(0));
    }

    @Test
    public void testMoveIngredient() {

        burger.addIngredient(mockIngredient1);
        burger.addIngredient(mockIngredient2);

        burger.moveIngredient(1, 0);

        Assert.assertEquals("Метод moveIngredient() перемещает ингредиенты", mockIngredient2, burger.ingredients.get(0));
        Assert.assertEquals("Метод moveIngredient() корректно обновляет список ингредиентов", mockIngredient1, burger.ingredients.get(1));
    }

    //Считаем стоимость бургера
    @Test
    public void testGetPrice() {

        burger.setBuns(mockBun);
        burger.addIngredient(mockIngredient1);
        burger.addIngredient(mockIngredient2);

        float actualPrice = burger.getPrice();

        float expectedPrice = 5.0f * 2 + 2.5f + 3.0f; // Цена булочки * 2 + ингредиенты
        Assert.assertEquals("Метод getPrice() корректно рассчитывает цену", expectedPrice, actualPrice, 0.0f);
    }

    //Получаем чек
    // Тест отключил, т.к jacoco ругается и не делает отчёт, но из-за этого упало покрытие
    @Test
    public void testGetReceipt() {

        burger.setBuns(mockBun);
        burger.addIngredient(mockIngredient1);
        burger.addIngredient(mockIngredient2);

        String actualReceipt = burger.getReceipt();

        // Ожидаемый чек
        String expectedReceipt = "(==== Булочка тестовая ====)\r\n= filling Биокотлета из марсианской Магнолии =\r\n= sauce Соус традиционный галактический =\r\n(==== Булочка тестовая ====)\r\n\r\nPrice: 15,500000\r\n";

        // Не понял почему тут ругается, хотя expected и actual идентичные 
        Assert.assertEquals("Метод getReceipt() должен возвращать корректный чек", expectedReceipt, actualReceipt);
    }
}

