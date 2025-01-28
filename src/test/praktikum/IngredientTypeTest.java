package praktikum;

import org.junit.Test;
import org.junit.Assert;
import java.util.List;
import java.util.ArrayList;

public class IngredientTypeTest {

    @Test
    public void checkIngredientType() {
        List<String> expectedType = new ArrayList<>();
        for (IngredientType type : IngredientType.values()) {
            expectedType.add(type.name());
        }
        List<String> actualType = new ArrayList<>();
        actualType.add("SAUCE");
        actualType.add("FILLING");
        Assert.assertEquals(expectedType, actualType);
    }
}
