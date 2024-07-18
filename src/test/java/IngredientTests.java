import org.apache.commons.lang3.RandomStringUtils;
import org.junit.Assert;
import org.junit.Test;
import praktikum.Ingredient;
import praktikum.IngredientType;

import java.util.Random;

public class IngredientTests {
    Random random = new Random(); // Генератор случайных чисел
    public IngredientType type = IngredientType.SAUCE; // Тип ингредиента (соус)
    public String name = RandomStringUtils.randomAlphabetic(5,15); // Случайное имя ингредиента длиной от 5 до 15 символов
    public float price = random.nextFloat() + 10; // Случайная цена ингредиента, начиная с 10

    @Test
    public void testType(){
        Ingredient ingredient = new Ingredient(type, name, price); // Создаем объект ингредиента

        Assert.assertEquals(type, ingredient.getType()); // Проверяем, что тип ингредиента соответствует ожидаемому типу
    }

    @Test
    public void testName(){
        Ingredient ingredient = new Ingredient(type, name, price); // Создаем объект ингредиента

        Assert.assertEquals(name, ingredient.getName()); // Проверяем, что имя ингредиента соответствует ожидаемому имени
    }

    @Test
    public void testPrice(){
        Ingredient ingredient = new Ingredient(type, name, price); // Создаем объект ингредиента

        Assert.assertEquals(price, ingredient.getPrice(), 0.001); // Проверяем, что цена ингредиента соответствует ожидаемой цене с точностью до 0.001
    }
}