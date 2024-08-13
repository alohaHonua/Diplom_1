package testingredient;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import praktikum.Ingredient;
import praktikum.IngredientType;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

@RunWith(Parameterized.class)
public class TestIngredient {
    private final IngredientType type;
    private final String name;
    private final float price;

    public TestIngredient(IngredientType type, String name, float price){
        this.type = type;
        this.name = name;
        this.price = price;
    }

    @Parameterized.Parameters
    public static Object[][] ingredientVariants(){
        return new Object[][]{
                {IngredientType.SAUCE, "hot sauce", 100},
                {IngredientType.SAUCE, "sour cream", 200},
                {IngredientType.SAUCE, "chili sauce", 300},
                {IngredientType.FILLING, "cutlet", 100},
                {IngredientType.FILLING, "dinosaur", 200},
                {IngredientType.FILLING, "sausage", 300}
        };
    }

    @Test
    public void ingredientGetPriceTest(){
        Ingredient ingredient = new Ingredient(type, name, price);
        assertThat(ingredient.getPrice(), is(price));

    }

    @Test
    public void ingredientGetNameTest(){
        Ingredient ingredient = new Ingredient(type, name, price);
        assertThat(ingredient.getName(), is(name));

    }

    @Test
    public void ingredientGetTypeTest(){
        Ingredient ingredient = new Ingredient(type, name, price);
        assertThat(ingredient.getType(), is(type));

    }

}
