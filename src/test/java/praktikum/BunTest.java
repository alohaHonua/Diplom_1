package praktikum;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

@RunWith(Parameterized.class)

public class BunTest {
    private Bun bun;
    private String name;
    private float price;
    public BunTest(String name, float price) {
        this.name = name;
        this.price = price;
    }

    @Parameterized.Parameters(name = "Название и цена булки. Тестовые данные: {0}, {1}")
    public static Object[][] getData() {
        return new Object[][] {
                {"black bun", 100},
                {"f", 200},
                {"black bun", 0},
                {"", 100},
                {"black bun", -1},
                {null, 150},
                {"ДлиннаяСтрокаДлиннаяСтрокаДлиннаяСтрокаДлиннаяСтрока", 100},
                {"'_спец.символы&?", 50},
                {" ", 150}
        };
    }

    @Before
    public void init() {
        bun = new Bun(name, price);
    }

    @Test
    public void checkGetName() {
        String actual = bun.getName();
        Assert.assertEquals("Наименования не совпадают",name, actual);
    }

    @Test
    public void checkGetPrice() {
        float actual = bun.getPrice();
        Assert.assertEquals("Цены не совпадают",price, actual, 0.001);
    }
}