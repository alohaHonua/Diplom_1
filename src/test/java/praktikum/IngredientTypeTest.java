package praktikum;

import org.junit.Test;
import static org.junit.Assert.*;

public class IngredientTypeTest {
    
    @Test
    public void testIngredientTypeValues() {
        IngredientType[] types = IngredientType.values();
        
        assertEquals("Должно быть 2 типа ингредиентов", 2, types.length);
        assertEquals("Первый тип должен быть SAUCE", IngredientType.SAUCE, types[0]);
        assertEquals("Второй тип должен быть FILLING", IngredientType.FILLING, types[1]);
    }
    
    @Test
    public void testIngredientTypeToString() {
        assertEquals("SAUCE должен преобразовываться в строку 'SAUCE'", "SAUCE", IngredientType.SAUCE.toString());
        assertEquals("FILLING должен преобразовываться в строку 'FILLING'", "FILLING", IngredientType.FILLING.toString());
    }
} 