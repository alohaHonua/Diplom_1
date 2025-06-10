import org.junit.Before;
import org.junit.Test;
import praktikum.Bun;

import static org.junit.Assert.assertEquals;

public class BunTest {

    private Bun bunWithOnion;

    @Before
    public void setUp(){
        bunWithOnion = new Bun("Булочка с луком", 123);
    }

    @Test
    public void testGetName(){
        assertEquals("Булочка с луком",bunWithOnion.getName());
    }

    @Test
    public void testGetPrice(){
        assertEquals(123,bunWithOnion.getPrice(),0);
    }
}
