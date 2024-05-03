import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import praktikum.Bun;
import praktikum.Burger;
import praktikum.Ingredient;
import praktikum.IngredientType;
import java.util.Arrays;
import java.util.Collection;
import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

@RunWith(Parameterized.class)
public class BurgerGetReceiptTest {

    private Bun bun;
    private Ingredient[] ingredients;
    private String expectedReceipt;

    public BurgerGetReceiptTest(Bun bun, Ingredient[] ingredients, String expectedReceipt) {
        this.bun = bun;
        this.ingredients = ingredients;
        this.expectedReceipt = expectedReceipt;
    }

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        // Создаем моки для Bun
        Bun bun1 = mock(Bun.class);
        when(bun1.getPrice()).thenReturn(2.50f);
        when(bun1.getName()).thenReturn("Sesame Bun");
        Bun bun2 = mock(Bun.class);
        when(bun2.getPrice()).thenReturn(3.00f);
        when(bun2.getName()).thenReturn("Black Bun");

        // Создаем моки для Ingredient
        Ingredient ingredient1 = mock(Ingredient.class);
        when(ingredient1.getPrice()).thenReturn(1.00f);
        when(ingredient1.getType()).thenReturn(IngredientType.FILLING);
        when(ingredient1.getName()).thenReturn("Chicken");
        Ingredient ingredient2 = mock(Ingredient.class);
        when(ingredient2.getPrice()).thenReturn(0.75f);
        when(ingredient2.getType()).thenReturn(IngredientType.SAUCE);
        when(ingredient2.getName()).thenReturn("Ketchup");

        return Arrays.asList(new Object[][]{
                {bun1, new Ingredient[]{ingredient1, ingredient1, ingredient2}, "(==== Sesame Bun ====)\r\n" +
                        "= filling Chicken =\r\n" +
                        "= filling Chicken =\r\n" +
                        "= sauce Ketchup =\r\n" +
                        "(==== Sesame Bun ====)\r\n" +
                        "\r\n" +
                        "Price: 7,750000\r\n"},
                {bun1, new Ingredient[]{ingredient1, ingredient2}, "(==== Sesame Bun ====)\r\n" +
                        "= filling Chicken =\r\n" +
                        "= sauce Ketchup =\r\n" +
                        "(==== Sesame Bun ====)\r\n" +
                        "\r\n" +
                        "Price: 6,750000\r\n"},
                {bun2, new Ingredient[]{ingredient1, ingredient1}, "(==== Black Bun ====)\r\n" +
                        "= filling Chicken =\r\n" +
                        "= filling Chicken =\r\n" +
                        "(==== Black Bun ====)\r\n" +
                        "\r\n" +
                        "Price: 8,000000\r\n"},
                {bun2, new Ingredient[]{ingredient1}, "(==== Black Bun ====)\r\n" +
                        "= filling Chicken =\r\n" +
                        "(==== Black Bun ====)\r\n" +
                        "\r\n" +
                        "Price: 7,000000\r\n"},
                {bun2, new Ingredient[]{}, "(==== Black Bun ====)\r\n" +
                        "(==== Black Bun ====)\r\n" +
                        "\r\n" +
                        "Price: 6,000000\r\n"}
        });
    }


    @Test
    public void testGetReceipt() {
        Burger burger = new Burger();
        burger.setBuns(bun);
        for (Ingredient ingredient : ingredients) {
            burger.addIngredient(ingredient);
        }
        assertEquals(expectedReceipt, burger.getReceipt());
    }
}