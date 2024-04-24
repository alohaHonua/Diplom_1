import org.junit.Test;
import praktikum.IngredientType;

import static org.junit.Assert.assertNotNull;

public class IngredientTypeTest {

    @Test
    public void fillingNotNull() {
        assertNotNull("Не выбрана начинка", IngredientType.valueOf("FILLING"));
    }

    @Test
    public void sauceNotNull() {
        assertNotNull("Не выбран соус", IngredientType.valueOf("SAUCE"));
    }
}
