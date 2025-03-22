import org.junit.Test;
import praktikum.Bun;
import static org.junit.Assert.assertEquals;

public class BunTest {
    Bun bun = new Bun("Краторная булка N-200i", 1255);

    @Test
    public void checkGetNameBun(){
        String expectedName = "Краторная булка N-200i";
        String actualName = bun.getName();
        assertEquals("Некорректное название булочки",expectedName, actualName);
    }

    @Test
    public void checkGetPriceBun(){
        float expectedPrice = 1255;
        float actualPrice = bun.getPrice();
        assertEquals("Некорректная цена булочки", expectedPrice, actualPrice, 0);
    }

}
