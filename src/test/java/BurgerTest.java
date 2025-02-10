import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import praktikum.*;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class BurgerTest {
    private static final String BUN_NAME = "new bun";
    private static final float BUN_PRICE = 199.99F;
    private static final String INGREDIENT_NAME = "new ingredient";
    private static final float INGREDIENT_PRICE = 0.99F;

    @InjectMocks
    Burger burger;

    @Mock
    Bun bun;
    @Mock
    Ingredient ingredientSauce;
    @Mock
    Ingredient ingredientFilling;

    @Before
    public void setUp() throws Exception {
        // Создаем моки
        MockitoAnnotations.openMocks(this);
        bun = getBunMock(BUN_NAME, BUN_PRICE);
        ingredientSauce = getIngredientMock(IngredientType.SAUCE, INGREDIENT_NAME, INGREDIENT_PRICE);
        ingredientFilling = getIngredientMock(IngredientType.FILLING, INGREDIENT_NAME, INGREDIENT_PRICE);
    }

    // Метод для создания мока булочки
    private static Bun getBunMock(String name, float price) {
        Bun bun = mock(Bun.class);
        when(bun.getName()).thenReturn(name);
        when(bun.getPrice()).thenReturn(price);
        return bun;
    }

    // Метод для создания мока ингредиента
    private static Ingredient getIngredientMock(IngredientType type, String name, float price) {
        Ingredient ingredient = mock(Ingredient.class);
        when(ingredient.getType()).thenReturn(type);
        when(ingredient.getName()).thenReturn(name);
        when(ingredient.getPrice()).thenReturn(price);
        return ingredient;
    }

    @Test
    public void setBunsWithMockTest() {
        burger.setBuns(bun);
        assertEquals(bun, burger.bun);
    }

    @Test
    public void addIngredientWithTwoMockIngredientsTest() {
        burger.addIngredient(ingredientSauce);
        burger.addIngredient(ingredientFilling);
        assertEquals("Количество ингредиентов в бургере указано не верно", 2, burger.ingredients.size());
    }

    @Test
    public void removeIngredientWithMockIngredientTest() {
        burger.addIngredient(ingredientSauce);
        burger.removeIngredient(0);
        assertEquals("Ингредиент не удален", 0, burger.ingredients.size());
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void removeIngredientWithInvalidIndexThrowsExceptionTest() {
        burger.removeIngredient(0); // Пустой список ингредиентов
    }

    @Test
    public void moveIngredientWithMockTest() {
        burger.addIngredient(ingredientSauce);
        burger.addIngredient(ingredientFilling);
        burger.moveIngredient(0, 1);
        assertEquals("Ингредиенты не меняются местами", ingredientFilling, burger.ingredients.get(0));
    }

    @Test
    public void moveIngredientWithMockTest2() {
        burger.addIngredient(ingredientSauce);
        burger.addIngredient(ingredientFilling);
        burger.moveIngredient(0, 1);
        assertEquals("Ингредиенты не меняются местами", ingredientSauce, burger.ingredients.get(1));
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void moveIngredientWithInvalidIndexThrowsExceptionTest() {
        burger.moveIngredient(0, 1); // Пустой список ингредиентов
    }

    @Test
    public void getPriceWithMockTest() {
        burger.setBuns(bun);
        burger.addIngredient(ingredientSauce);
        burger.addIngredient(ingredientFilling);
        float expectedPrice = BUN_PRICE * 2 + INGREDIENT_PRICE * 2;
        assertEquals("Цена бургера не корректна", expectedPrice, burger.getPrice(), 0.001F);
    }

    @Test
    public void getReceiptWithMockTest() {
        burger.setBuns(bun);
        burger.addIngredient(ingredientSauce);
        burger.addIngredient(ingredientFilling);

        String expected = String.format(
                "(==== %s ====)%n" +
                        "= %s %s =%n" +
                        "= %s %s =%n" +
                        "(==== %s ====)%n" +
                        "%nPrice: %f%n",
                BUN_NAME,
                IngredientType.SAUCE.toString().toLowerCase(), INGREDIENT_NAME,
                IngredientType.FILLING.toString().toLowerCase(), INGREDIENT_NAME,
                BUN_NAME,
                burger.getPrice());

        assertEquals("Рецепт напечатан не верно", expected, burger.getReceipt());
    }
}
