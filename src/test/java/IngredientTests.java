import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import praktikum.Ingredient;
import praktikum.IngredientType;

import java.util.Arrays;
import java.util.Collection;
import java.util.concurrent.ThreadLocalRandom;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class IngredientTests {
    private final IngredientType ingredientType;
    private final String name;
    private final float price;


    public IngredientTests(IngredientType ingredientType, String name, float price) {
        this.ingredientType = ingredientType;
        this.name = name;
        this.price = price;
    }

    @Parameterized.Parameters
    public static Collection<Object[]> dataTests() {
        return Arrays.asList(new Object[][]{
                {IngredientType.FILLING, generateRandomString(99), generateRandomPrice()},
                {IngredientType.SAUCE, generateRandomString(99), generateRandomPrice()}
        });
    }

    private static String generateRandomString(int length) {
        String characters = "АБВГабвг";
        StringBuilder sb = new StringBuilder(length);
        ThreadLocalRandom random = ThreadLocalRandom.current();
        for (int i = 0; i < length; i++) {
            sb.append(characters.charAt(random.nextInt(characters.length())));
        }
        return sb.toString();
    }

    private static float generateRandomPrice() {
        return ThreadLocalRandom.current().nextFloat() * 50;
    }

    @Test
    public void testGetIngredientType() {
        Ingredient ingredient = new Ingredient(ingredientType, name, price);
        assertEquals(ingredientType, ingredient.getType());
    }

    @Test
    public void testGetName() {
        Ingredient ingredient = new Ingredient(ingredientType, name, price);
        assertEquals(name, ingredient.getName());
    }

    @Test
    public void testGetPrice() {
        Ingredient ingredient = new Ingredient(ingredientType, name, price);
        assertEquals(price, ingredient.getPrice(), 0.002);
    }
}
