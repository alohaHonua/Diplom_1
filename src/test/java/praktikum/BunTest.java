package praktikum;
import org.junit.Before;
import org.apache.commons.lang3.RandomStringUtils;

import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import java.util.List;
import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

public class BunTest {
    private String nameBun;
    private float priceBun;
    Bun bun;


    @Before
    public void setUp() {
        nameBun = "TestNameBun_" + RandomStringUtils.randomAlphabetic(4);
        priceBun = (float) (Math.random() * 1000);
        priceBun = Math.round(priceBun * 100) / 100.0f; // Округление до сотых
        bun = new Bun(nameBun, priceBun);
    }

    @Test
    public void testBunGetName() {
        // Проверка что метод возвращает строку "Мяу"
        assertEquals(nameBun, bun.getName());
        System.out.println(nameBun);
    }

    @Test
    public void testBunGetPrice() {
        // Проверка что метод возвращает строку "Мяу"
        assertEquals(priceBun, bun.getPrice(), 0.01f);
        System.out.println(priceBun);
    }



}
