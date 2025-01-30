package praktikum;

import com.github.javafaker.Faker;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.Assert.*;
import static praktikum.IngredientType.SAUCE;

@RunWith(MockitoJUnitRunner.class)
public class BurgerTest {

    private Burger burger;
    private final Faker faker = new Faker();
    private final String bunName = faker.funnyName().name();
    private final String ingredientName = faker.funnyName().name();
    private final float bunPrice = (float) faker.random().nextDouble();
    private final float ingredientPrice = (float) faker.random().nextDouble();
    @Mock
    Bun bun;
    @Mock
    Ingredient ingredient;

    @Before
    public void setUp() {
        burger = new Burger();
    }

    @Test
    public void setBuns() {
        burger.setBuns(bun);
        assertEquals(bun, burger.bun);
    }

    @Test
    public void getPriceWithBun() {
        burger.setBuns(bun);
        Mockito.when(bun.getPrice()).thenReturn(bunPrice);
        Mockito.when(ingredient.getPrice()).thenReturn(ingredientPrice);
        burger.addIngredient(ingredient);
        assertEquals("Bun price was calculated incorrectly", 0, Float.compare(bunPrice * 2 + ingredientPrice,
                burger.getPrice()));

    }
    @Test
    public void getPriceWithoutBun() {
        burger.addIngredient(ingredient);
        assertThrows("Buns absence doesn't prevent from price calculating", NullPointerException.class,
                () -> Float.compare(bunPrice * 2 + ingredientPrice, burger.getPrice()));
    }
    @Test
    public void getReceipt() {
        burger.setBuns(bun);
        Mockito.when(bun.getName()).thenReturn(bunName);
        Mockito.when(ingredient.getType()).thenReturn(SAUCE);
        Mockito.when(ingredient.getName()).thenReturn(ingredientName);
        burger.addIngredient(ingredient);
        assertFalse("The receipt is empty", burger.getReceipt().isBlank());

    }
}
