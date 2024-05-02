import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import praktikum.Ingredient;
import praktikum.IngredientType;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class IngredientParametrizedTest {

    private IngredientType type;
    private String name;
    private float price;

    public IngredientParametrizedTest(IngredientType type, String name, float price) {
        this.type = type;
        this.name = name;
        this.price = price;
    }

    

    @Test
    public void ingredientConstructorTest() {
        Ingredient ingredient = new Ingredient(IngredientType.SAUCE, "Chicken", 1.3f);
        assertEquals(1.3f, ingredient.getPrice(), 0.0f);
        assertEquals("Chicken", ingredient.getName());
    }

    @Test
    public void getPriceTest() {
        Ingredient ingredient = new Ingredient(IngredientType.SAUCE, "Chicken", 1.3f);
        assertEquals(1.3f, ingredient.getPrice(), 0.0f);
    }


    @Test
    public void getNameTest() {
        Ingredient ingredient = new Ingredient(IngredientType.FILLING, "Chicken", 1.3f);
        assertEquals("Chicken", ingredient.getName());

    }

    @Test
    public void getTypeTest() {
        Ingredient ingredient = new Ingredient(IngredientType.FILLING, "Chicken", 1.3f);
        assertEquals(IngredientType.FILLING, ingredient.getType());
    }

}

