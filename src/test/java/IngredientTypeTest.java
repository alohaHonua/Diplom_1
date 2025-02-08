import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import praktikum.IngredientType;

import static org.junit.Assert.assertEquals;


@RunWith(Parameterized.class)
public class IngredientTypeTest {
    private final IngredientType type;
    private final String name;

    public IngredientTypeTest(IngredientType type, String name) {
        this.type = type;
        this.name = name;
    }

    @Parameterized.Parameters(name = "Тип ингредиента: {0}: {1}")
    public static Object[][] getIngredientTypeData() {
        return new Object[][] {
                {IngredientType.SAUCE, "SAUCE"},
                {IngredientType.FILLING, "FILLING"}
        };
    }

    @Test
    public void getIngredientTypeNameTest() {
        assertEquals("Неправильное название типа ингредиента", name, type.name());
    }
}