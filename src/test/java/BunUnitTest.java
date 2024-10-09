import org.junit.Assert;
import org.junit.Test;
import praktikum.Bun;

public class BunUnitTest {
Bun bun = new Bun("white bun", 200F);

@Test
    public void doesGetNameReturnsCorrectValue(){
    String expectedName = bun.name;
    String actualName = bun.getName();
    Assert.assertEquals(expectedName, actualName);
}

@Test
    public void doesGetPriceReturnsCorrectValue(){
    float expectedPrice = bun.price;
    float actualPrice = bun.getPrice();
    Assert.assertEquals(expectedPrice, actualPrice, 0.001);
}
}
