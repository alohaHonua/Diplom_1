import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import praktikum.IngredientType;

@RunWith(Parameterized.class)
public class TypeIngredientTest {
    public enum IngredientTypeExpected {
        SAUCE,
        FILLING
    }
    private praktikum.IngredientType ingredientType;
    private int ordinal;

    public TypeIngredientTest(int ordinal, IngredientType ingredientType) {
        this.ordinal = ordinal;
        this.ingredientType = ingredientType;
    }

    @Parameterized.Parameters( name = "Номер IngredientType ({0}) , name ({1})")
    public static Object[][] setParams() {
        return new Object[][]{
                {0, praktikum.IngredientType.SAUCE},
                {1, praktikum.IngredientType.FILLING},
        };
    }

    @Test
    public void test(){
        Assert.assertEquals("IngredientType не совпадает"
                , IngredientTypeExpected.values()[ordinal].name()
                , ingredientType.name());

    }
}
