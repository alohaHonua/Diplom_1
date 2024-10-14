package praktikum.burger;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;
import praktikum.Burger;
import praktikum.Ingredient;

import static org.junit.Assert.assertEquals;

public class BurgerAddIngredientTest {

    public static final int EXPECTED_INGREDIENTS_COUNT = 1;
    public static final int FIRST_INGREDIENT_INDEX = 0;
    private Burger burger;
    private Ingredient mockIngredient;

    @Before
    public void setUp() {
        burger = new Burger();
        mockIngredient = Mockito.mock(Ingredient.class);
    }

    @Test
    public void testAddIngredient() {
        // Добавляем ингредиент
        burger.addIngredient(mockIngredient);

        // Проверяем, что ингредиент добавлен в список
        assertEquals(EXPECTED_INGREDIENTS_COUNT, burger.ingredients.size());
        assertEquals(mockIngredient, burger.ingredients.get(FIRST_INGREDIENT_INDEX));
    }
}

