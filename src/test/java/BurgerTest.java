import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import praktikum.Bun;
import praktikum.Burger;
import praktikum.Ingredient;
import praktikum.IngredientType;

import java.util.ArrayList;
import java.util.Arrays;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class BurgerTest {
    private Burger burger;
    @Before
    public void Burger() {
        burger = new Burger();
    }
    @Mock
    Bun bun;
    @Mock
    Ingredient firstIngredient, secondIngredient, thirdIngredient;

    @Test
    public void setBuns() {
        burger.setBuns(bun);
        assertEquals(bun, burger.bun);
    }
    @Test
    public void addIngredient() {
        burger.addIngredient(firstIngredient);
        burger.addIngredient(secondIngredient);
        burger.addIngredient(thirdIngredient);
        assertEquals(3, burger.ingredients.size());
    }
    @Test
    public void removeIngredient() {
        burger.addIngredient(firstIngredient);
        burger.addIngredient(secondIngredient);
        burger.removeIngredient(0);
        assertEquals(1, burger.ingredients.size());
    }
    @Test
    public void moveIngredient() {
        burger.addIngredient(firstIngredient);
        burger.addIngredient(secondIngredient);
        burger.addIngredient(thirdIngredient);
        burger.moveIngredient(1, 0);
        assertEquals(new ArrayList<>(Arrays.asList(secondIngredient, firstIngredient, thirdIngredient)), burger.ingredients);
    }
    @Test
    public void getPrice() {
        burger.setBuns(bun);
        burger.ingredients.add(firstIngredient);
        when(bun.getPrice()).thenReturn(10f);
        when(firstIngredient.getPrice()).thenReturn(20f);
        float actual = burger.getPrice();
        assertThat(actual, equalTo(40f));
    }
    @Test
    public void getReceipt() {
        Bun bun = new Bun("red bun", 300);
        Ingredient ingredient = new Ingredient(IngredientType.SAUCE, "sour cream", 200);
        burger.setBuns(bun);
        burger.addIngredient(ingredient);
        String actual = burger.getReceipt();
        String expected = "(==== red bun ====)\r\n= sauce sour cream =\r\n(==== red bun ====)\r\n\r\nPrice: 800,000000\r\n";
        assertThat(actual, equalTo(expected));
    }
}
