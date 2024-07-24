import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.Spy;
import org.mockito.junit.MockitoJUnitRunner;
import praktikum.Bun;
import praktikum.Burger;
import praktikum.Ingredient;

import static praktikum.IngredientType.FILLING;
import static praktikum.IngredientType.SAUCE;

@RunWith(MockitoJUnitRunner.class)
public class BurgerTest {


    private final String BunName = "Бриошь";
    private final float BunPrice = 1F;

    private final Ingredient Tomato = new Ingredient(FILLING, "Томат", 2F);
    private final Ingredient Cucumbers = new Ingredient(FILLING, "Огурцы", 3F);

    @Mock
    Bun bun;

    @Spy
    private Ingredient ingredient = new Ingredient(SAUCE,"Томат",2F);

    @Test
    public void getPriceBurgerTest() {
        Mockito.when(bun.getPrice()).thenReturn(2F);
        Burger burger = new Burger();
        burger.setBuns(bun);
        Assert.assertEquals(4F, burger.getPrice(), 0);
    }

    @Test
    public void getReceiptBurgerTest() {
        Mockito.when(bun.getName()).thenReturn(BunName);
        Mockito.when(bun.getPrice()).thenReturn(2F);
        Mockito.when(ingredient.getType()).thenReturn(FILLING);
        Mockito.when(ingredient.getName()).thenReturn("Персик");

        Burger burger = new Burger();
        burger.setBuns(bun);
        burger.addIngredient(ingredient);
        Assert.assertEquals("(==== Бриошь ====)\n" +
                "= filling Персик =\n" +
                "(==== Бриошь ====)\n" +
                "\n" +
                "Price: 6,000000\n", burger.getReceipt());
    }

    @Test
    public void removeIngredientTest() {
        Bun bun = new Bun(BunName, BunPrice);
        Burger burger = new Burger();
        burger.setBuns(bun);
        burger.addIngredient(Tomato);
        burger.addIngredient(Cucumbers);
        burger.removeIngredient(0);
        Assert.assertEquals("(==== Бриошь ====)\n" +
                "= filling Огурцы =\n" +
                "(==== Бриошь ====)\n" +
                "\n" +
                "Price: 5,000000\n", burger.getReceipt());
    }

    @Test
    public void moveIngredientTest() {
        Bun bun = new Bun(BunName, BunPrice);
        Burger burger = new Burger();
        burger.setBuns(bun);
        burger.addIngredient(Tomato);
        burger.addIngredient(Cucumbers);
        burger.moveIngredient(0, 1);
        Assert.assertEquals("(==== Бриошь ====)\n" +
                "= filling Огурцы =\n" +
                "= filling Томат =\n" +
                "(==== Бриошь ====)\n" +
                "\n" +
                "Price: 7,000000\n", burger.getReceipt());
    }
}
