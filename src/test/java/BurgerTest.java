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

    Burger burger = new Burger();

    @Mock
    private Bun bun;
    @Mock
    private Ingredient FirstIngredient;
    @Mock
    private Ingredient SecondIngredient;

    // Тестирование добавления булочек
    @Test
    public void setBunsTest() {
        burger.setBuns(bun);
        Assert.assertEquals("Метод выбора булочек сработал неправильно", bun, burger.bun);
    }

    // Тестирование добавления ингредиента
    @Test
    public void checkAddIngredientTest() {
        burger.addIngredient(FirstIngredient);

        Assert.assertTrue("Метод не добавил новый ингредиент", burger.ingredients.contains(FirstIngredient));
    }

    // Тестирование удаления ингредиента
    @Test
    public void checkRemoveIngredientTest() {
        burger.addIngredient(FirstIngredient);
        burger.removeIngredient(0);

        int expectedSize = 0;
        Assert.assertEquals("Метод удаления ингредиента отработал неправильно", expectedSize, burger.ingredients.size());
    }

    // Тестирование изменения порядка ингредиентов
    @Test
    public void checkMoveIngredientTest() {
        burger.addIngredient(FirstIngredient);
        burger.addIngredient(SecondIngredient);
        burger.moveIngredient(1, 0);

        int expectedIndex = 0;
        int actualIndex = burger.ingredients.indexOf(SecondIngredient);
        Assert.assertEquals("Метод вернул неправильную позицию ингредиента", expectedIndex, actualIndex);
    }

    // Тестирование подсчета цены бургера
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

    // Тестирование вывода рецепта бургера
    @Test
    public void checkGetReceipt() {
        Mockito.when(bun.getName()).thenReturn("black bun");
        Mockito.when(FirstIngredient.getType()).thenReturn(IngredientType.SAUCE);
        Mockito.when(FirstIngredient.getName()).thenReturn("chili sauce");
        Mockito.when(FirstIngredient.getPrice()).thenReturn(300F);
        burger.setBuns(bun);
        burger.addIngredient(FirstIngredient);

        String expectedReceipt = "(==== black bun ====)\r\n" +
                "= sauce chili sauce =\r\n" +
                "(==== black bun ====)\r\n" +
                "\r\n" +
                "Price: 300,000000\r\n";
        Assert.assertEquals("Метод вернул неправильный рецепт", expectedReceipt, burger.getReceipt());
    }
}