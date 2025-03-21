package praktikum;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import java.util.List;
import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

public class BurgerTest {

    private Burger burger;

    @Mock
    Bun bun;


    private Ingredient sauce;
    private Ingredient filling;

    @Before
    public void setUp() {
        MockitoAnnotations.openMocks(this);
        burger = new Burger();

        Mockito.when(bun.getName()).thenReturn("White Bun");
        Mockito.when(bun.getPrice()).thenReturn(1.0f);
        sauce = new Ingredient(IngredientType.SAUCE, "Tomato Sauce", 0.5f);
        filling = new Ingredient(IngredientType.FILLING, "Cheese", 0.7f);
    }



    @Test
    public void testAddIngredient() {
        burger.addIngredient(sauce);
        burger.addIngredient(filling);

        List<Ingredient> ingredients = burger.ingredients;
        assertEquals("Должно быть 2 ингредиента", 2, ingredients.size());
        assertEquals("Первый ингредиент должен быть Tomato Sauce", sauce, ingredients.get(0));
        assertEquals("Второй ингредиент должен быть Cheese", filling, ingredients.get(1));
    }

    @Test
    public void testRemoveIngredient() {
        burger.addIngredient(sauce);
        burger.addIngredient(filling);

        burger.removeIngredient(0); // Удаляем первый ингредиент (Tomato Sauce)

        List<Ingredient> ingredients = burger.ingredients;
        assertEquals("Должен остаться 1 ингредиент", 1, ingredients.size());
        assertEquals("Оставшийся ингредиент должен быть Cheese", filling, ingredients.get(0));
    }

    @Test
    public void testMoveIngredient() {
        burger.addIngredient(sauce);
        burger.addIngredient(filling);

        burger.moveIngredient(0, 1); // Перемещаем Tomato Sauce на место Cheese

        List<Ingredient> ingredients = burger.ingredients;
        assertEquals("Первый ингредиент должен быть Cheese", filling, ingredients.get(0));
        assertEquals("Второй ингредиент должен быть Tomato Sauce", sauce, ingredients.get(1));
    }

    @Test
    public void testGetPrice() {
        burger.setBuns(bun);
        burger.addIngredient(sauce);
        burger.addIngredient(filling);

        float expectedPrice = bun.getPrice() * 2 + sauce.getPrice() + filling.getPrice();
        assertEquals("Цена должна быть рассчитана корректно", expectedPrice, burger.getPrice(), 0.001f);
    }

    @Test
    public void testGetReceipt() {
        burger.setBuns(bun);
        burger.addIngredient(sauce);
        burger.addIngredient(filling);

        String lineSeparator = System.getProperty("line.separator");
        String expectedReceipt = "(==== White Bun ====)" + lineSeparator +
                "= sauce Tomato Sauce =" + lineSeparator +
                "= filling Cheese =" + lineSeparator +
                "(==== White Bun ====)" + lineSeparator + lineSeparator +
                "Price: 3,200000" + lineSeparator;

        assertEquals("Чек должен быть сформирован корректно", expectedReceipt, burger.getReceipt());
    }
}