import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import praktikum.Bun;
import praktikum.Database;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.*;

@RunWith(Parameterized.class)
public class BunTest {
    private String name;
    private float price;
    private static final float DELTA = 0.0001f;

    public BunTest(String name, float price) {
        this.name = name;
        this.price = price;
    }

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        Database db = new Database();
        return Arrays.asList(new Object[][]{
                {db.availableBuns().get(0).getName(), db.availableBuns().get(0).getPrice()},
                {db.availableBuns().get(1).getName(), db.availableBuns().get(1).getPrice()},
                {db.availableBuns().get(2).getName(), db.availableBuns().get(2).getPrice()}
        });
    }

    @Test
    public void bunConstructorShouldCorrectlySetNameTest() {
        Bun bun = new Bun(name,price);
        assertEquals(name, bun.getName());
    }

    @Test
    public void bunConstructorShouldCorrectlySetPriceTest() {
        Bun bun = new Bun(name, price);
        assertEquals(price, bun.getPrice(), DELTA);
    }

    @Test
    public void bunGetNameShouldReturnTheSameValueTest() {
        Bun bun = new Bun(name,price);
        String bunName = bun.getName();
        assertEquals(name, bunName);
    }

    @Test
    public void bunGetPriceShouldReturnTheSameValueTest() {
        Bun bun = new Bun(name,price);
        float bunPrice = bun.getPrice();
        assertEquals(price, bunPrice, DELTA);
    }

    @Test
    public void bunNullNameTest() {
        Bun bun = new Bun(null, 100.0f);
        assertNull(bun.getName());
    }
}
