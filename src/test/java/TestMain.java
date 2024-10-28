import org.junit.Test;
import praktikum.Praktikum;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

public class TestMain {
    @Test
    public void testMainPracticum(){
        try {
            Praktikum.main(new String[]{});
        } catch (Exception e){
            fail("No exceptions should be thrown there!");
        }

    }
    @Test
    public void testPracticumConstructor(){
        try {
            Praktikum praktikum = new Praktikum();
            assertEquals("Got wrong class out of constructor", Praktikum.class, praktikum.getClass());
        } catch (Exception e){
            fail("No exceptions should be thrown there!");
        }
    }
}
