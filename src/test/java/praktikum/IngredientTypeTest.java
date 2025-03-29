package praktikum;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

import java.util.List;

public class IngredientTypeTest {

    private List<Ingredient> ingredients;

    @Before
    public void setUp() {
        // Получаем все ингредиенты из базы данных
        Database database = new Database();
        ingredients = database.availableIngredients();
    }

    @Test
    public void testIngredientTypeValues() {
        // Проверяем типы ингредиентов
        assertEquals(IngredientType.SAUCE, ingredients.get(0).getType());
        assertEquals(IngredientType.SAUCE, ingredients.get(1).getType());
        assertEquals(IngredientType.SAUCE, ingredients.get(2).getType());
        assertEquals(IngredientType.FILLING, ingredients.get(3).getType());
        assertEquals(IngredientType.FILLING, ingredients.get(4).getType());
        assertEquals(IngredientType.FILLING, ingredients.get(5).getType());
    }
}

