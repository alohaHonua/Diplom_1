package praktikum;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.Assert.*;
import static org.mockito.Mockito.when;

import java.util.List;

@RunWith(MockitoJUnitRunner.class)
public class BurgerTest {

    @Mock
    private Bun bun;

    @Mock
    private Ingredient ingredient1;

    @Mock
    private Ingredient ingredient2;

    @Mock
    private List<Ingredient> ingredients;

    @Test
    public void setBunsBurgerTest() {
        praktikum.Burger burger = new praktikum.Burger ();

        burger.setBuns(bun);

        assertEquals(bun, burger.getBun());
    }

    @Test
    public void addIngredientBurgerTest() {
        praktikum.Burger burger = new praktikum.Burger ();

        ingredients.add(ingredient1);
        burger.addIngredient(ingredient1);

        assertTrue(burger.ingredients.contains(ingredient1));
    }

    @Test
    public void removeIngredientBurgerTest() {
        praktikum.Burger burger = new praktikum.Burger ();

        ingredients.add(ingredient1);

        burger.addIngredient(ingredient1);
        burger.removeIngredient(0);

        assertEquals(0, ingredients.size());
    }

    @Test
    public void moveIngredientBurgerTest() {
        praktikum.Burger burger = new praktikum.Burger ();

        burger.addIngredient(ingredient1);
        burger.addIngredient(ingredient2);

        burger.moveIngredient(0, 1);

        assertEquals(ingredient1, burger.ingredients.get(1));
    }

    @Test
    public void getPriceBurgerTest() {
        praktikum.Burger burger = new praktikum.Burger ();
        burger.setBuns(bun);

        ingredients.add(ingredient1);
        ingredients.add(ingredient2);

        burger.addIngredient(ingredient1);
        burger.addIngredient(ingredient2);

        float expectedResult = bun.getPrice() * 2 + ingredient1.getPrice() + ingredient2.getPrice();
        float actualResult = burger.getPrice();

        assertEquals(expectedResult, actualResult, 0);
    }

    @Test
    public void getReceiptBurgerTest() {

        praktikum.Burger burger = new praktikum.Burger ();
        burger.setBuns(bun);

        ingredients.add(ingredient1);
        ingredients.add(ingredient2);

        burger.addIngredient(ingredient1);
        burger.addIngredient(ingredient2);

        when(bun.getName()).thenReturn("black bun");
        when(bun.getPrice()).thenReturn(1f);

        when(ingredient1.getType()).thenReturn(IngredientType.SAUCE);
        when(ingredient1.getName()).thenReturn("sour cream");
        when(ingredient1.getPrice()).thenReturn(0.5f);

        when(ingredient2.getType()).thenReturn(IngredientType.FILLING);
        when(ingredient2.getName()).thenReturn("cutlet");
        when(ingredient2.getPrice()).thenReturn(3f);

        StringBuilder expectedResult = new StringBuilder();

        expectedResult.append(String.format("(==== %s ====)%n", bun.getName()));
        expectedResult.append(String.format("= %s %s =%n", ingredient1.getType().toString().toLowerCase(), ingredient1.getName()));
        expectedResult.append(String.format("= %s %s =%n", ingredient2.getType().toString().toLowerCase(), ingredient2.getName()));
        expectedResult.append(String.format("(==== %s ====)%n", bun.getName()));
        expectedResult.append(String.format("%nPrice: %f%n", burger.getPrice()));

        String actualResult = burger.getReceipt();

        assertEquals(expectedResult.toString(), actualResult);
    }
}
