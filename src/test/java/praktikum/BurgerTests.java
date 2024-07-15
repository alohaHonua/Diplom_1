package praktikum;

import org.hamcrest.MatcherAssert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

@RunWith(MockitoJUnitRunner.class)
public class BurgerTests {

    @Mock
    private Bun mockBun;
    @Mock
    private Ingredient mockIngredient1;
    @Mock
    private Ingredient mockIngredient2;

    @Test
    public void shouldSetBunsCorrectly() {
        Burger testBurger = new Burger();
        Mockito.when(mockBun.getName()).thenReturn("testBunName");
        testBurger.setBuns(mockBun);

        MatcherAssert.assertThat(
                "Булочки не были установлены корректно",
                mockBun.getName(),
                equalTo(testBurger.bun.getName())
        );
    }

    @Test
    public void shouldAddIngredientSuccessfully() {
        Burger testBurger = new Burger();
        testBurger.addIngredient(mockIngredient1);

        assertTrue(
                "Ингредиент не был добавлен",
                testBurger.ingredients.contains(mockIngredient1)
        );
    }

    @Test
    public void shouldMoveIngredientSuccessfully() {
        Mockito.when(mockIngredient1.getName()).thenReturn("testIngredientName");

        Burger testBurger = new Burger();
        testBurger.addIngredient(mockIngredient1);
        testBurger.addIngredient(mockIngredient2);
        int initialIndex = testBurger.ingredients.indexOf(mockIngredient1);
        int targetIndex = testBurger.ingredients.indexOf(mockIngredient2);

        testBurger.moveIngredient(initialIndex, targetIndex);

        MatcherAssert.assertThat(
                "Ингредиент не был перемещен",
                mockIngredient1.getName(),
                equalTo(testBurger.ingredients.get(targetIndex).getName())
        );
    }

    @Test
    public void shouldRemoveIngredientSuccessfully() {
        Burger testBurger = new Burger();
        testBurger.addIngredient(mockIngredient1);

        int indexToRemove = testBurger.ingredients.indexOf(mockIngredient1);
        testBurger.removeIngredient(indexToRemove);

        assertFalse(
                "Ингредиент не был удален",
                testBurger.ingredients.contains(mockIngredient1)
        );
    }

    @Test
    public void shouldCalculatePriceCorrectly() {
        Mockito.when(mockBun.getPrice()).thenReturn(100f);
        Mockito.when(mockIngredient1.getPrice()).thenReturn(250f);

        Burger testBurger = new Burger();
        testBurger.setBuns(mockBun);
        testBurger.addIngredient(mockIngredient1);

        MatcherAssert.assertThat(
                "Цена была рассчитана некорректно",
                450f,
                equalTo(testBurger.getPrice())
        );
    }

    @Test
    public void shouldReturnCorrectReceipt() {
        Mockito.when(mockBun.getName()).thenReturn("testBunName");
        Mockito.when(mockBun.getPrice()).thenReturn(80f);
        Mockito.when(mockIngredient1.getName()).thenReturn("testIngredientName");
        Mockito.when(mockIngredient1.getPrice()).thenReturn(100f);
        Mockito.when(mockIngredient1.getType()).thenReturn(IngredientType.FILLING);

        String expectedReceipt =
                        "(==== testBunName ====)\n" +
                        "= filling testIngredientName =\n" +
                        "(==== testBunName ====)\n" +
                        "\nPrice: 260,000000\n";

        Burger testBurger = new Burger();
        testBurger.setBuns(mockBun);
        testBurger.addIngredient(mockIngredient1);

        MatcherAssert.assertThat(
                "Рецепт был возвращен некорректно",
                testBurger.getReceipt(),
                equalTo(expectedReceipt)
        );
    }
}
