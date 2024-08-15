import org.junit.Test;
import praktikum.IngredientType;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class IngredientTypeTest {

    @Test
    public void testSauceType() {
        // ���������, ��� ��� SAUCE ����� ���������� ��������
        IngredientType expectedType = IngredientType.SAUCE;
        assertEquals(expectedType, IngredientType.valueOf("SAUCE"));
    }

    @Test
    public void testFillingType() {
        // ���������, ��� ��� FILLING ����� ���������� ��������
        IngredientType expectedType = IngredientType.FILLING;
        assertEquals(expectedType, IngredientType.valueOf("FILLING"));
    }

    @Test
    public void testNumberOfTypes() {
        // ���������, ��� � ������������ IngredientType ����� 2 ��������
        int expectedNumberOfTypes = 2;
        assertEquals(expectedNumberOfTypes, IngredientType.values().length);
    }

    @Test
    public void testContainsSauce() {
        // ���������, ��� ������������ �������� ��� SAUCE
        boolean containsSauce = false;
        for (IngredientType type : IngredientType.values()) {
            if (type == IngredientType.SAUCE) {
                containsSauce = true;
                break;
            }
        }
        assertTrue(containsSauce);
    }

    @Test
    public void testContainsFilling() {
        // ���������, ��� ������������ �������� ��� FILLING
        boolean containsFilling = false;
        for (IngredientType type : IngredientType.values()) {
            if (type == IngredientType.FILLING) {
                containsFilling = true;
                break;
            }
        }
        assertTrue(containsFilling);
    }
}
