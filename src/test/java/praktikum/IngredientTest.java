package praktikum;


import org.hamcrest.MatcherAssert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.hamcrest.CoreMatchers.notNullValue;
import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class IngredientTest {

    private final IngredientType type;
    private final String name;
    private final float price;

    public IngredientTest(IngredientType type, String name, float price) {
        this.type = type;
        this.name = name;
        this.price = price;
    }


    @Parameterized.Parameters
    public static Collection<Object[]> ingredientsData() {
        return Arrays.asList(new Object[][]{
                {IngredientType.SAUCE, "Tomato Sauce", 100},
                {IngredientType.FILLING, "cutlet", 100},
                {IngredientType.SAUCE, "chili sauce", 300},
                {IngredientType.FILLING, "dinosaur", 200}
        });
    }


    @Test
    public void ingredientConstructorCheck() {
        Ingredient ingredient = new Ingredient(type, name, price);
        MatcherAssert.assertThat(ingredient, notNullValue());
    }

    @Test
    public void getIngredientTypeCheck() {
        Ingredient ingredient = new Ingredient(type, name, price);
        assertEquals(type, ingredient.getType());
    }

    @Test
    public void getIngredientNameCheck() {
        Ingredient ingredient = new Ingredient(type, name, price);
        assertEquals(name, ingredient.getName());
    }

    @Test
    public void getIngredientPriceCheck() {
        Ingredient ingredient = new Ingredient(type, name, price);
        assertEquals(price, ingredient.getPrice(), 0);
    }


}
