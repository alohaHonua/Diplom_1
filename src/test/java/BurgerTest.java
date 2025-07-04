import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import praktikum.Bun;
import praktikum.Burger;
import praktikum.Ingredient;
import praktikum.IngredientType;
import static org.mockito.Mockito.when;
import java.util.List;

@RunWith(MockitoJUnitRunner.class)
public class BurgerTest {

    private Burger burger;

    @Mock
    private Bun bun;

    @Mock
    private Ingredient ingredient1;

    @Mock
    private Ingredient ingredient2;

    @Mock
    private Ingredient ingredient3;

    @Before
    public void setUp() {
        burger = new Burger();
        when(bun.getName()).thenReturn("white bun");
        when(bun.getPrice()).thenReturn(200F);
        when(ingredient1.getType()).thenReturn(IngredientType.FILLING);
        when(ingredient1.getName()).thenReturn("dinosaur");
        when(ingredient1.getPrice()).thenReturn(200F);
        when(ingredient2.getType()).thenReturn(IngredientType.FILLING);
        when(ingredient2.getName()).thenReturn("cutlet");
        when(ingredient2.getPrice()).thenReturn(100F);
        when(ingredient3.getType()).thenReturn(IngredientType.SAUCE);
        when(ingredient3.getName()).thenReturn("hot sauce");
        when(ingredient3.getPrice()).thenReturn(100F);
    }

    @Test
    public void setBunTest() {
        burger.setBuns(bun);
        assertEquals("Название булки отличается от" + bun.getName(), bun.getName(), burger.bun.getName());
    }

    @Test
    public void addIngredientTest() {
        burger.addIngredient(ingredient1);
        assertEquals("В бургер было добавлено неверное количество ингредиентов", 1, burger.ingredients.size());
    }

    @Test
    public void removeIngredientTest() {
        burger.ingredients.add(ingredient1);
        burger.ingredients.add(ingredient2);
        burger.ingredients.add(ingredient3);
        burger.removeIngredient(1);
        assertEquals("Количество ингредиентов не совпадает", 2, burger.ingredients.size());
    }

    @Test
    public void removeIngredientRemovesRightIngredientTest() {
        burger.ingredients.add(ingredient1);
        burger.ingredients.add(ingredient2);
        burger.ingredients.add(ingredient3);
        burger.removeIngredient(1);
        List<Ingredient> expected = List.of(ingredient1, ingredient3);
        assertTrue("Из бургера был убран неверный ингредиент", burger.ingredients.containsAll(expected));
    }

    @Test
    public void moveIngredientTest() {
        burger.ingredients.add(ingredient1);
        burger.ingredients.add(ingredient2);
        burger.ingredients.add(ingredient3);
        burger.moveIngredient(2, 1);
        assertEquals("Ингредиент находится не на ожидаемом месте", burger.ingredients.get(1), ingredient3);
    }

    @Test
    public void getPriceTest() {
        burger.bun = bun;
        burger.ingredients.add(ingredient1);
        burger.ingredients.add(ingredient2);
        burger.ingredients.add(ingredient3);

        float expectedPrice =
                bun.getPrice() * 2
                + ingredient1.getPrice()
                + ingredient2.getPrice()
                + ingredient3.getPrice();

        assertEquals("Ожидаемая стоимость = " + expectedPrice + " | Полученная стоимость = " + burger.getPrice(), expectedPrice, burger.getPrice(), 0);
    }

    @Test
    public void getReceiptTest() {
        burger.bun = bun;
        burger.ingredients.add(ingredient1);
        burger.ingredients.add(ingredient2);
        burger.ingredients.add(ingredient3);

        String actualReceipt = burger.getReceipt();
        String expectedReceipt = "(==== white bun ====)\r\n" +
                "= filling dinosaur =\r\n" +
                "= filling cutlet =\r\n" +
                "= sauce hot sauce =\r\n" +
                "(==== white bun ====)\r\n" +
                "\r\n" +
                "Price: 800,000000\r\n";

        assertEquals("Получен чек неверного вида", expectedReceipt, actualReceipt);
    }
}
