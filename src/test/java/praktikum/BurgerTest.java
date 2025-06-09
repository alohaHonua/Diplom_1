package praktikum;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.Assert.*;

@RunWith(MockitoJUnitRunner.class)
public class BurgerTest {
    Burger burger;

    @Mock
    Bun bun;
    @Mock
    Ingredient firstIngredient;
    @Mock
    Ingredient secondIngredient;

    @Before
    public void setUp(){
        burger = new Burger();

        Mockito.when(bun.getName()).thenReturn("black bun");
        Mockito.when(bun.getPrice()).thenReturn(100F);

        Mockito.when(firstIngredient.getType()).thenReturn(IngredientType.SAUCE);
        Mockito.when(firstIngredient.getName()).thenReturn("hot sauce");
        Mockito.when(firstIngredient.getPrice()).thenReturn(100F);

        Mockito.when(secondIngredient.getType()).thenReturn(IngredientType.FILLING);
        Mockito.when(secondIngredient.getName()).thenReturn("dinosaur");
        Mockito.when(secondIngredient.getPrice()).thenReturn(200F);
    }

    @Test
    public void setBunsTest() {
        burger.setBuns(bun);
        assertEquals(String.format("Значение должно соответствовать %s", bun), bun, burger.bun);
    }

    @Test
    public void addIngredientTest() {
        burger.addIngredient(firstIngredient);
        assertTrue(String.format("Значение %s не добавлено в список ингредиентов", firstIngredient), burger.ingredients.contains(firstIngredient));
    }

    @Test
    public void removeIngredientTest() {
        burger.addIngredient(firstIngredient);
        burger.removeIngredient(0);
        assertFalse(String.format("Значение %s не удалено из списка ингредиентов", firstIngredient), burger.ingredients.contains(firstIngredient));
    }

    @Test
    public void moveIngredientTest() {
        burger.addIngredient(firstIngredient);
        burger.addIngredient(secondIngredient);
        burger.moveIngredient(0, 1);
        assertEquals("Значения не переместились", firstIngredient, burger.ingredients.get(1));
    }

    @Test
    public void getPriceTest() {
        burger.setBuns(bun);
        burger.addIngredient(firstIngredient);
        burger.addIngredient(secondIngredient);

        float expectedPrice = bun.getPrice() * 2 + firstIngredient.getPrice() + secondIngredient.getPrice();
        assertEquals("Цена не соответствует ожидаемой", expectedPrice, burger.getPrice(), 0);
    }

    @Test
    public void getReceiptTest() {
        burger.setBuns(bun);
        burger.addIngredient(firstIngredient);
        burger.addIngredient(secondIngredient);

        String expectedReceipt = String.format("(==== %s ====)%n" + "= sauce %s =%n" + "= filling %s =%n" + "(==== %s ====)%n" + "%nPrice: %f%n",
                bun.getName(), firstIngredient.getName(), secondIngredient.getName(), bun.getName(), burger.getPrice());

        assertEquals("Чек не соответствует ожидаемому", expectedReceipt, burger.getReceipt());
    }
}