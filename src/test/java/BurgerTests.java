package praktikum;

import org.hamcrest.MatcherAssert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.*;

@RunWith(MockitoJUnitRunner.class)

public class BurgerTests {

    //  !--- создаем МОК на булку ---!
    @Mock
    private Bun bun;

    //  !--- создаем МОК на первый ингредиент ---!
    @Mock
    private Ingredient ingredientOne;

    //  !--- создаем МОК на второй ингредиент ---!
    @Mock
    private Ingredient ingredientTwo;


    //  !--- Проверяем метод на добавление булки ---!
    @Test
    public void setBunsIsSuccessTest() {
        Burger burger = new Burger();
        Mockito.when(bun.getName()).thenReturn("Космическая булка");
        burger.setBuns(bun);
        MatcherAssert.assertThat("Не удалось добавить новую булку", bun.getName(), equalTo(burger.bun.getName()));
    }

    //  !--- Проверяем метод на добавление ингредиента ---!
    @Test
    public void addIngredientIsSuccessTest() {
        Burger burger = new Burger();
        burger.addIngredient(ingredientOne);
        assertTrue("Не удалось добавить ингредиент", burger.ingredients.contains(ingredientOne));
    }

    //  !--- Проверяем метод на удаление ингредиента ---!
    @Test
    public void removeIngredientIsSuccessTest() {
        Burger burger = new Burger();
        burger.addIngredient(ingredientOne);
        int index = burger.ingredients.indexOf(ingredientOne);
        burger.removeIngredient(index);
        assertFalse("Не удалось удалить ингредиент", burger.ingredients.contains(ingredientOne));

    }

    //  !--- Проверяем метод на перемещение ингредиента ---!
    @Test
    public void moveIngredientIsSuccessTest() {
        Burger burger = new Burger();
        Mockito.when(ingredientOne.getName()).thenReturn("Начинка 1");
        Mockito.when(ingredientTwo.getName()).thenReturn("Начинка 2");
        burger.addIngredient(ingredientOne);
        burger.addIngredient(ingredientTwo);
        burger.moveIngredient(0, 1);
        MatcherAssert.assertThat("Не удалось переместить ингредиент 1", burger.ingredients.get(1).getName(), equalTo("Начинка 1"));
        MatcherAssert.assertThat("Не удалось переместить ингредиент 2", burger.ingredients.get(0).getName(), equalTo("Начинка 2"));
    }

    //  !--- Проверяем метод на формирование цены ---!
    @Test
    public void getPriceIsSuccessTest() {
        Mockito.when(bun.getPrice()).thenReturn(100f);
        Mockito.when(ingredientOne.getPrice()).thenReturn(200f);
        float totalPrice = bun.getPrice() * 2 + ingredientOne.getPrice();
        Burger burger = new Burger();
        burger.setBuns(bun);
        burger.addIngredient(ingredientOne);
        MatcherAssert.assertThat("Стоимость сформирована не верно", totalPrice, equalTo(burger.getPrice()));
    }

    //  !--- Проверяем метод на формирование чека ---!
    @Test
    public void getReceiptIsSuccessTest() {
        Mockito.when(bun.getName()).thenReturn("Космическая булка");
        Mockito.when(bun.getPrice()).thenReturn(100f);
        Mockito.when(ingredientOne.getName()).thenReturn("Начинка 1");
        Mockito.when(ingredientOne.getPrice()).thenReturn(200F);
        Mockito.when(ingredientOne.getType()).thenReturn(IngredientType.FILLING);
        String bunName = bun.getName();
        String ingredientType = ingredientOne.getType().name().toLowerCase();
        String ingredientName = ingredientOne.getName();
        float totalPrice = (bun.getPrice() * 2) + ingredientOne.getPrice();
        String expectedReceipt = String.format("(==== %s ====)%n", bunName) +
                String.format("= %s %s =%n", ingredientType, ingredientName) +
                String.format("(==== %s ====)%n", bunName) +
                String.format("%nPrice: %.6f%n", totalPrice);
        Burger burger = new Burger();
        burger.setBuns(bun);
        burger.addIngredient(ingredientOne);
        MatcherAssert.assertThat("Неверный чек", burger.getReceipt(), equalTo(expectedReceipt));
    }
}