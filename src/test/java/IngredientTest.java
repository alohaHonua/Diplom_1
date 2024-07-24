import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import praktikum.Ingredient;
import praktikum.IngredientType;

import static junit.framework.TestCase.assertEquals;

import static praktikum.IngredientType.FILLING;
import static praktikum.IngredientType.SAUCE;

@RunWith(Parameterized.class)
public class IngredientTest {

    private IngredientType ingredientType;
    private String name;
    private float price;

    public IngredientTest(IngredientType ingredientType, String name, float price) {
        this.ingredientType = ingredientType;
        this.name = name;
        this.price = price;
    }

    @Parameterized.Parameters
    public static Object[][] getTestData() {
        return new Object[][]{
                {FILLING, "Имя Ингредиента", 12.34f},
                {SAUCE, "Ingedient name", 1234f}
        };
    }

    @Test
    public void getPriceTest(){
        Ingredient ingredient = new Ingredient(ingredientType, name, price);
        assertEquals(price, ingredient.getPrice());
    }

    @Test
    public void getNameTest(){
        Ingredient ingredient = new Ingredient(ingredientType, name, price);
        assertEquals(name, ingredient.getName());
    }

    @Test
    public void getTypeTest(){
        Ingredient ingredient = new Ingredient(ingredientType, name, price);
        assertEquals(ingredientType, ingredient.getType());
    }
}
