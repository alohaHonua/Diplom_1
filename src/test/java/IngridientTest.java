import org.apache.commons.lang3.RandomStringUtils;
import org.junit.Test;

import praktikum.Ingredient;
import praktikum.IngredientType;

import static org.junit.Assert.assertEquals;


public class IngridientTest {

    Ingredient ingredient;
    private IngredientType type;

    @Test
    public void getSauceIngredient(){
        ingredient = new Ingredient(type.SAUCE, "hot sauce", 100);
        String request = "SAUCE";
        assertEquals(ingredient.getType().toString(), request);
    }
    @Test
    public void getFillingIngredient(){
        ingredient = new Ingredient(type.FILLING, "dinosaur", 200);
        String request = "FILLING";
        assertEquals(ingredient.getType().toString(), request);
    }
    @Test
    public void getNameIngredient(){
        String name = RandomStringUtils.randomAlphabetic(10);
        ingredient = new Ingredient(type.FILLING, name, 100);
        String request = name;
        assertEquals(ingredient.getName(), request);
    }

    @Test
    public void getPriceIngredient(){
        float price = 50f;
        ingredient = new Ingredient(type.FILLING, "dinosaur", price);
        float request = price;
        assertEquals(ingredient.getPrice(), request, 0.001);
    }

}
