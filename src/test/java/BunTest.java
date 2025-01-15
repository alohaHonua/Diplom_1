import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;
import praktikum.Bun;

@RunWith(MockitoJUnitRunner.class)
public class BunTest {
    private Bun bun;

    @Before
    public void setUp() {
        bun = new Bun("white", 100);
    }


    @Test
    public void BunGetName() {
        String getExpectedName = bun.getName();
        Assert.assertEquals(getExpectedName, "white");
    }

    @Test
    public void BunGetPrice() throws Exception {
        float getExpectedPrice = bun.getPrice();
        Assert.assertEquals(getExpectedPrice, 100, 0);
    }

}
