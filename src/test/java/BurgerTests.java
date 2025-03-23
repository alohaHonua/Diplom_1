import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.Spy;
import org.mockito.junit.MockitoJUnitRunner;
import praktikum.Bun;
import praktikum.Burger;
import praktikum.Ingredient;

import static org.junit.Assert.assertEquals;
import static praktikum.Const.*;
import static praktikum.IngredientType.*;

@RunWith(MockitoJUnitRunner.class)
public class BurgerTests {

    @Spy
    Bun bun = new Bun(BUN_NAME, BUN_PRICE);

    @Mock
    Ingredient ingredient1;
    @Mock
    Ingredient ingredient2;

    @Test
    public void burgerSetBuns() {
        Burger burger = new Burger();
        burger.setBuns(bun);
        assertEquals(BUN_NAME, burger.bun.getName());
        assertEquals(BUN_PRICE, burger.bun.getPrice(), DELTA);
    }

    @Test
    public void burgerAddIngredient() {
        Mockito.when(ingredient1.getName()).thenReturn(FIRST_INGREDIENT_NAME);

        Burger burger = new Burger();
        burger.addIngredient(ingredient1);
        assertEquals(FIRST_INGREDIENT_NAME, burger.ingredients.get(0).getName());
    }

    @Test
    public void burgerRemoveIngredient() {
        Burger burger = new Burger();
        burger.addIngredient(ingredient1);
        burger.removeIngredient(0);
        assertEquals(0, burger.ingredients.size());
    }

    @Test
    public void burgerMoveIngredient() {
        Mockito.when(ingredient1.getName()).thenReturn(FIRST_INGREDIENT_NAME);
        Mockito.when(ingredient2.getName()).thenReturn(SECOND_INGREDIENT_NAME);

        Burger burger = new Burger();
        burger.addIngredient(ingredient1);
        burger.addIngredient(ingredient2);
        burger.moveIngredient(0,1);
        assertEquals(SECOND_INGREDIENT_NAME, burger.ingredients.get(0).getName());
        assertEquals(FIRST_INGREDIENT_NAME, burger.ingredients.get(1).getName());
    }

    @Test
    public void burgerGetPrice() {
        Mockito.when(ingredient1.getPrice()).thenReturn(FIRST_INGREDIENT_PRICE);
        Mockito.when(ingredient2.getPrice()).thenReturn(SECOND_INGREDIENT_PRICE);

        Burger burger = new Burger();
        burger.setBuns(bun);
        burger.addIngredient(ingredient1);
        burger.addIngredient(ingredient2);

        float price = BUN_PRICE*2 + FIRST_INGREDIENT_PRICE + SECOND_INGREDIENT_PRICE;
        assertEquals(price, burger.getPrice(), DELTA);

    }

    @Test
    public void burgerGetReceipt() {
        Mockito.when(ingredient1.getType()).thenReturn(SAUCE);
        Mockito.when(ingredient2.getType()).thenReturn(FILLING);
        Mockito.when(ingredient1.getName()).thenReturn(FIRST_INGREDIENT_NAME);
        Mockito.when(ingredient2.getName()).thenReturn(SECOND_INGREDIENT_NAME);
        Mockito.when(ingredient1.getPrice()).thenReturn(FIRST_INGREDIENT_PRICE);
        Mockito.when(ingredient2.getPrice()).thenReturn(SECOND_INGREDIENT_PRICE);

        Burger burger = new Burger();
        burger.setBuns(bun);
        burger.addIngredient(ingredient1);
        burger.addIngredient(ingredient2);

        String expectedReceipt =
                String.format("(==== %s ====)%n= %s %s =%n= %s %s =%n(==== %s ====)%n%nPrice: %f%n",
                        BUN_NAME, SAUCE.toString().toLowerCase(), FIRST_INGREDIENT_NAME, FILLING.toString().toLowerCase(), SECOND_INGREDIENT_NAME, BUN_NAME, burger.getPrice());

        assertEquals(expectedReceipt, burger.getReceipt());
    }
}
