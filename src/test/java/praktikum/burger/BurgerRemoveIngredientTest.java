package praktikum.burger;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;
import praktikum.Burger;
import praktikum.Ingredient;
import praktikum.TestConstants;

import static org.junit.Assert.assertEquals;

public class BurgerRemoveIngredientTest {

    private Burger burger;
    private Ingredient mockIngredient1;
    private Ingredient mockIngredient2;

    @Before
    public void setUp() {
        burger = new Burger();
        mockIngredient1 = Mockito.mock(Ingredient.class);
        mockIngredient2 = Mockito.mock(Ingredient.class);

        // Добавляем два ингредиента для теста
        burger.addIngredient(mockIngredient1);
        burger.addIngredient(mockIngredient2);
    }

    // Проверка удаления ингредиента и корректного обновления списка ингредиентов
    @Test
    public void testRemoveIngredient() {
        // Удаляем первый ингредиент
        burger.removeIngredient(TestConstants.FIRST_INDEX);

        // Проверяем, что остался только один ингредиент - размер списка ингредиентов уменьшился на один после удаления.
        assertEquals(TestConstants.EXPECTED_INGREDIENTS_COUNT_AFTER_REMOVAL, burger.ingredients.size());
        // Проверяем, что оставшийся ингредиент находится на первом месте, то есть удаление сработало правильно, и список ингредиентов был корректно обновлен.
        assertEquals(mockIngredient2, burger.ingredients.get(TestConstants.FIRST_INDEX));
    }
}
