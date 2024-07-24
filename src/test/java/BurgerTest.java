import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import praktikum.Bun;
import praktikum.Burger;
import praktikum.Ingredient;
import praktikum.IngredientType;

import java.util.List;

import static junit.framework.TestCase.assertEquals;


@RunWith(MockitoJUnitRunner.class)
public class BurgerTest {
    @Mock
    Bun bun;
    @Mock
    Ingredient filling;
    @Mock
    Ingredient sauce;

    @Test
    public void setBunsTest() {
        Burger burger = new Burger();
        burger.setBuns(bun);
        assertEquals(bun, burger.bun);
    }

    @Test
    public void addIngredientTest() {
        Burger burger = new Burger();
        burger.addIngredient(filling);
        burger.addIngredient(sauce);
        List<Ingredient> ingredients = burger.ingredients;

        assertEquals(List.of(filling, sauce), ingredients);
    }

    @Test
    public void removeIngredientTest() {
        Burger burger = new Burger();
        burger.addIngredient(filling);
        burger.addIngredient(sauce);
        List<Ingredient> ingredients = burger.ingredients;
        burger.removeIngredient(0);

        assertEquals(List.of(sauce), ingredients);
    }

    @Test
    public void moveIngredientTest() {
        Burger burger = new Burger();
        burger.addIngredient(filling);
        burger.addIngredient(sauce);
        burger.moveIngredient(0,1);
        Ingredient ingedient = burger.ingredients.get(1);

        assertEquals(filling, ingedient);
    }

    @Test
    public void getPriceTest() {
        Burger burger = new Burger();
        Mockito.when(bun.getPrice()).thenReturn(10.0f);
        burger.setBuns(bun);

        Mockito.when(sauce.getPrice()).thenReturn(5.0f);
        burger.addIngredient(sauce);

        Mockito.when(filling.getPrice()).thenReturn(25.0f);
        burger.addIngredient(filling);

        float price = bun.getPrice() * 2 + sauce.getPrice() + filling.getPrice();
        assertEquals(price, burger.getPrice());
    }

    @Test
    public void getReceiptTest() {
        Burger burger = new Burger();
        Mockito.when(bun.getName()).thenReturn("Мои Булочки");
        Mockito.when(bun.getPrice()).thenReturn(10.0f);
        burger.setBuns(bun);

        Mockito.when(sauce.getType()).thenReturn(IngredientType.SAUCE);
        Mockito.when(sauce.getName()).thenReturn("Соус");
        Mockito.when(sauce.getPrice()).thenReturn(5.0f);
        burger.addIngredient(sauce);

        Mockito.when(filling.getType()).thenReturn(IngredientType.FILLING);
        Mockito.when(filling.getName()).thenReturn("Начинка");
        Mockito.when(filling.getPrice()).thenReturn(25.0f);
        burger.addIngredient(filling);

        String receipt = "(==== "+bun.getName()+" ====)\r\n= sauce "+sauce.getName()+" =\r\n= filling "+filling.getName()+" =\r\n(==== "+bun.getName()+" ====)\r\n\r\nPrice: "+String.format("%f", burger.getPrice())+"\r\n";
        assertEquals(receipt, burger.getReceipt());
    }
}
