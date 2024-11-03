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
    private final int index;

    public IngredientTypeTest(String name,IngredientType type, int index) {
        this.name = name;
        this.type = type;
        this.index = index;
    }

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][] {
                {"SAUCE",IngredientType.SAUCE, 0},
                {"FILLING",IngredientType.FILLING, 1},
        });
    }

    @Test
    public void enumNameTest() {
        Assert.assertEquals(name, type.name());
    }

    @Test
    public void enumOrdinalTest() {
        Assert.assertEquals(index, type.ordinal());
    }
}
