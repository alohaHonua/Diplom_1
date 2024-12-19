package praktikum;

import org.apache.commons.lang3.RandomStringUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class IngredientTest {

    private final IngredientType type;
    private final String nameIngr;
    private final float priceIngr;

    public IngredientTest(IngredientType type, String nameIngr, float priceIngr) {
        this.type = type;
        this.nameIngr = nameIngr;
        this.priceIngr = priceIngr;
        System.out.println(type + ",  " + nameIngr + ",  " + priceIngr);  // Логируем тестовые данные

    }

    @Parameterized.Parameters(name = "IngredientType: {0}, Name: {1}, Price: {2}")
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {IngredientType.SAUCE, "SauceTest_" + RandomStringUtils.randomAlphabetic(4), generateRandomPrice()},
                {IngredientType.FILLING, "FillingTest_" + RandomStringUtils.randomAlphabetic(4), generateRandomPrice()}
        });
    }

    private static float generateRandomPrice() {
        float price = (float) (Math.random() * 300);
        return Math.round(price * 100) / 100.0f; // Округление до сотых
    }

    @Test
    public void testIngredientGetName() {
        Ingredient ingredient = new Ingredient(type, nameIngr, priceIngr);
        assertEquals("Ingredient name should match", nameIngr, ingredient.getName());
    }

    @Test
    public void testIngredientGetPrice() {
        Ingredient ingredient = new Ingredient(type, nameIngr, priceIngr);
        assertEquals("Ingredient price should match", priceIngr, ingredient.getPrice(), 0.01f);
    }

    @Test
    public void testIngredientGetType() {
        Ingredient ingredient = new Ingredient(type, nameIngr, priceIngr);
        assertEquals("Ingredient type should match", type, ingredient.getType());
    }
}
