package praktikum.burger;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;
import praktikum.Burger;
import praktikum.Ingredient;

import static org.junit.Assert.assertEquals;

public class BurgerMoveIngredientTest {

    private Burger burger;
    private Ingredient mockIngredient1;
    private Ingredient mockIngredient2;

    @Before
    public void setUp() {
        burger = new Burger();
        mockIngredient1 = Mockito.mock(Ingredient.class);
        mockIngredient2 = Mockito.mock(Ingredient.class);

        // Добавляем два ингредиента
        burger.addIngredient(mockIngredient1);
        burger.addIngredient(mockIngredient2);
    }

    @Test
    public void testMoveIngredient() {
        // Перемещаем второй ингредиент на первую позицию
        burger.moveIngredient(1, 0);

        // Проверяем, что ингредиенты поменялись местами
        assertEquals(mockIngredient2, burger.ingredients.get(0));
        assertEquals(mockIngredient1, burger.ingredients.get(1));
    }
}
