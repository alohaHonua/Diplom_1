package praktikum;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

@RunWith(MockitoJUnitRunner.class)
public class BurgerTest {

    private Burger burger;

    @Mock
    Bun bun;

    @Mock
    Ingredient sauce;
    @Mock
    Ingredient filling;

    @Before
    public void setUp() {
        burger = new Burger();
    }


    @Test
    public void setBunsTest() {
        burger.setBuns(bun);
        assertEquals("Установлена переданнная булочка", bun, burger.bun);
    }


    @Test
    public void addIngredientTest() {
        burger.addIngredient(sauce);
        assertTrue("Ингридиент добавлен", burger.ingredients.contains(sauce));
    }

    @Test
    public void removeIngredientTest() {
        burger.addIngredient(sauce);
        burger.addIngredient(filling);
        burger.removeIngredient(0);
        burger.removeIngredient(0);
        assertTrue("Списко не пустой", burger.ingredients.isEmpty());
    }

    @Test
    public void moveIngredientTest() {
        burger.addIngredient(sauce);
        burger.addIngredient(filling);
        burger.moveIngredient(0, 1);
        assertEquals("Позиция не соответсвет номеру", sauce, burger.ingredients.get(1));
    }

    @Test
    public void getPriceTest() {
        Mockito.when(bun.getPrice()).thenReturn(50.0f);
        burger.setBuns(bun);

        Mockito.when(sauce.getPrice()).thenReturn(100.0f);
        burger.addIngredient(sauce);

        Mockito.when(filling.getPrice()).thenReturn(200.0f);
        burger.addIngredient(filling);

        float expectedPrice = 400;
        Assert.assertEquals("цена бургера не правильная", expectedPrice, burger.getPrice(), 0);
    }

    @Test
    public void getReceiptTest() {
        Mockito.when(bun.getName()).thenReturn("black bun");
        Mockito.when(bun.getPrice()).thenReturn(50.0f);
        burger.setBuns(bun);

        Mockito.when(filling.getType()).thenReturn(IngredientType.FILLING);
        Mockito.when(filling.getName()).thenReturn("cutlet");
        Mockito.when(filling.getPrice()).thenReturn(200.0f);
        burger.addIngredient(filling);

        StringBuilder receipt = new StringBuilder(String.format("(==== %s ====)%n", bun.getName()));
        List<Ingredient> ingredients = burger.ingredients;

        for (Ingredient ingredient : ingredients) {
            receipt.append(String.format("= %s %s =%n", ingredient.getType().name().toLowerCase(),
                    ingredient.getName()));
        }

        receipt.append(String.format("(==== %s ====)%n", bun.getName()));
        receipt.append(String.format("%nPrice: %f%n", burger.getPrice()));

        Assert.assertEquals(receipt.toString(), burger.getReceipt());
    }
}
