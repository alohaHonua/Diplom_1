import org.junit.Assert;
import praktikum.Bun;
import org.junit.Test;
import static org.junit.Assert.assertEquals;


public class BunTests {

    Bun bun = new Bun("Чиз", 12.3F);

    @Test
    public void getNameTest(){
        String expected = "Чиз";
        Assert.assertEquals(expected, bun.getName());
    }
    @Test
    public void getPriceTest(){
        Assert.assertEquals(12.3F, bun.getPrice(), 0);
    }
}
