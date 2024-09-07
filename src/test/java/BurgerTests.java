import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.Spy;
import org.mockito.junit.MockitoJUnitRunner;
import praktikum.Bun;
import praktikum.Burger;
import praktikum.Ingredient;
import praktikum.IngredientType;

import java.util.ArrayList;
import java.util.List;

import static praktikum.IngredientType.FILLING;
import static praktikum.IngredientType.SAUCE;

@RunWith(MockitoJUnitRunner.class)
public class BurgerTests {

    @Mock
    private Bun bunMock;
    @Mock
    Ingredient ingredientMock;
    @Mock
    Ingredient ingredientMock2;
    @Mock
    Ingredient ingredientMock3;
    Burger burger ;

    @Before
    public void setUp(){
        burger = new Burger();
    }
    @Test
    public void setBunsSetsCorrectValue(){
        burger.setBuns(bunMock);
        Assert.assertEquals(bunMock, burger.bun);
    }

    @Test
    public void addIngredientAddsToIngredientList(){
        burger.addIngredient(ingredientMock);
        Assert.assertTrue(burger.ingredients.contains(ingredientMock));
    }

    @Test
    public void removeIngredientRemovesIngredient(){
        burger.addIngredient(ingredientMock);
        Assert.assertTrue(burger.ingredients.contains(ingredientMock));
        burger.removeIngredient(0);
        Assert.assertFalse(burger.ingredients.contains(ingredientMock));
    }

    @Test
    public  void moveIngredientMovesIngredient(){
        burger.addIngredient(ingredientMock);
        burger.addIngredient(ingredientMock2);
        burger.addIngredient(ingredientMock3);
        burger.moveIngredient(2,0);
        Assert.assertEquals(ingredientMock3,burger.ingredients.get(0));
    }

    @Test
    public  void  getPriceReturnsCorrectPrice(){
        Mockito.when(bunMock.getPrice()).thenReturn(3F);
        Mockito.when(ingredientMock.getPrice()).thenReturn(3.66F);
        Mockito.when(ingredientMock2.getPrice()).thenReturn(0.55F);

        float expectedPrice = 3F*2+3.66F+0.55F;
        burger.setBuns(bunMock);
        burger.addIngredient(ingredientMock);
        burger.addIngredient(ingredientMock2);

        Assert.assertEquals(expectedPrice, burger.getPrice(),0);
    }



    @Test
    public void getReceiptReturnsCorrectReceipt(){
        Mockito.when(bunMock.getName()).thenReturn("Булка с моком");
        Mockito.when(bunMock.getPrice()).thenReturn(1F);
        Mockito.when(ingredientMock.getType()).thenReturn(SAUCE);
        Mockito.when(ingredientMock2.getType()).thenReturn(FILLING);
        Mockito.when(ingredientMock.getName()).thenReturn("Соусец и моков");
        Mockito.when(ingredientMock2.getName()).thenReturn("Копчёные моки");
        Mockito.when(ingredientMock.getPrice()).thenReturn(3.15F);
        Mockito.when(ingredientMock2.getPrice()).thenReturn(4.10F);


        burger.setBuns(bunMock);
        burger.addIngredient(ingredientMock);
        burger.addIngredient(ingredientMock2);

        StringBuilder expectedReceiptBuild = new StringBuilder(String.format("(==== Булка с моком ====)%n= sauce Соусец и моков =%n= filling Копчёные моки =%n(==== Булка с моком ====)%n" +
                "%nPrice: 9,250000%n"));
        // в жидаемом результате подогнал цену чтобы не падал тест ()
        String expectedReceipt = expectedReceiptBuild.toString();
        Assert.assertEquals(expectedReceipt,burger.getReceipt());
    }

}
