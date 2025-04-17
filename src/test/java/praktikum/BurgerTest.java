package praktikum;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import static org.mockito.Mockito.when;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

@RunWith(Parameterized.class)
public class BurgerTest {
    @Mock
    private Bun bun;
    
    @Mock
    private Ingredient ingredient1;
    
    @Mock
    private Ingredient ingredient2;
    
    private Burger burger;
    private final float bunPrice;
    private final float ingredient1Price;
    private final float ingredient2Price;

    public BurgerTest(float bunPrice, float ingredient1Price, float ingredient2Price) {
        this.bunPrice = bunPrice;
        this.ingredient1Price = ingredient1Price;
        this.ingredient2Price = ingredient2Price;
    }

    @Parameterized.Parameters
    public static Object[][] getTestData() {
        return new Object[][] {
            {100f, 50f, 75f},
            {200f, 100f, 150f}
        };
    }

    @Before
    public void setUp() {
        MockitoAnnotations.openMocks(this);
        burger = new Burger();
        
        when(bun.getPrice()).thenReturn(bunPrice);
        when(bun.getName()).thenReturn("black bun");
        
        when(ingredient1.getPrice()).thenReturn(ingredient1Price);
        when(ingredient1.getType()).thenReturn(IngredientType.SAUCE);
        when(ingredient1.getName()).thenReturn("hot sauce");
        
        when(ingredient2.getPrice()).thenReturn(ingredient2Price);
        when(ingredient2.getType()).thenReturn(IngredientType.FILLING);
        when(ingredient2.getName()).thenReturn("cutlet");
    }

    @Test
    public void testSetBuns() {
        burger.setBuns(bun);
        assertEquals(bun, burger.bun);
    }

    @Test
    public void testAddIngredient() {
        burger.addIngredient(ingredient1);
        assertEquals(1, burger.ingredients.size());
        assertTrue(burger.ingredients.contains(ingredient1));
    }

    @Test
    public void testRemoveIngredient() {
        burger.addIngredient(ingredient1);
        burger.addIngredient(ingredient2);
        burger.removeIngredient(0);
        assertEquals(1, burger.ingredients.size());
        assertTrue(burger.ingredients.contains(ingredient2));
    }

    @Test
    public void testMoveIngredient() {
        burger.addIngredient(ingredient1);
        burger.addIngredient(ingredient2);
        burger.moveIngredient(0, 1);
        assertEquals(ingredient1, burger.ingredients.get(1));
        assertEquals(ingredient2, burger.ingredients.get(0));
    }

    @Test
    public void testGetPrice() {
        burger.setBuns(bun);
        burger.addIngredient(ingredient1);
        burger.addIngredient(ingredient2);
        
        float expectedPrice = bunPrice * 2 + ingredient1Price + ingredient2Price;
        assertEquals(expectedPrice, burger.getPrice(), 0.0f);
    }

    @Test
    public void testGetReceipt() {
        burger.setBuns(bun);
        burger.addIngredient(ingredient1);
        burger.addIngredient(ingredient2);
        
        String expectedReceipt = String.format("(==== %s ====)%n", bun.getName()) +
                String.format("= %s %s =%n", ingredient1.getType().toString().toLowerCase(), ingredient1.getName()) +
                String.format("= %s %s =%n", ingredient2.getType().toString().toLowerCase(), ingredient2.getName()) +
                String.format("(==== %s ====)%n", bun.getName()) +
                String.format("%nPrice: %f%n", burger.getPrice());

        assertEquals("Чек сформирован некорректно", expectedReceipt, burger.getReceipt());
    }
} 