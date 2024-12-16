package praktikum;

import static constants.Constants.DELTA;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.when;
import static praktikum.IngredientType.*;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class BurgerTest {

    private Burger burger;

    @Mock
    private Bun bun;
    @Mock
    private Ingredient ingredient1;
    @Mock
    private Ingredient ingredient2;
    @Mock
    private Ingredient ingredient3;

    @Before
    public void setUp() {
        burger = new Burger();
        burger.setBuns(bun);
        burger.addIngredient(ingredient1);
        burger.addIngredient(ingredient3);
        burger.addIngredient(ingredient2);

        when(bun.getPrice()).thenReturn(50.0f);
        when(bun.getName()).thenReturn("булочка с кунжутом");

        when(ingredient1.getPrice()).thenReturn(50.0f);
        when(ingredient1.getName()).thenReturn("барбекю");
        when(ingredient1.getType()).thenReturn(SAUCE);

        when(ingredient2.getPrice()).thenReturn(150.0f);
        when(ingredient2.getName()).thenReturn("котлета");
        when(ingredient2.getType()).thenReturn(FILLING);

        when(ingredient3.getPrice()).thenReturn(100.0f);
        when(ingredient3.getName()).thenReturn("сыр");
        when(ingredient3.getType()).thenReturn(FILLING);
    }

    @Test
    public void testSetBuns() {
        burger.setBuns(bun);
        assertNotNull(burger.bun);
        assertEquals(bun, burger.bun);
    }

    @Test
    public void testAddIngredient() {
        if (!burger.ingredients.isEmpty()) {
            burger.ingredients.clear();
        }
        burger.addIngredient(ingredient1);
        assertEquals(1, burger.ingredients.size());
        assertEquals(ingredient1, burger.ingredients.get(0));

        burger.addIngredient(ingredient2);
        assertEquals(2, burger.ingredients.size());
        assertEquals(ingredient2, burger.ingredients.get(1));

        burger.addIngredient(ingredient3);
        assertEquals(3, burger.ingredients.size());
        assertEquals(ingredient3, burger.ingredients.get(2));
    }

    @Test
    public void testRemoveIngredient() {
        burger.removeIngredient(1); // Удаляем Lettuce
        assertEquals(2, burger.ingredients.size());
        assertFalse(burger.ingredients.contains(ingredient3));
    }

    @Test
    public void testMoveIngredient() {
        burger.moveIngredient(0, 1);
        assertEquals(ingredient3, burger.ingredients.get(0));
        assertEquals(ingredient1, burger.ingredients.get(1));
    }

    @Test
    public void testGetPrice() {
        float expectedPrice = (bun.getPrice() * 2);

        for (Ingredient ingredient : burger.ingredients) {
            expectedPrice += ingredient.getPrice();
        }
        assertEquals(expectedPrice, burger.getPrice(), DELTA);
        System.out.println(expectedPrice);
    }

    @Test
    public void testGetReceipt() {
        String expectedReceipt = String.format(
            "(==== %s ====)%n= %s %s =%n= %s %s =%n= %s %s =%n(==== %s ====)%n%nPrice: %f%n",
            bun.getName(),
            ingredient1.getType().toString().toLowerCase(),
            ingredient1.getName(),
            ingredient3.getType().toString().toLowerCase(),
            ingredient3.getName(),
            ingredient2.getType().toString().toLowerCase(),
            ingredient2.getName(),
            bun.getName(),
            burger.getPrice()
        );
        assertEquals(expectedReceipt, burger.getReceipt());
        System.out.println(expectedReceipt);
    }
}