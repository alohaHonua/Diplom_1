import praktikum.Bun;
import org.junit.*;

public class BunTest {

    //Проверяет, что конструктор правильно инициализирует поля name и price.
    @Test
    public void testConstructorSetsNameAndPrice() {
        
        String expectedName = "Булочка с кунжутом";
        float expectedPrice = 15.5f;

        Bun bun = new Bun(expectedName, expectedPrice);

        Assert.assertEquals("Конструктор должен корректно устанавливать имя булочки", expectedName, bun.getName());
        Assert.assertEquals("Конструктор должен корректно устанавливать цену булочки", expectedPrice, bun.getPrice(), 0.0f);
    }

    //Проверяеv, что метод getName() возвращает корректное значение
    @Test
    public void testGetNameReturnsCorrectValue() {

        String expectedName = "Цельнозерновая булочка";
        Bun bun = new Bun(expectedName, 14.0f);

        String actualName = bun.getName();

        Assert.assertEquals("Метод getName() возвращает правильное имя", expectedName, actualName);
    }

    //Проверяеv, что метод getPrice() возвращает корректное значение
    @Test
    public void testGetPriceReturnsCorrectValue() {

        float expectedPrice = 6.25f;
        Bun bun = new Bun("Простая булочка", expectedPrice);

        float actualPrice = bun.getPrice();

        Assert.assertEquals("Метод getPrice() возвращает правильную цену", expectedPrice, actualPrice, 0.0f);
    }
}