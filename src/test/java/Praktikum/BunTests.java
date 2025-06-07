package Praktikum;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import praktikum.Bun;
import static org.junit.Assert.assertEquals;

public class BunTests {

    Bun bun;

    @Before
    public void setUp() {
        bun = new Bun("Флюоресцентная булка R2-D3", 988.0f);
    }

    @After
    public void tearDown() {
        bun = null;
    }

    @Test
    public void checkGetName() {
        assertEquals("Флюоресцентная булка R2-D3", bun.getName());
    }

    @Test
    public void checkGetPrice() {
        assertEquals(988.0f, bun.getPrice(), 0.01);
    }
}