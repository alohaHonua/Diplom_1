package praktitum;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import praktikum.Bun;


@RunWith(MockitoJUnitRunner.class)
public class TestForBunWithMock {

    @Mock
    Bun mockForBun;

    @Test
    public void testGetNameMethodWithMock(){
        mockForBun.getName();
        Mockito.verify(mockForBun, Mockito.times(1)).getName();
    }

    @Test
    public void testGetPriceMethodWithMock(){
        mockForBun.getPrice();
        Mockito.verify(mockForBun, Mockito.times(1)).getPrice();
    }
}
