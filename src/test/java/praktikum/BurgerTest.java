package praktikum;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import java.util.ArrayList;
import java.util.List;
import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class BurgerTest {
    @Mock
    Bun bun;

    @Mock
    Ingredient ingredient1;

    @Mock
    Ingredient ingredient2;

    @Test
    public void setBuns() {
        Burger burger = new Burger();
        burger.setBuns(bun);
        assertEquals("Bun should be set correctly", bun, burger.bun);
    }

    @Test
    public void addIngredient() {
        Burger burger = new Burger();
        burger.addIngredient(ingredient1);
        assertEquals("Ingredient should be added", List.of(ingredient1), burger.ingredients);
    }

    @Test
    public void removeIngredient() {
        Burger burger = new Burger();
        burger.addIngredient(ingredient1);
        burger.removeIngredient(0);
        assertEquals("Ingredient list should be empty after removal", new ArrayList<>(), burger.ingredients);
    }

    @Test
    public void moveIngredient() {
        Burger burger = new Burger();
        burger.addIngredient(ingredient1);
        burger.addIngredient(ingredient2);
        burger.moveIngredient(0, 1);
        assertEquals("Ingredients should be swapped", List.of(ingredient2, ingredient1), burger.ingredients);
    }

    @Test
    public void getReceipt() {
        when(bun.getName()).thenReturn("Whole Wheat");
        when(bun.getPrice()).thenReturn(2.5f);

        when(ingredient1.getName()).thenReturn("Mustard");
        when(ingredient1.getType()).thenReturn(IngredientType.SAUCE);
        when(ingredient1.getPrice()).thenReturn(0.3f);
        Burger burger = new Burger();
        burger.setBuns(bun);
        burger.addIngredient(ingredient1);

        String expectedReceipt = String.format(
                "(==== %s ====)%n= sauce Mustard =%n(==== %s ====)%n%nPrice: %.2f%n",
                "Whole Wheat", "Whole Wheat", 2.5f * 2 + 0.3f
        );

        assertEquals("Receipt should match expected format", expectedReceipt, burger.getReceipt());
    }
}
