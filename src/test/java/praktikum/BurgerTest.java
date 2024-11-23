package praktikum;

import org.hamcrest.MatcherAssert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.*;

@RunWith(MockitoJUnitRunner.class)

public class BurgerTest {
    @Mock
    private Bun bun;
    @Mock
    private Ingredient ingredientX;
    @Mock
    private Ingredient ingredientY;

    @Test
    public void setBunsIsSuccess() {
        Burger burger = new Burger();
        Mockito.when(bun.getName()).thenReturn("sweet bun");
        burger.setBuns(bun);

        MatcherAssert.assertThat("Новая булочка не добавляется",
                bun.getName(),
                equalTo(burger.bun.getName()));
    }

    @Test
    public void addIngredientIsSuccess() {
        Burger burger = new Burger();
        burger.addIngredient(ingredientX);

        assertTrue("Ингредиент не добавляется",
                burger.ingredients.contains(ingredientX));
    }

    @Test
    public void removeIngredientIsSuccess() {
        Burger burger = new Burger();
        burger.addIngredient(ingredientX);

        int index = burger.ingredients.indexOf(ingredientX);
        burger.removeIngredient(index);

        assertFalse("Ингредиент не удалён",
                burger.ingredients.contains(ingredientX));

    }

    @Test
    public void moveIngredientIsSuccess() {
        Burger burger = new Burger();
        Mockito.when(ingredientX.getName()).thenReturn("Salad");
        Mockito.when(ingredientY.getName()).thenReturn("Meat");
        burger.addIngredient(ingredientX);
        burger.addIngredient(ingredientY);

        burger.moveIngredient(0,1);

        MatcherAssert.assertThat("Ингредиент не перемещён",
                burger.ingredients.get(1).getName(),
                equalTo("Salad"));

        MatcherAssert.assertThat("Ингредиент не перемещён",
                burger.ingredients.get(0).getName(),
                equalTo("Meat"));
    }

    @Test
    public void getPriceIsSuccess() {
        Mockito.when(bun.getPrice()).thenReturn(50F);
        Mockito.when(ingredientX.getPrice()).thenReturn(300F);
        float totalPrice = bun.getPrice() * 2 + ingredientX.getPrice();

        Burger burger = new Burger();
        burger.setBuns(bun);
        burger.addIngredient(ingredientX);

        MatcherAssert.assertThat("Стоимость раcсчитана неверно",
                totalPrice,
                equalTo(burger.getPrice()));
    }

    @Test
    public void getReceiptIsSuccess() {
        Mockito.when(bun.getName()).thenReturn("sweet bun");
        Mockito.when(bun.getPrice()).thenReturn(50F);
        Mockito.when(ingredientX.getName()).thenReturn("Meat");
        Mockito.when(ingredientX.getPrice()).thenReturn(100F);
        Mockito.when(ingredientX.getType()).thenReturn(IngredientType.FILLING);

        String expectedReceipt = String.format("(==== %s ====)%n", bun.getName()) +
                String.format("= %s %s =%n", ingredientX.getType().name().toLowerCase(), ingredientX.getName()) +
                String.format("(==== %s ====)%n", bun.getName()) +
                String.format("%nPrice: %.6f%n", (bun.getPrice() * 2) + ingredientX.getPrice());


        Burger burger = new Burger();
        burger.setBuns(bun);
        burger.addIngredient(ingredientX);

        MatcherAssert.assertThat("Неверный рецепт",
                burger.getReceipt(),
                equalTo(expectedReceipt));
    }
}