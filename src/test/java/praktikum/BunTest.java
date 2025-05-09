package praktikum;

import org.junit.Test;

import static org.junit.Assert.*;

public class BunTest {
    Bun bun = new Bun("Black", 7.99F);

    @Test
    public void checkGetName() {
        assertEquals("Black", bun.getName());
    }

    @Test
    public void checkGetPrice(){
        assertEquals(7.99, bun.getPrice(), 0.1);
    }



}
