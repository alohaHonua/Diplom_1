import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.assertEquals;

import praktikum.Ingredient;
import praktikum.IngredientType;

@RunWith(Parameterized.class)
public class IngredientParameterizedTest {

    private final IngredientType type;
    private final String name;
    private final float price;

    public IngredientParameterizedTest(IngredientType type, String name, float price) {
        this.type = type;
        this.name = name;
        this.price = price;
    }

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {IngredientType.SAUCE, "hot sauce", 100.0f},
                {IngredientType.SAUCE, "sour cream", 200.0f},
                {IngredientType.SAUCE, "chili sauce", 300.0f},
                {IngredientType.FILLING, "cutlet", 100.0f},
                {IngredientType.FILLING, "dinosaur", 200.0f},
                {IngredientType.FILLING, "sausage", 300.0f},
                {null, null, 0.0f},
                {IngredientType.SAUCE, "Русский", 1.05f},
                {IngredientType.FILLING, "!@#$%^&*()_+{}|:?><", Float.MIN_VALUE},
                {IngredientType.SAUCE, "    ", Float.MAX_VALUE}
        });
    }

    @Test
    public void ingredientGetTypeReturnsCorrectType() {
        Ingredient ingredient = new Ingredient(type, name, price);
        assertEquals(type, ingredient.getType());
    }

    @Test
    public void ingredientGetNameReturnsCorrectName() {
        Ingredient ingredient = new Ingredient(type, name, price);
        assertEquals(name, ingredient.getName());
    }

    @Test
    public void ingredientGetPriceReturnsCorrectPrice() {
        Ingredient ingredient = new Ingredient(type, name, price);
        assertEquals(price, ingredient.getPrice(), 0.0f);
    }
}
