import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import praktikum.Bun;
import praktikum.Burger;
import praktikum.Ingredient;


import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.when;
import static praktikum.IngredientType.FILLING;
import static praktikum.IngredientType.SAUCE;

@RunWith(MockitoJUnitRunner.class)

public class BurgerTest {

    private Burger burger;

    @Mock
    private Bun bun;

    @Mock
    private Ingredient ingredientFilling;

    @Mock
    private Ingredient ingredientSauce;

    @Before
    public void setUp() {
        burger  = new Burger();
    }

    @Test
    public void setBunTest() {
        burger.setBuns(bun);
        assertEquals("Булочка не соответствует ожидаемой", bun, burger.bun);
    }

    @Test
    public void addIngredientTest() {
        burger.addIngredient(ingredientFilling);
        assertEquals("Ингредиент не был добавлен", ingredientFilling, burger.ingredients.get(0));
    }

    @Test
    public void removeIngredientTest() {
        burger.addIngredient(ingredientFilling);
        burger.removeIngredient(0);
        assertTrue("Ингредиент не был удален", burger.ingredients.isEmpty());
    }

    @Test
    public void moveIngredientTest() {
        burger.addIngredient(ingredientFilling);
        burger.addIngredient(ingredientSauce);
        burger.moveIngredient(0,1);
        assertEquals("Ингредиент не был перемещен",ingredientFilling, burger.ingredients.get(1));
    }

    @Test
    public void getPriceTest() {
        burger.setBuns(bun);
        burger.addIngredient(ingredientFilling);
        burger.addIngredient(ingredientSauce);
        when(bun.getPrice()).thenReturn(100f);
        when(ingredientFilling.getPrice()).thenReturn(200f);
        when(ingredientSauce.getPrice()).thenReturn(200f);
        float expectedPrice = 100f * 2 + 200f + 200f;
        assertEquals("Цена не соответствует ожидаемой", expectedPrice, burger.getPrice(), 0.01f);
    }
    @Test
    public void getReceiptTest() {
        burger.setBuns(bun);
        burger.addIngredient(ingredientFilling);
        burger.addIngredient(ingredientSauce);

        when(bun.getName()).thenReturn("black bun");
        when(ingredientFilling.getName()).thenReturn("dinosaur");
        when(ingredientFilling.getType()).thenReturn(FILLING);
        when(ingredientSauce.getName()).thenReturn("sour cream");
        when(ingredientSauce.getType()).thenReturn(SAUCE);
        when(bun.getPrice()).thenReturn(100f);
        when(ingredientFilling.getPrice()).thenReturn(200f);
        when(ingredientSauce.getPrice()).thenReturn(200f);
        String expectedReceipt = "(==== black bun ====)\r\n" +
                "= filling dinosaur =\r\n" +
                "= sauce sour cream =\r\n" +
                "(==== black bun ====)\r\n" +
                "\r\n" +
                "Price: 600,000000\r\n";
        assertEquals("Чек сформирован неправильно", expectedReceipt.trim(), burger.getReceipt().trim());

    }
}
