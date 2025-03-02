package praktikum;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class BurgerTest {

    @Test
    public void checkSetBuns() {
        Bun bun = Mockito.mock(Bun.class);
        Burger burger = new Burger();
        burger.setBuns(bun);
        Assert.assertNotNull(burger.bun);
    }

    @Test
    public void checkAddIngredient() {
        Ingredient ingredient = Mockito.mock(Ingredient.class);
        Burger burger = new Burger();
        burger.addIngredient(ingredient);
        Assert.assertEquals("Не совпадает размер списка", 1, burger.ingredients.size());
    }

    @Test
    public void checkRemoveIngredient() {
        Ingredient ingredient = Mockito.mock(Ingredient.class);
        Burger burger = new Burger();
        burger.addIngredient(ingredient);
        burger.removeIngredient(0);
        Assert.assertTrue("Список ингредиентов не пуст", burger.ingredients.isEmpty());
    }

    @Test
    public void checkMoveIngredient() {
        Ingredient ingredient1 = Mockito.mock(Ingredient.class);
        Ingredient ingredient2 = Mockito.mock(Ingredient.class);

        Burger burger = new Burger();
        burger.addIngredient(ingredient1);
        burger.addIngredient(ingredient2);

        burger.moveIngredient(0,1);
        Assert.assertEquals(ingredient2, burger.ingredients.get(0));
    }

    @Test
    public void checkGetPrice() {

        float priceBun = 10.5f; //цена булочки
        float priceIngredient1 = 4.25f; //цена первого ингредиента
        float priceIngredient2 = 3.25f; //цена второго ингредиента

        Bun bun = Mockito.mock(Bun.class); //мок булочки
        Mockito.when(bun.getPrice()).thenReturn(priceBun); //стаб возвращающий цену булочки
        Ingredient ingredient1 = Mockito.mock(Ingredient.class); //мок первого ингредиента
        Mockito.when(ingredient1.getPrice()).thenReturn(priceIngredient1); //стаб возвращающий цену первого ингредиента
        Ingredient ingredient2 = Mockito.mock(Ingredient.class); //мок второго ингредиента
        Mockito.when(ingredient2.getPrice()).thenReturn(priceIngredient2); //стаб второго ингредиента

        Burger burger = new Burger(); //объект бургер
        burger.setBuns(bun); //инициализация булочки в бургере
        burger.addIngredient(ingredient1); //добавили первый ингредиент в список ингредиентов
        burger.addIngredient(ingredient2); //добавили второй ингредиент в список ингредиентов

        float expectedResult = priceBun*2+priceIngredient1+priceIngredient2; //ОР
        float actualResult = burger.getPrice(); //ФР
        Assert.assertEquals("Ошибка в расчете цены бургера", expectedResult, actualResult,0);
    }

    @Test
    public void checkGetReceipt() {
        String nameBun = "Илон-Масковская"; //название булочки
        float priceBun = 13.666f; //цена булочки
        String nameIngredient1 = "Батарея Теслы"; //название первого ингредиента
        IngredientType typeIngredient1 = IngredientType.FILLING; //тип первого ингредиента
        float priceIngredient1 = 9.99f; //цена первого ингредиента
        String nameIngredient2 = "Республиканский Соус"; //название второго ингредиента
        IngredientType typeIngredient2 = IngredientType.SAUCE; //тип второго ингредиента
        float priceIngredient2 = 6.66f; //цена второго ингредиента

        Bun bun = Mockito.mock(Bun.class); //мок булочки
        Mockito.when(bun.getName()).thenReturn(nameBun); //стаб возвращающий название булочки
        Mockito.when(bun.getPrice()).thenReturn(priceBun); //стаб возвращающий цену булочки
        Ingredient ingredient1 = Mockito.mock(Ingredient.class); //мок первого ингредиента
        Mockito.when(ingredient1.getName()).thenReturn(nameIngredient1); //стаб возвращающий имя первого ингредиента
        Mockito.when(ingredient1.getType()).thenReturn(typeIngredient1); //стаб возвращающий тип первого ингредиента
        Mockito.when(ingredient1.getPrice()).thenReturn(priceIngredient1); //стаб возвращающий цену первого ингредиента
        Ingredient ingredient2 = Mockito.mock(Ingredient.class); //мок первого ингредиента
        Mockito.when(ingredient2.getName()).thenReturn(nameIngredient2); //стаб возвращающий имя второго ингредиента
        Mockito.when(ingredient2.getType()).thenReturn(typeIngredient2); //стаб возвращающий тип второго ингредиента
        Mockito.when(ingredient2.getPrice()).thenReturn(priceIngredient2); //стаб возвращающий цену второго ингредиента

        Burger burger = new Burger(); //объект бургер
        burger.setBuns(bun); //инициализация булочки в бургере
        burger.addIngredient(ingredient1); //добавили первый ингредиент в список ингредиентов
        burger.addIngredient(ingredient2); //добавили второй ингредиент в список ингредиентов

        String expectedResult = String.format("(==== %s ====)%n= %s %s =%n= %s %s =%n(==== %s ====)%n%nPrice: %f%n", nameBun, typeIngredient1.toString().toLowerCase(), nameIngredient1, typeIngredient2.toString().toLowerCase(), nameIngredient2, nameBun, priceBun*2+priceIngredient1+priceIngredient2); //ОР
        String actualResult = burger.getReceipt(); //ФР
        Assert.assertEquals("Чек не совпал", expectedResult, actualResult);
    }
}