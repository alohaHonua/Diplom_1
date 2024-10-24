import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import praktikum.Bun;
import praktikum.Burger;
import praktikum.Ingredient;
import praktikum.IngredientType;

@RunWith(MockitoJUnitRunner.class)
public class BurgerTest {

    private Burger burger;

    @Mock
    private Ingredient sauce;
    @Mock
    private Ingredient filling;
    @Mock
    private Bun bun;

    @Before
    public void setUp() {
        burger = new Burger(); // Инициализация перед каждым тестом
    }

    @Test
    public void setBunsTest() {
        Bun bunForTest = new Bun("name", 10F);
        burger.setBuns(bunForTest);

        Assert.assertSame(bunForTest, burger.bun);
    }

    @Test
    public void addIngredientTest() {
        int initialSize = burger.ingredients.size();
        burger.addIngredient(sauce);
        int newSize = burger.ingredients.size();
        Assert.assertEquals(initialSize + 1, newSize);
    }

    @Test
    public void removeIngredientTest() {
        burger.addIngredient(sauce);
        int initialSize = burger.ingredients.size();
        burger.removeIngredient(0);
        int newSize = burger.ingredients.size();
        Assert.assertEquals(initialSize - 1, newSize);
    }

    @Test
    public void moveIngredientTest() {
        burger.addIngredient(sauce);
        burger.addIngredient(filling);
        burger.moveIngredient(1, 0);
        Assert.assertEquals(filling, burger.ingredients.get(0));
    }

    @Test
    public void getPriceTest() {
        Mockito.when(bun.getPrice()).thenReturn(20F);
        Mockito.when(sauce.getPrice()).thenReturn(60F);

        burger.setBuns(bun);
        burger.addIngredient(sauce);

        float expected = 80F; // Обратите внимание, корректируйте соответственно
        Assert.assertEquals(expected, burger.getPrice(), 0.001F);
    }

    @Test
    public void getReceiptTest() {
        String expected = String.format("(==== black bun ====)%n"
                + "= sauce sour cream =%n"
                + "(==== black bun ====)%n"
                + "%n"
                + "Price: 600.0%n");

        burger.addIngredient(sauce);
        burger.setBuns(bun);

        Mockito.when(bun.getPrice()).thenReturn(300F);
        Mockito.when(sauce.getPrice()).thenReturn(300F);
        Mockito.when(bun.getName()).thenReturn("black bun");
        Mockito.when(sauce.getName()).thenReturn("sour cream");
        Mockito.when(sauce.getType()).thenReturn(IngredientType.SAUCE);

        Assert.assertEquals(expected, burger.getReceipt());
    }
}