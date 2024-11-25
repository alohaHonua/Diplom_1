package praktikum;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.Collection;
import java.util.EnumSet;

import static org.junit.Assert.*;

@RunWith(Parameterized.class)
public class IngredientTypeTest {

    private IngredientType ingredientType;
    private String ingredientTypeName;

    // Параметризованный конструктор
    public IngredientTypeTest(IngredientType ingredientType, String ingredientTypeName) {
        this.ingredientType = ingredientType;
        this.ingredientTypeName = ingredientTypeName;
    }

    // Данные для параметризации
    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][] {
                { IngredientType.SAUCE, "SAUCE" },
                { IngredientType.FILLING, "FILLING" }
        });
    }

    // Проверка метода valueOf()
    @Test
    public void testValueOf() {
        assertEquals(ingredientType, IngredientType.valueOf(ingredientTypeName));
    }

    // Проверка метода name()
    @Test
    public void testName() {
        assertEquals(ingredientTypeName, ingredientType.name());
    }

    // Проверка метода toString()
    @Test
    public void testToString() {
        assertEquals(ingredientTypeName, ingredientType.toString());
    }

    // Проверка всех значений перечисления
    @Test
    public void testEnumValues() {
        IngredientType[] types = IngredientType.values();
        assertEquals(2, types.length); // Должно быть два значения
        assertTrue(EnumSet.allOf(IngredientType.class).contains(IngredientType.SAUCE));
        assertTrue(EnumSet.allOf(IngredientType.class).contains(IngredientType.FILLING));
    }

    // Проверка, что выбрасывается исключение для несуществующего значения
    @Test(expected = IllegalArgumentException.class)
    public void testInvalidEnumValue() {
        IngredientType.valueOf("INVALID");
    }

    // Проверка равенства и неравенства элементов перечисления
    @Test
    public void testEqualityAndInequality() {
        assertEquals(IngredientType.SAUCE, IngredientType.SAUCE);
        assertEquals(IngredientType.FILLING, IngredientType.FILLING);
        assertNotEquals(IngredientType.SAUCE, IngredientType.FILLING);
    }

    // Проверка метода ordinal()
    @Test
    public void testOrdinal() {
        assertEquals(0, IngredientType.SAUCE.ordinal());
        assertEquals(1, IngredientType.FILLING.ordinal());
    }
}

