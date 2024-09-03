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
public class BurgerTest {

    @Mock
    Bun bun;
    @Mock
    Ingredient meat;
    @Mock
    Ingredient cheese;
    @Mock
    Ingredient ketchup;

    Burger burger;

    private final float bunPrice = 50.0f;
    private final float ingredientPrice = 20.0f;

    public void makeCheeseburger() {
        burger = new Burger();

        burger.setBuns(bun);

        burger.addIngredient(meat);
        burger.addIngredient(cheese);
        burger.addIngredient(ketchup);
    }

    public void mockPrices() {
        Mockito.when(bun.getPrice()).thenReturn(bunPrice);
        Mockito.when(meat.getPrice()).thenReturn(ingredientPrice);
        Mockito.when(cheese.getPrice()).thenReturn(ingredientPrice);
        Mockito.when(ketchup.getPrice()).thenReturn(ingredientPrice);
    }

    public void mockNames() {
        Mockito.when(bun.getName()).thenReturn("Пшеничная булочка");
        Mockito.when(meat.getName()).thenReturn("Говяжья котлета");
        Mockito.when(cheese.getName()).thenReturn("Сыр чеддер");
        Mockito.when(ketchup.getName()).thenReturn("Кетчуп");
    }

    public void mockTypes() {
        Mockito.when(meat.getType()).thenReturn(IngredientType.FILLING);
        Mockito.when(cheese.getType()).thenReturn(IngredientType.FILLING);
        Mockito.when(ketchup.getType()).thenReturn(IngredientType.SAUCE);
    }

    public void mockAll() {
        mockTypes();
        mockNames();
        mockPrices();
    }

    @Test
    public void getPriceTest() {

        makeCheeseburger();

        mockPrices();

        Assert.assertEquals(burger.getPrice(), bunPrice * 2 + ingredientPrice * 3, 0.001);

    }

    @Test
    public void getReceiptTest() {

        String expectedReceipt = String.format("(==== Пшеничная булочка ====)%n= filling Говяжья котлета =%n= filling Сыр чеддер =%n= sauce Кетчуп =%n(==== Пшеничная булочка ====)%n%nPrice: 160,000000%n");

        makeCheeseburger();

        mockAll();

        Assert.assertEquals(burger.getReceipt(), expectedReceipt);

    }

    @Test
    public void removeIngredientTest() {
        String expectedReceipt = String.format("(==== Пшеничная булочка ====)%n= filling Говяжья котлета =%n= filling Сыр чеддер =%n(==== Пшеничная булочка ====)%n%nPrice: 140,000000%n");

        makeCheeseburger();

        mockAll();

        burger.removeIngredient(2);

        Assert.assertEquals(burger.getPrice(), bunPrice * 2 + ingredientPrice * 2, 0.001);

        Assert.assertEquals(burger.getReceipt(), expectedReceipt);
    }

    @Test
    public void moveIngredientTest() {
        String expectedReceipt = String.format("(==== Пшеничная булочка ====)%n= sauce Кетчуп =%n= filling Говяжья котлета =%n= filling Сыр чеддер =%n(==== Пшеничная булочка ====)%n%nPrice: 160,000000%n");

        makeCheeseburger();

        mockAll();

        burger.moveIngredient(2, 0);

        Assert.assertEquals(burger.getPrice(), bunPrice * 2 + ingredientPrice * 3, 0.001);

        Assert.assertEquals(burger.getReceipt(), expectedReceipt);
    }

}
