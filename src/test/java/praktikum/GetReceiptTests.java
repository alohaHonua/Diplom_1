package praktikum;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

@RunWith(Parameterized.class)
public class GetReceiptTests {
    private Burger newBurger;
    private final Bun bun;
    private final Ingredient[] ingredients;
    private final String receipt;

    public GetReceiptTests(Bun bun, Ingredient[] ingredients, String receipt) {
        this.bun = bun;
        this.ingredients = ingredients;
        this.receipt = String.format(receipt);
    }

    @Before
    public void createBurger() {
        newBurger = new Burger();
    }

    @Parameterized.Parameters
    public static Object[][] receipt() {
        Ingredient[] oneIngredient = new Ingredient[]{new Ingredient(IngredientType.FILLING, "dinosaur", 200f)};
        Ingredient[] twoIngredients = new Ingredient[]{new Ingredient(IngredientType.SAUCE, "sour cream", 200f), new Ingredient(IngredientType.FILLING, "cutlet", 100f)};
        return new Object[][]{
                {new Bun("black bun", 100f), oneIngredient, "(==== black bun ====)%n= filling dinosaur =%n(==== black bun ====)%n%nPrice: 400,000000%n"},
                {new Bun("white bun", 200f), twoIngredients, "(==== white bun ====)%n= sauce sour cream =%n= filling cutlet =%n(==== white bun ====)%n%nPrice: 700,000000%n"},
                {new Bun("red bun", 300f), null, "(==== red bun ====)%n(==== red bun ====)%n%nPrice: 600,000000%n"},
        };
    }

    @Test
    public void getReceiptTest() {
        newBurger.setBuns(bun);
        if (ingredients != null) {
            for (Ingredient ingredient : ingredients) {
                newBurger.addIngredient(ingredient);
            }
        }
        String result = newBurger.getReceipt();
        Assert.assertEquals(receipt, result);
    }
}
