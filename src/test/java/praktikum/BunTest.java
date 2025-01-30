package praktikum;

import com.github.javafaker.Faker;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;


public class BunTest {
    private final Faker faker = new Faker();
    private final String bunName = faker.funnyName().name();
    private final float bunPrice = (float) faker.random().nextDouble();
    private Bun bun;

    @Before
    public void setUp() {
        bun = new Bun(bunName, bunPrice);
    }

    @Test
    public void getName() {
        assertEquals("Bun name is not that we installed", bunName, bun.getName());
    }

    @Test
    public void getPrice() {
        assertEquals("Bun price is not that we installed", 0, Float.compare(bunPrice, bun.getPrice()));
    }
}