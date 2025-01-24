import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import praktikum.Bun;
import praktikum.Burger;
import praktikum.Ingredient;
import praktikum.IngredientType;

import static Constants.Constants.*;
import static org.junit.Assert.assertEquals;
import static praktikum.IngredientType.*;

@RunWith(MockitoJUnitRunner.class)
public class BurgerTest {

    Burger burger = new Burger();

    @Mock
    Bun bunMock;
    @Mock
    Ingredient ingredientMock;
    @Mock
    Ingredient ingredientMock2;

    @Test
    public void setBunTest() {
        burger.setBuns(bunMock);
        assertEquals(bunMock, burger.bun);
    }

    @Test
    public void addIngredientTest() {
        burger.addIngredient(ingredientMock);
        assertEquals(ingredientMock, burger.ingredients.get(0));
    }

    @Test
    public void removeIngredientTest() {
        burger.addIngredient(ingredientMock);
        burger.removeIngredient(0);
        assertEquals(burger.ingredients.size(), 0);
    }

    @Test
    public void moveIngredientTest() {
        burger.addIngredient(ingredientMock);
        burger.addIngredient(ingredientMock2);
        burger.moveIngredient(1,0);
        assertEquals(ingredientMock2, burger.ingredients.get(0));
    }

    @Test
    public void getPriceBurgerTest() {
        burger.setBuns(bunMock);
        burger.addIngredient(ingredientMock);
        Mockito.when(bunMock.getPrice()).thenReturn(PRICE_BUN);
        Mockito.when(ingredientMock.getPrice()).thenReturn(PRICE_INGREDIENT);
        float burgerPrice = burger.getPrice();
        float expectedPrice = PRICE_BUN * 2 + PRICE_INGREDIENT;
        assertEquals("Стоимость бургера расчитана неверно", expectedPrice, burgerPrice, 0);
    }

    @Test
    public void getReceiptTest() {
        Mockito.when(bunMock.getName()).thenReturn(NAME_BUN);
        Mockito.when(bunMock.getPrice()).thenReturn(PRICE_BUN);
        Mockito.when(ingredientMock.getType()).thenReturn(FILLING);
        Mockito.when(ingredientMock.getName()).thenReturn(NAME_INGREDIENT);
        Mockito.when(ingredientMock.getPrice()).thenReturn(PRICE_INGREDIENT);
        burger.setBuns(bunMock);
        burger.addIngredient(ingredientMock);
        String actualReceipt = burger.getReceipt();
        String expectedReceipt = String.format("(==== %s ====)%n", NAME_BUN) +
                String.format("= %s %s =%n", FILLING.toString().toLowerCase(), NAME_INGREDIENT) +
                String.format("(==== %s ====)%n", NAME_BUN) +
                String.format("%nPrice: %f%n", burger.getPrice());
        System.out.println(expectedReceipt);
        assertEquals(expectedReceipt, actualReceipt);

    }
}
