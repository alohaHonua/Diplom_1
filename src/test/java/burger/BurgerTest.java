package burger;

import net.datafaker.Faker;
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

import java.util.ArrayList;
import java.util.List;

import static praktikum.IngredientType.SAUCE;

@RunWith(MockitoJUnitRunner.class)
public class BurgerTest {
    Faker faker = new Faker();
    private final IngredientType typeOfIngredient = SAUCE;
    private final String nameOfIngredient = faker.food().ingredient();
    Burger burger = new Burger();
    @Mock
    Ingredient ingredient;
    @Mock
    Ingredient ingredient1;
    @Mock
    Bun bun;

    @Test
    public void addIngredientTest() {
        burger.addIngredient(ingredient);
        Assert.assertTrue(burger.ingredients.contains(ingredient));
    }

    @Test
    public void removeIngredientTest() {
        List<Ingredient> list = new ArrayList<>(1);
        burger.addIngredient(ingredient);
        burger.removeIngredient(0);
        Assert.assertEquals(list, burger.ingredients);
    }

    @Test
    public void moveIngredientTest() {
        burger.addIngredient(ingredient);
        burger.addIngredient(ingredient1);
        burger.moveIngredient(0, 1);
        Assert.assertEquals(burger.ingredients.get(1), ingredient);
    }

    @Test
    public void getPriceTest() {
        burger.setBuns(bun);
        burger.addIngredient(ingredient);
        Mockito.when(bun.getPrice()).thenReturn(100.000F);
        Mockito.when(ingredient.getPrice()).thenReturn(20.000F);
        Assert.assertEquals(220.000F, burger.getPrice(), 0);
    }

    @Test
    public void getReceiptTest() {
        String expectedResult =
                "(==== " + nameOfIngredient + " ====)" +
                        "\r\n" +
                        "= sauce null =" +
                        "\r\n" +
                        "(==== " + nameOfIngredient + " ====)" +
                        "\r\n" +
                        "\r\n" +
                        "Price: 100,000000" +
                        "\r\n";
        burger.setBuns(bun);
        burger.addIngredient(ingredient);
        Mockito.when(bun.getName()).thenReturn(nameOfIngredient);
        Mockito.when(burger.getPrice()).thenReturn(100.000F);
        Mockito.when(ingredient.getType()).thenReturn(typeOfIngredient);
        Assert.assertEquals(expectedResult, burger.getReceipt());
    }
}
