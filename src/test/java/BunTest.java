import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;
import praktikum.Bun;

@RunWith(MockitoJUnitRunner.class)
public class BunTest {

    @Test
    public void getNameTest(){
        Bun bun = new Bun("BBQ", 11.5f);
        Assert.assertEquals("BBQ", bun.getName());
    }

    @Test
    public void getPriceTest(){
        Bun bun = new Bun("BBQ", 11.5f);
        Assert.assertEquals(11.5f, bun.getPrice(), 0);
    }

 }

