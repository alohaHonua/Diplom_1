import org.assertj.core.api.SoftAssertions;
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
public class BurgerMockTest {

    private Burger burger;

    @Mock
    Bun bunMock;

    @Mock
    Ingredient ingredientMock;

    @Mock
    Ingredient ingredient2Mock;

    @Before
    public void setUp() {
        burger = new Burger();
        Mockito.when(bunMock.getPrice()).thenReturn(1255f);
        Mockito.when(bunMock.getName()).thenReturn("Краторная булка");
        burger.setBuns(bunMock);
    }

    @Test
    public void addIngredientCorrectAdditionTest() {
        SoftAssertions softAssertions = new SoftAssertions();

        softAssertions.assertThat(burger.ingredients.size())
                .as("Ингредиентов в бургере должно быть 0")
                .isEqualTo(0);

        burger.addIngredient(ingredientMock);

        softAssertions.assertThat(burger.ingredients.size())
                .as("Ингредиентов в бургере должно быть 1")
                .isEqualTo(1);

        softAssertions.assertAll();
    }

    @Test
    public void removeIngredientCorrectRemoveTest() {
        SoftAssertions softAssertions = new SoftAssertions();
        softAssertions.assertThat(burger.ingredients.size())
                .as("Ингредиентов в бургере должно быть 0")
                .isEqualTo(0);

        burger.addIngredient(ingredientMock);
        burger.addIngredient(ingredient2Mock);

        softAssertions.assertThat(burger.ingredients.size())
                .as("Ингредиентов в бургер должно быть 2")
                .isEqualTo(2);

        burger.removeIngredient(1);
        softAssertions.assertThat(burger.ingredients.size())
                .as("Ингредиентов в бургере должно быть 1")
                .isEqualTo(1);

        softAssertions.assertThat(burger.ingredients.get(0).equals(ingredientMock))
                .as("Ингредиент удаляется некорректно")
                .isTrue();

        softAssertions.assertAll();
    }

    @Test
    public void moveIngredientCorrectMovingTest() {
        SoftAssertions softAssertions = new SoftAssertions();

        softAssertions.assertThat(burger.ingredients.size())
                .as("Ингредиентов в бургере должно быть 0")
                .isEqualTo(0);

        burger.addIngredient(ingredientMock);
        burger.addIngredient(ingredient2Mock);

        softAssertions.assertThat(burger.ingredients.size())
                .as("Ингредиентов в бургере должно быть 2")
                .isEqualTo(2);

        burger.moveIngredient(0, 1);

        softAssertions.assertThat(burger.ingredients.get(0).equals(ingredient2Mock))
                .as("Перемещение происходит некорректно")
                .isTrue();
        softAssertions.assertThat(burger.ingredients.get(1).equals(ingredientMock))
                .as("Перемещение происходит некорректно")
                .isTrue();
        softAssertions.assertAll();
    }

    @Test
    public void getPriceGetCorrectPriceTest() {
        SoftAssertions softAssertions = new SoftAssertions();

        Mockito.when(ingredientMock.getPrice()).thenReturn(424f);
        Mockito.when(ingredient2Mock.getPrice()).thenReturn(4142f);

        softAssertions.assertThat(burger.ingredients.size())
                .as("Ингредиентов в бургере должно быть 0")
                .isEqualTo(0);
        burger.addIngredient(ingredientMock);
        burger.addIngredient(ingredient2Mock);

        float expectedPrice = 1255f * 2 + 424f + 4142f;
        System.out.println();
        softAssertions.assertThat(burger.getPrice())
                .as("Цена бургера рассчитана неверно")
                .isEqualTo(expectedPrice);

        softAssertions.assertAll();
    }

    @Test
    public void getReceiptGetCorrectReceiptTest() {
        SoftAssertions softAssertions = new SoftAssertions();

        Mockito.when(ingredientMock.getName()).thenReturn("Биокотлета из марсианской Магнолии");
        Mockito.when(ingredientMock.getType()).thenReturn(IngredientType.FILLING);
        Mockito.when(ingredientMock.getPrice()).thenReturn(424f);

        Mockito.when(ingredient2Mock.getName()).thenReturn("Сыр с астероидной плесенью");
        Mockito.when(ingredient2Mock.getType()).thenReturn(IngredientType.FILLING);
        Mockito.when(ingredient2Mock.getPrice()).thenReturn(4142f);

        softAssertions.assertThat(burger.ingredients.size())
                .as("Ингредиентов в бургере должно быть 0")
                .isEqualTo(0);
        burger.addIngredient(ingredientMock);
        burger.addIngredient(ingredient2Mock);

        softAssertions.assertThat(burger.ingredients.size())
                .as("Ингредиентов в бургере должно быть 2")
                .isEqualTo(2);

        String expectedReceipt = "(==== Краторная булка ====)\r\n" +
                "= filling Биокотлета из марсианской Магнолии =\r\n" +
                "= filling Сыр с астероидной плесенью =\r\n" +
                "(==== Краторная булка ====)\r\n" +
                "\r\nPrice: 7076,000000\r\n";

        softAssertions.assertThat(burger.getReceipt())
                .as("Чек сформирован неверно")
                .isEqualTo(expectedReceipt);

        softAssertions.assertAll();
    }
}
