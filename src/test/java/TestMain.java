import org.junit.Test;
import praktikum.Praktikum;

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
}
