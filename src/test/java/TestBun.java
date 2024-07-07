import org.apache.commons.lang3.RandomStringUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import praktikum.Bun;
import java.util.Random;
import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class TestBun {
    private String title;
    private float cost;

    private static RandomStringUtils randomStringUtils = new RandomStringUtils();
    private static Random random = new Random();

    public TestBun(String name, float price) {
        this.title = title;
        this.cost = cost;
    }

    @Parameterized.Parameters
    public static Object[][] getParameters() {
        return new Object[][]{
                {randomStringUtils.randomAlphabetic(10), random.nextFloat()},
                {randomStringUtils.randomAlphabetic(10), 600.000000000F}
        };
    }

    @Test
    public void TestGetTitle() {
        Bun bun = new Bun(title, cost);
        String actual = bun.getName();
        assertEquals(title, actual);
    }

    @Test
    public void TestGetCost() {
        Bun bun = new Bun(title, cost);
        float actual = bun.getPrice();
        assertEquals(cost, actual, 0);
    }

}
