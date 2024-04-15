package praktikum;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.Assert.*;
import static org.mockito.Mockito.when;
import static praktikum.IngredientType.SAUCE;

@RunWith(MockitoJUnitRunner.class)
 public class BurgerTest extends BaseParams{

    @Mock
    Bun bun;
    @Mock
    Ingredient ingredient;
    @Mock
    Ingredient ingredient2;
    Burger burger = new Burger();
    private final float expectedPrice = 200;


     @Before
     public void beforeTest(){
         burger.setBuns(bun);
         burger.addIngredient(ingredient);
         burger.addIngredient(ingredient2);
     }

     @Test
     public void checkAddIngredient(){
         assertTrue("Объект ингридиента не был добавлен", burger.ingredients.contains(ingredient));
     }

     @Test
     public void checkRemoveIngredient(){
         burger.removeIngredient(burger.ingredients.indexOf(ingredient));
         assertFalse("Объект ингридиента не был удалён", burger.ingredients.contains(ingredient));
     }

     @Test
     public void checkMoveIngredient(){
         int index = burger.ingredients.indexOf(ingredient);
         int newIndex =  burger.ingredients.indexOf(ingredient2);

         burger.moveIngredient(index, newIndex);
         int indexAfterMoving = burger.ingredients.indexOf(ingredient);
         assertEquals("Объект ингридиента не был перемещён", indexAfterMoving, newIndex);
     }

    @Test
    public void checkGetPriceForCorrectPriceBun(){
        when(bun.getPrice()).thenReturn(expectedPrice);
        assertEquals("Сумма булочек получилась некорректной",
                expectedPrice * 2, burger.getPrice(), DELTA);
    }

    @Test
    public void checkGetPriceForCorrectPriceIngredients(){
        when(ingredient.getPrice()).thenReturn(expectedPrice);

        assertEquals("Сумма ингридиентов получилась некорректной",
                expectedPrice, burger.getPrice(),DELTA);
    }

    @Test
    public void checkGetReceiptCorrectValue(){
        when(bun.getName()).thenReturn("bulochka");
        when(ingredient.getType()).thenReturn(SAUCE);
        when(ingredient2.getType()).thenReturn(SAUCE);

        when(ingredient.getName()).thenReturn("nachinka");
        when(ingredient2.getName()).thenReturn("nachinka2");

        when(bun.getPrice()).thenReturn(expectedPrice);

        when(ingredient.getPrice()).thenReturn(expectedPrice);
        when(ingredient2.getPrice()).thenReturn(expectedPrice);

        assertEquals(
                String.format("(==== %s ====)%n" +
                "= %s %s =%n" +
                "= %s %s =%n" +
                "(==== %s ====)%n" +
                "%nPrice: %f%n",
                bun.getName(),
                ingredient.getType().toString().toLowerCase(),
                ingredient.getName(),
                ingredient2.getType().toString().toLowerCase(),
                ingredient2.getName(),
                bun.getName(),
                burger.getPrice()),
                burger.getReceipt());

    }
 }
