import org.junit.Assert;
import org.junit.Test;
import praktikum.IngredientType;

public class IngredientTypeTest {
    @Test
    public void testEnumToString() {
        for (IngredientType type : IngredientType.values()) {
            Assert.assertEquals(type.name(), type.toString()); // Проверяет, что toString() возвращает имя перечисления
        }
    }
}