package praktikum;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import java.util.Arrays;
import java.util.Collection;
import static org.junit.Assert.*;

@RunWith(Parameterized.class)
public class IngredientTypeTest {

    private final IngredientType type;
    private final String expectedName;

    public IngredientTypeTest(IngredientType type, String expectedName) {
        this.type = type;
        this.expectedName = expectedName;
    }

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][] {
                {IngredientType.SAUCE, "SAUCE"},
                {IngredientType.FILLING, "FILLING"}
        });
    }

    @Test
    public void testEnumValueOf() {
        // Проверяем, что значение enum соответствует ожидаемому
        assertEquals(expectedName, type.name());
    }

    @Test
    public void testEnumValues() {
        // Проверяем, что в enum ровно 2 значения
        assertEquals(2, IngredientType.values().length);
    }

    @Test
    public void testEnumContainsCorrectValues() {
        // Проверяем, что enum содержит только SAUCE и FILLING
        assertTrue(Arrays.asList(IngredientType.values()).contains(IngredientType.SAUCE));
        assertTrue(Arrays.asList(IngredientType.values()).contains(IngredientType.FILLING));
    }
}