import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import praktikum.Bun;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class BunParamTest {

private final String name;
private final float price;

    public BunParamTest(String name, float price) {
        this.name = name;
        this.price = price;
    }

    @Parameterized.Parameters()
    public static Object[][] getNameAndPriceBun(){
    return new Object[][] {
            {"Батон", 1.5F},
            {"Broun", 3}

    };
}

@Test
public void checkName() {
    Bun bun = new Bun(name, price);
    String actualName = bun.getName();
    assertEquals(name, actualName);
}

@Test
public void checkPrice() {
    Bun bun = new Bun(name, price);
    float delta = 0.1F;
    float actualPrice = bun.getPrice();
    assertEquals(price, actualPrice, delta);
}
}