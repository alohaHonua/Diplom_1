import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import praktikum.Bun;
import praktikum.Burger;
import praktikum.Ingredient;
import praktikum.IngredientType;

import java.util.List;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@RunWith(Parameterized.class)
public class BurgerReceiptTest {

    private final String bunName;
    private final List<Ingredient> ingredients;
    private final String expectedReceipt;

    public BurgerReceiptTest(String bunName, List<Ingredient> ingredients, String expectedReceipt) {
        this.bunName = bunName;
        this.ingredients = ingredients;
        this.expectedReceipt = expectedReceipt;
    }

    @Parameterized.Parameters(name = "Bun: {0}, Ingredients: {1}")
    public static Object[][] getData() {
        return new Object[][] {
                {"White Bun",
                        List.of(),
                        String.format("(==== White Bun ====)%n(==== White Bun ====)%n%nPrice: 200.000000%n")
                },
                {"Black Bun",
                        List.of(createMockIngredient("cutlet", IngredientType.FILLING, 75f)),
                        String.format("(==== Black Bun ====)%n= filling cutlet =%n(==== Black Bun ====)%n%nPrice: 275.000000%n")
                },
                {"Red Bun",
                        List.of(createMockIngredient("cheesy", IngredientType.SAUCE, 20f)),
                        String.format("(==== Red Bun ====)%n= sauce cheesy =%n(==== Red Bun ====)%n%nPrice: 220.000000%n")
                },

        };
    }

    @Mock Bun bun;

    @Before
    public void setUp() {
        MockitoAnnotations.openMocks(this);
        when(bun.getPrice()).thenReturn(100f);
    }

    @Test
    public void getReceipt_shouldReturnFormattedReceipt() {
        when(bun.getName()).thenReturn(bunName);

        Burger burger = new Burger();
        burger.setBuns(bun);
        ingredients.forEach(burger::addIngredient);

        String actualReceipt = burger.getReceipt();

        String normalizedExpected = expectedReceipt.replace(",", ".");
        String normalizedActual = actualReceipt.replace(",", ".");
        Assert.assertEquals(normalizedExpected, normalizedActual);
    }

    private static Ingredient createMockIngredient(String name, IngredientType type, float price) {
        Ingredient ingredient = mock(Ingredient.class);
        when(ingredient.getName()).thenReturn(name);
        when(ingredient.getType()).thenReturn(type);
        when(ingredient.getPrice()).thenReturn(price);
        return ingredient;
    }
}