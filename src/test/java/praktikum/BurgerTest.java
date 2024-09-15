package praktikum;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.Assert.assertEquals;

@RunWith(MockitoJUnitRunner.class)
public class BurgerTest {

    final static String EXP_RECEIPT = String.format("(==== черный хлебушек ====)%n= sauce кетчунез =%n= filling зеленая жижа =%n(==== черный хлебушек ====)%n%nPrice: 40,000000%n");
    private final Burger burger = new Burger();
    @Mock
    Bun bun;
    @Mock
    Ingredient ingredient1;
    @Mock
    Ingredient ingredient2;

    @Before
    public void setUp() {

        Mockito.when(bun.getPrice()).thenReturn(5.0F);
        Mockito.when(bun.getName()).thenReturn("черный хлебушек");
        Mockito.when(ingredient1.getPrice()).thenReturn(10.0F);
        Mockito.when(ingredient2.getPrice()).thenReturn(20.0F);
        Mockito.when(ingredient1.getName()).thenReturn("кетчунез");
        Mockito.when(ingredient2.getName()).thenReturn("зеленая жижа");
        Mockito.when(ingredient1.getType()).thenReturn(IngredientType.SAUCE);
        Mockito.when(ingredient2.getType()).thenReturn(IngredientType.FILLING);
    }

    @Test
    public void getPriceReturnCorrectValue() {

        burger.setBuns(bun);
        burger.addIngredient(ingredient1);
        burger.addIngredient(ingredient2);
        assertEquals(40.0F, burger.getPrice(), 0);
    }

    @Test
    public void addIngredientAddsIngredientInList() {

        burger.addIngredient(ingredient1);
        assertEquals(1, burger.ingredients.size());
    }

    @Test
    public void removeIngredientRemovesIngredientFromList() {

        burger.addIngredient(ingredient1);
        burger.removeIngredient(0);
        assertEquals(0, burger.ingredients.size());
    }

    @Test
    public void moveIngredientMovesIngredientInList() {

        burger.addIngredient(ingredient1);
        burger.addIngredient(ingredient2);
        burger.moveIngredient(0, 1);
        assertEquals(1, burger.ingredients.indexOf(ingredient1));
    }

    @Test
    public void getReceiptReturnsCorrectValue() {


        burger.setBuns(bun);
        burger.addIngredient(ingredient1);
        burger.addIngredient(ingredient2);
        burger.setBuns(bun);
        System.out.println(burger.getReceipt());
        assertEquals(EXP_RECEIPT, burger.getReceipt());
    }

}
