import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;
import ru.practikum.yandex.Bun;
import ru.practikum.yandex.Burger;
import ru.practikum.yandex.Ingredient;
import ru.practikum.yandex.IngredientType;

import java.util.List;

@RunWith(MockitoJUnitRunner.class)
public class BurgerTest {

    @Mock
    private Bun mockBun;

    @Mock
    private Ingredient mockIngredient1;

    @Mock
    private Ingredient mockIngredient2;

    private Burger burger;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        burger = new Burger();
        when(mockBun.getPrice()).thenReturn(50.0f);
        when(mockBun.getName()).thenReturn("Sesame Bun");
        burger.setBuns(mockBun);
    }

    @Test
    public void addIngredientTest() {
        int initialSize = burger.ingredients.size();

        burger.addIngredient(mockIngredient1);
        burger.addIngredient(mockIngredient2);

        assertEquals(initialSize + 2, burger.ingredients.size());
    }

    @Test
    public void removeIngredientTest() {
        burger.addIngredient(mockIngredient1);
        burger.addIngredient(mockIngredient2);
        int initialSize = burger.ingredients.size();

        burger.removeIngredient(0);

        assertEquals(initialSize - 1, burger.ingredients.size());
    }

    @Test
    public void moveIngredientTest() {
        burger.addIngredient(mockIngredient1);
        burger.addIngredient(mockIngredient2);

        // перемещение с первой позиции на вторую
        burger.moveIngredient(0, 1);

        List<Ingredient> ingredients = burger.ingredients;
        assertEquals(mockIngredient2, ingredients.get(0));
        assertEquals(mockIngredient1, ingredients.get(1));
    }

    @Test
    public void getPriceTest() {
        when(mockIngredient1.getPrice()).thenReturn(20.0f);
        when(mockIngredient2.getPrice()).thenReturn(30.0f);

        burger.addIngredient(mockIngredient1);
        burger.addIngredient(mockIngredient2);

        float expectedPrice = mockBun.getPrice() * 2 + mockIngredient1.getPrice() + mockIngredient2.getPrice();
        assertEquals(expectedPrice, burger.getPrice(), 0.01);
    }

    @Test
    public void getReceiptTest() {
        when(mockIngredient1.getType()).thenReturn(IngredientType.FILLING);
        when(mockIngredient1.getName()).thenReturn("Lettuce");
        when(mockIngredient2.getType()).thenReturn(IngredientType.SAUCE);
        when(mockIngredient2.getName()).thenReturn("Ketchup");

        burger.addIngredient(mockIngredient1);
        burger.addIngredient(mockIngredient2);

        String expectedReceipt = String.format("(==== %s ====)%n= filling Lettuce =%n= sauce Ketchup =%n(==== %s ====)%n%nPrice: %f%n",
                mockBun.getName(), mockBun.getName(), burger.getPrice());

        assertEquals(expectedReceipt, burger.getReceipt());
    }
}
