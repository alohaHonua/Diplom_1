package praktikum;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class IngredientTypeTest {

    @Test
    public void valueOfSauceTypeReturnsSauceEnum() {
        IngredientType type = IngredientType.valueOf("SAUCE");
        assertEquals("Метод valueOf должен правильно создавать SAUCE", 
                   IngredientType.SAUCE, type);
    }

    @Test
    public void valueOfFillingTypeReturnsFillingEnum() {
        IngredientType type = IngredientType.valueOf("FILLING");
        assertEquals("Метод valueOf должен правильно создавать FILLING",
                   IngredientType.FILLING, type);
    }
    
    @Test
    public void valuesReturnsCorrectNumberOfElements() {
        IngredientType[] types = IngredientType.values();
        assertEquals("Enum должен содержать ровно 2 значения", 2, types.length);
    }
    
    @Test
    public void valuesContainsSauceType() {
        IngredientType[] types = IngredientType.values();
        boolean hasSauce = false;
        for (IngredientType type : types) {
            if (type == IngredientType.SAUCE) {
                hasSauce = true;
                break;
            }
        }
        assertTrue("Enum должен содержать SAUCE", hasSauce);
    }
    
    @Test
    public void valuesContainsFillingType() {
        IngredientType[] types = IngredientType.values();
        boolean hasFilling = false;
        for (IngredientType type : types) {
            if (type == IngredientType.FILLING) {
                hasFilling = true;
                break;
            }
        }
        assertTrue("Enum должен содержать FILLING", hasFilling);
    }

    @Test(expected = IllegalArgumentException.class)
    public void valueOfWithNonExistentValueThrowsException() {
        IngredientType.valueOf("NONEXISTENT_TYPE");
    }
    
    @Test(expected = NullPointerException.class)
    public void valueOfWithNullThrowsException() {
        IngredientType.valueOf(null);
    }
} 