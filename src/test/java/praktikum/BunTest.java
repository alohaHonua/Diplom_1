package praktikum;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;


@RunWith(Parameterized.class)
public class BunTest {

    private final String name;
    private final float price;
    private Bun bun;

    private float delta = 0.01f;

    public BunTest(String name, float price) {
        this.name = name;
        this.price = price;
    }

    @Parameterized.Parameters(name = "Bun: {0}, Price: {1}")
    public static Collection<Object[]> getData() {
        return Arrays.asList(new Object[][]{
                {"С маком", 10.0f},
                {"Стандартная", 50.5f},
                {"Темная", 20.0f}
        });
    }

    @Before
    public void setUp() {
      bun = new Bun(name, price);
    }

    @Test
    public void getNameTest(){
        Assert.assertEquals("Ожидаемое имя: " + name,  name, bun.getName());
    }


    @Test
    public void getPriceTest(){
        Assert.assertEquals("Ожидаемая цена:" + price + " =- " + delta,  price, bun.getPrice(), delta);
    }








}
