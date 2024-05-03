package praktikum;

import org.junit.Assert;
import org.junit.Test;

public class IngredientTypeTest {

    @Test
    public void testSauceIngredientType() {
        IngredientType sauce = IngredientType.SAUCE;
        Assert.assertEquals("Получено имя != SAUCE","SAUCE", sauce.name());
    }

    @Test
    public void testFillingIngredientType() {
        IngredientType filling = IngredientType.FILLING;
        Assert.assertEquals("Получено имя != FILLING","FILLING", filling.name());
    }

    @Test
    public void testIngredientTypeEquality() {
        IngredientType sauce1 = IngredientType.SAUCE;
        IngredientType sauce2 = IngredientType.SAUCE;
        Assert.assertSame("Значения sauce не равны",sauce1, sauce2);
    }

    @Test
    public void testIngredientTypeInequality() {
        IngredientType sauce = IngredientType.SAUCE;
        IngredientType filling = IngredientType.FILLING;
        Assert.assertNotSame("Значения sauce и filling равны",sauce, filling);
    }
}