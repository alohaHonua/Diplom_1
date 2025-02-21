import praktikum.Bun;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

@RunWith(Parameterized.class)
public class BunTest {

    private String bunName;
    private float bunPrice;
    private Bun bun;

    public BunTest(String name, float price) {
        this.bunName = name;
        this.bunPrice = price;
    }

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][] {
                { "black bun", 100 },
                { "white bun", 120 },
                { "whole grain bun", 150 }
        });
    }

    @Test
    public void testGetName() {
        bun = new Bun(bunName, bunPrice);
        Assert.assertEquals(bunName, bun.getName());
    }

    @Test
    public void testGetPrice() {
        bun = new Bun(bunName, bunPrice);
        Assert.assertEquals(bunPrice, bun.getPrice(), 0.0f);
    }

}