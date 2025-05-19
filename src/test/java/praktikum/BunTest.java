package praktikum;

import org.junit.Test;
import org.mockito.Spy;

import static org.junit.Assert.*;

public class BunTest {
    private static final String nameBun = "Black";
    private static final float priceBun = 7.99F;

    @Spy
    Bun bun = new Bun(nameBun, priceBun);

    @Test
    //проверяем метод getName
    public void checkGetNameTest() {
        assertEquals("Ожидаемое имя булки не совпадает с фактическим",nameBun, bun.getName());
    }

    @Test
    //проверяем метод getPrice
    public void checkGetPriceTest(){
        assertEquals("Ожидаемая цена булки не совпадает с фактической", priceBun, bun.getPrice(), 0);
    }

}
