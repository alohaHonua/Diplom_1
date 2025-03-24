package praktikum;


import org.junit.Test;


import static org.junit.Assert.assertEquals;
import static praktikum.IngredientType.SAUCE;


public class IngredientTest {
    @Test
    public void getPriceTest(){
        Ingredient ingredient = new Ingredient(SAUCE, "Майонез", 50);
        assertEquals(50, ingredient.getPrice(), 0.1);
    }

    @Test
    public void getNameTest(){
        Ingredient ingredient = new Ingredient(SAUCE, "Майонез", 50);
        assertEquals("Майонез", ingredient.getName());
    }

    @Test
    public void getTypeTest(){
        Ingredient ingredient = new Ingredient(SAUCE, "Майонез", 50);
        assertEquals(SAUCE, ingredient.getType());
    }
}
