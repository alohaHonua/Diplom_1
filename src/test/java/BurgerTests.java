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
public class BurgerTests {

    Burger burger = new Burger();

    @Mock
    private Bun bun;
    @Mock
    private Ingredient FirstIngredient;
    @Mock
    private Ingredient SecondIngredient;

    @Test
    public void setBunsTest() {
        burger.setBuns(bun);
        Assert.assertEquals("Метод выбора булочек сработал неправильно", bun, burger.bun);
    }

    @Test
    public void checkAddIngredientTest() {
        burger.addIngredient(FirstIngredient);

        Assert.assertTrue("Метод не добавил новый ингредиент", burger.ingredients.contains(FirstIngredient));
    }

    @Test
    public void checkRemoveIngredientTest() {
        burger.addIngredient(FirstIngredient);
        burger.removeIngredient(0);

        int expectedSize = 0;
        Assert.assertEquals("Метод удаления ингредиента отработал неправильно", expectedSize, burger.ingredients.size());
    }

    @Test
    public void checkMoveIngredientTest() {
        burger.addIngredient(FirstIngredient);
        burger.addIngredient(SecondIngredient);
        burger.moveIngredient(1, 0);

        int expectedIndex = 0;
        int actualIndex = burger.ingredients.indexOf(SecondIngredient);
        Assert.assertEquals("Метод вернул непрпавильную позицию ингредиента", expectedIndex, actualIndex);
    }

    @Test
    public void checkGetPriceTest() {
        Mockito.when(bun.getPrice()).thenReturn(100F);
        Mockito.when(FirstIngredient.getPrice()).thenReturn(100F);
        Mockito.when(SecondIngredient.getPrice()).thenReturn(150F);
        burger.setBuns(bun);
        burger.addIngredient(FirstIngredient);
        burger.addIngredient(SecondIngredient);

        float expectedPrice = 450F;
        Assert.assertEquals("Метод вернул неправильную цену", expectedPrice, burger.getPrice(), 0F);
    }

    @Test
    public void checkGetReceipt() {
        Mockito.when(bun.getName()).thenReturn("white bun");
        Mockito.when(FirstIngredient.getType()).thenReturn(IngredientType.SAUCE);
        Mockito.when(FirstIngredient.getName()).thenReturn("chili sauce");
        Mockito.when(FirstIngredient.getPrice()).thenReturn(300F);
        burger.setBuns(bun);
        burger.addIngredient(FirstIngredient);

        String expectedReceipt = "(==== white bun ====)\r\n" +
                "= sauce chili sauce =\r\n" +
                "(==== white bun ====)\r\n" +
                "\r\n" +
                "Price: 300,000000\r\n";
        Assert.assertEquals("Метод вернул неправильный рецепт", expectedReceipt, burger.getReceipt());
    }
}