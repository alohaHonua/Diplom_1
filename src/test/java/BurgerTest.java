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

    Burger burger;

    @Mock
    Bun bun;

    @Mock
    Ingredient ingredient;

    @Mock
    Ingredient firstIngredient;

    @Mock
    Ingredient secondIngredient;

    @Before
    public void setUp() {
        burger = new Burger();
    }

    @Test
    public void setBunsSuccess() throws Exception {
        burger.setBuns(bun);
        Assert.assertEquals(bun, burger.bun);
    }

    @Test
    public void addIngredientSuccess() throws Exception {
        burger.addIngredient(ingredient);
        Assert.assertTrue(burger.ingredients.contains(ingredient));
    }

    @Test
    public void removeIngredientSuccess() throws Exception {
        burger.addIngredient(ingredient);
        burger.removeIngredient(burger.ingredients.size() - 1);
        Assert.assertFalse(burger.ingredients.contains(ingredient));
    }

    @Test
    public void moveIngredientSuccess() throws Exception {
        burger.addIngredient(firstIngredient);
        burger.addIngredient(secondIngredient);
        burger.moveIngredient(0, 1);
        Assert.assertEquals(firstIngredient.name, burger.ingredients.get(1).name);
    }

    @Test
    public void getPriceSuccess() throws Exception {
        burger.setBuns(bun);
        burger.addIngredient(ingredient);
        Mockito.when(bun.getPrice()).thenReturn(100.0F);
        Mockito.when(ingredient.getPrice()).thenReturn(50.0F);
        Assert.assertEquals(250.0F, burger.getPrice(), 0.0F);
    }

    @Test
    public void getReceiptSuccess() throws Exception {
        burger.setBuns(bun);
        burger.addIngredient(ingredient);
        Mockito.when(bun.getPrice()).thenReturn(100.0F);
        Mockito.when(ingredient.getPrice()).thenReturn(50.0F);
        Mockito.when(bun.getName()).thenReturn("Флюоресцентная булка R2-D3");
        Mockito.when(ingredient.getType()).thenReturn(IngredientType.SAUCE);
        Mockito.when(ingredient.getName()).thenReturn("Соус Spicy-X");
        Assert.assertEquals(String.format("(==== Флюоресцентная булка R2-D3 ====)%n" +
                "= sauce Соус Spicy-X =%n" +
                "(==== Флюоресцентная булка R2-D3 ====)%n" +
                "%nPrice: 250,000000%n"), burger.getReceipt());
    }









}
