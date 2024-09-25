import org.junit.Test;
import praktikum.IngredientType;

import static org.junit.Assert.assertEquals;

public class IngredientTypeTest {
            @Test
        public void testIngredientTypeCount() {

            IngredientType[] types = IngredientType.values();
            assertEquals(2, types.length);
        }

        @Test
        public void testIngredientTypeSAUCE() {
            // Проверяем, что тип SAUCE существует и соответствует ожидаемому значению
            assertEquals(IngredientType.SAUCE, IngredientType.valueOf("SAUCE"));
        }

        @Test
        public void testIngredientTypeFILLING() {
            // Проверяем, что тип FILLING существует и соответствует ожидаемому значению
            assertEquals(IngredientType.FILLING, IngredientType.valueOf("FILLING"));
        }

        @Test
        public void testUnknownType() {
            // Проверка на наличие исключения при вызове valueOf с неизвестным значением
            try {
                IngredientType.valueOf("UNKNOWN");
            } catch (IllegalArgumentException e) {
                assertEquals("No enum constant praktikum.IngredientType.UNKNOWN", e.getMessage());
            }
        }
    }


