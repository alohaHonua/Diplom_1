package praktikum;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class IngredientTest {

    private final IngredientType ingredientType;
    private final String name;
    private final float price;

    public IngredientTest(IngredientType ingredientType, String name, float price) {
        this.ingredientType = ingredientType;
        this.name = name;
        this.price = price;
    }
        @Parameterized.Parameters
        public static Object[][] createIngredient() {
            return new Object[][]{
                    {IngredientType.SAUCE, "cutlet", 100},
                    {IngredientType.SAUCE, "sour cream", 200},
                    {IngredientType.SAUCE, "chili sauce", 300},
                    {IngredientType.FILLING, "hot sauce", 100},
                    {IngredientType.FILLING, "dinosaur", 200},
                    {IngredientType.FILLING, "sausage", 300}
            };
        }

    @Test
    public void getPriceTest(){
        Ingredient ingredient = new Ingredient(ingredientType, name, price);
        float actualPrice = ingredient.getPrice();

        assertEquals(price, actualPrice, 0);
        }

    @Test
    public void getNameTest(){
        Ingredient ingredient = new Ingredient(ingredientType, name, price);
        String actualName = ingredient.getName();

        assertEquals(name, actualName);
    }

    @Test
    public void getTypeTest(){
        Ingredient ingredient = new Ingredient(ingredientType, name, price);
        IngredientType actualType = ingredient.getType();

        assertEquals(ingredientType, actualType);
    }
}
