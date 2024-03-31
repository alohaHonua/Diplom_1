import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import praktikum.Bun;
import praktikum.Burger;
import praktikum.Ingredient;
import praktikum.IngredientType;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class TestBurger {
private Burger burger;
    @Mock
    private Bun bun;

    @Mock
    private Ingredient ingredient, ingredient_2, ingredient_3;

    @Before
    public void setUp(){
        burger = new Burger();
    }

    @Test
    public void setBunTest(){
        burger.setBuns(bun);
        assertEquals(bun.getName(),burger.bun.getName());
    }

    @Test
    public void addIngredientTest(){
        burger.addIngredient(ingredient);
        Assert.assertFalse(burger.ingredients.isEmpty());
    }

    @Test
    public void removeIngredientTest(){
        burger.addIngredient(ingredient);
        burger.addIngredient(ingredient_2);
        burger.addIngredient(ingredient_3);
        assertEquals(3, burger.ingredients.size());
        burger.removeIngredient(1);
        assertEquals(2, burger.ingredients.size());
    }

    @Test
    public void moveIngredientTest(){
        burger.addIngredient(ingredient);
        burger.addIngredient(ingredient_2);
        burger.addIngredient(ingredient_3);
        burger.moveIngredient(1,2);
        assertEquals(ingredient_2, burger.ingredients.get(2));
        assertEquals(ingredient_3, burger.ingredients.get(1));
    }

    @Test
    public void getPriceTest(){
        burger.setBuns(bun);
        burger.addIngredient(ingredient);
        when(bun.getPrice()).thenReturn(51.00F);
        when(ingredient.getPrice()).thenReturn(120.00F);
        Assert.assertEquals(222.00F,burger.getPrice(),0);
    }

    @Test
    public void getReceiptTest(){
        burger.setBuns(bun);
        burger.addIngredient(ingredient);
        burger.addIngredient(ingredient_2);
        when(bun.getName()).thenReturn("burger");
        when(ingredient.getName()).thenReturn("ingredient1");
        when(ingredient_2.getName()).thenReturn("ingredient2");
        when(bun.getPrice()).thenReturn(200F);
        when(ingredient.getPrice()).thenReturn(15F);
        when(ingredient_2.getPrice()).thenReturn(3F);
        when(ingredient.getType()).thenReturn(IngredientType.SAUCE);
        when(ingredient_2.getType()).thenReturn(IngredientType.FILLING);

        String expected = "(==== burger ====)\r\n" +
                "= sauce ingredient1 =\r\n" +
                "= filling ingredient2 =\r\n" +
                "(==== burger ====)\r\n" +
                "\r\n" +
                "Price: 418,000000\r\n";

        assertEquals(expected, burger.getReceipt());


    }
}
