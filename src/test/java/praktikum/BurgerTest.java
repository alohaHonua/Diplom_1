package praktikum;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

@RunWith(Parameterized.class)
public class BurgerTest {

    private Burger burger;

    @Mock
    private Bun mockBun;

    private final String bunName;
    private final float bunPrice;
    private final List<Ingredient> ingredients;
    private final float expectedPrice;
    private final String expectedReceipt;

    public BurgerTest(String bunName, float bunPrice, List<Ingredient> ingredients,
                      float expectedPrice, String expectedReceipt) {
        this.bunName = bunName;
        this.bunPrice = bunPrice;
        this.ingredients = ingredients;
        this.expectedPrice = expectedPrice;
        this.expectedReceipt = expectedReceipt;
    }

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        burger = new Burger();

        mockBun = mock(Bun.class);
        when(mockBun.getName()).thenReturn(bunName);
        when(mockBun.getPrice()).thenReturn(bunPrice);
        burger.setBuns(mockBun);

        for (Ingredient ingredient : ingredients) {
            burger.addIngredient(ingredient);
        }
    }

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {
                        "Флюоресцентная булка R2-D3",
                        988,
                        Arrays.asList(
                                createMockIngredient(IngredientType.SAUCE, "Соус Spicy-X", 90),
                                createMockIngredient(IngredientType.FILLING, "Говяжий метеорит (отбивная)", 3000)
                        ),
                        5066,
                        "(==== Флюоресцентная булка R2-D3 ====)\n" +
                                "= sauce Соус Spicy-X =\n" +
                                "= filling Говяжий метеорит (отбивная) =\n" +
                                "(==== Флюоресцентная булка R2-D3 ====)\n\n" +
                                "Price: 5066,000000\n"
                },
                {
                        "Краторная булка N-200i",
                        1255,
                        Arrays.asList(
                                createMockIngredient(IngredientType.SAUCE, "Традиционный галактический соус", 15),
                                createMockIngredient(IngredientType.FILLING, "Биокотлета из марсианской Магнолии", 424)
                        ),
                        2949,
                        "(==== Краторная булка N-200i ====)\n" +
                                "= sauce Традиционный галактический соус =\n" +
                                "= filling Биокотлета из марсианской Магнолии =\n" +
                                "(==== Краторная булка N-200i ====)\n\n" +
                                "Price: 2949,000000\n"
                },
                {
                        "Флюоресцентная булка R2-D3",
                        988,
                        Arrays.asList(),
                        1976,
                        "(==== Флюоресцентная булка R2-D3 ====)\n" +
                                "(==== Флюоресцентная булка R2-D3 ====)\n\n" +
                                "Price: 1976,000000\n"
                }
        });
    }

    private static Ingredient createMockIngredient(IngredientType type, String name, float price) {
        Ingredient mockIngredient = mock(Ingredient.class);
        when(mockIngredient.getType()).thenReturn(type);
        when(mockIngredient.getName()).thenReturn(name);
        when(mockIngredient.getPrice()).thenReturn(price);
        return mockIngredient;
    }

    @Test
    public void testGetPrice() {
        assertEquals(expectedPrice, burger.getPrice(), 0.0f);
    }

    @Test
    public void testGetReceipt() {
        String actualReceipt = burger.getReceipt().replace("\r\n", "\n");
        String expected = expectedReceipt.replace("\r\n", "\n");
        assertEquals(expected, actualReceipt);
    }

    @Test
    public void testAddIngredient() {
        int initialSize = burger.ingredients.size();
        Ingredient newIngredient = createMockIngredient(IngredientType.SAUCE, "Соус фирменный Space Sauce", 80);
        burger.addIngredient(newIngredient);
        assertEquals(initialSize + 1, burger.ingredients.size());
        assertTrue(burger.ingredients.contains(newIngredient));
    }

    @Test
    public void testRemoveIngredient() {
        if (!burger.ingredients.isEmpty()) {
            int initialSize = burger.ingredients.size();
            burger.removeIngredient(0);
            assertEquals(initialSize - 1, burger.ingredients.size());
        }
    }

    @Test
    public void testMoveIngredient() {
        if (burger.ingredients.size() > 1) {
            Ingredient first = burger.ingredients.get(0);
            Ingredient second = burger.ingredients.get(1);
            burger.moveIngredient(0, 1);
            assertEquals(second, burger.ingredients.get(0));
            assertEquals(first, burger.ingredients.get(1));
        }
    }

    @Test
    public void testSetBuns() {
        Bun newBun = mock(Bun.class);
        when(newBun.getName()).thenReturn("Краторная булка N-200i");
        when(newBun.getPrice()).thenReturn(1255f);

        burger.setBuns(newBun);
        assertEquals(newBun, burger.bun);
    }
}
