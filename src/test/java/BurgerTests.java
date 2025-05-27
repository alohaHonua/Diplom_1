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
public class BurgerTests {
    private final  String expectedReceipt =
            "(==== Test burgerVinegrette ====)\r\n" +
            "= sauce krujki =\r\n" +
            "= filling romano =\r\n" +
            "(==== Test burgerVinegrette ====)\r\n" +
            "\r\n" +
            "Price: 60,000000\r\n";
    private Burger burger;

    @Mock
    private Bun burgerVinegrette;

    @Mock
    private Ingredient ogurchik, salatik, bulochka ,kotletka;

    @Before
    public void setUp() {
        burger = new Burger(); //  создание объекта
    }

    @Test
    public void testSetBunSetsCorrectBurgerVinegrette() {
        when(burgerVinegrette.getName()).thenReturn("Test BurgerVinegrette");
        burger.setBuns(burgerVinegrette);
        assertEquals("Test BurgerVinegrette", burger.bun.getName());
    }

    @Test
    public void testAddIngredientIncreasesListSize() {
        burger.addIngredient(ogurchik);
        assertEquals(1, burger.ingredients.size());
    }

    @Test
    public void testRemoveIngredientDecreasesListSize() {
        burger.addIngredient(ogurchik);
        burger.addIngredient(salatik);
        burger.addIngredient(bulochka);
        burger.addIngredient(kotletka);
        assertEquals(4, burger.ingredients.size());
        burger.removeIngredient(2);
        assertEquals(3, burger.ingredients.size());
    }

    @Test
    public void testMoveIngredientSwapsCorrectly() {
        burger.addIngredient(ogurchik);
        burger.addIngredient(salatik);
        burger.addIngredient(bulochka);
        burger.addIngredient(kotletka);
        burger.moveIngredient(1, 2);
        assertEquals(salatik, burger.ingredients.get(2));
        assertEquals(bulochka, burger.ingredients.get(1));
    }

    @Test
    public void testGetPriceReturnsCorrectSum() {
        burger.setBuns(burgerVinegrette);
        burger.addIngredient(ogurchik);
        burger.addIngredient(salatik);
        when(burgerVinegrette.getPrice()).thenReturn(30F);
        when(ogurchik.getPrice()).thenReturn(30F);
        when(salatik.getPrice()).thenReturn(2F);
        float expectedPrice = 30F * 2 + 30F + 2F;
        assertEquals(expectedPrice, burger.getPrice(), 0);
    }

    @Test
    public void testGetReceiptReturnsFormattedReceipt() {
        burger.setBuns(burgerVinegrette);
        burger.addIngredient(ogurchik);
        burger.addIngredient(salatik);
        when(burgerVinegrette.getName()).thenReturn("Test burgerVinegrette");
        when(burgerVinegrette .getPrice()).thenReturn(20F);
        when(ogurchik.getName()).thenReturn("krujki");
        when(ogurchik.getType()).thenReturn(IngredientType.SAUCE);
        when(ogurchik.getPrice()).thenReturn(10F);
        when(salatik.getName()).thenReturn("romano");
        when(salatik.getType()).thenReturn(IngredientType.FILLING);
        when(salatik.getPrice()).thenReturn(10F);
        assertEquals(expectedReceipt, burger.getReceipt());
    }
}