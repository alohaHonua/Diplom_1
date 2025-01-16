package tests;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import praktikum.Burger;
import praktikum.Bun;
import praktikum.Ingredient;
import praktikum.IngredientType;
import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

public class BurgerReceiptTest {

    private Burger burger;

    @Mock
    private Bun bun;

    @Mock
    private Ingredient ingredient1;

    @Mock
    private Ingredient ingredient2;

    @Before
    public void setUp() {
        MockitoAnnotations.openMocks(this);
        burger = new Burger();

        when(bun.getName()).thenReturn("BunName");
        when(bun.getPrice()).thenReturn(2.0f);

        when(ingredient1.getType()).thenReturn(IngredientType.SAUCE);
        when(ingredient1.getName()).thenReturn("Ingredient1");
        when(ingredient1.getPrice()).thenReturn(1.5f);

        when(ingredient2.getType()).thenReturn(IngredientType.FILLING);
        when(ingredient2.getName()).thenReturn("Ingredient2");
        when(ingredient2.getPrice()).thenReturn(2.0f);

        burger.setBuns(bun);
        burger.addIngredient(ingredient1);
        burger.addIngredient(ingredient2);
    }

    @Test
    public void testGetReceipt() {
        String expectedReceipt = "(==== BunName ====)\n" +
                "= sauce Ingredient1 =\n" +
                "= filling Ingredient2 =\n" +
                "(==== BunName ====)\n" +
                "\nPrice: 7,500000\n";

        String actualReceiptNormalized = burger.getReceipt().replaceAll("\r\n", "\n");

        assertEquals(expectedReceipt, actualReceiptNormalized);
    }
}