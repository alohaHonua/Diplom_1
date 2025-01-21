import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import praktikum.Bun;

import java.util.Arrays;
import java.util.Collection;

@RunWith(Parameterized.class)
public class BunTest {

    public String name;
    public float price;

    public BunTest(String name, float price) {
        this.name = name;
        this.price = price;
    }

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {"black bun", 100},       // Позитивный тест
                {"", 100},               // Пустое имя
                {"a".repeat(256), 100},  // Длинное имя
                {"white bun", 0},        // Нулевая цена
                {"red bun", -50},        // Отрицательная цена
                {"green bun", 10.5f},     // Положительная дробная цена
                {"blue bun", 200}         // Позитивный тест
        });
    }

    @Test
    public void testBunName() {
        Bun bun = new Bun(name, price);
        Assert.assertEquals("Имя булочки не совпадает", name, bun.getName());
    }

    @Test
    public void testBunPrice() {
        Bun bun = new Bun(name, price);
        Assert.assertEquals("Цена булочки не совпадает", price, bun.getPrice(), 0);
    }

}
