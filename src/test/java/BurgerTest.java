package praktikum;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class BurgerTest {
    private Burger burger;

    @Mock
    private Bun bun;
    @Mock
    private Ingredient ingredient1, ingredient2, ingredient3;

    @Before
    public void Burger() {

        burger = new Burger();
    }

    @Test
    public void TestSetBun() {
        burger.setBuns(bun);
        assertEquals(bun.getName(), burger.bun.getName());
    }

    @Test
    public void TestAddIngredient() {
        burger.addIngredient(ingredient1);
        assertEquals(1, burger.ingredients.size());
    }

    @Test
    public void TestRemoveIngredient() {
        burger.addIngredient(ingredient1);
        burger.addIngredient(ingredient2);
        burger.addIngredient(ingredient3);
        assertEquals(3, burger.ingredients.size());
        burger.removeIngredient(2);
        assertEquals(2, burger.ingredients.size());
    }

    @Test
    public void TestMoveIngredient() {
        burger.addIngredient(ingredient1);
        burger.addIngredient(ingredient2);
        burger.addIngredient(ingredient3);
        burger.moveIngredient(1, 2);
        assertEquals(ingredient2, burger.ingredients.get(2));
        assertEquals(ingredient3, burger.ingredients.get(1));
    }

    @Test
    public void TestGetPrice() {
        burger.setBuns(bun);
        burger.addIngredient(ingredient1);
        burger.addIngredient(ingredient2);
        when(bun.getPrice()).thenReturn(20F);
        when(ingredient1.getPrice()).thenReturn(10F);
        when(ingredient2.getPrice()).thenReturn(2F);
        float expected = (20F * 2) + 10F + 2F;
        assertEquals(expected, burger.getPrice(), 0);
    }

    @Test
    public void TestGetReceipt() {
        burger.setBuns(bun);
        burger.addIngredient(ingredient1);
        burger.addIngredient(ingredient2);
        when(bun.getName()).thenReturn("burger");
        when(ingredient1.getName()).thenReturn("ingredient1");
        when(ingredient2.getName()).thenReturn("ingredient2");
        when(bun.getPrice()).thenReturn(20F);
        when(ingredient1.getPrice()).thenReturn(10F);
        when(ingredient2.getPrice()).thenReturn(2F);
        when(ingredient1.getType()).thenReturn(IngredientType.SAUCE);
        when(ingredient2.getType()).thenReturn(IngredientType.FILLING);
        String expected = "(==== burger ====)\r\n" +
                "= sauce ingredient1 =\r\n" +
                "= filling ingredient2 =\r\n" +
                "(==== burger ====)\r\n" +
                "\r\n" +
                "Price: 52,000000\r\n";

        assertEquals(expected, burger.getReceipt());
    }
}
