package praktikum;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.List;

import static org.junit.Assert.*;

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
}