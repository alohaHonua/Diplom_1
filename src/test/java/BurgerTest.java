import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import praktikum.Bun;
import praktikum.Burger;
import praktikum.Database;
import praktikum.Ingredient;

import java.util.List;

import static org.junit.Assert.*;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class BurgerTest {
    private static final float DELTA = 0.001f;
    private Burger burger;

    private Database db;

    @Mock
    private Bun bun;

    @Before
    public void setUp() {
        burger = new Burger();
        db = new Database();
    }

    @Test
    public void setBunsTest() {
        burger.setBuns(bun);

        assertSame(bun, burger.bun);
    }

    @Test
    public void addIngredientTest() {
        Ingredient ingredient = db.availableIngredients().get(0);
        burger.addIngredient(ingredient);

        assertEquals("Должен быть 1 ингредиент", 1, burger.ingredients.size());
        assertSame("Список должен содержать добавленный ингредиент: ", ingredient, burger.ingredients.get(0));
    }

    @Test
    public void removeIngredientTest() {
        Ingredient ingredient = db.availableIngredients().get(1);
        burger.addIngredient(ingredient);
        burger.removeIngredient(0);

        assertTrue("Список ингредиентов пуст", burger.ingredients.isEmpty());
    }

    @Test (expected = IndexOutOfBoundsException.class)
    public void removeIngredientWithInvalidIndexTest() {
        burger.removeIngredient(0);

    }

    @Test
    public void addAllSaucesTest() {
        List<Ingredient> sauces = db.availableIngredients().subList(0, 3);
        for (Ingredient sauce : sauces) {
            burger.addIngredient(sauce);
        }
        assertEquals(3, burger.ingredients.size());
    }

    @Test
    public void addAllFillingsTest() {
        List<Ingredient> fillings = db.availableIngredients().subList(3, 6);
        for (Ingredient filling : fillings) {
            burger.addIngredient(filling);
        }
        assertEquals(3, burger.ingredients.size());
    }

    @Test
    public void moveIngredientTest() {
        List<Ingredient> ingredients = db.availableIngredients().subList(0, 2);

        burger.addIngredient(ingredients.get(0));
        burger.addIngredient(ingredients.get(1));

        burger.moveIngredient(0, 1);

        assertSame("Первый элемент должен измениться",
                ingredients.get(1), burger.ingredients.get(0));
        assertSame("Второй элемент должен измениться",
                ingredients.get(0), burger.ingredients.get(1));
    }

    @Test
    public void getPriceForBunAndAllIngredientsTest() {

        when(bun.getPrice()).thenReturn(db.availableBuns().get(0).getPrice());

        burger.setBuns(bun);

        float expectedPrice = bun.getPrice() * 2;
        for (Ingredient ingredient : db.availableIngredients()) {
            burger.addIngredient(ingredient);
            expectedPrice += ingredient.getPrice();
        }
        assertEquals(expectedPrice, burger.getPrice(), DELTA);
    }

    @Test
    public void getReceiptWithAllIngredientsTest() {

        when(bun.getName()).thenReturn(db.availableBuns().get(1).getName());
        when(bun.getPrice()).thenReturn(db.availableBuns().get(1).getPrice());
        burger.setBuns(bun);

        for (Ingredient ingredient : db.availableIngredients()) {
            burger.addIngredient(ingredient);
        }

        StringBuilder expected = new StringBuilder();
        expected.append(String.format("(==== %s ====)%n", bun.getName()));

        for (Ingredient ingredient : db.availableIngredients()) {
            expected.append(String.format("= %s %s =%n", ingredient.getType().toString().toLowerCase(), ingredient.getName()));
        }

        expected.append(String.format("(==== %s ====)%n", bun.getName()));
        expected.append(String.format("%nPrice: %f%n", burger.getPrice()));

        assertEquals(expected.toString(), burger.getReceipt());
    }

    @Test
    public void getReceiptWithOneSauceAndOneFillingTest() {
        when(bun.getName()).thenReturn(db.availableBuns().get(2).getName());
        when(bun.getPrice()).thenReturn(db.availableBuns().get(2).getPrice());
        burger.setBuns(bun);

        Ingredient sauce = db.availableIngredients().get(0);
        Ingredient filling = db.availableIngredients().get(3);
        burger.addIngredient(sauce);
        burger.addIngredient(filling);

        String expected = String.format("(==== %s ====)%n", bun.getName()) +
                String.format("= %s %s =%n", sauce.getType().toString().toLowerCase(), sauce.getName()) +
                String.format("= %s %s =%n", filling.getType().toString().toLowerCase(), filling.getName()) +
                String.format("(==== %s ====)%n", bun.getName()) +
                String.format("%nPrice: %f%n", burger.getPrice());

        assertEquals(expected, burger.getReceipt());
    }
}