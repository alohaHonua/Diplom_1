import org.junit.Before;
import org.junit.Test;
import praktikum.Bun;
import praktikum.Burger;
import praktikum.Ingredient;
import praktikum.IngredientType;
import static org.junit.Assert.*;
import java.util.Arrays;
import java.util.List;
public class BurgerTest {
    private Burger burger;
    private Bun bun;
    private Ingredient sauce;
    private Ingredient filling;

    @Before
    public void setUp() {
        bun = new Bun("white bun", 200);
        sauce = new Ingredient(IngredientType.SAUCE, "hot sauce", 100);
        filling = new Ingredient(IngredientType.FILLING, "cutlet", 300);
        burger = new Burger();
    }

    @Test
    public void testSetBuns() {
        burger.setBuns(bun);
        assertEquals(bun, burger.bun);
    }

    @Test
    public void testAddIngredient() {
        burger.addIngredient(sauce);
        assertEquals(1, burger.ingredients.size());
        assertEquals(sauce, burger.ingredients.get(0));
    }

    @Test
    public void testRemoveIngredient() {
        burger.addIngredient(sauce);
        burger.removeIngredient(0);
        assertTrue(burger.ingredients.isEmpty());
    }

    @Test
    public void testMoveIngredient() {
        Ingredient ingredient1 = new Ingredient(IngredientType.SAUCE, "sour cream", 200);
        Ingredient ingredient2 = new Ingredient(IngredientType.FILLING, "dinosaur", 400);
        burger.addIngredient(sauce);
        burger.addIngredient(ingredient1);
        burger.addIngredient(ingredient2);

        burger.moveIngredient(0, 2);
        List<Ingredient> expectedOrder = Arrays.asList(ingredient1, ingredient2, sauce);
        assertEquals(expectedOrder, burger.ingredients);
    }

    @Test
    public void testGetPrice() {
        burger.setBuns(bun);
        burger.addIngredient(sauce);
        burger.addIngredient(filling);
        float expectedPrice = 200 * 2 + 100 + 300;
        assertEquals(expectedPrice, burger.getPrice(), 0);
    }

    @Test
    public void testGetReceipt() {
        burger.setBuns(bun);
        burger.addIngredient(sauce);
        burger.addIngredient(filling);
        String expectedReceipt = String.format(
                "(==== %s ====)%n= %s %s =%n= %s %s =%n(==== %s ====)%n%nPrice: %f%n",
                bun.getName(),
                sauce.getType().toString().toLowerCase(),
                sauce.getName(),
                filling.getType().toString().toLowerCase(),
                filling.getName(),
                bun.getName(),
                burger.getPrice()
        );
        assertEquals(expectedReceipt, burger.getReceipt());
    }
}
