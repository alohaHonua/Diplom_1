package praktikum.burger;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;
import praktikum.Burger;
import praktikum.Ingredient;

import static org.junit.Assert.assertEquals;

public class BurgerAddIngredientTest {

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
        assertEquals(1, burger.ingredients.size());
        assertEquals(mockIngredient, burger.ingredients.get(0));
    }
}

