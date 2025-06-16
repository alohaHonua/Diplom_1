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

    private final String expectedReceipt =
            "(==== Test bunWithOnion ====)\r\n" +
                    "= sauce cheese =\r\n" +
                    "= filling pickles =\r\n" +
                    "(==== Test bunWithOnion ====)\r\n" +
                    "\r\n" +
                    "Price: 80,000000\r\n";



    private Burger burger;

    @Mock
    private Bun bunWithOnion;

    @Mock
    private Ingredient cheese, pickles, onion, patty;

    @Before
    public void setUp() {
        burger = new Burger(); // создание объекта
    }

    @Test
    public void testSetBunSetsCorrectBunWithOnion() {
        when(bunWithOnion.getName()).thenReturn("Test bunWithOnion");
        burger.setBuns(bunWithOnion);
        assertEquals("Test bunWithOnion", burger.bun.getName());
    }

    @Test
    public void testAddIngredientIncreasesListSize() {
        burger.addIngredient(cheese);
        assertEquals(1, burger.ingredients.size());
    }

    @Test
    public void testRemoveIngredientDecreasesListSize() {
        burger.addIngredient(cheese);
        burger.addIngredient(pickles);
        burger.addIngredient(onion);
        burger.addIngredient(patty);
        assertEquals(4, burger.ingredients.size());
        burger.removeIngredient(2);
        assertEquals(3, burger.ingredients.size());
    }

    @Test
    public void testMoveIngredientSwapsCorrectly() {
        burger.addIngredient(cheese);
        burger.addIngredient(pickles);
        burger.addIngredient(onion);
        burger.addIngredient(patty);
        burger.moveIngredient(1, 2);
        assertEquals(pickles, burger.ingredients.get(2));
        assertEquals(onion, burger.ingredients.get(1));
    }

    @Test
    public void testGetPriceReturnsCorrectSum() {
        burger.setBuns(bunWithOnion);
        burger.addIngredient(cheese);
        burger.addIngredient(pickles);
        burger.addIngredient(onion);
        burger.addIngredient(patty);

        // Устанавливаем цены для булочки и ингредиентов
        when(bunWithOnion.getPrice()).thenReturn(30F); // цена булочки
        when(cheese.getPrice()).thenReturn(20F); // цена сыра
        when(pickles.getPrice()).thenReturn(10F); // цена огурцов
        when(onion.getPrice()).thenReturn(5F); // цена лука
        when(patty.getPrice()).thenReturn(15F); // цена котлеты

        // Рассчитываем ожидаемую цену
        float expectedPrice = bunWithOnion.getPrice() * 2 + cheese.getPrice() + pickles.getPrice() + onion.getPrice() + patty.getPrice();

        // Проверяем, что фактическая цена совпадает с ожидаемой
        assertEquals(expectedPrice, burger.getPrice(), 0);
    }

    @Test
    public void testGetReceiptReturnsFormattedReceipt() {
        burger.setBuns(bunWithOnion);
        burger.addIngredient(cheese);
        burger.addIngredient(pickles);
        when(bunWithOnion.getName()).thenReturn("Test bunWithOnion");
        when(bunWithOnion.getPrice()).thenReturn(25F);
        when(cheese.getName()).thenReturn("cheese");
        when(cheese.getType()).thenReturn(IngredientType.SAUCE);
        when(cheese.getPrice()).thenReturn(20F);
        when(pickles.getName()).thenReturn("pickles");
        when(pickles.getType()).thenReturn(IngredientType.FILLING);
        when(pickles.getPrice()).thenReturn(10F);
        assertEquals(expectedReceipt, burger.getReceipt());
    }
}
