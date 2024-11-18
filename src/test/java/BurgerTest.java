import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import praktikum.Bun;
import praktikum.Burger;
import praktikum.Ingredient;
import praktikum.IngredientType;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

public class BurgerTest {

    @Mock
    private Bun bun;
    @Mock
    private Ingredient ingredient1;
    @Mock
    private Ingredient ingredient2;
    @Mock
    private Ingredient ingredient3;

    private Burger burger;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        burger = new Burger();
    }

    @Test
    public void testAddIngredient() {
        when(bun.getPrice()).thenReturn(100.0f);
        when(ingredient1.getPrice()).thenReturn(200.0f);
        burger.setBuns(bun);
        burger.addIngredient(ingredient1);
        assertEquals(400.0f, burger.getPrice(), 0.001);
        assertEquals(1, burger.ingredients.size());
    }


    @Test
    public void testRemoveIngredient() {
        when(bun.getPrice()).thenReturn(100.0f);
        when(ingredient1.getPrice()).thenReturn(200.0f);
        when(ingredient2.getPrice()).thenReturn(300.0f);

        burger.setBuns(bun);
        burger.addIngredient(ingredient1);
        burger.addIngredient(ingredient2);

        assertEquals(700.0f, burger.getPrice(), 0.001);
        assertEquals(2, burger.ingredients.size());

        burger.removeIngredient(0); // Remove ingredient2

        assertEquals(500.0f, burger.getPrice(), 0.001);
        assertEquals(1, burger.ingredients.size());
    }

    @Test
    public void testMoveIngredient() {
        when(bun.getPrice()).thenReturn(1.0f);
        when(ingredient1.getPrice()).thenReturn(2.0f);
        when(ingredient2.getPrice()).thenReturn(3.0f);

        burger.setBuns(bun);
        burger.addIngredient(ingredient1);
        burger.addIngredient(ingredient2);

        assertEquals(7.0f, burger.getPrice(), 0.001);
        assertEquals(2, burger.ingredients.size());

        burger.moveIngredient(1, 0); // Move ingredient2 to index 0

        assertEquals(ingredient2, burger.ingredients.get(0));
        assertEquals(ingredient1, burger.ingredients.get(1));
        assertEquals(7.0f, burger.getPrice(), 0.001);
    }

    @Test
    public void testGetPrice_emptyBurger() {
        when(bun.getPrice()).thenReturn(100f);
        burger.setBuns(bun);
        assertEquals(200f, burger.getPrice(), 0.001);
    }

    @Test
    public void testGetPrice_withIngredients() {
        when(bun.getPrice()).thenReturn(100f);
        when(ingredient1.getPrice()).thenReturn(200f);
        when(ingredient2.getPrice()).thenReturn(300f);
        when(ingredient3.getPrice()).thenReturn(100f);

        burger.setBuns(bun);
        burger.addIngredient(ingredient1);
        burger.addIngredient(ingredient2);
        burger.addIngredient(ingredient3);

        assertEquals(800.0f, burger.getPrice(), 0.001);
    }


    @Test
    public void testGetReceipt_emptyBurger() {
        when(bun.getName()).thenReturn("Sesame");
        when(bun.getPrice()).thenReturn(1.0f);
        burger.setBuns(bun);
        String receipt = burger.getReceipt();

        List<String> expectedLines = Arrays.asList(
                "(==== Sesame ====)",
                "(==== Sesame ====)",
                "",
                "Price: 2,000000"  //Изменено форматирование для корректного сравнения
        );

        List<String> actualLines = Arrays.asList(receipt.split("\n"));

        assertEquals(expectedLines.size(), actualLines.size()); // Проверяем количество строк

        for (int i = 0; i < expectedLines.size(); i++) {
            assertEquals("Line " + (i + 1) + " mismatch", expectedLines.get(i), actualLines.get(i).trim());
        }
    }

    @Test
    public void testGetReceipt_withIngredients() {
        when(bun.getName()).thenReturn("Sesame");
        when(bun.getPrice()).thenReturn(100f);
        when(ingredient1.getName()).thenReturn("Cheese");
        when(ingredient1.getType()).thenReturn(IngredientType.SAUCE);
        when(ingredient1.getPrice()).thenReturn(200f);
        when(ingredient2.getName()).thenReturn("Tomato");
        when(ingredient2.getType()).thenReturn(IngredientType.FILLING);
        when(ingredient2.getPrice()).thenReturn(150f);

        burger.setBuns(bun);
        burger.addIngredient(ingredient1);
        burger.addIngredient(ingredient2);
        String receipt = burger.getReceipt();

        List<String> expectedLines = Arrays.asList(
                "(==== Sesame ====)",
                "= sauce Cheese =",
                "= filling Tomato =",
                "(==== Sesame ====)",
                "",
                "Price: 550,000000"
        );
        List<String> actualLines = Arrays.asList(receipt.split("\n"));
        assertEquals(expectedLines.size(), actualLines.size());
        for (int i = 0; i < expectedLines.size(); i++) {
            assertEquals(expectedLines.get(i), actualLines.get(i).trim());
        }
    }
}