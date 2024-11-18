package praktikum;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class BurgerTest {

    private Burger burger;

    @Mock
    private Bun bun;

    @Mock
    private Ingredient ingredientSauce;

    @Mock
    private Ingredient ingredientFilling;


    @Before
    public void setUp() {
        burger = new Burger();
    }

    @Test
    public void setBunsTest() {
        burger.setBuns(bun);
        Assert.assertEquals(bun, burger.bun);
    }

    @Test
    public void addIngredientTest() {
        burger.addIngredient(ingredientSauce);
        Assert.assertEquals(1, burger.ingredients.size());
        Assert.assertEquals(ingredientSauce, burger.ingredients.get(0));
    }

    @Test
    public void removeIngredientTest() {
        burger.addIngredient(ingredientSauce);
        burger.removeIngredient(0);
        Assert.assertEquals(0, burger.ingredients.size());
    }

    @Test
    public void moveIngredientTest() {
        burger.addIngredient(ingredientSauce);
        burger.addIngredient(ingredientFilling);
        burger.moveIngredient(0, 1);
        Assert.assertEquals(ingredientFilling, burger.ingredients.get(0));
        Assert.assertEquals(ingredientSauce, burger.ingredients.get(1));

    }

    @Test
    public void getPriceTest() {
        Mockito.when(bun.getPrice()).thenReturn(988f);
        Mockito.when(ingredientSauce.getPrice()).thenReturn(90f);
        Mockito.when(ingredientFilling.getPrice()).thenReturn(874f);
        burger.setBuns(bun);
        burger.addIngredient(ingredientSauce);
        burger.addIngredient(ingredientFilling);
        float expectedPrice = (bun.getPrice() * 2) + ingredientSauce.getPrice() + ingredientFilling.getPrice();
        Assert.assertEquals(expectedPrice, burger.getPrice(), 0.01);
    }

    @Test
    public void testGetReceipt() {
        Mockito.when(bun.getName()).thenReturn("Флюоресцентная булка R2-D3");
        Mockito.when(bun.getPrice()).thenReturn(988f);
        Mockito.when(ingredientSauce.getName()).thenReturn("Соус Spice-X");
        Mockito.when(ingredientSauce.getType()).thenReturn(IngredientType.SAUCE);
        Mockito.when(ingredientSauce.getPrice()).thenReturn(90f);
        Mockito.when(ingredientFilling.getName()).thenReturn("Биоколтела из марсианской Магнолии");
        Mockito.when(ingredientFilling.getType()).thenReturn(IngredientType.FILLING);
        Mockito.when(ingredientFilling.getPrice()).thenReturn(424f);

        burger.setBuns(bun);
        burger.addIngredient(ingredientSauce);
        burger.addIngredient(ingredientFilling);

        String expectedReceipt = String.format("(==== %s ====)%n= %s %s =%n= %s %s =%n(==== %s ====)%n%nPrice: %f%n",
                bun.getName(), ingredientSauce.getType().toString().toLowerCase(), ingredientSauce.getName(), ingredientFilling.getType().toString().toLowerCase(), ingredientFilling.getName(), bun.getName(), burger.getPrice());

        Assert.assertEquals(expectedReceipt, burger.getReceipt());
    }
}