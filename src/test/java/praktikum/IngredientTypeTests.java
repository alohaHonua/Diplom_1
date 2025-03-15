package praktikum;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import static praktikum.IngredientType.FILLING;
import static praktikum.IngredientType.SAUCE;

@RunWith(Parameterized.class)
public class IngredientTypeTests {
    private final IngredientType type;

    public IngredientTypeTests(IngredientType type) {
        this.type = type;
    }

    @Parameterized.Parameters
    public static Object[][] getType() {
        return new Object[][]{
                {SAUCE},
                {FILLING},
        };
    }

    @Test
    public void checkIngredientGetType() {
        Ingredient ingredient = new Ingredient(type,"Name", 45F);
        Assert.assertEquals(type, ingredient.getType());
    }

}