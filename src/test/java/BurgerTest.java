import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import praktikum.Bun;
import praktikum.Burger;
import praktikum.Ingredient;
import praktikum.IngredientType;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

@RunWith(Parameterized.class)
public class BurgerTest {

    private final Bun bun;
    private final Ingredient ingredient1;
    private final Ingredient ingredient2;
    private final float expectedPrice;

    public BurgerTest(Bun bun, Ingredient ingredient1, Ingredient ingredient2, float expectedPrice) {
        this.bun = bun;
        this.ingredient1 = ingredient1;
        this.ingredient2 = ingredient2;
        this.expectedPrice = expectedPrice;
    }

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {new Bun("black bun", 100), new Ingredient(IngredientType.SAUCE, "hot sauce", 100),
                        new Ingredient(IngredientType.FILLING, "cutlet", 100), 400},
                {new Bun("white bun", 200), new Ingredient(IngredientType.SAUCE, "sour cream", 200),
                        new Ingredient(IngredientType.FILLING, "dinosaur", 200), 800},
        });
    }

    @Test
    public void testGetPrice() {
        Burger burger = new Burger();
        burger.setBuns(bun);
        burger.addIngredient(ingredient1);
        burger.addIngredient(ingredient2);

        assertEquals(expectedPrice, burger.getPrice(), 0.01);
    }

    @Test
    public void testAddIngredient() {
        Burger burger = new Burger();
        Ingredient ingredient = mock(Ingredient.class);
        burger.addIngredient(ingredient);

        assertEquals(1, burger.ingredients.size());
        assertTrue(burger.ingredients.contains(ingredient));
    }

    @Test
    public void testRemoveIngredient() {
        Burger burger = new Burger();
        Ingredient ingredient = mock(Ingredient.class);
        burger.addIngredient(ingredient);
        burger.removeIngredient(0);

        assertEquals(0, burger.ingredients.size());
    }

    @Test
    public void testMoveIngredient() {
        Burger burger = new Burger();
        Ingredient ingredient1 = mock(Ingredient.class);
        Ingredient ingredient2 = mock(Ingredient.class);
        burger.addIngredient(ingredient1);
        burger.addIngredient(ingredient2);

        burger.moveIngredient(0, 1);

        assertEquals(ingredient1, burger.ingredients.get(1));
        assertEquals(ingredient2, burger.ingredients.get(0));
    }

    @Test
    public void testGetReceipt() {
        Burger burger = new Burger();
        Bun bun = new Bun("black bun", 100);
        Ingredient ingredient = new Ingredient(IngredientType.SAUCE, "hot sauce", 100);

        burger.setBuns(bun);
        burger.addIngredient(ingredient);

        String expectedReceipt = String.format(
                "(==== black bun ====)%n" +
                "= sauce hot sauce =%n" +
                "(==== black bun ====)%n" +
                "%n" +
                "Price: 300.000000%n"
        );

        System.out.println(expectedReceipt);
        System.out.println(burger.getReceipt());
        assertEquals(expectedReceipt, burger.getReceipt());
    }
}
