import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import praktikum.Bun;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BunTest {
    private Bun bun;

    @BeforeEach
    void setUp() {
        bun = new Bun("Булочка с корицей", 150.0f);
    }

    @Test
    void testGetName() {
        assertEquals("Булочка с корицей", bun.getName());
    }

    @Test
    void testGetPrice() {
        assertEquals(150, bun.getPrice());
    }
}
