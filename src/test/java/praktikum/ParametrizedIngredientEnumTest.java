package praktikum;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import static org.junit.Assert.assertEquals;
import static praktikum.IngredientType.FILLING;
import static praktikum.IngredientType.SAUCE;


@RunWith(Parameterized.class)
public class ParametrizedIngredientEnumTest {
    private final IngredientType expectedIngredientType;


    public ParametrizedIngredientEnumTest(IngredientType expectedIngredientType) {
        this.expectedIngredientType = expectedIngredientType;
    }


    @Parameterized.Parameters()
    public static Object[][] switchBetweenEnumParams() {
        return new Object[][]{
                {SAUCE},
                {FILLING}
        };
    }

    @Test
    public void IngredientTypeTest(){
        Ingredient ingredient = new Ingredient(expectedIngredientType,"someIngredient", 100F);
        assertEquals(expectedIngredientType,ingredient.getType());
    }
}