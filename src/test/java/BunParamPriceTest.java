import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import praktikum.Bun;
import static org.junit.Assert.assertEquals;


@RunWith(Parameterized.class)
public class BunParamPriceTest {

    private final float expectedPrice;
    private final float price;

    public BunParamPriceTest(float expectedPrice, float price) {
        this.expectedPrice = expectedPrice;
        this.price = price;
    }

    @Parameterized.Parameters(name = "expectedPrice = {0}, price = {1}")
    public static Object[][] getData() {
        return new Object[][]{
                {1255f, 1255f},
                {-5.0f, -5.0f},
                {0.0f, 0.0f},
                {0.01f, 0.01f},
                {Float.MAX_VALUE, Float.MAX_VALUE}
        };
    }

    @Test
    public void getPriceForBunReturnCorrectPriceTest() {
        Bun bun = new Bun("Краторная булка", price);
        float actualResult = bun.getPrice();
        assertEquals("Ожидаемый результат = " + expectedPrice + ", а должен быть = " + actualResult, expectedPrice, actualResult, 0.0001f);
    }
}

