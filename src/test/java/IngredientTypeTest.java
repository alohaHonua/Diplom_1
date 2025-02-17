import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import praktikum.IngredientType;

import java.util.Arrays;
import java.util.Collection;

@RunWith(Parameterized.class)
public class IngredientTypeTest {

    private final String name;
    private final IngredientType type;

    public IngredientTypeTest(String name, IngredientType type) {
        this.name = name;
        this.type = type;
    }

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {"SAUCE", IngredientType.SAUCE},
                {"FILLING", IngredientType.FILLING}
        });
    }

    @Test
    public void getTypeTest() {
        Assert.assertEquals(name, type.name());
    }
}
