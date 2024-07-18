import org.apache.commons.lang3.RandomStringUtils;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import praktikum.Bun;

import java.util.Random;

public class BunTests {

    private String bunName; // Имя булочки
    private float bunPrice; // Цена булочки
    private Random random; // Генератор случайных чисел

    @Before
    public void setUp() {
        // Это запускается перед каждым тестом
        random = new Random();
        bunName = RandomStringUtils.randomAlphabetic(5, 15); // Создаем случайное имя для булочки
        bunPrice = random.nextFloat() + 10; // Создаем случайную цену для булочки
    }

    @Test
    public void testGetName() {
        // Тестируем метод
        Bun bun = createBun(); // Создаем булочку с случайными именем и ценой
        String actualName = bun.getName(); // Получаем имя булочки
        Assert.assertEquals(bunName, actualName); // Проверяем, что имя совпадает с ожидаемым
    }

    @Test
    public void testGetPrice() {
        // Тестируем метод
        Bun bun = createBun(); // Создаем булочку с случайными именем и ценой
        float actualPrice = bun.getPrice(); // Получаем цену булочки
        Assert.assertEquals(bunPrice, actualPrice, 0.001); // Проверяем, что цена совпадает с ожидаемой с точностью до 0.001
    }

    private Bun createBun() {
        // Создаем новую булочку с текущими значениями имени и цены
        return new Bun(bunName, bunPrice);
    }
}