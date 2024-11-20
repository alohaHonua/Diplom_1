import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import praktikum.Bun;
import praktikum.Burger;
import praktikum.Ingredient;
import praktikum.IngredientType;

import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class BurgerTest {
    private Burger burger;
    @Mock
    private Bun bun;
    @Mock
    private Ingredient ingredient1, ingredient2, ingredient3;

    @Before
    public void setUp() {
        burger = new Burger();
    }

    @Test
    public void testSetBuns() {
        burger.setBuns(bun);
        Assert.assertEquals(bun.getName(), burger.bun.getName());
    }

    @Test
    public void testAddIngredient() {
        burger.addIngredient(ingredient1);
        burger.addIngredient(ingredient2);
        burger.addIngredient(ingredient3);

        Assert.assertEquals(3, burger.ingredients.size());
    }

    @Test
    public void testRemoveIngredient() {
        testAddIngredient();
        burger.removeIngredient(2);
        Assert.assertEquals(2, burger.ingredients.size());
    }

    @Test
    public void testMoveIngredient() {
        testAddIngredient();
        burger.moveIngredient(2, 1);
        Assert.assertEquals(ingredient3, burger.ingredients.get(1));
        Assert.assertEquals(ingredient2, burger.ingredients.get(2));
    }

    @Test
    public void testGetPrice() {
        burger.setBuns(bun);
        burger.addIngredient(ingredient1);
        burger.addIngredient(ingredient2);
        burger.addIngredient(ingredient3);

        when(bun.getPrice()).thenReturn(60F);
        when(ingredient1.getPrice()).thenReturn(15F);
        when(ingredient2.getPrice()).thenReturn(20F);
        when(ingredient3.getPrice()).thenReturn(25F);

        float expected = (60F * 2) + 15F + 20F + 25F;
        System.out.println(expected);
        System.out.println(burger.getPrice());
        Assert.assertEquals(expected, burger.getPrice(), 0);
    }

    @Test
    public void testGetReceipt() {
        burger.setBuns(bun);
        burger.addIngredient(ingredient1);
        burger.addIngredient(ingredient2);
        burger.addIngredient(ingredient3);

        when(bun.getName()).thenReturn("Double Cheese");
        when(ingredient1.getName()).thenReturn("Lettuce");
        when(ingredient2.getName()).thenReturn("Mayo");
        when(ingredient3.getName()).thenReturn("Tomato");

        when(bun.getPrice()).thenReturn(60F);
        when(ingredient1.getPrice()).thenReturn(15F);
        when(ingredient2.getPrice()).thenReturn(20F);
        when(ingredient3.getPrice()).thenReturn(25F);

        when(ingredient1.getType()).thenReturn(IngredientType.FILLING);
        when(ingredient2.getType()).thenReturn(IngredientType.SAUCE);
        when(ingredient3.getType()).thenReturn(IngredientType.FILLING);

        String expected = String.format("(==== Double Cheese ====)%n" +
                "= filling Lettuce =%n" +
                "= sauce Mayo =%n" +
                "= filling Tomato =%n" +
                "(==== Double Cheese ====)%n" +
                "%nPrice: 180,000000%n");

        System.out.println(expected);
        System.out.println(burger.getReceipt());
        Assert.assertEquals(expected, burger.getReceipt());
    }

}
