package praktikum;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

@RunWith(MockitoJUnitRunner.class)
public class BurgerTest {
    private final static double DELTA = 0.01;
    Burger burger;

    @Mock
    private Bun bun;
    @Mock
    private Ingredient ingredient;

    @Before
    public void setUp() {
        burger = new Burger();
    }

    @Test
    public void setBunsTest() {
        burger.setBuns(bun);
        assertEquals(bun, burger.bun);
    }

    @Test
    public void addIngredientTest() {
        List<Ingredient> ingredients = new ArrayList<>();
        ingredients.add(ingredient);

        burger.addIngredient(ingredient);
        assertEquals(ingredients, burger.ingredients);
    }

    @Test
    public void removeIngredientTest() {
        List<Ingredient> ingredients = new ArrayList<>();
        burger.addIngredient(ingredient);

        burger.removeIngredient(0);
        assertEquals(ingredients, burger.ingredients);
    }

    @Test
    public void moveIngredientTest() {
        Ingredient ingredient1 = new Ingredient(IngredientType.SAUCE, "Соус фирменный Space Sauce", 80.0F);
        Ingredient ingredient2 = new Ingredient(IngredientType.FILLING, "Говяжий метеорит (отбивная)", 3000.0F);

        List<Ingredient> ingredients = new ArrayList<>();
        ingredients.add(ingredient2);
        ingredients.add(ingredient1);

        burger.addIngredient(ingredient1);
        burger.addIngredient(ingredient2);

        burger.moveIngredient(0, 1);
        assertEquals(ingredients, burger.ingredients);
    }

    @Test
    public void getPriceTest() {
        Mockito.when(bun.getPrice()).thenReturn(988.0F);
        burger.setBuns(bun);
        Mockito.when(ingredient.getPrice()).thenReturn(90.0F);
        burger.addIngredient(ingredient);

        float expectedPrice = 2066.0F;
        assertEquals(expectedPrice, burger.getPrice(), DELTA);
    }

    @Test
    public void getReceiptTest() {
        Mockito.when(bun.getName()).thenReturn("Краторная булка N-200i");
        Mockito.when(bun.getPrice()).thenReturn(1255.0F);
        burger.setBuns(bun);

        Mockito.when(ingredient.getName()).thenReturn("Соус Spicy-X");
        Mockito.when(ingredient.getPrice()).thenReturn(90.0F);
        Mockito.when(ingredient.getType()).thenReturn(IngredientType.SAUCE);
        burger.addIngredient(ingredient);

        List<Ingredient> ingredients = new ArrayList<>();
        ingredients.add(ingredient);

        StringBuilder receipt = new StringBuilder(String.format("(==== %s ====)%n", bun.getName()));
        for (Ingredient i : ingredients) {
            receipt.append(String.format("= %s %s =%n", i.getType().toString().toLowerCase(),
                    i.getName()));
        }
        receipt.append(String.format("(==== %s ====)%n", bun.getName()));
        receipt.append(String.format("%nPrice: %f%n", 2600.0F));
        assertEquals(receipt.toString(), burger.getReceipt());
    }
}
