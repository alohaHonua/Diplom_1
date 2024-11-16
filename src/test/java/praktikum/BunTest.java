package praktikum;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class BunTest {

    private Bun bun;

    @Before
    public void setUp() {
        bun = new Bun("Флюоресцентная булка R2-D3", 988);
    }

    @Test
    public void getNameTest(){
        String expected = "Флюоресцентная булка R2-D3";
        String actual= bun.getName();
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void getPriceTest(){
        float expected = 988;
        float actual= bun.getPrice();
        Assert.assertEquals(expected, actual, 0.0001);
    }
}