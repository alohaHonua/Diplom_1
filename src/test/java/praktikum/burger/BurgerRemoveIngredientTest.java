package praktikum.burger;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;
import praktikum.Burger;
import praktikum.Ingredient;

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

    @Test
    public void testRemoveIngredient() {
        // Удаляем первый ингредиент
        burger.removeIngredient(0);

        // Проверяем, что остался только один ингредиент
        assertEquals(1, burger.ingredients.size());
        assertEquals(mockIngredient2, burger.ingredients.get(0));
    }
}
