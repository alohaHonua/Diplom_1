import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import praktikum.Ingredient;
import praktikum.IngredientType;

import static org.junit.Assert.assertEquals;
import static praktikum.Const.*;
import static praktikum.IngredientType.*;

@RunWith(Parameterized.class)
public class IngredientTests {

    public IngredientType type;
    public String name;
    public float price;

    public IngredientTests(IngredientType type, String name, float price) {
        this.type = type;
        this.name = name;
        this.price = price;
    }

    @Parameterized.Parameters
    public static Object[][] getType() {
        return new Object[][] {
                {SAUCE, FIRST_INGREDIENT_NAME, FIRST_INGREDIENT_PRICE},
                {FILLING, SECOND_INGREDIENT_NAME, SECOND_INGREDIENT_PRICE},
        };
    }

    @Test
    public void ingredientGetPrice(){
        Ingredient ingredient = new Ingredient(type, name, price);
        assertEquals(price, ingredient.getPrice(), DELTA);
    }

    @Test
    public void ingredientGetName(){
        Ingredient ingredient = new Ingredient(type, name, price);
        assertEquals(name, ingredient.getName());
    }

    @Test
    public void ingredientGetType(){
        Ingredient ingredient = new Ingredient(type, name, price);
        assertEquals(type, ingredient.getType());
    }
}
