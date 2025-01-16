package tests;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import praktikum.Burger;
import praktikum.Ingredient;
import java.util.Arrays;
import java.util.List;
import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

@RunWith(Parameterized.class)
public class BurgerMoveIngredientTest {

    private final int initialIndex;
    private final int newIndex;
    private final String expectedNameIngredient1;
    private final String expectedNameIngredient2;
    private final String expectedNameIngredient3;

    Burger burger;

    @Mock
    Ingredient ingredient1;

    @Mock
    Ingredient ingredient2;

    @Mock
    Ingredient ingredient3;

    @Parameterized.Parameters
    public static Iterable<Object[]> data() {

        return Arrays.asList(new Object[][] {
                {0, 2, "Ingredient2", "Ingredient3", "Ingredient1"}, // Перемещаем в конец
                {1, 0, "Ingredient2", "Ingredient1", "Ingredient3"}, // Перемещаем в начало
                {2, 1, "Ingredient1", "Ingredient3", "Ingredient2"}, // Перемещаем в середину
        });
    }

    public BurgerMoveIngredientTest(int initialIndex, int newIndex,
                                    String expectedNameIngredient1, String expectedNameIngredient2, String expectedNameIngredient3) {
        this.initialIndex = initialIndex;
        this.newIndex = newIndex;
        this.expectedNameIngredient1 = expectedNameIngredient1;
        this.expectedNameIngredient2 = expectedNameIngredient2;
        this.expectedNameIngredient3 = expectedNameIngredient3;
    }

    @Before
    public void setUp() {
        MockitoAnnotations.openMocks(this);
        burger = new Burger();

        when(ingredient1.getName()).thenReturn("Ingredient1");
        when(ingredient2.getName()).thenReturn("Ingredient2");
        when(ingredient3.getName()).thenReturn("Ingredient3");

        burger.addIngredient(ingredient1);
        burger.addIngredient(ingredient2);
        burger.addIngredient(ingredient3);
    }

    @Test
    public void testMoveIngredient() {
        burger.moveIngredient(initialIndex, newIndex);

        List<Ingredient> ingredients = burger.ingredients;

        assertEquals(ingredients.get(0).getName(), expectedNameIngredient1);
        assertEquals(ingredients.get(1).getName(), expectedNameIngredient2);
        assertEquals(ingredients.get(2).getName(), expectedNameIngredient3);
    }
}