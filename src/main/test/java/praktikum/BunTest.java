package praktikum;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import java.lang.Exception;


@RunWith(MockitoJUnitRunner.class)
public class BunTest {
    @Mock
    Bun bunMock;

    @Test
    public void getNameBun() throws Exception {
        Mockito.when(bunMock.getName()).thenReturn("Hamburger");// создай стаб
        String nameBun = bunMock.getName();
        Assert.assertEquals("Hamburger", nameBun);
    }

    @Test
    public void getPriceBun() throws Exception{
        Mockito.when(bunMock.getPrice()).thenReturn(0.23F);// создай стаб
        float priceBun = bunMock.getPrice();
        Assert.assertEquals(0.23F,priceBun,0.1F);
    }

    @Test
    public void testClassBun(){
        bunMock = new Bun("Hamburger",0.23F);
        String expectedName = "Hamburger";
        String actualName = bunMock.getName();
        Assert.assertEquals(expectedName, actualName);
    }
}
