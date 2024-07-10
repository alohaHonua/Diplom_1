import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;
import praktikum.Ingredient;
import praktikum.IngredientType;


@RunWith(MockitoJUnitRunner.class)
public class IngredientTest {

    private Ingredient ingredient;

    @Before
    public void setUp()  {
        ingredient = new Ingredient(IngredientType.SAUCE, "hot sauce", 100);
    }

    @Test
    public void testGetPrice() {
        assertEquals(100, ingredient.getPrice(), 1);
    }

    @Test
    public void testGetName() {
        assertEquals("hot sauce", ingredient.getName());
    }

    @Test
    public void testGetType() {
        assertEquals(IngredientType.SAUCE, ingredient.getType());
    }

    // Использование моков
    @Test
    public void testMocking() {
        // Создание мока для метода getPrice
        Ingredient ingredientMock = mock(Ingredient.class);
        when(ingredientMock.getPrice()).thenReturn(5.0f);

        // Проверка поведения мока
        assertEquals(5.0f, ingredientMock.getPrice(), 0.001f);
    }

    // Тестирование поля `type`
    @Test
    public void testType() {
        Ingredient ingredient = new Ingredient(IngredientType.SAUCE, "hot sauce", 100);
        assertEquals(IngredientType.SAUCE, ingredient.getType());
    }

    // Тестирование поля `name`
    @Test
    public void testName() {
        Ingredient ingredient = new Ingredient(IngredientType.SAUCE, "hot sauce", 100);
        assertEquals("hot sauce", ingredient.getName());
    }

    // Тестирование поля `price`
    @Test
    public void testPrice() {
        Ingredient ingredient = new Ingredient(IngredientType.SAUCE, "hot sauce", 100);
        assertEquals(100, ingredient.getPrice(), 1);
    }

}
