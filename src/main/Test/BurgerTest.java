import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import praktikum.Bun;
import praktikum.Burger;
import praktikum.Ingredient;
import praktikum.IngredientType;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class BurgerTest {
    @Mock
    private Bun bun;
    @InjectMocks
    private Burger burger;

    @Test
    public void testSetBuns() {
        when(bun.getName()).thenReturn("Sesame");
        burger.setBuns(bun);
        assertNotNull(burger.bun);
        assertEquals("Sesame", burger.bun.getName());
    }

    @Test
    public void testAddAndRemoveIngredient() {
        Ingredient ingredient = new Ingredient(IngredientType.FILLING, "Lettuce", 0.50f);
        burger.addIngredient(ingredient);
        assertEquals(1, burger.ingredients.size());

        burger.removeIngredient(0);
        assertEquals(0, burger.ingredients.size());
    }

    @Test
    public void testMoveIngredient() {
        Ingredient ingredient1 = new Ingredient(IngredientType.FILLING, "Lettuce", 0.50f);
        Ingredient ingredient2 = new Ingredient(IngredientType.FILLING, "Tomato", 0.70f);

        burger.addIngredient(ingredient1);
        burger.addIngredient(ingredient2);

        burger.moveIngredient(0, 1);
        assertEquals(ingredient2, burger.ingredients.get(0));
        assertEquals(ingredient1, burger.ingredients.get(1));
    }

    @Test
    public void testGetPrice() {
        when(bun.getPrice()).thenReturn(1.50f);
        burger.setBuns(bun);

        Ingredient ingredient = new Ingredient(IngredientType.FILLING, "Lettuce", 0.50f);
        burger.addIngredient(ingredient);

        assertEquals(3.50f, burger.getPrice(), 0.01);
    }

    @Test
    public void testGetReceipt() {
        when(bun.getName()).thenReturn("Sesame");
        when(bun.getPrice()).thenReturn(1.50f);
        burger.setBuns(bun);

        Ingredient ingredient = new Ingredient(IngredientType.FILLING, "Lettuce", 0.50f);
        burger.addIngredient(ingredient);

            float expectedPrice = bun.getPrice() * 2 + ingredient.getPrice();

           String expectedReceipt = String.format("(==== %s ====)%n= filling %s =%n(==== %s ====)%n%nPrice: %.2f%n",
                bun.getName(), ingredient.getName().toLowerCase(), bun.getName(), expectedPrice).replace(".", ",");


        String actualReceipt = burger.getReceipt();
        System.out.println("Actual Receipt: " + actualReceipt);
        assertEquals(expectedReceipt, actualReceipt);
    }



}
