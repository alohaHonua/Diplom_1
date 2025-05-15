import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import praktikum.Bun;
import praktikum.Burger;
import praktikum.Ingredient;
import praktikum.IngredientType;

import static org.junit.Assert.assertEquals;

@RunWith(MockitoJUnitRunner.class)
public class BurgerTest {
    public static final float BUN_PRICE_100 = 100.0f;
    public static final float FILLING_PRICE_50 = 50.0f;
    public static final float SAUCE_PRICE_10 = 10.0f;
    public static final float EXPECTED_PRICE_260 = 260.0f;
    public static final int INDEX_0 = 0;
    public static final int EXPECTED_AMOUNT_ZERO = 0;
    public static final int INDEX_1 = 1;
    public static final int EXPECTED_AMOUNT_ONE = 1;
    public static final String FLIRE_BUN = "Флюоресцентная булка";
    public static final String BEEF_METEORITE_CHOPPED = "Говяжий метеорит (отбивная)";
    public static final String SAUCE_SPICY_X = "Соус Spicy-X";
    @Mock
    private Bun bun;
    @Mock
    private Ingredient ingredientSauce;
    @Mock
    private Ingredient ingredientFilling;
    private Burger burger;


    @Before
    public void init() {
        burger = new Burger();
    }

    @Test
    public void addIngredientReturnSuccess() {
        burger.addIngredient(ingredientFilling);
        assertEquals(EXPECTED_AMOUNT_ONE, burger.ingredients.size());
    }

    @Test
    public void removeIngredientReturnSuccess() {
        burger.addIngredient(ingredientFilling);
        burger.removeIngredient(INDEX_0);
        assertEquals(EXPECTED_AMOUNT_ZERO, burger.ingredients.size());
    }

    @Test
    public void moveIngredientReturnSuccess() {
        burger.addIngredient(ingredientFilling);
        burger.addIngredient(ingredientSauce);
        burger.moveIngredient(INDEX_0, INDEX_1);
        assertEquals(ingredientSauce, burger.ingredients.get(INDEX_0));
        assertEquals(ingredientFilling, burger.ingredients.get(INDEX_1));
    }

    @Test
    public void setBunsReturnSuccess() {
        burger.setBuns(bun);
        assertEquals(bun, burger.bun);
    }

    @Test
    public void getPriceReturnPrice260Success() {
        burger.setBuns(bun);
        burger.addIngredient(ingredientFilling);
        burger.addIngredient(ingredientSauce);
        Mockito.when(bun.getPrice()).thenReturn(BUN_PRICE_100);
        Mockito.when(ingredientFilling.getPrice()).thenReturn(FILLING_PRICE_50);
        Mockito.when(ingredientSauce.getPrice()).thenReturn(SAUCE_PRICE_10);
        assertEquals(EXPECTED_PRICE_260, burger.getPrice(), 0.001);
    }

    @Test
    public void getReceiptWithIngredientsReturnReceiptSuccess() {
        burger.setBuns(bun);
        Mockito.when(bun.getName()).thenReturn(FLIRE_BUN);

        Mockito.when(ingredientFilling.getType()).thenReturn(IngredientType.FILLING);
        Mockito.when(ingredientFilling.getName()).thenReturn(BEEF_METEORITE_CHOPPED);

        Mockito.when(ingredientSauce.getType()).thenReturn(IngredientType.SAUCE);
        Mockito.when(ingredientSauce.getName()).thenReturn(SAUCE_SPICY_X);

        burger.addIngredient(ingredientFilling);
        burger.addIngredient(ingredientSauce);

        Mockito.when(burger.getPrice()).thenReturn(EXPECTED_PRICE_260);

        String expectedReceipt = String.format("(==== %s ====)%n", FLIRE_BUN) +
                String.format("= %s %s =%n", "filling", BEEF_METEORITE_CHOPPED) +
                String.format("= %s %s =%n", "sauce", SAUCE_SPICY_X) +
                String.format("(==== %s ====)%n", FLIRE_BUN) +
                String.format("%nPrice: %f%n", EXPECTED_PRICE_260);

        assertEquals(expectedReceipt, burger.getReceipt());
    }
}
