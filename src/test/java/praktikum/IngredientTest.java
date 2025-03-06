package praktikum;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

import java.util.List;

public class IngredientTest {

    private List<Ingredient> ingredients;

    @Before
    public void setUp() {
        // Получаем все ингредиенты из базы данных
        Database database = new Database();
        ingredients = database.availableIngredients();
    }

    @Test
    public void testGetName() {
        // Проверяем название каждого ингредиента
        assertEquals("hot sauce", ingredients.get(0).getName());
        assertEquals("sour cream", ingredients.get(1).getName());
        assertEquals("chili sauce", ingredients.get(2).getName());
        assertEquals("cutlet", ingredients.get(3).getName());
        assertEquals("dinosaur", ingredients.get(4).getName());
        assertEquals("sausage", ingredients.get(5).getName());
    }

    @Test
    public void testGetPrice() {
        // Проверяем цену каждого ингредиента
        assertEquals(100.0, ingredients.get(0).getPrice(), 0.01);
        assertEquals(200.0, ingredients.get(1).getPrice(), 0.01);
        assertEquals(300.0, ingredients.get(2).getPrice(), 0.01);
        assertEquals(100.0, ingredients.get(3).getPrice(), 0.01);
        assertEquals(200.0, ingredients.get(4).getPrice(), 0.01);
        assertEquals(300.0, ingredients.get(5).getPrice(), 0.01);
    }

    @Test
    public void testGetType() {
        // Проверяем тип каждого ингредиента
        assertEquals(IngredientType.SAUCE, ingredients.get(0).getType());
        assertEquals(IngredientType.SAUCE, ingredients.get(1).getType());
        assertEquals(IngredientType.SAUCE, ingredients.get(2).getType());
        assertEquals(IngredientType.FILLING, ingredients.get(3).getType());
        assertEquals(IngredientType.FILLING, ingredients.get(4).getType());
        assertEquals(IngredientType.FILLING, ingredients.get(5).getType());
    }
}

