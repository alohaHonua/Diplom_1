import org.junit.Test;
import praktikum.IngredientType;

import static org.junit.Assert.*;

public class IngredientTypeTest {
    @Test//Проверяем, что все типы ингредиентов существуют
    public void testIngredientTypeExists(){
        //Проверяем наличие всех типов
        assertNotNull(IngredientType.FILLING);
        assertNotNull(IngredientType.SAUCE);
    }

    @Test//Проверяем, что название типов совпадают с ожидаемыми значениями
    public void testIngredientTypeNames(){
        assertEquals("SAUCE", IngredientType.SAUCE.name());
        assertEquals("FILLING", IngredientType.FILLING.name());
    }
}

