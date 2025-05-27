package praktikum;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import static org.junit.Assert.*;
import static org.mockito.Mockito.*;
import java.util.Arrays;
import java.util.Collection;

@RunWith(MockitoJUnitRunner.class)
public class BurgerTest {
    
    private Burger burger;
    
    @Mock
    private Bun bun;
    
    @Mock
    private Ingredient ingredient1;
    
    @Mock
    private Ingredient ingredient2;
    
    @Before
    public void setUp() {
        burger = new Burger();
        
        when(bun.getName()).thenReturn("black bun");
        when(bun.getPrice()).thenReturn(100f);
        
        when(ingredient1.getType()).thenReturn(IngredientType.SAUCE);
        when(ingredient1.getName()).thenReturn("hot sauce");
        when(ingredient1.getPrice()).thenReturn(50f);
        
        when(ingredient2.getType()).thenReturn(IngredientType.FILLING);
        when(ingredient2.getName()).thenReturn("cutlet");
        when(ingredient2.getPrice()).thenReturn(150f);
    }
    
    @Test
    public void testSetBuns() {
        burger.setBuns(bun);
        assertEquals("Булочка должна быть установлена", bun, burger.bun);
    }
    
    @Test
    public void testAddIngredient() {
        burger.addIngredient(ingredient1);
        assertEquals("Ингредиент должен быть добавлен", 1, burger.ingredients.size());
        assertEquals("Добавленный ингредиент должен совпадать", ingredient1, burger.ingredients.get(0));
    }
    
    @Test
    public void testRemoveIngredient() {
        burger.addIngredient(ingredient1);
        burger.addIngredient(ingredient2);
        burger.removeIngredient(0);
        
        assertEquals("Должен остаться один ингредиент", 1, burger.ingredients.size());
        assertEquals("Оставшийся ингредиент должен быть ingredient2", ingredient2, burger.ingredients.get(0));
    }
    
    @Test
    public void testMoveIngredient() {
        burger.addIngredient(ingredient1);
        burger.addIngredient(ingredient2);
        burger.moveIngredient(0, 1);
        
        assertEquals("Первый ингредиент должен быть ingredient2", ingredient2, burger.ingredients.get(0));
        assertEquals("Второй ингредиент должен быть ingredient1", ingredient1, burger.ingredients.get(1));
    }
    
    @Test
    public void testGetPrice() {
        burger.setBuns(bun);
        burger.addIngredient(ingredient1);
        burger.addIngredient(ingredient2);

        float expectedPrice = 100f * 2 + 50f + 150f; // значения из when(...)
        float actualPrice = burger.getPrice();
        assertEquals("Цена должна быть рассчитана правильно", expectedPrice, actualPrice, 0.0f);

        verify(ingredient1, times(1)).getPrice();
        verify(ingredient2, times(1)).getPrice();
    }
    
    @Test
    public void testGetReceipt() {
        burger.setBuns(bun);
        burger.addIngredient(ingredient1);
        burger.addIngredient(ingredient2);
        
        String receipt = burger.getReceipt();
        
        assertTrue("Чек должен содержать название булочки", receipt.contains("black bun"));
        assertTrue("Чек должен содержать название соуса", receipt.contains("hot sauce"));
        assertTrue("Чек должен содержать название начинки", receipt.contains("cutlet"));
        assertTrue("Чек должен содержать общую цену", receipt.contains("400.0"));
        
        verify(bun, times(2)).getName();
        verify(ingredient1, times(1)).getType();
        verify(ingredient1, times(1)).getName();
        verify(ingredient2, times(1)).getType();
        verify(ingredient2, times(1)).getName();
    }

    @RunWith(Parameterized.class)
    public static class BurgerPriceTest {
        private Burger burger;
        private final float bunPrice;
        private final float[] ingredientPrices;
        private final float expectedPrice;
        
        @Mock
        private Bun bun;
        
        @Mock
        private Ingredient[] ingredients;
        
        public BurgerPriceTest(float bunPrice, float[] ingredientPrices, float expectedPrice) {
            this.bunPrice = bunPrice;
            this.ingredientPrices = ingredientPrices;
            this.expectedPrice = expectedPrice;
        }
        
        @Parameters(name = "{index}: bunPrice={0}, ingredientPrices={1}, expectedPrice={2}")
        public static Collection<Object[]> data() {
            return Arrays.asList(new Object[][] {
                { 100f, new float[]{50f, 150f}, 400f },  // 2 * bunPrice + sum(ingredientPrices)
                { 50f, new float[]{30f}, 130f },         // 2 * bunPrice + single ingredient
                { 200f, new float[]{}, 400f },           // only bun, no ingredients
                { 75f, new float[]{25f, 25f, 25f}, 250f } // multiple ingredients
            });
        }
        
        @Before
        public void setUp() {
            burger = new Burger();
            ingredients = new Ingredient[ingredientPrices.length];
            
            when(bun.getPrice()).thenReturn(bunPrice);
            burger.setBuns(bun);
            
            for (int i = 0; i < ingredientPrices.length; i++) {
                ingredients[i] = mock(Ingredient.class);
                when(ingredients[i].getPrice()).thenReturn(ingredientPrices[i]);
                burger.addIngredient(ingredients[i]);
            }
        }
        
        @Test
        public void testGetPrice() {
            float actualPrice = burger.getPrice();
            assertEquals("Цена должна быть рассчитана правильно", expectedPrice, actualPrice, 0.0f);
            
            verify(bun, times(1)).getPrice();
            for (Ingredient ingredient : ingredients) {
                verify(ingredient, times(1)).getPrice();
            }
        }
    }
} 