import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import praktikum.IngredientType;

@RunWith(Parameterized.class)

public class IngredientParametrizedTypeTest {
    private final String name;
    private final IngredientType ingredientType;

    public IngredientParametrizedTypeTest(String name, IngredientType ingredientType) {
        this.name = name;
        this.ingredientType = ingredientType;
    }

    @Parameterized.Parameters
    public static Object [] [] getInfo () {
        return new Object[][] {
                {"SAUCE", IngredientType.SAUCE},
                {"FILLING", IngredientType.FILLING}
        };
    }

    @Test
    public void getTypeName() {
        Assert.assertEquals(name, ingredientType.name());
    }


}
