import org.junit.Test;
import praktikum.IngredientType;
import static org.junit.Assert.assertEquals;

public class IngredientTypeTest {

    public String describeIngredientType(IngredientType type) {
        // Возвращаем русское описание, соответствующее типу
        switch (type) {
            case SAUCE:
                return "Это соус";
            case FILLING:
                return "Это начинка";
            default:
                // Печатаем предупреждение для нового типа
                System.out.println("Предупреждение: найден неизвестный тип ингредиента: " + type);
                return "Неизвестный тип";
        }
    }

    @Test
    public void testDescribeSauce() {
        assertEquals("Это соус", describeIngredientType(IngredientType.SAUCE));
    }

    @Test
    public void testDescribeFilling() {
        assertEquals("Это начинка", describeIngredientType(IngredientType.FILLING));
    }

    @Test // Тест на неизвестный тип
    public void testUnknownType() {
        // Проходим по всем типам в enum и проверяем, что они корректно обрабатываются
        for (IngredientType type : IngredientType.values()) {
            String expected = getExpectedDescription(type);
            assertEquals("Тип " + type + " обработан неправильно", expected, describeIngredientType(type));
        }
    }

    private String getExpectedDescription(IngredientType type) {
        switch (type) {
            case SAUCE:
                return "Это соус";
            case FILLING:
                return "Это начинка";
            default:
                return "Неизвестный тип";
        }
    }
}
