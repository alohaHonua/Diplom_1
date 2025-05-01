import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import praktikum.Bun;

import static org.junit.jupiter.api.Assertions.*;

class BunTest {

    @ParameterizedTest
    @CsvSource({
            "Black Bun, 100",
            "White Bun, 200",
            "Red Bun, 300"
    })
    void testBunConstructorAndGetters(String name, float price) {
        Bun bun = new Bun(name, price);

        assertEquals(name, bun.getName());
        assertEquals(price, bun.getPrice(), 0.001);
    }

    @Test
    void testBunWithEmptyName() {
        Bun bun = new Bun("", 150);

        assertEquals("", bun.getName());
        assertEquals(150, bun.getPrice(), 0.001);
    }

    @Test
    void testBunWithZeroPrice() {
        Bun bun = new Bun("Zero Bun", 0);

        assertEquals("Zero Bun", bun.getName());
        assertEquals(0, bun.getPrice(), 0.001);
    }
}