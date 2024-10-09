import org.junit.Before;
import org.junit.Test;
import praktikum.Ingredient;
import praktikum.IngredientType;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class IngredientUnitTest {
    private Ingredient ingredient;

    @Before
    public void setUp(){
        ingredient = new Ingredient(IngredientType.FILLING, "sausage", 300f);
    }

    @Test
public void doesIngredientBeingInitialized(){
        assertNotNull(ingredient);
    }

    @Test
    public void doesGetTypeReturnsCorrectValue(){
        assertEquals(IngredientType.FILLING, ingredient.getType());
    }

    @Test
    public void doesGetNameReturnsCorrectValue(){
        assertEquals("sausage", ingredient.getName());
    }

    @Test
    public void doesGetPriceReturnsCorrectValue(){
        assertEquals(300f, ingredient.getPrice(), 0.001);
    }
}
