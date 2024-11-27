import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.mockito.Spy;
import org.mockito.junit.MockitoJUnitRunner;
import praktikum.Ingredient;
import praktikum.IngredientType;

import static org.junit.Assert.assertEquals;


@RunWith(MockitoJUnitRunner.class)
public class IngredientTest {
    @Spy
    Ingredient ingredient = new Ingredient(IngredientType.SAUCE, "hot sauce", 100);

    @Test
    public void checkGetPrice() {
        ingredient.getPrice();
        Mockito.verify(ingredient, Mockito.times(1)).getPrice();
        assertEquals(100, ingredient.getPrice(), 0);
    }

    @Test
    public void checkGetName() {
        ingredient.getName();
        Mockito.verify(ingredient, Mockito.times(1)).getName();
        assertEquals("hot sauce", ingredient.getName());
    }

    @Test
    public void checkGetType() {
        ingredient.getType();
        Mockito.verify(ingredient, Mockito.times(1)).getType();
        assertEquals(IngredientType.SAUCE, ingredient.getType());
    }
}

