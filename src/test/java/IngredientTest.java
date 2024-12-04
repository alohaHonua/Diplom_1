import praktikum.*;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import static org.junit.Assert.*;

//Параметризированные тесты для класса Ingredient.
@RunWith(Parameterized.class)
public class IngredientTest {

    private final IngredientType type;
    private final String name; 
    private final float price;

    public IngredientTest(IngredientType type, String name, float price) {
        this.type = type;
        this.name = name;
        this.price = price;
    }

    @Parameterized.Parameters(name = "Тип: {0}, Название: {1}, Цена: {2}")
    public static Object[][] testData() {
        return new Object[][]{
                {IngredientType.SAUCE, "Соус с шипами Антарианского плоскоходца", 88.0f},
                {IngredientType.FILLING, "Филе Люминесцентного тетраодонтимформа", 988.0f},
                {IngredientType.SAUCE, "Соус традиционный галактический", 15.0f},
                {IngredientType.FILLING, "Биокотлета из марсианской Магнолии", 424.0f}
        };
    }

    @Test
    public void testIngredientMethods() {
        //Создаем ингредиент
        Ingredient ingredient = new Ingredient(type, name, price);

        //Проверяем геттеры
        assertEquals("Тип ингредиента неверный", type, ingredient.getType());
        assertEquals("Название ингредиента неверное", name, ingredient.getName());
        assertEquals("Цена ингредиента неверная", price, ingredient.getPrice(), 0);
    }
}