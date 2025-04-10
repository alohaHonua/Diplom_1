package praktikum;

import org.junit.Test;
import static org.junit.Assert.*;


public class IngredientTypeTest {

    @Test
    public void ingredientTypeSauceValueTest() {
        assertEquals("Ожидаемый элемент - SAUCE", IngredientType.SAUCE, IngredientType.valueOf("SAUCE"));
    }

    @Test
    public void ingredientTypeFillingValueTest() {
        assertEquals("Ожидаемый элемент - FILLING", IngredientType.FILLING, IngredientType.valueOf("FILLING"));
    }

    @Test
    public void IngredientTypeEnumSizeTest(){
    assertEquals("Ожидаемое кол-во элементов - 2" ,2, IngredientType.values().length);
    }
}
