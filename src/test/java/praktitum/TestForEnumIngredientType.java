package praktitum;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import praktikum.IngredientType;

import static org.junit.Assert.assertEquals;

//public class TestForEnumIngredientType {

//    @Test
//    public void testSauce() {
//        assertEquals("SAUCE", IngredientType.SAUCE.name());
//    }

//    @Test
//    public void testFilling() {
//        assertEquals("FILLING", IngredientType.FILLING.name());
//    }
//}


@RunWith(Parameterized.class)
public class TestForEnumIngredientType {

    private IngredientType ingredientType;
    private String expectedIngredientTypeName;

    public TestForEnumIngredientType(String expectedIngredientTypeName, IngredientType ingredientType) {
        this.ingredientType = ingredientType;
        this.expectedIngredientTypeName = expectedIngredientTypeName;
    }

    @Parameterized.Parameters
    public static Object[][] ingredientTypeParameters() {
        return new Object[][]{
                {"SAUCE", IngredientType.SAUCE},
                {"FILLING", IngredientType.FILLING}
        };
    }

    @Test
    public void testIngredientTypeName() {
//        assertEquals(expectedIngredientTypeName, ingredientType.name());
        assertEquals(IngredientType.valueOf(expectedIngredientTypeName), ingredientType);
    }
}