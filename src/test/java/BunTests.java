import org.junit.Before;
import org.junit.Test;
import praktikum.Bun;

import static org.junit.Assert.*;

public class BunTests {

    private Bun bunWithVinaigrette;

    @Before
    public void setUp() {
        bunWithVinaigrette = new Bun("Булочка с винегретом", 99999999999.9f);
    }

    @Test
    public void testGetName() {
        assertEquals("Булочка с винегретом", bunWithVinaigrette.getName());
    }

    @Test
    public void testGetPrice() {
        assertEquals(99999999999.9f, bunWithVinaigrette.getPrice(), 0.0f);
    }

}