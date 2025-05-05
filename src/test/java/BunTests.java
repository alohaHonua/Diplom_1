import org.junit.Assert;
import org.junit.Test;
import praktikum.Bun;

public class BunTests {

    Bun bun = new Bun("Beef007", 9.99F);

    @Test
    public void checkGetNameMethod() {
        String expectedName = "Beef007";

        Assert.assertEquals("Метод возвращает неправильное имя",expectedName, bun.getName());
    }

    @Test
    public void checkGetPriceMethod() {
        float expectedPrice = 9.99F;

        Assert.assertEquals("Метод возвращает неправильную цену", expectedPrice, bun.getPrice(), 0.01F);
    }
}
