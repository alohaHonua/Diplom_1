package praktitum;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import praktikum.Ingredient;

@RunWith(MockitoJUnitRunner.class)
public class TestForIngredientWithMock {

    @Mock
    Ingredient mockForIngredient;

    @Test
    public void TestForGetPriceMethod(){
        mockForIngredient.getPrice();
        Mockito.verify(mockForIngredient, Mockito.times(1)).getPrice();
    }

    @Test
    public void TestForGetNameMethod(){
        mockForIngredient.getName();
        Mockito.verify(mockForIngredient, Mockito.times(1)).getName();
    }

    @Test
    public void TestForGetTypeMethod(){
        mockForIngredient.getType();
        Mockito.verify(mockForIngredient, Mockito.times(1)).getType();
    }
}
