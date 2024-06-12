import org.hamcrest.MatcherAssert;
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

import static org.hamcrest.Matchers.equalTo;

@RunWith(MockitoJUnitRunner.class)
public class BurgerTest {
    @Mock
    private Bun bun;

    @Mock
    private Ingredient ingredient;

    @Test
    public void checkSetBunsTest() {
        Burger burger = new Burger();
        burger.setBuns(bun);
        Assert.assertEquals(bun, burger.bun);
    }

    @Test
    public void checkAddIngredientTest() {
        Burger burger = new Burger();
        burger.addIngredient(ingredient);
        Assert.assertTrue(burger.ingredients.contains(ingredient));
    }

    @Test
    public void checkRemoveIngredientTest() {
        Burger burger = new Burger();
        List<Ingredient> ingredients = new ArrayList<>();
        burger.addIngredient(ingredient);
        burger.removeIngredient(0);
        Assert.assertEquals(ingredients, burger.ingredients);
    }

    @Test
    public void checkMoveIngredientTest() {
        Burger burger = new Burger();
        Ingredient ingredient1 = new Ingredient(IngredientType.SAUCE, "hot sauce", 100);
        Ingredient ingredient2 = new Ingredient(IngredientType.FILLING, "dinosaur", 200);
        List<Ingredient> ingredients = new ArrayList<>();
        ingredients.add(ingredient2);
        ingredients.add(ingredient1);
        burger.addIngredient(ingredient1);
        burger.addIngredient(ingredient2);
        burger.moveIngredient(0, 1);
        Assert.assertEquals(ingredients, burger.ingredients);
    }

    @Test
    public void checkGetPriceTest() {
        Burger burger = new Burger();
        Mockito.when(bun.getPrice()).thenReturn(900f);
        Mockito.when(ingredient.getPrice()).thenReturn(100f);
        burger.setBuns(bun);
        burger.addIngredient(ingredient);
        MatcherAssert.assertThat("Некорректная цена", 1900f, equalTo(burger.getPrice()));
    }

    @Test
    public void checkGetReceiptTest() {
        Burger burger = new Burger();
        Mockito.when(bun.getPrice()).thenReturn(900f);
        Mockito.when(bun.getName()).thenReturn("Бургер");
        burger.setBuns(bun);
        Mockito.when(ingredient.getPrice()).thenReturn(100f);
        Mockito.when(ingredient.getName()).thenReturn("Соус традиционный галактический");
        Mockito.when(ingredient.getType()).thenReturn(IngredientType.SAUCE);
        List<Ingredient> ingredients = new ArrayList<>();
        ingredients.add(ingredient);
        burger.addIngredient(ingredient);
        StringBuilder receipt = new StringBuilder(String.format("(==== %s ====)%n", bun.getName()));
        for (Ingredient i : ingredients) {
            receipt.append(String.format("= %s %s =%n", i.getType().toString().toLowerCase(),
                    i.getName()));
        }
        receipt.append(String.format("(==== %s ====)%n", bun.getName()));
        receipt.append(String.format("%nPrice: %f%n", 1900f));
        Assert.assertEquals(receipt.toString(), burger.getReceipt());
    }
}
