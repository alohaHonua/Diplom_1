package praktikum;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Spy;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.Assert.assertEquals;

@RunWith(MockitoJUnitRunner.class)
public class IngredientTest {

    @Spy
    IIngredient ingredient = new Ingredient(IngredientType.SAUCE, "NAME", 100.0f);

    @Test
    public void getPriceTest() {
        float actualPrice = ingredient.getPrice();
        float exceptedPrice = 100.0f;

        assertEquals(exceptedPrice, actualPrice, 0);
    }

    @Test
    public void getNameTest() {
        String actualName = ingredient.getName();
        String exceptedName = "NAME";

        assertEquals(exceptedName, actualName);
    }

}
