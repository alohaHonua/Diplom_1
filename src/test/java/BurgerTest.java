import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import praktikum.Bun;
import praktikum.Burger;
import praktikum.Ingredient;
import praktikum.IngredientType;

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
    private Burger burger;
    @Before
    public void setUp(){
        burger = new Burger();
    }
    @Test
    public void checkSetBuns(){
        burger.setBuns(bun);
        assertEquals(bun, burger.bun);
    }

    @Test
    public void checkAddIngredient() {
        burger.addIngredient(ingredient1);
        assertEquals(1, burger.ingredients.size());
    }

    @Test
    public void checkRemoveIngredient() {
        burger.addIngredient(ingredient1);
        burger.addIngredient(ingredient2);
        burger.removeIngredient(1);
        assertEquals(1, burger.ingredients.size());
    }

    @Test
    public void checkMoveIngredient() {
        burger.addIngredient(ingredient1);
        burger.addIngredient(ingredient2);
        burger.moveIngredient(0, 1);
        assertEquals(ingredient1, burger.ingredients.get(1));
    }

    @Test
    public void checkGetPrice(){
        when(bun.getPrice()).thenReturn(100f);
        when(ingredient1.getPrice()).thenReturn(50f);
        when(ingredient2.getPrice()).thenReturn(150f);
        burger.setBuns(bun);
        burger.addIngredient(ingredient1);
        burger.addIngredient(ingredient2);

        assertEquals(400f, burger.getPrice(), 0.0);
    }
    @Test
    public void checkGetReceipt(){
        when(bun.getName()).thenReturn("test bun");
        when(bun.getPrice()).thenReturn(100f);
        when(ingredient1.getType()).thenReturn(IngredientType.SAUCE);
        when(ingredient1.getName()).thenReturn("test sauce");
        when(ingredient1.getPrice()).thenReturn(50f);
        when(ingredient2.getType()).thenReturn(IngredientType.FILLING);
        when(ingredient2.getName()).thenReturn("test filling");
        when(ingredient2.getPrice()).thenReturn(150f);

        burger.setBuns(bun);
        burger.addIngredient(ingredient1);
        burger.addIngredient(ingredient2);

        String expectedReceipt = String.format("(==== %s ====)%n", "test bun") +
                String.format("= %s %s =%n", "sauce", "test sauce") +
                String.format("= %s %s =%n", "filling", "test filling") +
                String.format("(==== %s ====)%n", "test bun") +
                String.format("%nPrice: %f%n", 400.000000f);

        assertEquals(expectedReceipt, burger.getReceipt());
    }
}