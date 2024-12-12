import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import praktikum.Bun;
import praktikum.Burger;
import praktikum.Ingredient;

import static praktikum.IngredientType.FILLING;
import static praktikum.IngredientType.SAUCE;

@RunWith(MockitoJUnitRunner.class)
public class BurgerTest {

    private Burger burger;

    @Mock
    private Bun bun;

    @Mock
    private Ingredient ingredient1;

    @Mock
    private Ingredient ingredient2;

    @Mock
    private Ingredient ingredient3;

    @Before
    public void setUp() {
        burger = new Burger();
        Mockito.when(bun.getName()).thenReturn("Все на булочке с кунжутом");
        Mockito.when(bun.getPrice()).thenReturn(20.0F);

        Mockito.when(ingredient1.getType()).thenReturn(FILLING);
        Mockito.when(ingredient2.getType()).thenReturn(SAUCE);
        Mockito.when(ingredient3.getType()).thenReturn(FILLING);

        Mockito.when(ingredient1.getName()).thenReturn("Две мясных котлеты гриль");
        Mockito.when(ingredient2.getName()).thenReturn("Специальный соус сыр");
        Mockito.when(ingredient3.getName()).thenReturn("Оругцы, салат и лук");

        Mockito.when(ingredient1.getPrice()).thenReturn(50.0F);
        Mockito.when(ingredient2.getPrice()).thenReturn(25.0F);
        Mockito.when(ingredient3.getPrice()).thenReturn(40.0F);
    }

    @Test
    public void testSetBuns() {
        burger.setBuns(bun);
        Assert.assertEquals(bun, burger.bun);
    }

    @Test
    public void testAddIngredient() {
        burger.addIngredient(ingredient1);
        burger.addIngredient(ingredient2);
        burger.addIngredient(ingredient3);
        Assert.assertEquals(3, burger.ingredients.size());
    }

    @Test
    public void testRemoveIngredient() {
        burger.addIngredient(ingredient1);
        burger.addIngredient(ingredient2);
        burger.addIngredient(ingredient3);
        burger.removeIngredient(0);
        Assert.assertEquals(2, burger.ingredients.size());
    }

    @Test
    public void testMoveIngredient() {
        burger.addIngredient(ingredient1);
        burger.addIngredient(ingredient2);
        burger.addIngredient(ingredient3);
        burger.moveIngredient(0, 1);
        Assert.assertEquals(ingredient2, burger.ingredients.get(0));
    }

    @Test
    public void testGetPrice() {
        burger.setBuns(bun);
        burger.addIngredient(ingredient1);
        burger.addIngredient(ingredient2);
        burger.addIngredient(ingredient3);
        float expectedPrice = bun.getPrice() * 2;
        for (Ingredient ingredient : burger.ingredients) {
            expectedPrice += ingredient.getPrice();
        }
        Assert.assertEquals(expectedPrice, burger.getPrice(), 0.01);
    }

    @Test
    public void testGetReceipt() {
        burger.setBuns(bun);
        burger.addIngredient(ingredient1);
        burger.addIngredient(ingredient2);
        burger.addIngredient(ingredient3);
        String expectedReceipt = String.format("(==== %s ====)%n= %s %s =%n= %s %s =%n= %s %s =%n(==== %s ====)%n%nPrice: %f%n",
                bun.getName(), ingredient1.getType().toString().toLowerCase(), ingredient1.getName(),
                ingredient2.getType().toString().toLowerCase(), ingredient2.getName(),
                ingredient3.getType().toString().toLowerCase(), ingredient3.getName(),
                bun.getName(), burger.getPrice());

        Assert.assertEquals(expectedReceipt, burger.getReceipt());
    }
}