import org.junit.Assert;
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
public class BurgerMockTest {
    @Mock
    private Bun bunMock;

    @Mock
    private Ingredient ingredientMock;

    @Test
    public void setBunsTest() {
        Burger burger = new Burger();
        burger.setBuns(bunMock);
        Assert.assertEquals(bunMock, burger.bun);

    }
    @Test
    public void addIngredientBurgerTest() {
        Burger burger = new Burger();
        burger.addIngredient(ingredientMock);
        Assert.assertTrue(burger.ingredients.contains(ingredientMock));

    }
    @Test
    public void removeIngredientBurgerTest() {
        Burger burger = new Burger();
        burger.addIngredient(ingredientMock);
        burger.removeIngredient(0);
        Assert.assertFalse(burger.ingredients.contains(ingredientMock));
    }
    @Test
    public void moveIngredientBurgerTest() {
        Burger burger = new Burger();
        burger.addIngredient(new Ingredient(IngredientType.FILLING, "Мясо бессмертных моллюсков Protostomia", 1337));
        burger.addIngredient(new Ingredient(IngredientType.SAUCE, "Соус Spicy-X", 90));
        burger.moveIngredient(0, 1);
        Assert.assertEquals("Мясо бессмертных моллюсков Protostomia", burger.ingredients.get(1).name);
    }
    @Test
    public void getPriceBurgerTest() {
        Burger burger = new Burger();
        float price = 300;
        Mockito.when(bunMock.getPrice()).thenReturn(price);
        Mockito.when(ingredientMock.getPrice()).thenReturn(price);
        burger.setBuns(bunMock);
        burger.addIngredient(ingredientMock);
        Assert.assertEquals(price * 2 + price, burger.getPrice(), 0);
    }
    @Test
    public void getReceiptBurgerTest() {
        Burger burger = new Burger();
        burger.setBuns(bunMock);
        burger.addIngredient(new Ingredient(IngredientType.FILLING, "Сыр с астероидной плесенью", 4142));
        burger.addIngredient(new Ingredient(IngredientType.SAUCE, "Соус Spicy-X", 90));
        String expectedReceipt = burger.getReceipt();
        Assert.assertEquals(expectedReceipt, burger.getReceipt());
    }
}
