
import org.junit.Test;

import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import praktikum.Bun;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class BunPriceTest{

    private final String name;
    private final float price;
    Bun bun;

    public BunPriceTest(String name, float price) throws IllegalArgumentException{
        this.name = name;
        this.price = price;
    }

    @Parameterized.Parameters
    public static Object[][] getBunParams(){
        return new Object[][]{
                {"black bun", 100f},
                {"black bun", 0f},
                {"black bun", 24.5f},
                {"black bun", Float.NEGATIVE_INFINITY},
                {"black bun", Float.NaN},
                {"black bun", Float.MIN_VALUE},
                {"black bun", Float.MAX_VALUE},
        };
    }

    @Test
    public void getPriceBun(){
        bun = new Bun(name, price);
        float request = bun.getPrice();
        assertEquals(price, request, 0.0001);
    }


}
