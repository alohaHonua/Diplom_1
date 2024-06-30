import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import praktikum.*;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static praktikum.IngredientType.FILLING;
import static praktikum.IngredientType.SAUCE;

@RunWith(MockitoJUnitRunner.class)
public class IngredientTest {

    private final Burger burger = new Burger();

    @Mock
    Database database;
    public List<Ingredient> ingrediantlist = new ArrayList<>();

    @Before
    public void setUp() {
        ingrediantlist.add(new Ingredient(SAUCE, "sauce", 100));
        ingrediantlist.add(new Ingredient(FILLING, "steak", 200));
        Mockito.when(database.availableIngredients()).thenReturn(ingrediantlist);
    }

    @Test
    public void adddIngredientTest() {
        burger.addIngredient(database.availableIngredients().get(0));
        burger.removeIngredient(0);
        assertEquals(0, burger.ingredients.size());
    }

    @Test
    public void removeIngredientTest() {
        burger.addIngredient(database.availableIngredients().get(0));
        burger.removeIngredient(0);
        assertEquals(0, burger.ingredients.size());
    }

    @Test
    public void moveIngredientTest() {
        burger.addIngredient(database.availableIngredients().get(1));
        burger.addIngredient(database.availableIngredients().get(0));
        burger.moveIngredient(0,1);
        assertEquals(database.availableIngredients(), burger.ingredients);
    }
}
