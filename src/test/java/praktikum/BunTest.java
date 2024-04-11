package praktikum;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.apache.commons.lang3.RandomStringUtils;

import java.util.Random;

public class BunTest {
    public Bun bun;
    Random random = new Random();
    private final float expectedPrice = random.nextFloat() * 100;
    private final String expectedName = RandomStringUtils.randomAlphabetic(10);

    @Before
    public void bunCreator() {
        bun = new Bun(expectedName, expectedPrice);
    }

    @Test
    public void checkGetBunName() {
        Assert.assertEquals(expectedName, bun.getName());
    }

    @Test
    public void checkGetBunPrice() {
        Assert.assertEquals(expectedPrice, bun.getPrice(), 1.0);
    }
}
