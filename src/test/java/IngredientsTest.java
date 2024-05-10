import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.mockito.Spy;
import org.mockito.junit.MockitoJUnitRunner;
import praktikum.Ingredient;
import praktikum.IngredientType;
import static org.junit.Assert.*;

@RunWith(MockitoJUnitRunner.class)
public class IngredientsTest {


    @Spy
    private Ingredient ingredient = new Ingredient(IngredientType.SAUCE, "SomeName", 3);;



    @Test public void getPriceTest(){
        assertEquals(ingredient.getPrice(),3.0,0);
        Mockito.verify(ingredient,Mockito.times(1)).getPrice();
    }

    @Test public void getNameTest(){
        assertEquals(ingredient.getName(),"SomeName");
        Mockito.verify(ingredient,Mockito.times(1)).getName();
    }

    @Test public void getTypeTest(){
        assertEquals(ingredient.getType(),IngredientType.SAUCE);
        Mockito.verify(ingredient,Mockito.times(1)).getType();
    }

}
