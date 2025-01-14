import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import praktikum.IngredientType;
import static praktikum.IngredientType.FILLING;
import static praktikum.IngredientType.SAUCE;


@RunWith(Parameterized.class)
public class IngredientTypeTest {

    final private IngredientType ingredient;
    final private String result;

    public IngredientTypeTest(IngredientType ingredient, String result) {
        this.ingredient = ingredient;
        this.result = result;
    }

    @Parameterized.Parameters (name = "Тестовые данные: {0}, Pезультат: {1}")
    public static Object[][] type() {
        return new Object[][]{
                {SAUCE, "SAUCE"},
                {FILLING, "FILLING"},
        };
    }

    @Test
    public void valueOfTypeTest() {
        Assert.assertEquals(ingredient, IngredientType.valueOf(result));
    }
}



