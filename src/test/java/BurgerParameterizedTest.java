import org.junit.*;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import java.util.*;

import praktikum.Bun;
import praktikum.Burger;
import praktikum.Ingredient;
import praktikum.IngredientType;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

/**
 * В модели бургера нет ограничений по количеству ингредиентов
 * Ограничения должны быть предусмотрены при оформлении заказа
 */

@RunWith(Parameterized.class)
public class BurgerParameterizedTest {
    @Parameterized.Parameters(name = "Соусы: {0}, Начинки: {1}")
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][] {
                {0, 0}, // только булочка
                {1, 0}, // 1 соус
                {0, 1}, // 1 начинка
                {2, 3}, // несколько ингредиентов
                {100, 1}, // много соусов
                {1, 100}, // много начинок
                {100, 100} // очень много ингредиентов
        });
    }

    @Parameterized.Parameter(0)
    public int sauceCount;

    @Parameterized.Parameter(1)
    public int fillingCount;

    private Burger burger;
    private Bun mockBun;

    @Before
    public void setUp() {
        burger = new Burger();
        mockBun = mock(Bun.class);
        when(mockBun.getName()).thenReturn("Тестовая булочка");
        when(mockBun.getPrice()).thenReturn(100.0f);
        burger.setBuns(mockBun);
    }

    @Test
    public void addIngredientsWorksWithDifferentCounts() {
        Ingredient mockSauce = mock(Ingredient.class);
        when(mockSauce.getType()).thenReturn(IngredientType.SAUCE);

        Ingredient mockFilling = mock(Ingredient.class);
        when(mockFilling.getType()).thenReturn(IngredientType.FILLING);

        for (int i = 0; i < sauceCount; i++) {
            burger.addIngredient(mockSauce);
        }
        for (int i = 0; i < fillingCount; i++) {
            burger.addIngredient(mockFilling);
        }

        assertEquals("Неверное количество ингредиентов",
                sauceCount + fillingCount,
                burger.ingredients.size());
    }
}