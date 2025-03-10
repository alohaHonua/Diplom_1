import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import praktikum.Bun;
import praktikum.Burger;
import praktikum.Ingredient;
import praktikum.IngredientType;
import java.util.List;

public class BurgerTest {
    private Burger burger;

    @Mock
    private List<Ingredient> mockIngredientList;
    @InjectMocks
    private Burger mockBurger;

    private static final String BUN_TITLE = "sampleBun";
    private static final String INGREDIENT_TITLE = "sampleIngredient";
    private static final float BUN_COST = 7;
    private static final float INGREDIENT_COST = 5;
    private static final IngredientType INGREDIENT_CATEGORY = IngredientType.FILLING;
    private static final Ingredient SAMPLE_INGREDIENT = new Ingredient(INGREDIENT_CATEGORY, INGREDIENT_TITLE, INGREDIENT_COST);
    private static final Bun SAMPLE_BUN = new Bun(BUN_TITLE, BUN_COST);
    private static final int TEST_INDEX_ONE = 3;
    private static final int TEST_INDEX_TWO = 2;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
        mockBurger = new Burger();
        mockBurger.ingredients = mockIngredientList;
        burger = new Burger();
    }

    @Test
    public void shouldAddIngredientCorrectly() {
        mockBurger.addIngredient(SAMPLE_INGREDIENT);
        Mockito.verify(mockIngredientList, Mockito.times(1)).add(SAMPLE_INGREDIENT);
        Mockito.verifyNoMoreInteractions(mockIngredientList);
    }

    @Test
    public void shouldRemoveIngredientCorrectly() {
        mockBurger.removeIngredient(TEST_INDEX_ONE);
        Mockito.verify(mockIngredientList, Mockito.times(1)).remove(TEST_INDEX_ONE);
        Mockito.verifyNoMoreInteractions(mockIngredientList);
    }

    @Test
    public void shouldMoveIngredientCorrectly() {
        Mockito.when(mockIngredientList.remove(TEST_INDEX_ONE)).thenReturn(SAMPLE_INGREDIENT);
        mockBurger.moveIngredient(TEST_INDEX_ONE, TEST_INDEX_TWO);
        Mockito.verify(mockIngredientList, Mockito.times(1)).remove(TEST_INDEX_ONE);
        Mockito.verify(mockIngredientList, Mockito.times(1)).add(TEST_INDEX_TWO, SAMPLE_INGREDIENT);
        Mockito.verifyNoMoreInteractions(mockIngredientList);
    }

    @ParameterizedTest
    @ValueSource(ints = {0, 1})
    public void shouldCalculatePriceCorrectly(int ingredientCount) {
        burger.setBuns(SAMPLE_BUN);
        for (int i = 0; i < ingredientCount; i++)
            burger.addIngredient(SAMPLE_INGREDIENT);
        float expectedCost = calculateExpectedPrice(ingredientCount);

        Assertions.assertEquals(expectedCost, burger.getPrice());
    }

    @Test
    public void shouldThrowNPEWhenPriceWithoutBun() {
        burger.addIngredient(SAMPLE_INGREDIENT);
        Assertions.assertThrowsExactly(NullPointerException.class, () -> burger.getPrice());
    }

    @ParameterizedTest
    @ValueSource(ints = {0, 1})
    public void shouldReturnExpectedReceipt(int ingredientCount) {
        Bun mockBun = Mockito.mock(Bun.class);
        Ingredient mockIngredient = Mockito.mock(Ingredient.class);
        Mockito.when(mockBun.getName()).thenReturn(BUN_TITLE);
        Mockito.when(mockBun.getPrice()).thenReturn(BUN_COST);
        Mockito.when(mockIngredient.getName()).thenReturn(INGREDIENT_TITLE);
        Mockito.when(mockIngredient.getType()).thenReturn(INGREDIENT_CATEGORY);
        Mockito.when(mockIngredient.getPrice()).thenReturn(INGREDIENT_COST);
        String expectedReceipt = buildExpectedReceipt(ingredientCount);

        burger.setBuns(SAMPLE_BUN);
        for (int i = 0; i < ingredientCount; i++)
            burger.addIngredient(SAMPLE_INGREDIENT);

        Assertions.assertEquals(expectedReceipt, burger.getReceipt());
    }

    @Test
    public void shouldThrowNPEWhenReceiptWithoutBun() {
        burger.addIngredient(SAMPLE_INGREDIENT);
        Assertions.assertThrowsExactly(NullPointerException.class, () -> burger.getReceipt());
    }

    private float calculateExpectedPrice(int ingredientCount) {
        return BUN_COST * 2 + INGREDIENT_COST * ingredientCount;
    }

    private String buildExpectedReceipt(int ingredientCount) {
        StringBuilder receiptBuilder = new StringBuilder(String.format("(==== %s ====)%n", BUN_TITLE));
        for (int i = 0; i < ingredientCount; i++)
            receiptBuilder.append(String.format("= %s %s =%n", INGREDIENT_CATEGORY.toString().toLowerCase(), INGREDIENT_TITLE));
        receiptBuilder.append(String.format("(==== %s ====)%n", BUN_TITLE));
        receiptBuilder.append(String.format("%nPrice: %f%n", calculateExpectedPrice(ingredientCount)));
        return receiptBuilder.toString();
    }
}