package praktikum;


import org.junit.*;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.Spy;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.List;

import static org.hamcrest.CoreMatchers.containsString;
import static org.junit.Assert.*;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class BurgerTest {
    @Mock
    Bun bun;
    @Mock
    Ingredient fish;
    @Mock
    Ingredient secondIngredient;
    @Mock
    Ingredient potato;
    @Mock
    Ingredient ingredient;

    @Spy
    private Burger burger;

    @Before
    public void setup() {
        when(bun.getName()).thenReturn("Флюоресцентная булка R2-D3");
        when(bun.getPrice()).thenReturn(5.0f);
        when(ingredient.getPrice()).thenReturn(3.0f);
        when(ingredient.getName()).thenReturn("Space Sauce");
        when(ingredient.getType()).thenReturn(IngredientType.SAUCE);
        when(secondIngredient.getPrice()).thenReturn(4.0f);
        when(secondIngredient.getName()).thenReturn("Хрустящие минеральные кольца");
        when(secondIngredient.getType()).thenReturn(IngredientType.FILLING);
    }

    @Test
    public void setBunsTest() {
        burger.setBuns(bun);
        assertEquals(bun, burger.bun);
    }

    @Test
    public void addIngredientTest() {
        burger.addIngredient(ingredient);
        assertTrue(burger.ingredients.contains(ingredient));
    }

    @Test
    public void removeIngredientTest() {
        burger.ingredients.add(ingredient);
        burger.removeIngredient(0);
        assertTrue(burger.ingredients.isEmpty());
    }

    @Test
    public void moveIngredientTest() {
        burger.ingredients.addAll(List.of(ingredient, secondIngredient));
        burger.moveIngredient(1, 0);
        burger.ingredients.get(1).getName();
        Mockito.verify(ingredient).getName();
    }

    @Test
    public void getPriceTest() {
        burger.setBuns(bun);
        burger.ingredients.addAll(List.of(ingredient, secondIngredient));
        assertEquals(17.0, burger.getPrice(), 0.01);
    }

    @Test
    public void getReceiptCorrectTest() {
        burger.setBuns(bun);
        burger.ingredients.addAll(List.of(ingredient, secondIngredient));
        String expected = String.format("(==== Флюоресцентная булка R2-D3 ====)\r\n" +
                "= sauce Space Sauce =\r\n" +
                "= filling Хрустящие минеральные кольца =\r\n" +
                "(==== Флюоресцентная булка R2-D3 ====)\r\n" +
                "\r\n" +
                "Price: 17,000000\r\n");
        assertEquals(expected, burger.getReceipt());
    }
}


