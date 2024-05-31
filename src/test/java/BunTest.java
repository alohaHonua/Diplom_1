import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import praktikum.Bun;

@RunWith(MockitoJUnitRunner.class)
public class BunTest {

    @Mock
    private Bun bun = new Bun("Булочка",3);

    @Test
    public void getNameTest(){
        bun.getName();
        Mockito.verify(bun,Mockito.times(1)).getName();

    }

    @Test
    public void getPriceTest(){
        bun.getPrice();
        Mockito.verify(bun,Mockito.times(1)).getPrice();
    }
}
