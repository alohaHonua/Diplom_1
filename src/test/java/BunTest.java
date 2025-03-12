import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import praktikum.Bun;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class BunTest {
    private final Bun bun;
    private final String name;
    private final float price;

    public BunTest(String name, float price){
        bun = new Bun(name, price);
        this.name = name;
        this.price = price;
    }

    @Parameterized.Parameters(name="Название - {0}, цена - {1}")
    public static Object[][] getData(){
        return new Object[][]{
                {"Булка", 10},
                {null, 10},
                {"", 10},
                {"БулкаБулкаБулкаБулкаБулкаБулкаБулкаБулкаБулкаБулка", 10},
                {"Булка#@&", 10},
                {"Булка", 0},
                {"Булка", 0.1F},
                {"Булка", -0.1F},
                {"Булка", -10},
                {"Булка", 1000000}
        };
    }

    @Test
    public void getNameBunTest(){
        String actualName = bun.getName();
        assertEquals("Имя булки отличается от ожидаемого", name, actualName);
    }

    @Test
    public void getPriceBunTest(){
        float actualPrice = bun.getPrice();
        assertEquals("Цена за булку отличается от ожидаемой", price, actualPrice,0);
    }
}