import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import praktikum.Ingredient;
import praktikum.IngredientType;

import static praktikum.IngredientType.FILLING;
import static praktikum.IngredientType.SAUCE;

@RunWith(Parameterized.class)
public class IngredientParamTest {

    public IngredientType type;
    public String name;

    public IngredientParamTest(IngredientType type) {
        this.type = type;
    }

    @Parameterized.Parameters
    public static Object[][] data() {
        return new Object[][]{
                {SAUCE},
                {FILLING},
        }; // тестовые данные для
    }
    @Test
    public void testIngredientType(){

        Ingredient ingredient = new Ingredient(type,"Лук", 200.00f);
        Assert.assertEquals(type ,ingredient.getType());

    }
}

