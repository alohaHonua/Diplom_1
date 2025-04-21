package praktikum;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;

import static org.junit.Assert.assertEquals;
import static praktikum.ConfigConst.*;

@RunWith(MockitoJUnitRunner.class)
public class BurgerTest {
    Burger burger;
    @Mock
    Bun bun;
    @Mock
    Ingredient ingredientOne;
    @Mock
    Ingredient ingredientTwo;
    String data;
    String dataReverse;
    @Before
    public void setUp () {
        burger = new Burger();
        burger.setBuns(bun);
    }

    @Test
    public void getBurgerTest()  {
        Mockito.when(bun.getPrice()).thenReturn(PRICE_BUN);
        Mockito.when(bun.getName()).thenReturn(MOZART);
        Mockito.when(ingredientOne.getPrice()).thenReturn(PRICE_BUN);
        Mockito.when(ingredientOne.getName()).thenReturn(WINE);
        Mockito.when(ingredientOne.getType()).thenReturn(IngredientType.SAUCE);
        Mockito.when(ingredientTwo.getPrice()).thenReturn(PRICE_INGREDIENT);
        Mockito.when(ingredientTwo.getName()).thenReturn(CHEESE);
        Mockito.when(ingredientTwo.getType()).thenReturn(IngredientType.FILLING);
        burger.setBuns(bun);
        burger.addIngredient(ingredientOne);
        burger.addIngredient(ingredientTwo);
        assertEquals(PRICE_BURGER,burger.getPrice(),1);
        try {
            System.out.println(SUCCESS);
            data= "";
            byte[] encoded = Files.readAllBytes(Paths.get(PATH_RECEIPT));
            data = new String(encoded, StandardCharsets.UTF_8);
        } catch (IOException e) {
            System.out.println(ERROR);
            e.printStackTrace();
        }
        assertEquals(data,burger.getReceipt());
        burger.removeIngredient(1);
        burger.addIngredient(ingredientTwo);
        burger.moveIngredient(0,1);
        try {
            System.out.println(SUCCESS);
            dataReverse= "";
            byte[] encoded = Files.readAllBytes(Paths.get(PATH_RECEIPT_R));
            dataReverse = new String(encoded, StandardCharsets.UTF_8);
        } catch (IOException e) {
            System.out.println(ERROR);
            e.printStackTrace();
        }
        assertEquals(dataReverse,burger.getReceipt());
        Mockito.verify(bun, Mockito.times(3)).getPrice();
        Mockito.verify(bun, Mockito.times(4)).getName();
        Mockito.verify(ingredientOne, Mockito.times(2)).getName();
        Mockito.verify(ingredientTwo, Mockito.times(2)).getName();
        Mockito.verify(ingredientOne, Mockito.times(2)).getType();
        Mockito.verify(ingredientTwo, Mockito.times(2)).getType();
        Mockito.verify(ingredientOne, Mockito.times(3)).getPrice();
        Mockito.verify(ingredientTwo, Mockito.times(3)).getPrice();

    }

}