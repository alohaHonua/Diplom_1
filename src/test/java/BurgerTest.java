import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import praktikum.Bun;
import praktikum.Burger;
import praktikum.Ingredient;
import praktikum.IngredientType;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;


public class BurgerTest {
    private Burger burger;

    //стаб для булки
    public Bun getMockBun() {
        Bun bunMock = mock(Bun.class);
        when(bunMock.getName()).thenReturn("black bun");
        when(bunMock.getPrice()).thenReturn((float)100);
        return bunMock;
    }

    //стаб для первого ингредиента - Соусы
    public Ingredient getMockSauce() {
        Ingredient ingredientMock = mock(Ingredient.class);
        when(ingredientMock.getType()).thenReturn(IngredientType.SAUCE);
        when(ingredientMock.getName()).thenReturn("hot sauce");
        when(ingredientMock.getPrice()).thenReturn((float)100);
        return ingredientMock;
    }

    //стаб для второго ингредиента - Начинка
    public Ingredient getMockeFilling() {
        Ingredient ingredientMock = mock(Ingredient.class);
        when(ingredientMock.getType()).thenReturn(IngredientType.FILLING);
        when(ingredientMock.getName()).thenReturn("cutlet");
        when(ingredientMock.getPrice()).thenReturn((float)100);
        return ingredientMock;
    }

    @Before
    public void setUp() {
        burger = new Burger();
    }

    @Test
    public void setBunWithMockDataTest() {
        Bun bunExpected = getMockBun();
        burger.setBuns(bunExpected);
        Assert.assertEquals(bunExpected, burger.bun);

    }

    @Test
    public void addIngredientMockSauceDataTest() {
        Ingredient ingredientExpected = getMockSauce();
        burger.addIngredient(ingredientExpected);
        Assert.assertEquals(ingredientExpected, burger.ingredients.get(0));
    }

    @Test
    public void addIngredientMockFillingDataTest() {
        Ingredient ingredientExpected = getMockeFilling();
        burger.addIngredient(ingredientExpected);
        Assert.assertEquals(ingredientExpected, burger.ingredients.get(0));
    }

    @Test
    public void removeIngredientWithMockDataTest() {
        Ingredient ingredient = getMockSauce();
        burger.addIngredient(ingredient);
        burger.removeIngredient(0);
        Assert.assertTrue(burger.ingredients.isEmpty());
    }

    @Test
    public void moveIngredientWithMockDataTest() {
        Ingredient firstIngredient = getMockSauce();
        Ingredient secondIngredient = getMockeFilling();
        burger.addIngredient(firstIngredient);
        burger.addIngredient(secondIngredient);
        burger.moveIngredient(0, 1);
        Assert.assertEquals(firstIngredient.name, burger.ingredients.get(1).name);
    }

    @Test
    public void getPriceWithMockData() {
        Bun bunExpected = getMockBun();
        Ingredient firstIngredientExpected = getMockSauce();
        Ingredient secondIngredientExpected = getMockeFilling();
        burger.setBuns(bunExpected);
        burger.addIngredient(firstIngredientExpected);
        burger.addIngredient(secondIngredientExpected);
        float actual = burger.getPrice();
        float expected = (getMockBun().getPrice()*2)+ getMockSauce().getPrice()+ getMockeFilling().getPrice();
        Assert.assertEquals(expected, actual, 0);
    }

    @Test
    public void getReceiptCheckWithMockData() {
        Bun bunMock = getMockBun();
        Ingredient firstIngredientMock = getMockSauce();
        Ingredient secondIngredientMock = getMockeFilling();
        burger.setBuns(bunMock);
        burger.addIngredient(firstIngredientMock);
        burger.addIngredient(secondIngredientMock);
        String actualReceipt = burger.getReceipt();
        String expectedReceipt = String.format("(==== black bun ====)%n" +
                "= sauce hot sauce =%n" +
                "= filling cutlet =%n" +
                "(==== black bun ====)%n" +
                "%n" +
                "Price: 400,000000%n");
        Assert.assertEquals(expectedReceipt, actualReceipt);
    }

}
