package praktikum;

import org.hamcrest.MatcherAssert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.List;
import java.util.regex.Matcher;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.containsString;

@RunWith(MockitoJUnitRunner.class)
public class BurgerTest {

    private Burger burger;

    @Mock
    private Bun bun;

    @Mock
    private Ingredient sauce;

    @Mock
    private Ingredient filling;

    //Перд каждым тестом создаем новый объект бургера
    @Before
    public void setUp() {
        burger = new Burger();
    }

    @Test
    public void setBuns() {
        burger.setBuns(bun);
        assertEquals("Вернулась не та булочка",bun, burger.bun);
    }

    @Test
    public void addIngredientReturnListOfIngredients() {
        burger.addIngredient(filling);
        burger.addIngredient(sauce);
        List<Ingredient> expextedList = List.of (filling, sauce);
        assertEquals("Список ингредиентов не совпадает", expextedList, burger.ingredients);
    }

    @Test
    public void removeIngredientReturnEmptyList() {
        burger.addIngredient(sauce);
        burger.removeIngredient(0);
        assertEquals("Списко ингредиентов не пустой", List.of(), burger.ingredients);
    }

    @Test
    public void moveIngredient() {
        burger.addIngredient(filling);
        burger.addIngredient(sauce);
        burger.moveIngredient(0, 1);
        assertEquals("Не совпадает первый ингредиет", sauce, burger.ingredients.get(0));
    }

    @Test
    public void getPriceReturnSix() {
        Mockito.when(bun.getPrice()).thenReturn(1.0f);
        burger.setBuns(bun);

        Mockito.when(sauce.getPrice()).thenReturn(2.7f);
        Mockito.when(filling.getPrice()).thenReturn(1.3f);
        burger.addIngredient(sauce);
        burger.addIngredient(filling);

        float expectedPrice = 1.0f * 2 + 2.7f + 1.3f;
        assertEquals("Цена бургера не равна 6,0", expectedPrice, burger.getPrice(), 0);

    }

    @Test
    public void getReceipt() {
        Mockito.when(bun.getName()).thenReturn("rye");
        Mockito.when(bun.getPrice()).thenReturn(2.0f);
        burger.setBuns(bun);

        Mockito.when(sauce.getType()).thenReturn(IngredientType.SAUCE);
        Mockito.when(sauce.getName()).thenReturn("pesto");
        Mockito.when(sauce.getPrice()).thenReturn(1.0f);
        burger.addIngredient(sauce);

        Mockito.when(filling.getType()).thenReturn(IngredientType.FILLING);
        Mockito.when(filling.getName()).thenReturn("pickls");
        Mockito.when(filling.getPrice()).thenReturn(2.0f);
        burger.addIngredient(filling);

        String expectedReceipt = String.format("(==== rye ====)%n")
                + String.format("= sauce pesto =%n")
                + String.format("= filling pickls =%n")
                + String.format("(==== rye ====)%n")
                + (String.format("%nPrice: 7,000000%n"));

        assertEquals(expectedReceipt, burger.getReceipt());

    }
}