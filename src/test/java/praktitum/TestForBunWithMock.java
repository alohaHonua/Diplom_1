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
//    Избыточный тест, проверенно в TestForBunWithParameterized()
//    @Test
//    public void testGetNameMethodWithStub(){
//        Mockito.when(mockForBun.getName()).thenReturn("black bun");
//        assertEquals("black bun", mockForBun.getName());
//    }

    @Test
    public void testGetPriceMethodWithMock(){
        mockForBun.getPrice();
        Mockito.verify(mockForBun, Mockito.times(1)).getPrice();
    }

//    Избыточный тест, проверенно в TestForBunWithParameterized()
//    @Test
//    public void testGetPriceMethodWithStub(){
//        Mockito.when(mockForBun.getPrice()).thenReturn(100);
//        assertEquals(100, mockForBun.getPrice(), 0);
//    }


}
