import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import praktikum.*;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

@RunWith(MockitoJUnitRunner.class)
public class BurgerTests {

    @Mock
    private Bun bun;

    @Mock
    private Ingredient ingredient;

    @Mock
    private Ingredient ingredient2;

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

    @Test
    public void moveIngredientTest(){
        //Этим тестом проверяем работу метода moveIngredient, добавляем два ингредиента в список, меняем их индексы, проверяем переместился ли ingredient2 на индекс 0
        Burger burger = new Burger();
        burger.addIngredient(ingredient);
        burger.addIngredient(ingredient2);
        burger.moveIngredient(1, 0);
        assertEquals(ingredient2, burger.ingredients.get(0));
    }

    @Test
    public void getPriceTest(){
        //Этим тестом проверяем работу метода getPrice, устанавливаем возвращаемые значения наших моков, передаём моки в класс бургер, сравниваем возвращаемое значение метода getPrice с ожидаемым результатом
        float bunPrice = 10.5f;
        float ingredientPrice = 5.5f;
        float expected = bunPrice * 2 + ingredientPrice;
        Burger burger = new Burger();
        Mockito.when(bun.getPrice()).thenReturn(bunPrice);
        Mockito.when(ingredient.getPrice()).thenReturn(ingredientPrice);
        burger.setBuns(bun);
        burger.addIngredient(ingredient);
        assertEquals(expected, burger.getPrice(), 0);
    }

    @Test
    public void getReceiptTest(){
        //Этим тестом проверяем работу метода getReceipt
        Mockito.when(bun.getName()).thenReturn("Булка для бургера из котов");
        Mockito.when(bun.getPrice()).thenReturn(10f);
        Mockito.when(ingredient.getName()).thenReturn("Котлета из каса");
        Mockito.when(ingredient.getPrice()).thenReturn(5f);
        Mockito.when(ingredient.getType()).thenReturn(IngredientType.FILLING);
        Mockito.when(ingredient2.getName()).thenReturn("Котлета из маси");
        Mockito.when(ingredient.getPrice()).thenReturn(15f);
        Mockito.when(ingredient2.getType()).thenReturn(IngredientType.FILLING);
        Burger burger = new Burger();
        burger.setBuns(bun);
        burger.addIngredient(ingredient);
        burger.addIngredient(ingredient2);
        Assert.assertEquals(exceptionReceipt(), burger.getReceipt());
    }

    public String exceptionReceipt(){
        //Метод для получения ожидаемого рецепта
        Mockito.when(bun.getName()).thenReturn("Булка для бургера из котов");
        Mockito.when(bun.getPrice()).thenReturn(10f);
        Mockito.when(ingredient.getName()).thenReturn("Котлета из каса");
        Mockito.when(ingredient.getPrice()).thenReturn(5f);
        Mockito.when(ingredient.getType()).thenReturn(IngredientType.FILLING);
        Mockito.when(ingredient2.getName()).thenReturn("Котлета из маси");
        Mockito.when(ingredient.getPrice()).thenReturn(15f);
        Mockito.when(ingredient2.getType()).thenReturn(IngredientType.FILLING);

        StringBuilder receipt = new StringBuilder(String.format("(==== %s ====)%n", bun.getName()));
        receipt.append(String.format("= %s %s =%n", ingredient.getType().toString().toLowerCase(), ingredient.getName()));
        receipt.append(String.format("= %s %s =%n", ingredient2.getType().toString().toLowerCase(), ingredient2.getName()));
        receipt.append(String.format("(==== %s ====)%n", bun.getName()));
        receipt.append(String.format("%nPrice: %f%n", 35.000000f));

        return receipt.toString();
    }

}
