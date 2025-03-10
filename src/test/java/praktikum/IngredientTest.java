package praktikum;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class IngredientTest {

    @Test
    public void getNameReturnsCorrectName() {
        String expectedName = "Сыр";
        Ingredient ingredient = new Ingredient(IngredientType.FILLING, expectedName, 50.0f);
        String actualName = ingredient.getName();
        assertEquals("Метод getName() должен возвращать правильное имя ингредиента", 
                expectedName, actualName);
    }

    @Test
    public void getPriceReturnsCorrectPrice() {
        float expectedPrice = 75.5f;
        Ingredient ingredient = new Ingredient(IngredientType.SAUCE, "Кетчуп", expectedPrice);
        float actualPrice = ingredient.getPrice();
        assertEquals("Метод getPrice() должен возвращать правильную цену ингредиента", 
                expectedPrice, actualPrice, 0.001f);
    }
    
    @Test
    public void getTypeReturnsCorrectType() {
        IngredientType expectedType = IngredientType.FILLING;
        Ingredient ingredient = new Ingredient(expectedType, "Котлета", 120.0f);
        IngredientType actualType = ingredient.getType();
        assertEquals("Метод getType() должен возвращать правильный тип ингредиента", 
                expectedType, actualType);
    }
    
    @Test
    public void getNameReturnsLongName() {
        String expectedName = "randomlongnamerandomlongnamerandomlongnamerandomlongnamerandomlongnamerandomlongnamerandomlongnamerandomlongnamerandomlongnamerandomlongnamerandomlongnamerandomlongnamerandomlongnamerandomlongnamerandomlongnamerandomlongnamerandomlongnamerandomlongname";
        Ingredient ingredient = new Ingredient(IngredientType.FILLING, expectedName, 120.0f);
        String actualName = ingredient.getName();
        assertEquals("Метод getName() должен корректно возвращать длинное имя ингредиента", 
                expectedName, actualName);
    }
    
    @Test
    public void getNameReturnsNameWithSpecialCharacters() {
        String expectedName = "Специальный ингредиент !@#$%^&*()_+-={}[]|\\:;\"'<>,.?/";
        Ingredient ingredient = new Ingredient(IngredientType.FILLING, expectedName, 120.0f);
        String actualName = ingredient.getName();
        assertEquals("Метод getName() должен корректно возвращать имя ингредиента со спецсимволами", 
                expectedName, actualName);
    }
    
    @Test
    public void getNameReturnsEmptyName() {
        String expectedName = "";
        Ingredient ingredient = new Ingredient(IngredientType.FILLING, expectedName, 120.0f);
        String actualName = ingredient.getName();
        assertEquals("Метод getName() должен корректно возвращать пустое имя ингредиента", 
                expectedName, actualName);
    }
    
    @Test
    public void getNameReturnsNameWithNumbers() {
        String expectedName = "12345";
        Ingredient ingredient = new Ingredient(IngredientType.FILLING, expectedName, 120.0f);
        String actualName = ingredient.getName();
        assertEquals("Метод getName() должен корректно возвращать имя ингредиента из цифр", 
                expectedName, actualName);
    }
    
    @Test
    public void getPriceReturnsZeroPrice() {
        float expectedPrice = 0.0f;
        Ingredient ingredient = new Ingredient(IngredientType.SAUCE, "Бесплатный соус", expectedPrice);
        float actualPrice = ingredient.getPrice();
        assertEquals("Метод getPrice() должен корректно возвращать нулевую цену ингредиента", 
                expectedPrice, actualPrice, 0.001f);
    }
    
    @Test
    public void getPriceReturnsNegativePrice() {
        float expectedPrice = -30.0f;
        Ingredient ingredient = new Ingredient(IngredientType.FILLING, "Ингредиент со скидкой", expectedPrice);
        float actualPrice = ingredient.getPrice();
        assertEquals("Метод getPrice() должен корректно возвращать отрицательную цену ингредиента", 
                expectedPrice, actualPrice, 0.001f);
    }
    
    @Test
    public void getPriceReturnsLargePrice() {
        float expectedPrice = 999999.99f;
        Ingredient ingredient = new Ingredient(IngredientType.FILLING, "Очень дорогой ингредиент", expectedPrice);
        float actualPrice = ingredient.getPrice();
        assertEquals("Метод getPrice() должен корректно возвращать очень большую цену ингредиента", 
                expectedPrice, actualPrice, 0.001f);
    }
    
    @Test
    public void getTypeReturnsSauceType() {
        IngredientType expectedType = IngredientType.SAUCE;
        Ingredient ingredient = new Ingredient(expectedType, "Горчица", 50.0f);
        IngredientType actualType = ingredient.getType();
        assertEquals("Метод getType() должен возвращать правильный тип соуса", 
                expectedType, actualType);
    }
    
    @Test
    public void getTypeReturnsFillingType() {
        IngredientType expectedType = IngredientType.FILLING;
        Ingredient ingredient = new Ingredient(expectedType, "Томат", 35.0f);
        IngredientType actualType = ingredient.getType();
        assertEquals("Метод getType() должен возвращать правильный тип начинки", 
                expectedType, actualType);
    }
} 