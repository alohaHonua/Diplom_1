package praktikum;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

public class BurgerTest {

    @Mock
    private Bun mockBun;
    
    @Mock
    private Ingredient mockIngredient1;
    
    @Mock
    private Ingredient mockIngredient2;

    private Burger burger;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        burger = new Burger();
    }

    @Test
    public void testSetBun() {
        when(mockBun.getName()).thenReturn("Test Bun");
        when(mockBun.getPrice()).thenReturn(100.0f);
        
        burger.setBuns(mockBun);
        assertEquals(mockBun, burger.bun);
    }

    @Test
    public void testAddIngredient() {
        when(mockIngredient1.getName()).thenReturn("Test Ingredient");
        when(mockIngredient1.getPrice()).thenReturn(50.0f);
        when(mockIngredient1.getType()).thenReturn(IngredientType.FILLING);
        
        burger.addIngredient(mockIngredient1);
        List<Ingredient> ingredients = burger.ingredients;
        assertEquals(1, ingredients.size());
        assertEquals(mockIngredient1, ingredients.get(0));
    }

    @Test
    public void testRemoveIngredient() {
        when(mockIngredient1.getName()).thenReturn("Test Ingredient 1");
        when(mockIngredient1.getPrice()).thenReturn(50.0f);
        when(mockIngredient1.getType()).thenReturn(IngredientType.SAUCE);
        
        when(mockIngredient2.getName()).thenReturn("Test Ingredient 2");
        when(mockIngredient2.getPrice()).thenReturn(70.0f);
        when(mockIngredient2.getType()).thenReturn(IngredientType.FILLING);
        
        burger.addIngredient(mockIngredient1);
        burger.addIngredient(mockIngredient2);
        
        assertEquals(2, burger.ingredients.size());
        
        burger.removeIngredient(0);
        
        assertEquals(1, burger.ingredients.size());
        assertEquals(mockIngredient2, burger.ingredients.get(0));
    }

    @Test
    public void testMoveIngredient() {
        when(mockIngredient1.getName()).thenReturn("Test Ingredient 1");
        when(mockIngredient1.getPrice()).thenReturn(50.0f);
        
        when(mockIngredient2.getName()).thenReturn("Test Ingredient 2");
        when(mockIngredient2.getPrice()).thenReturn(70.0f);
        
        burger.addIngredient(mockIngredient1);
        burger.addIngredient(mockIngredient2);
        
        burger.moveIngredient(0, 1);
        
        assertEquals(mockIngredient2, burger.ingredients.get(0));
        assertEquals(mockIngredient1, burger.ingredients.get(1));
    }

    @Test
    public void testCalculateCorrectPrice() {
        when(mockBun.getPrice()).thenReturn(100.0f);
        when(mockIngredient1.getPrice()).thenReturn(50.0f);
        when(mockIngredient2.getPrice()).thenReturn(70.0f);
        
        burger.setBuns(mockBun);
        burger.addIngredient(mockIngredient1);
        burger.addIngredient(mockIngredient2);
        
        float expectedPrice = 100.0f * 2 + 50.0f + 70.0f; 
        assertEquals(expectedPrice, burger.getPrice(), 0.0f);
    }

    @Test
    public void testMoveIngredientToList() {
        Burger burger = new Burger();
        Ingredient bun = new Ingredient(IngredientType.FILLING, "bun", 100.0f);
        Ingredient cheese = new Ingredient(IngredientType.FILLING, "cheese", 50.0f);
        Ingredient sauce = new Ingredient(IngredientType.SAUCE, "sauce", 25.0f);
        
        burger.addIngredient(bun);
        burger.addIngredient(cheese);
        burger.addIngredient(sauce);
        
        assertEquals(3, burger.ingredients.size());
        assertTrue(burger.ingredients.contains(bun));
        assertTrue(burger.ingredients.contains(cheese));
        assertTrue(burger.ingredients.contains(sauce));
    }
    
    private void assertTrue(boolean condition) {
        assertEquals(true, condition);
    }
}