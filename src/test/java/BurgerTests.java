import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.Spy;
import org.mockito.junit.MockitoJUnitRunner;
import praktikum.*;

import java.util.ArrayList;
import java.util.List;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

@RunWith(MockitoJUnitRunner.class)
public class BurgerTests {

    @Mock
    private Bun bun;

    @Mock
    private Ingredient ingredient;

    @Spy
    private Ingredient ingredientSpyA = new Ingredient(IngredientType.SAUCE, "AA", 11f);

    @Spy
    private Ingredient ingredientSpyB = new Ingredient(IngredientType.SAUCE, "BB", 22f);

    @Test
    public void setBunTestReturnName() {
        //Этим тестом я проверяю корректную работу метода setBuns в классе Burger, если булка установилась можно вернуть её название
        String testValue = "Название булочки";
        Mockito.when(bun.getName()).thenReturn(testValue);
        Burger burger = new Burger();
        burger.setBuns(bun);
        String result = burger.bun.getName();
        assertEquals(testValue, result);
    }

    @Test
    public void setBunTestReturnPrice(){
        //Этим тестом я проверяю корректную работу метода setBuns в классе Burger, если булка установилась можно вернуть её цену
        float testValue = 1300.4f;
        Mockito.when(bun.getPrice()).thenReturn(testValue);
        Burger burger = new Burger();
        burger.setBuns(bun);
        float result = burger.bun.getPrice();
        assertEquals(testValue, result, 0);
    }

    @Test
    public void addIngredientTest(){
        //Этим тестом проверяем корректную работу метода addIngredient, если список не пустой метод работает, если список пуст метод не добавляет ингредиент
        Burger burger = new Burger();
        burger.addIngredient(ingredient);
        boolean expected = false;
        assertEquals(expected, burger.ingredients.isEmpty());
    }

    @Test
    public void addIngredientQuantityTest(){
        //Этим тестом проверяем корректную работу метода addIngredient, в данном случае, что метод добавляет именно один ингредиент
        int expectedQuantity = 1;
        Burger burger = new Burger();
        burger.addIngredient(ingredient);
        assertTrue(expectedQuantity == burger.ingredients.size());
    }

    @Test
    public void removeIngredientTest(){
        //Этим тестом проверяем работу метода removeIngredient, добавляем два ингредиента, удаляем один, сравниваем количество ингредиентов списка с ожидаемым результатом
        int expectedQuantity = 1;
        Burger burger = new Burger();
        burger.addIngredient(ingredient);
        burger.addIngredient(ingredient);
        burger.removeIngredient(1);
        assertTrue(expectedQuantity == burger.ingredients.size());
    }
///----------------------------------------------------------------------------------------
    @Test
    public void moveIngredientTest(){
        //Этим тестом проверяем работу метода moveIngredient, не знаю как убрать зависимость от класса Ingredient, потому что если передавать два замокированных ингредиента не получится вычислить меняет ли индекс метод moveIngredient
        Burger burger = new Burger();
        burger.addIngredient(ingredientSpyA);
        burger.addIngredient(ingredientSpyB);
        burger.moveIngredient(1, 0);
        String expectedName = "BB";
        assertEquals(expectedName, burger.ingredients.get(0).name);
    }
///---------------------------------------------------------------------------------------
}
