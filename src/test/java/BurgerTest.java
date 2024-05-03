import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import praktikum.*;

import java.util.List;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;


public class BurgerTest {
    @Mock
    Bun bunMock;
    @Mock
    Ingredient ingredient1;
    @Mock
    Ingredient ingredient2;
    @Before
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testSetBuns(){
        Burger burger = new Burger();
        burger.setBuns(bunMock);
        assertEquals(bunMock, burger.bun);
    }
    @Test
    public void testAddIngredient() {
        List<Ingredient> ingredientsMock = mock(List.class);
        Burger burger = new Burger();
        burger.ingredients = ingredientsMock;
        burger.addIngredient(ingredient1);
        verify(ingredientsMock, times(1)).add(ingredient1);
    }


    @Test
    public void testRemoveIngredient() {
        Burger burger = new Burger();
        burger.setBuns(bunMock);
        burger.addIngredient(ingredient1);
        burger.addIngredient(ingredient2);
        burger.removeIngredient(0);
        assertEquals(1, burger.ingredients.size());
        assertEquals(ingredient2, burger.ingredients.get(0));
    }

    @Test
    public void testMoveIngredient() {
        Burger burger = new Burger();
        burger.setBuns(bunMock);
        burger.addIngredient(ingredient1);
        burger.addIngredient(ingredient2);
        burger.moveIngredient(0, 1);
        assertEquals(ingredient2, burger.ingredients.get(0));
        assertEquals(ingredient1, burger.ingredients.get(1));
    }
}
