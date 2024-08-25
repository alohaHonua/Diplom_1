package praktikum;

import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class BurgerTest {

    @Test
    public void shouldReturnExpectedPriceWhenGetPriceIsCalled() {
        float expectedPrice = 12.280001f;
        Burger burger = new Burger();
        Bun bun = mock(Bun.class);
        when(bun.getPrice()).thenReturn(3.14f);
        List<Ingredient> ingredients = List.of(
                mock(Ingredient.class),
                mock(Ingredient.class),
                mock(Ingredient.class)
        );
        for (int i = 0; i < 3; i++) {
            Ingredient ingredient = ingredients.get(i);
            when(ingredient.getPrice()).thenReturn(i + 1f);
            burger.addIngredient(ingredient);
        }
        burger.setBuns(bun);

        float actualPrice = burger.getPrice();

        assertEquals(expectedPrice, actualPrice, 0);
    }

    @Test
    public void shouldReturnExpectedReceiptWhenGetReceiptIsCalled() {
        String expectedReceipt = "(==== Cheese bun ====)\n" +
                "= sauce 0 =\n" +
                "= filling 1 =\n" +
                "= sauce 2 =\n" +
                "(==== Cheese bun ====)\n" +
                "\n" +
                "Price: 12,280001\n";
        Burger burger = new Burger();
        Bun bun = mock(Bun.class);
        when(bun.getPrice()).thenReturn(3.14f);
        when(bun.getName()).thenReturn("Cheese bun");
        List<Ingredient> ingredients = List.of(
                mock(Ingredient.class),
                mock(Ingredient.class),
                mock(Ingredient.class)
        );
        IngredientType[] values = IngredientType.values();
        for (int i = 0; i < 3; i++) {
            Ingredient ingredient = ingredients.get(i);
            when(ingredient.getPrice()).thenReturn(i + 1f);
            when(ingredient.getType()).thenReturn(values[i % values.length]);
            when(ingredient.getName()).thenReturn(i + "");
            burger.addIngredient(ingredient);
        }
        burger.setBuns(bun);

        String actualReceipt = burger.getReceipt();

        assertEquals(expectedReceipt, actualReceipt);
    }

    @Test
    public void shouldAddExpectedIngredientsWhenAddIngredientIsCalled() {
        Burger burger = new Burger();
        Ingredient ingredient1 = mock(Ingredient.class);
        Ingredient ingredient2 = mock(Ingredient.class);
        Ingredient ingredient3 = mock(Ingredient.class);

        burger.addIngredient(ingredient1);
        assertEquals(List.of(ingredient1), burger.ingredients);

        burger.addIngredient(ingredient2);
        assertEquals(List.of(ingredient1, ingredient2), burger.ingredients);

        burger.addIngredient(ingredient3);
        assertEquals(List.of(ingredient1, ingredient2, ingredient3), burger.ingredients);
    }

    @Test
    public void shouldRemoveExpectedIngredientsWhenRemoveIngredientIsCalled() {
        Burger burger = new Burger();
        Ingredient ingredient1 = mock(Ingredient.class);
        Ingredient ingredient2 = mock(Ingredient.class);
        Ingredient ingredient3 = mock(Ingredient.class);

        burger.addIngredient(ingredient1);
        burger.addIngredient(ingredient2);
        burger.addIngredient(ingredient3);
        assertEquals(List.of(ingredient1, ingredient2, ingredient3), burger.ingredients);

        burger.removeIngredient(1);
        assertEquals(List.of(ingredient1, ingredient3), burger.ingredients);
    }

    @Test
    public void shouldMoveExpectedIngredientsWhenMoveIngredientIsCalled() {
        Burger burger = new Burger();
        Ingredient ingredient1 = mock(Ingredient.class);
        Ingredient ingredient2 = mock(Ingredient.class);
        Ingredient ingredient3 = mock(Ingredient.class);

        burger.addIngredient(ingredient1);
        burger.addIngredient(ingredient2);
        burger.addIngredient(ingredient3);
        assertEquals(List.of(ingredient1, ingredient2, ingredient3), burger.ingredients);

        burger.moveIngredient(0, 2);
        assertEquals(List.of(ingredient2, ingredient3, ingredient1), burger.ingredients);
    }
}