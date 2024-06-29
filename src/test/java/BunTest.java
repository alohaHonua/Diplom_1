
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;
import praktikum.Bun;

import static org.junit.Assert.assertEquals;


@RunWith(MockitoJUnitRunner.class)
public class BunTest{


    @Test
    public void testGetName() {
        Bun bun = new Bun("Булочка с маком", 200);
       bun.getName();
        assertEquals("Булочка с маком", bun.getName());
    }

    @Test
    public void testGetPrice(){
        float actual;
        Bun bun = new Bun("Булочка с маком", 7000);
       actual = bun.getPrice();
        assertEquals(200, actual, 7000);
    }
}
