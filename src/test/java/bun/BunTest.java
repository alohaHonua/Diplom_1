package bun;

import net.datafaker.Faker;
import org.junit.Assert;
import org.junit.Test;
import praktikum.Bun;

public class BunTest {
    Faker faker = new Faker();
    private final String typeOfBun = faker.food().ingredient();
    private final float priceBun = faker.random().nextFloat();
    Bun bun = new Bun(typeOfBun, priceBun);

    @Test
    public void getNameTest() {
        Assert.assertEquals(typeOfBun, bun.getName());
    }

    @Test
    public void getPriceTest() {
        Assert.assertEquals(priceBun, bun.getPrice(), 0);
    }
}
