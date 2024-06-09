package praktikum;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import static org.junit.Assert.assertEquals;
import static praktikum.IngredientType.FILLING;
import static praktikum.IngredientType.SAUCE;

@RunWith(Parameterized.class)
public class IngredientTypeParameterizedTest {
    private final IngredientType type;
    private final String name;
    public IngredientTypeParameterizedTest(IngredientType type, String name) {
        this.type = type;
        this.name = name;
    }

    @Parameterized.Parameters(name = " type  = {0} ")
    public static Object[][] getIngredientTypeData() {
        return new Object[][]{
                {SAUCE, "SAUCE"},
                {FILLING, "FILLING"}
        };
    }

    @Test
    public void checkIngredientTypeName() {
        assertEquals("Ошибка в типе ингридиента", name, type.name());
    }
}
