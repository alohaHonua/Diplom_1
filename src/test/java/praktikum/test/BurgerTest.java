package praktikum.test;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import praktikum.Bun;
import praktikum.Burger;
import praktikum.Ingredient;

import static org.mockito.Mockito.when;
import static praktikum.IngredientType.FILLING;
import static praktikum.IngredientType.SAUCE;
import static praktikum.constants.Constants.*;
import static org.junit.Assert.assertEquals;


@RunWith(MockitoJUnitRunner.class)
public class BurgerTest {

    private Burger burger;
    @Mock
    private Bun bun;
    private Ingredient ingredient1;
    private Ingredient ingredient2;


    @Before
    public void setUp() {
        burger = new Burger();
        bun = Mockito.mock(Bun.class);
        ingredient1 = new Ingredient(SAUCE, "hot sauce", 100F );
        ingredient2 = new Ingredient(FILLING, "cutlet", 100F );
        burger.setBuns(bun);
    }

    @Test
    public void testSetBuns() {
        when(bun.getPrice()).thenReturn(988.0F);
        assertEquals(1976.0F, burger.getPrice(), DELTA);
    }

    @Test
    public void testAddIngredient() {
        burger.addIngredient(ingredient1);
        assertEquals("Количество добавленных ингредиентов = 1", 1, burger.ingredients.size());
        assertEquals("Ингредиенты из ingredient1", ingredient1, burger.ingredients.get(0));
    }

    @Test
    public void testRemoveIngredient() {
        burger.addIngredient(ingredient1);
        burger.addIngredient(ingredient2);
        assertEquals("Количество добавленных ингредиентов = 2", 2, burger.ingredients.size());

        burger.removeIngredient(0);
        assertEquals("Количество ингредиентов после удаления позиции",1, burger.ingredients.size());
        assertEquals("Ингредиенты из ingredient2 отсутствует", ingredient2, burger.ingredients.get(0));
    }

    @Test
    public void testMoveIngredient() {
        burger.addIngredient(ingredient1);
        burger.addIngredient(ingredient2);
        assertEquals("Ингредиенты из ingredient1", ingredient1, burger.ingredients.get(0));
        assertEquals("Ингредиенты из ingredient2", ingredient2, burger.ingredients.get(1));

        burger.moveIngredient(0, 1);
        assertEquals("Ингредиенты из ingredient1 на позиции 2 после перемещения", ingredient1, burger.ingredients.get(1));
        assertEquals("Ингредиенты из ingredient2 на позиции 1 после перемещения", ingredient2, burger.ingredients.get(0));
    }

    @Test
    public void testGetPrice() {
        burger.addIngredient(ingredient1);
        burger.addIngredient(ingredient2);

        float expectedPrice = bun.getPrice() * 2
                + ingredient1.getPrice()
                + ingredient2.getPrice();
        assertEquals("Проверяем ожидаемую стоимость с актуальной", expectedPrice, burger.getPrice(), DELTA);
    }

    @Test
    public void testGetReceipt() {
        burger.addIngredient(ingredient1);
        burger.addIngredient(ingredient2);

        String expectedReceipt = String.format("(==== %s ====)%n" +
                        "= sauce %s =%n" +
                        "= filling %s =%n" +
                        "(==== %s ====)%n" +
                        "%nPrice: %f%n",
                bun.getName(), ingredient1.getName(), ingredient2.getName(), bun.getName(), burger.getPrice());
        assertEquals(expectedReceipt, burger.getReceipt());
    }
}
