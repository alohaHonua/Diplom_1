import praktikum.*;
import static org.junit.Assert.*;
import static org.mockito.Mockito.*;
import org.junit.Test;
import org.junit.Before;


public class BurgerTest {

    private Burger burger;

    @Before
    public void setUp() {
        burger = new Burger();
    }

    @Test
    public void testAddIngredient() {
        Ingredient ingredient = mock(Ingredient.class);
        when(ingredient.getType()).thenReturn(IngredientType.SAUCE);
        when(ingredient.getName()).thenReturn("hot sauce");
        when(ingredient.getPrice()).thenReturn(100.0f);

        burger.addIngredient(ingredient);

        assertEquals(1, burger.ingredients.size());
        assertTrue(burger.ingredients.contains(ingredient));
        System.out.println("Тест пройден успешно: добавление ингредиента");
    }


    @Test
    public void testRemoveIngredient() {
        Ingredient ingredient = mock(Ingredient.class);
        when(ingredient.getType()).thenReturn(IngredientType.SAUCE);
        when(ingredient.getName()).thenReturn("hot sauce");
        when(ingredient.getPrice()).thenReturn(100.0f);

        burger.ingredients.add(ingredient);

        burger.removeIngredient(0);

        assertTrue(burger.ingredients.isEmpty());
        System.out.println("Тест пройден успешно: удаление ингредиента");
    }


    @Test
    public void testMoveIngredient() {
        Ingredient ingredient1 = mock(Ingredient.class);
        Ingredient ingredient2 = mock(Ingredient.class);
        when(ingredient1.getType()).thenReturn(IngredientType.SAUCE);
        when(ingredient1.getName()).thenReturn("hot sauce");
        when(ingredient1.getPrice()).thenReturn(100.0f);
        when(ingredient2.getType()).thenReturn(IngredientType.FILLING);
        when(ingredient2.getName()).thenReturn("sausage");
        when(ingredient2.getPrice()).thenReturn(300.0f);

        burger.ingredients.add(ingredient1);
        burger.ingredients.add(ingredient2);

        burger.moveIngredient(0, 1);

        assertEquals(ingredient1, burger.ingredients.get(1));
        assertEquals(ingredient2, burger.ingredients.get(0));
        System.out.println("Тест пройден успешно: перемещение ингредиента");
    }

    @Test
    public void testGetPrice() {
        Bun bun = mock(Bun.class);
        Ingredient ingredient1 = mock(Ingredient.class);
        Ingredient ingredient2 = mock(Ingredient.class);
        when(bun.getPrice()).thenReturn(200.0f);
        when(ingredient1.getPrice()).thenReturn(100.0f);
        when(ingredient2.getPrice()).thenReturn(300.0f);

        burger.setBuns(bun);
        burger.ingredients.add(ingredient1);
        burger.ingredients.add(ingredient2);

        float expectedPrice = 200.0f * 2 + 100.0f + 300.0f;

        assertEquals(expectedPrice, burger.getPrice(), 0.001f);
        System.out.println("Тест пройден успешно: расчет цены бургера");
    }

    @Test
    public void testGetReceipt() {

        Bun bun = mock(Bun.class);
        Ingredient ingredient1 = mock(Ingredient.class);
        Ingredient ingredient2 = mock(Ingredient.class);

        when(bun.getName()).thenReturn("white bun");
        when(bun.getPrice()).thenReturn(200.0f);
        when(ingredient1.getType()).thenReturn(IngredientType.SAUCE);
        when(ingredient1.getName()).thenReturn("hot sauce");
        when(ingredient1.getPrice()).thenReturn(100.0f);
        when(ingredient2.getType()).thenReturn(IngredientType.FILLING);
        when(ingredient2.getName()).thenReturn("sausage");
        when(ingredient2.getPrice()).thenReturn(300.0f);

        burger.setBuns(bun);

        burger.ingredients.add(ingredient1);
        burger.ingredients.add(ingredient2);


        String expectedReceipt = "(==== white bun ====)" + System.lineSeparator() +
                "= sauce hot sauce =" + System.lineSeparator() +
                "= filling sausage =" + System.lineSeparator() +
                "(==== white bun ====)" + System.lineSeparator() +
                System.lineSeparator() +
                "Price: 800,000000" + System.lineSeparator();

        assertEquals(expectedReceipt, burger.getReceipt());
        System.out.println("Тест пройден успешно: создание чека");
    }
}
