import org.junit.Assert;
import org.junit.Test;
import praktikum.IngredientType;

import static org.junit.Assert.assertEquals;

public class IngredientTypeTest {

    @Test
    public void ingredientTypeSuccess() {
        Assert.assertEquals(IngredientType.SAUCE, IngredientType.valueOf("SAUCE"));
    }
}
