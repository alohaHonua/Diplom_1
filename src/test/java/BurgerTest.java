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
    private final String bunName = "bunName";
    private final String ingredientName = "ingredientName";
    private final float bunPrice = 123;
    private final float ingredientPrice = 456;
    @Mock
    Bun bun;
    @Mock
    Ingredient ingredient1;
    @Mock
    Ingredient ingredient2;

    @Before
    public  void setUp() {
        burger = new Burger();
    }

    @Test
    public void setBunTest() {
        burger.setBuns(bun);
        Assert.assertEquals(bun, burger.bun);
    }

    @Test
    public void burgerAddIngredientTest() {
        burger.addIngredient(ingredient1);
        Assert.assertEquals(ingredient1, burger.ingredients.get(0));
    }

    @Test
    public void burgerMoveIngredientTest() {
        burger.addIngredient(ingredient1);
        burger.addIngredient(ingredient1);
        burger.addIngredient(ingredient2);
        burger.moveIngredient(2,1);
        Assert.assertEquals(ingredient2, burger.ingredients.get(1));
    }

    @Test
    public void burgerRemoveIngredientTest() {
        burger.addIngredient(ingredient1);
        burger.addIngredient(ingredient1);
        burger.removeIngredient(0);
        Assert.assertEquals(burger.ingredients.size(), 1);
    }

    @Test
    public void getReceiptTextTest() {
        Mockito.when(bun.getName()).thenReturn(bunName);
        Mockito.when(ingredient1.getType()).thenReturn(IngredientType.SAUCE);
        Mockito.when(ingredient1.getName()).thenReturn(ingredientName);
        Mockito.when(bun.getPrice()).thenReturn(bunPrice);
        Mockito.when(ingredient1.getPrice()).thenReturn(ingredientPrice);
        burger.setBuns(bun);
        burger.addIngredient(ingredient1);
        String actualResult = burger.getReceipt();
        String expectedResult = String.format("(==== " + bunName + " ====)%n" +
                "= sauce "+ ingredientName +" =%n" +
                "(==== "+ bunName +" ====)%n" +
                "%n" +
                "Price: "+ String.format("%f", ((bunPrice * 2) + ingredientPrice)) +"%n");
        Assert.assertEquals(expectedResult, actualResult);
    }

    @Test
    public void getPriceTest() {
        burger.setBuns(bun);
        burger.addIngredient(ingredient1);
        burger.addIngredient(ingredient2);
        float actualResult = burger.getPrice();
        float expectedResult = bun.getPrice() * 2 + ingredient1.getPrice() + ingredient2.getPrice();
        Assert.assertEquals(expectedResult, actualResult, 0);
    }
}
