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
    private Bun mockBun = Mockito.mock(Bun.class);
    private Ingredient mockSauce;
    private Ingredient mockIngredient;

    @Before
    public void setUp() {
        burger = new Burger();
        mockSauce = Mockito.mock(Ingredient.class);
        mockIngredient = Mockito.mock(Ingredient.class);
    }

    @Test
    public void testSetBuns() {
        burger.setBuns(mockBun);

        Assert.assertEquals(mockBun, burger.bun);
    }

    @Test
    public void testAddIngredient() {
        Mockito.when(mockIngredient.getName()).thenReturn("cheese");

        burger.addIngredient(mockIngredient);

        Assert.assertEquals(1, burger.ingredients.size());
        Assert.assertEquals(mockIngredient.getName(), burger.ingredients.get(0).getName());
    }

    @Test
    public void testRemoveIngredient() {
        Mockito.when(mockIngredient.getName()).thenReturn("cheese");

        burger.addIngredient(mockSauce);
        burger.addIngredient(mockIngredient);
        burger.removeIngredient(0);

        Assert.assertEquals(1, burger.ingredients.size());
        Assert.assertEquals(mockIngredient.getName(), burger.ingredients.get(0).getName());
    }

    @Test
    public void testMoveIngredient() {
        Mockito.when(mockSauce.getName()).thenReturn("ketchup");

        burger.addIngredient(mockSauce);
        burger.addIngredient(mockIngredient);
        burger.moveIngredient(0,1);

        Assert.assertEquals(2, burger.ingredients.size());
        Assert.assertEquals(mockSauce.getName(), burger.ingredients.get(1).getName());
    }

    @Test
    public void testGetPrice() {
        Mockito.when(mockBun.getPrice()).thenReturn(50f);
        Mockito.when(mockSauce.getPrice()).thenReturn(20f);
        Mockito.when(mockIngredient.getPrice()).thenReturn(100f);

        burger.setBuns(mockBun);
        burger.addIngredient(mockSauce);
        burger.addIngredient(mockIngredient);

        Assert.assertEquals(220f, burger.getPrice(), 0);
    }

    @Test
    public void testGetReceipt() {
        Mockito.when(mockBun.getName()).thenReturn("bun");
        Mockito.when(mockIngredient.getName()).thenReturn("cheese");
        Mockito.when(mockSauce.getName()).thenReturn("ketchup");
        Mockito.when(mockSauce.getType()).thenReturn(IngredientType.SAUCE);
        Mockito.when(mockIngredient.getType()).thenReturn(IngredientType.FILLING);
        Mockito.when(mockBun.getPrice()).thenReturn(50f);
        Mockito.when(mockSauce.getPrice()).thenReturn(20f);
        Mockito.when(mockIngredient.getPrice()).thenReturn(100f);

        burger.setBuns(mockBun);
        burger.addIngredient(mockSauce);
        burger.addIngredient(mockIngredient);

        String expectedReceipt = String.format("(==== %s ====)%n", "bun") +
                String.format("= %s %s =%n", "sauce", "ketchup") +
                String.format("= %s %s =%n", "filling", "cheese") +
                String.format("(==== %s ====)%n", "bun") +
                String.format("%nPrice: %f%n", 220.0f);

        Assert.assertEquals(expectedReceipt, burger.getReceipt());
    }
}
