import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import praktikum.Bun;
import praktikum.Burger;
import praktikum.Ingredient;
import praktikum.IngredientType;

import static org.junit.Assert.assertNotEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static praktikum.Constants.*;

@RunWith(MockitoJUnitRunner.class)
public class BurgerMockTest {
    private final float EXPECTED_PRICE = PRICE_BUN * 2 + PRICE_INGREDIENT;
    private final String EXPECTED_RECEIPT = String.format("(==== %s ====)%n= filling %s =%n(==== %s ====)%n%nPrice: %.6f%n",
            FLU_BUN, NAME_INGREDIENT, FLU_BUN, PRICE_BUN * 2 + PRICE_INGREDIENT);

    Burger burger = new Burger();

    @Mock
    Bun bun;

    @Mock
    Ingredient ingredient;

    @Test
    public void setBunsTest() {
        burger.setBuns(bun);
        Assert.assertEquals(burger.bun, bun);
    }
    @Test
    public void addIngredientTest() {
        burger.addIngredient(ingredient);
        assertNotEquals(0, burger.ingredients.size());
    }
    @Test
    public void moveIngredientTest() {
        Ingredient Ingredient1 = mock(Ingredient.class);
        Ingredient Ingredient2 = mock(Ingredient.class);

        burger.addIngredient(Ingredient1);
        burger.addIngredient(Ingredient2);
        burger.moveIngredient(1, 0);
        Assert.assertEquals(Ingredient1, burger.ingredients.get(1));
    }
    @Test
    public void removeIngredientTest() {
        burger.addIngredient(ingredient);
        burger.removeIngredient(0);
        Assert.assertTrue(burger.ingredients.isEmpty());
    }
    @Test
    public void getBurgerReceiptTest() {
        burger.setBuns(bun);
        burger.addIngredient(ingredient);
        when(bun.getName()).thenReturn(FLU_BUN);
        when(ingredient.getName()).thenReturn(NAME_INGREDIENT);
        when(bun.getPrice()).thenReturn(PRICE_BUN);
        when(ingredient.getPrice()).thenReturn(PRICE_INGREDIENT);
        when(ingredient.getType()).thenReturn(IngredientType.FILLING);
        Assert.assertEquals(EXPECTED_RECEIPT, burger.getReceipt());
    }
    @Test
    public void getBurgerPriceTest() {
        burger.setBuns(bun);
        when(bun.getPrice()).thenReturn(PRICE_BUN);
        burger.addIngredient(ingredient);
        when(ingredient.getPrice()).thenReturn(PRICE_INGREDIENT);
        Assert.assertEquals(EXPECTED_PRICE, burger.getPrice(), 0);
    }
}
