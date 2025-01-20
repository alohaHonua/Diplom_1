import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import praktikum.Ingredient;
import praktikum.IngredientType;

@RunWith(Parameterized.class)

public class IngredientParametrizedTest {
    private final IngredientType ingredientType;
    private final String name;
    private final float price;

    public IngredientParametrizedTest(IngredientType ingredientType, String name, float price) {
        this.ingredientType = ingredientType;
        this.name = name;
        this.price = price;
    }

    @Parameterized.Parameters
    public static Object [] [] getIngredient() {
        return new Object [] [] {
                {IngredientType.SAUCE, "hot sauce", 100 },
                {IngredientType.FILLING, "cutlet", 100}
        };
    }

    @Test
    public void getIngredientType () {
        Ingredient ingredient = new Ingredient(ingredientType, name, price);
        IngredientType actualIngredientType = ingredient.getType();
        Assert.assertEquals(ingredientType, actualIngredientType);
    }

}
