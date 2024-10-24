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
import java.util.ArrayList;
import java.util.List;

@RunWith(MockitoJUnitRunner.class)

public class BurgerTest {

    private Burger burger;

    @Mock
    Bun bun;
    @Mock
    Ingredient ingredient;
    @Mock
    List<Ingredient> ingredients;

    @Before
    public void setUp() {
        burger = new Burger();
    }

    @Test
    public void setBunTest() {
        Mockito.when(bun.getName()).thenReturn(Credentials.BUN_NAME);
        Mockito.when(bun.getPrice()).thenReturn(Credentials.BUN_PRICE);
        burger.setBuns(bun);
        Assert.assertEquals(Credentials.BUN_NAME, bun.getName());
        Assert.assertEquals(Credentials.BUN_PRICE, bun.getPrice(), Credentials.DELTA);
        Assert.assertEquals(bun, burger.bun);
    }

    @Test
    public void addIngredientTest() {
        burger.ingredients = ingredients;
        burger.addIngredient(ingredient);
        Mockito.verify(ingredients, Mockito.times(Credentials.MIN_ITERATIONS)).add(ingredient);
    }

    @Test
    public void removeIngredientTest() {
        burger.ingredients = ingredients;
        burger.removeIngredient(Credentials.INDEX);
        Mockito.verify(ingredients, Mockito.times(Credentials.MIN_ITERATIONS)).remove(Credentials.INDEX);
    }

    @Test
    public void moveIngredientTest() {
        burger.ingredients = ingredients;
        burger.moveIngredient(Credentials.INDEX, Credentials.NEW_INDEX);
        Mockito.verify(ingredients, Mockito.times(Credentials.MIN_ITERATIONS))
                .add(Credentials.NEW_INDEX, ingredients.remove(Credentials.INDEX));
    }

    @Test
    public void getPriceTest() {
        burger.setBuns(bun);
        Mockito.when(bun.getPrice()).thenReturn(Credentials.BUN_PRICE);
        List<Ingredient> ingredients = new ArrayList<>();
        for (int i = 0; i < Credentials.MAX_ITERATIONS; i++) {
            ingredients.add(ingredient);
        }
        burger.ingredients = ingredients;
        Mockito.when(ingredient.getPrice()).thenReturn(Credentials.INGREDIENT_PRICE);
        burger.getPrice();
        Mockito.verify(ingredient, Mockito.times(Credentials.MAX_ITERATIONS)).getPrice();
        Assert.assertEquals(Credentials.TOTAL_PRICE, burger.getPrice(), Credentials.DELTA);

    }


    @Test
    public void getReceiptTest() {
        burger.setBuns(bun);
        Mockito.when(ingredient.getType()).thenReturn(IngredientType.SAUCE);
        Mockito.when(ingredient.getName()).thenReturn(Credentials.INGREDIENT_NAME);
        Mockito.when(bun.getName()).thenReturn(Credentials.BUN_NAME);
        Mockito.when(bun.getPrice()).thenReturn(Credentials.BUN_PRICE);
        for (int i = 0; i < Credentials.MAX_ITERATIONS; i++) {
            burger.addIngredient(ingredient);
        }
        burger.getReceipt();
        Mockito.verify(ingredient, Mockito.times(Credentials.MAX_ITERATIONS)).getType();
        Mockito.verify(ingredient, Mockito.times(Credentials.MAX_ITERATIONS)).getName();
        Mockito.verify(bun, Mockito.times(2)).getName();
        Mockito.verify(bun, Mockito.times(Credentials.MIN_ITERATIONS)).getPrice();
        String expected = String.format("(==== black bun ====)%n= sauce hot sauce =%n= sauce hot sauce =%n= sauce hot sauce =" +
                "%n= sauce hot sauce =%n= sauce hot sauce =%n(==== black bun ====)%n%nPrice: 200,000000%n");
        Assert.assertEquals(expected, burger.getReceipt());
    }

}
