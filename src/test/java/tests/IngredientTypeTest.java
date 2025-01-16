package tests;

import org.junit.Test;
import praktikum.IngredientType;
import static org.junit.Assert.*;

public class IngredientTypeTest {

    @Test
    public void checkAllIngredientTypesTest(){

        String[] expectedValues = {"SAUCE", "FILLING"};

        String[] actualValues = new String[IngredientType.values().length];
        for (int i = 0; i < IngredientType.values().length; i++) {
            actualValues[i] = IngredientType.values()[i].name();
        }

        assertArrayEquals(expectedValues, actualValues);
    }
}
