package praktikum.burger;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;
import praktikum.Burger;
import praktikum.Ingredient;
import praktikum.Bun;

import java.util.Locale;

import static org.junit.Assert.assertEquals;

public class BurgerBoundaryTests {

    private static final float BUN_PRICE = 100f;
    private static final float EXPECTED_PRICE = BUN_PRICE * 2;
    private static final String BUN_NAME = "black bun";
    private static final String EXPECTED_RECEIPT = "(==== black bun ====)\n" +
            "(==== black bun ====)\n" +
            "\nPrice: 200.000000\n";
    private static final int FIRST_INGREDIENT_INDEX = 0;
    private static final int INVALID_INDEX = 5;
    private static final int INGREDIENTS_COUNT = 1;
    private static final double DELTA = 0.01;

    private Burger burger;
    private Bun mockBun;
    private Ingredient mockIngredient1;
    private Ingredient mockIngredient2;

    @Before
    public void setUp() {
        burger = new Burger();
        mockBun = Mockito.mock(Bun.class);
        mockIngredient1 = Mockito.mock(Ingredient.class);
        mockIngredient2 = Mockito.mock(Ingredient.class);
        Locale.setDefault(Locale.US);

    }

    @Test
    public void testBurgerWithOnlyBun() {
        Mockito.when(mockBun.getPrice()).thenReturn(BUN_PRICE);
        burger.setBuns(mockBun);

        assertEquals(EXPECTED_PRICE, burger.getPrice(), DELTA);

        Mockito.when(mockBun.getName()).thenReturn(BUN_NAME);
        System.out.println(burger.getReceipt()); // Выводим фактический чек
        assertEquals(EXPECTED_RECEIPT, burger.getReceipt());
    }


    // Добавление первого ингредиента
    @Test
    public void testAddFirstIngredient() {
        burger.addIngredient(mockIngredient1);

        // Проверка добавления ингредиента в список
        assertEquals(INGREDIENTS_COUNT, burger.ingredients.size());
        assertEquals(mockIngredient1, burger.ingredients.get(FIRST_INGREDIENT_INDEX));
    }

    // Удаление ингредиента из пустого списка должно выбросить исключение
    @Test(expected = IndexOutOfBoundsException.class)
    public void testRemoveIngredientFromEmptyList() {
        burger.removeIngredient(FIRST_INGREDIENT_INDEX);
    }

    // Добавление и удаление последнего ингредиента
    @Test
    public void testRemoveLastIngredient() {
        burger.addIngredient(mockIngredient1);
        burger.removeIngredient(FIRST_INGREDIENT_INDEX);

        // Проверка, что список стал пустым
        assertEquals(0, burger.ingredients.size());
    }

    // Перемещение ингредиента на недопустимый индекс должно выбросить исключение
    @Test(expected = IndexOutOfBoundsException.class)
    public void testMoveIngredientInvalidIndex() {
        burger.addIngredient(mockIngredient1);
        burger.addIngredient(mockIngredient2);
        burger.moveIngredient(INVALID_INDEX, FIRST_INGREDIENT_INDEX);
    }

    // Перемещение единственного ингредиента на то же место не должно изменять список
    @Test
    public void testMoveSingleIngredient() {
        burger.addIngredient(mockIngredient1);
        burger.moveIngredient(FIRST_INGREDIENT_INDEX, FIRST_INGREDIENT_INDEX);

        // Проверка, что ингредиент остался на месте
        assertEquals(INGREDIENTS_COUNT, burger.ingredients.size());
        assertEquals(mockIngredient1, burger.ingredients.get(FIRST_INGREDIENT_INDEX));
    }
}
