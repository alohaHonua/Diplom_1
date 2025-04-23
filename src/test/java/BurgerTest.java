import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;
import praktikum.Bun;
import praktikum.Burger;
import praktikum.Ingredient;

import org.mockito.Mock;

import java.util.Random;

import static org.junit.Assert.assertEquals;

@RunWith(MockitoJUnitRunner.class)
public class BurgerTest {

    private int index;
    private Burger burger = new Burger();

    @Mock
    private Bun bun;

    @Mock
    private Ingredient ingredient;

    @Mock
    private Ingredient anotherIngredient;

    @Before
    public void setUp() {
        index = 2 + new Random().nextInt(9);

        for(int i = 0; i <= index; i++) {
            burger.addIngredient(i % 2 == 0 ? ingredient : anotherIngredient);
        }

        burger.setBuns(bun);
    }

    @Test
    public void testRemoveIngredient() {
        int initialSize = burger.ingredients.size();

        burger.removeIngredient(index);

        assertEquals(initialSize - 1, burger.ingredients.size());

        if (index < initialSize - 1) {
            assertEquals(anotherIngredient.getName(),
                    burger.ingredients.get(index).getName());
        }
    }

    @Test
    public void testMoveIngredient() {
        Ingredient ingredientToMove = burger.ingredients.get(index);
        Ingredient ingredientAtTarget = burger.ingredients.get(index - 1);

        int initialSize = burger.ingredients.size();

        burger.moveIngredient(index, index - 1);

        assertEquals(initialSize, burger.ingredients.size());

        assertEquals(ingredientToMove.getName(),
                burger.ingredients.get(index - 1).getName());
        assertEquals(ingredientAtTarget.getName(),
                burger.ingredients.get(index).getName());
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testRemoveIngredientWithInvalidIndex() {
        burger.removeIngredient(burger.ingredients.size() + 1);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testMoveIngredientWithInvalidIndex() {
        burger.moveIngredient(burger.ingredients.size() + 1, 0);
    }
}