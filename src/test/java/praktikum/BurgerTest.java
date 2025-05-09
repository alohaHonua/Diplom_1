package praktikum;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;
import static org.mockito.Mockito.when;

@RunWith(Parameterized.class)
public class BurgerTest {

    private Burger burger;

    @Mock
    private Bun bun;

    @Mock
    private Ingredient ingredient1;

    @Mock
    private Ingredient ingredient2;

    // Параметры для тестов
    private final String bunName;
    private final float bunPrice;
    private final IngredientType ingredientType;
    private final String ingredientName;
    private final float ingredientPrice;

    public BurgerTest(String bunName, float bunPrice, IngredientType ingredientType,
                      String ingredientName, float ingredientPrice) {
        this.bunName = bunName;
        this.bunPrice = bunPrice;
        this.ingredientType = ingredientType;
        this.ingredientName = ingredientName;
        this.ingredientPrice = ingredientPrice;
    }

    @Parameterized.Parameters
    public static Object[][] data() {
        return new Object[][]{
                {"Белая булка", 100.0f, IngredientType.FILLING, "Котлета", 50.0f},
                {"Чёрная булка", 150.0f, IngredientType.SAUCE, "Кетчуп", 30.0f}
        };
    }

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        burger = new Burger();

        // Правильное мокирование для float-значений
        when(bun.getName()).thenReturn(bunName);
        when(bun.getPrice()).thenReturn(bunPrice);  // bunPrice - float

        when(ingredient1.getType()).thenReturn(ingredientType);
        when(ingredient1.getName()).thenReturn(ingredientName);
        when(ingredient1.getPrice()).thenReturn(ingredientPrice);  // ingredientPrice - float

        when(ingredient2.getType()).thenReturn(IngredientType.SAUCE);
        when(ingredient2.getName()).thenReturn("Горчица");
        when(ingredient2.getPrice()).thenReturn(20.0f);  // Явное указание float
    }

    @Test
    public void testSetBuns() {
        burger.setBuns(bun);
        assertSame("Булочка должна быть установлена", bun, burger.bun);
    }

    @Test
    public void testAddIngredient() {
        burger.addIngredient(ingredient1);
        assertEquals("Ингредиент должен добавиться", 1, burger.ingredients.size());
        assertSame("Ингредиент должен быть в списке", ingredient1, burger.ingredients.get(0));
    }

    @Test
    public void testRemoveIngredient() {
        burger.addIngredient(ingredient1);
        burger.removeIngredient(0);
        assertTrue("Список ингредиентов должен быть пуст", burger.ingredients.isEmpty());
    }

    @Test
    public void testMoveIngredient() {
        burger.addIngredient(ingredient1);
        burger.addIngredient(ingredient2);
        burger.moveIngredient(0, 1);

        assertEquals("Ингредиенты должны поменяться местами",
                Arrays.asList(ingredient2, ingredient1), burger.ingredients);
    }

    @Test
    public void testGetPrice() {
        burger.setBuns(bun);
        burger.addIngredient(ingredient1);

        float expectedPrice = bunPrice * 2 + ingredientPrice;
        assertEquals("Цена должна быть рассчитана правильно",
                expectedPrice, burger.getPrice(), 0.001f);
    }

    @Test
    public void testGetReceipt() {
        burger.setBuns(bun);
        burger.addIngredient(ingredient1);

        String expected = String.format(
                "(==== %s ====)%n= %s %s =%n(==== %s ====)%n%nPrice: %f%n",
                bunName,
                ingredientType.toString().toLowerCase(),
                ingredientName,
                bunName,
                bunPrice * 2 + ingredientPrice
        );

        assertEquals("Чек должен формироваться правильно", expected, burger.getReceipt());
    }
}