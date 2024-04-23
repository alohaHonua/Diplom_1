import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import praktikum.Ingredient;

import static org.junit.Assert.assertEquals;

@RunWith(MockitoJUnitRunner.class)
public class IngredientTest {

    @Mock
    private Ingredient ingredient;

    private String name;
    private float price;

    @Test
    public void getPriceTest() {
        assertEquals(price, ingredient.getPrice(), 0.0);
    }

    @Test
    public void getNameTest() {
        assertEquals(name, ingredient.getName());
    }

}
