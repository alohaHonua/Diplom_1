package praktikum;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class BunTest {

    @Test
    public void getNameReturnsCorrectName() {
        String expectedName = "Булочка для бургера";
        Bun bun = new Bun(expectedName, 100.0f);
        String actualName = bun.getName();
        assertEquals("Метод getName() должен возвращать правильное имя булочки", 
                    expectedName, actualName);
    }

    @Test
    public void getPriceReturnsCorrectPrice() {
        float expectedPrice = 120.5f;
        Bun bun = new Bun("Булочка", expectedPrice);
        float actualPrice = bun.getPrice();
        assertEquals("Метод getPrice() должен возвращать правильную цену булочки", 
                    expectedPrice, actualPrice, 0.001f);
    }
    
    @Test
    public void getNameReturnsLongName() {
        String expectedName = "randomlongnamerandomlongnamerandomlongnamerandomlongnamerandomlongnamerandomlongnamerandomlongnamerandomlongnamerandomlongnamerandomlongnamerandomlongnamerandomlongnamerandomlongnamerandomlongnamerandomlongnamerandomlongnamerandomlongnamerandomlongnamerandomlongname";
        Bun bun = new Bun(expectedName, 100.0f);
        String actualName = bun.getName();
        assertEquals("Метод getName() должен корректно возвращать длинное имя булочки", 
                    expectedName, actualName);
    }
    
    @Test
    public void getNameReturnsNameWithSpecialCharacters() {
        String expectedName = "Булочка !@#$%^&*()_+-={}[]|\\:;\"'<>,.?/";
        Bun bun = new Bun(expectedName, 100.0f);
        String actualName = bun.getName();
        assertEquals("Метод getName() должен корректно возвращать имя булочки со спецсимволами", 
                    expectedName, actualName);
    }
    
    @Test
    public void getNameReturnsEmptyName() {
        String expectedName = "";
        Bun bun = new Bun(expectedName, 100.0f);
        String actualName = bun.getName();
        assertEquals("Метод getName() должен корректно возвращать пустое имя булочки", 
                    expectedName, actualName);
    }
    
    @Test
    public void getNameReturnsNameWithNumbers() {
        String expectedName = "12345";
        Bun bun = new Bun(expectedName, 100.0f);
        String actualName = bun.getName();
        assertEquals("Метод getName() должен корректно возвращать имя булочки из цифр", 
                    expectedName, actualName);
    }
    
    @Test
    public void getPriceReturnsZeroPrice() {
        float expectedPrice = 0.0f;
        Bun bun = new Bun("Бесплатная булочка", expectedPrice);
        float actualPrice = bun.getPrice();
        assertEquals("Метод getPrice() должен корректно возвращать нулевую цену булочки", 
                    expectedPrice, actualPrice, 0.001f);
    }
    
    @Test
    public void getPriceReturnsNegativePrice() {
        float expectedPrice = -50.0f;
        Bun bun = new Bun("Булочка со скидкой", expectedPrice);
        float actualPrice = bun.getPrice();
        assertEquals("Метод getPrice() должен корректно возвращать отрицательную цену булочки", 
                    expectedPrice, actualPrice, 0.001f);
    }
    
    @Test
    public void getPriceReturnsLargePrice() {
        float expectedPrice = 999999.99f;
        Bun bun = new Bun("Очень дорогая булочка", expectedPrice);
        float actualPrice = bun.getPrice();
        assertEquals("Метод getPrice() должен корректно возвращать очень большую цену булочки", 
                    expectedPrice, actualPrice, 0.001f);
    }
} 