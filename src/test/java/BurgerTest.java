import org.hamcrest.CoreMatchers;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import praktikum.*;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class BurgerTest {
    private List<Bun> bunList;
    private List<Ingredient> ingrediantlist;

    @Before
    public void setUo() {
        Database mockDatabase = mock(Database.class);

        bunList = new ArrayList<>();

        bunList.add(new Bun("fluorescent", 500));
        bunList.add(new Bun("crater", 1000));
        bunList.add(new Bun("custom", 1515));


        ingrediantlist = new ArrayList<>();

        ingrediantlist.add(new Ingredient(IngredientType.SAUCE, "Spicy-X", 90));
        ingrediantlist.add(new Ingredient(IngredientType.SAUCE, "Space Sauce", 80));
        ingrediantlist.add(new Ingredient(IngredientType.FILLING, "Protostomia", 1400));
        ingrediantlist.add(new Ingredient(IngredientType.FILLING, "Cheese", 4200));

        when(mockDatabase.availableBuns()).thenReturn(bunList);
        when(mockDatabase.availableIngredients()).thenReturn(ingrediantlist);
    }

    @Test
    public void getPriceTest() {
        Burger burger = new Burger();

        burger.setBuns(bunList.get(0));
        burger.addIngredient(ingrediantlist.get(0));
        burger.addIngredient(ingrediantlist.get(1));
        burger.addIngredient(ingrediantlist.get(2));
        burger.addIngredient(ingrediantlist.get(3));
        burger.moveIngredient(3, 2);
        burger.removeIngredient(1);

        assertEquals(6690, burger.getPrice(), 0.1F);
    }

    @Test
    public void getReceiptTest() {
        Burger burger = new Burger();
        burger.setBuns(bunList.get(1));
        burger.addIngredient(ingrediantlist.get(1));
        burger.addIngredient(ingrediantlist.get(2));

        String actual = burger.getReceipt();
        Assert.assertThat(actual, CoreMatchers.containsString("(==== crater ====)\n" +
                "= sauce Space Sauce =\n" +
                "= filling Protostomia =\n" +
                "(==== crater ====)"));
        assertEquals(3480, burger.getPrice(), 0.1F);
    }
}
