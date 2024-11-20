import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import praktikum.Bun;
import praktikum.Database;

import java.util.Arrays;
import java.util.Collection;

@RunWith(Parameterized.class)
public class BunTest {

    private final String expectedName;
    private final float expectedPrice;

    private Bun bun;

    private static Database database;

    public BunTest(String expectedName, float expectedPrice) {
        this.expectedName = expectedName;
        this.expectedPrice = expectedPrice;
    }

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {"black bun", 100.0F},
                {"white bun", 200.0F},
                {"red bun", 300.0F}
        });
    }

    @Before
    public void setUp() {
        database = new Database();
    }

    @Test
    public void testBunInitialization() {
        bun = new Bun(expectedName, expectedPrice);
    }

    @Test
    public void testBunGetName() {
        bun = new Bun(expectedName, expectedPrice);
        Assert.assertEquals(expectedName, bun.getName());
    }

    @Test
    public void testBunGetPrice() {
        bun = new Bun(expectedName, expectedPrice);
        Assert.assertEquals(expectedPrice, bun.getPrice(), 0.001);
    }

}

