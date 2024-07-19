package praktikum;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.Assert.*;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class BurgerTest {

    Burger burger;

    @Mock
    Bun bun;

    @Mock
    Ingredient ingredient1;
    @Mock
    Ingredient ingredient2;

    @Before
    public void createBurger() {
        //Создаем объект класса Burger, который будет использоваться во всех тестах текущего класса
        burger = new Burger();
    }

    @Test
    public void checkSetBuns() {

        //Задаем значение объекта Bun для класса Burger через проверяемый метод
        burger.setBuns(bun);

        //Проверяем, что после отработки объект Bun был задан верно
        assertEquals("Объекты bun не совпадают", bun, burger.bun);
    }

    @Test
    public void checkAddIngredient() {

        //Добавляем ингредиент в список ingredients класса бургер
        burger.addIngredient(ingredient1);
        //Проверяем, что ингредиент успешно добавлен в список
        assertTrue("В списке ингредиентов отсутствует добавленный ранее ингредиент", burger.ingredients.contains(ingredient1));
    }

    @Test
    public void checkRemoveIngredient() {

        //Добавляем ингредиент в список ingredients класса бургер
        burger.addIngredient(ingredient1);
        //Убедились, что ингредиент успешно добавлен в список
        assertTrue("В списке ингредиентов отсутствует добавленный ранее ингредиент. Дальнейшее выполнение теста невозможно", burger.ingredients.contains(ingredient1));

        //Удаляем, добавленный ингредиент из списка
        burger.removeIngredient(0);
        //Проверяем, что ингредиент отсутствует в списке
        assertFalse("В списке ингредиентов присутствует удаленный ранее ингредиент", burger.ingredients.contains(ingredient1));
    }

    @Test
    public void checkMoveIngredient() {

        //Добавляем два ингредиента в список ingredients класса бургер
        burger.addIngredient(ingredient1);
        burger.addIngredient(ingredient2);

        //Проверяем, что оба ингредиента успешно добавлены в список
        assertTrue("В списке ингредиентов отсутствует добавленный ранее ингредиент. Дальнейшее выполнение теста невозможно", burger.ingredients.contains(ingredient1));
        assertTrue("В списке ингредиентов отсутствует добавленный ранее ингредиент. Дальнейшее выполнение теста невозможно", burger.ingredients.contains(ingredient2));

        //Перемещаем ингредиент1 с 0 на 1
        burger.moveIngredient(0,1);

        //Получаем ингредиент с индексом 1
        Ingredient actualIngredient1 = burger.ingredients.get(1);
        //Проверяем, что ингредиент с индексом 1 - ингредиент1, который ранее имел индекс 0
        assertEquals("Ожидаемый ингредиент отсутствует на ожидаемом месте в списке. " +
                "Перемещение ингредиентов сработало некорректно", ingredient1, actualIngredient1);
    }

    @Test
    public void checkGetPrice() {
        //Значения для моков
        when(bun.getPrice()).thenReturn(100.0F);
        when(ingredient1.getPrice()).thenReturn(200.F);
        when(ingredient2.getPrice()).thenReturn(300.F);

        //Добавляем в бургер булку и ингредиенты
        burger.setBuns(bun);
        burger.addIngredient(ingredient1);
        burger.addIngredient(ingredient2);

        //Указываем ожидаемую стоимость
        float expectedPrice = 100.0F * 2 + 200.0F + 300.0F;

        //Вызываем тестируемый метод расчета цены
        float actualPrice = burger.getPrice();
        //Проверяем, что стоимость соответствует ожидаемой
        assertEquals("Ожидаемая стоимость бургера не соответствует фактической", expectedPrice, actualPrice,0);


    }

    @Test
    public void checkGetReceipt() {
        //Значения для моков
        when(bun.getName()).thenReturn("black bun");
        when(bun.getPrice()).thenReturn(100.0F);
        when(ingredient1.getType()).thenReturn(IngredientType.SAUCE);
        when(ingredient1.getPrice()).thenReturn(200.F);
        when(ingredient1.getName()).thenReturn("sour cream");
        when(ingredient2.getType()).thenReturn(IngredientType.FILLING);
        when(ingredient2.getName()).thenReturn("sausage");
        when(ingredient2.getPrice()).thenReturn(300.F);


        //Добавляем в бургер булку и ингредиенты
        burger.setBuns(bun);
        burger.addIngredient(ingredient1);
        burger.addIngredient(ingredient2);

        //Ожидаемая строка
        String expectedReceipt = String.format("(==== %s ====)%n= %s %s =%n= %s %s =%n(==== %s ====)%n%nPrice: %f%n",
                "black bun","sauce","sour cream","filling","sausage", "black bun", 700.0F);


        //Вызываем метод getReceipt
        String actualReceipt = burger.getReceipt();

        //Сравниваем ожидаемый и полученный рецепт
        assertEquals("Полученный рецепт не соответствует ожидаемому", expectedReceipt, actualReceipt);
    }
}