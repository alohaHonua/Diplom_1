import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import praktikum.Bun;
import praktikum.Burger;
import praktikum.Ingredient;
import praktikum.IngredientType;


import static org.junit.Assert.*;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class BurgerTests {
    private Burger burger;

    @Mock
    private Bun bun;

    @Mock
    private Ingredient ingredient1;

    @Mock
    private Ingredient ingredient2;

    @Before
    public void setUp(){
        burger = new Burger();
    }

    @Test
    public void setBunsTest() {
        burger.setBuns(bun);
        assertEquals(bun, burger.bun);
    }
    @Test
    public void addIngredientTest() {
        burger.addIngredient(ingredient1);
        assertTrue(burger.ingredients.contains(ingredient1));
    }
    @Test
    public void removeIngredientTest(){
        burger.addIngredient(ingredient1);
        burger.removeIngredient(0);
        assertFalse(burger.ingredients.contains(ingredient1));
    }
    @Test
    public void moveIngredientTest(){
        burger.addIngredient(ingredient1);
        burger.addIngredient(ingredient2);
        burger.moveIngredient(0,1);
        assertEquals(ingredient1,burger.ingredients.get(1));
    }
    @Test
    public void getPriceTest(){
        when(bun.getPrice()).thenReturn(2.0F);
        when(ingredient1.getPrice()).thenReturn(1.0F);
        when(ingredient2.getPrice()).thenReturn(3.0F);
        burger.setBuns(bun);
        burger.addIngredient(ingredient1);
        burger.addIngredient(ingredient2);
        assertEquals(8.0F,burger.getPrice(),0.0F);
    }
    @Test
    public void getReceiptTest(){
        when(bun.getName()).thenReturn("Bun");
        when(ingredient1.getType()).thenReturn(IngredientType.SAUCE);
        when(ingredient2.getType()).thenReturn(IngredientType.FILLING);
        when(ingredient1.getName()).thenReturn("ingredient1");
        when(ingredient2.getName()).thenReturn("ingredient2");
        when(ingredient1.getPrice()).thenReturn(2.0F);
        when(ingredient2.getPrice()).thenReturn(3.0F);
        burger.setBuns(bun);
        burger.addIngredient(ingredient1);
        burger.addIngredient(ingredient2);
        String expectedResult = "(==== Bun ====)\n" + "= sauce ingredient1 =\n"+"= filling ingredient2 =\n"+"(==== Bun ====)\n"+"\nPrice: 5.000000\n";
        assertEquals(expectedResult,burger.getReceipt());
    }
}
