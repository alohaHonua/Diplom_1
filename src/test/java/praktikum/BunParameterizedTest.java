package praktikum;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class BunParameterizedTest {

    @ParameterizedTest
    @CsvSource({
            "Sesame, 25.0",
            "Rye, 30.5",
            "Wheat, 45.0"
    })
    public void testParameterizedConstructor(String name, float price) {
        Bun paramBun = new Bun(name, price);
        Assertions.assertEquals(name, paramBun.getName());
        Assertions.assertEquals(price, paramBun.getPrice(), 0.001f);
    }
}