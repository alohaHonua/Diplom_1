import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import praktikum.Ingredient;
import praktikum.IngredientType;


@RunWith(Parameterized.class)
public class IngredientTest {
    IngredientType expectedIngredientType;
    public IngredientTest(IngredientType expectedIngredientType){
        this.expectedIngredientType = expectedIngredientType;
    }
    @Parameterized.Parameters
    public static Object[][] getIngredient(){
        return new Object[][] {
                {IngredientType.valueOf("SAUCE")},
                {IngredientType.valueOf("FILLING")},
        };
    }
    @Test
    public void ingredientGetTypeMethodTest(){
        Assert.assertEquals(expectedIngredientType, new Ingredient(expectedIngredientType, "Булка", 20F).getType());
    }
    @Test
    public void ingredientGetPriceMethodTest(){
        Assert.assertEquals(20F, new Ingredient(expectedIngredientType, "Булка", 20F).getPrice(), 0);
    }
    @Test
    public void ingredientGetNameMethodTest(){
        Assert.assertEquals("Булка", new Ingredient(expectedIngredientType, "Булка", 20F).getName());
    }
}
