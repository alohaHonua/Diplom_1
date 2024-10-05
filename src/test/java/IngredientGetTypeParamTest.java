import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import praktikum.Ingredient;
import praktikum.IngredientType;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class IngredientGetTypeParamTest {
    public IngredientType type;
    public String name;
    public float price;
    public IngredientType expectedType;

    public IngredientGetTypeParamTest(IngredientType type, String name, float price, IngredientType expectedType) {
        this.type = type;
        this.name = name;
        this.price = price;
        this.expectedType = expectedType;
    }

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {IngredientType.SAUCE, "sauce", 1.5f, IngredientType.SAUCE},
                {IngredientType.FILLING, "filling", 0.5f, IngredientType.FILLING}
        });
    }
      @Test
    public void GetIngredientTypeTest(){
        Ingredient ingredient = new Ingredient(type,name,price);
          assertEquals(expectedType,ingredient.getType());
      }
}
