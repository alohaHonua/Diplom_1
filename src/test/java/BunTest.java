import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import praktikum.Bun;

@RunWith(Parameterized.class)
public class BunTest {
    private final String name;
    private final float price;
    private final Bun bun;

    public BunTest(String name, float price) {
        this.name = name;
        this.price = price;
        this.bun = new Bun(name, price); // Создаем объект Bun с параметрами имени и цены
    }

    @Parameterized.Parameters
    public static Object[][] getBunAndPriceData() {
        return new Object[][]{
                {"black bun", 100.05F},
                {"white bun", 200F},
                {"red bun", 300.50F},
                {"brown bun", 0.00F},
                {"pink bun", 500F},
                {"green bun", 1600.00F},
        };
    }

    @Test
    public void getNameTest() {
        // Проверяем, что имя соответствует ожидаемому
        Assert.assertEquals(name, bun.getName());
    }

    @Test
    public void getPriceTest() {
        // Проверяем, что цена соответствует ожидаемой
        Assert.assertEquals(price, bun.getPrice(), 0.001F); // Указываем дельту для точности
    }
}