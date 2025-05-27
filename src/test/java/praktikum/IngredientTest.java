package praktikum;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;
import static org.junit.Assert.*;
import java.util.Arrays;
import java.util.Collection;

@RunWith(Parameterized.class)
public class IngredientTest {
    
    private final IngredientType type;
    private final String name;
    private final float price;
    private final Ingredient ingredient;
    
    public IngredientTest(IngredientType type, String name, float price) {
        this.type = type;
        this.name = name;
        this.price = price;
        this.ingredient = new Ingredient(type, name, price);
    }
    
    @Parameters(name = "{index}: type={0}, name={1}, price={2}")
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][] {
            { IngredientType.SAUCE, "hot sauce", 100f },
            { IngredientType.FILLING, "cutlet", 200f },
            { IngredientType.SAUCE, "sour cream", 50f },
            { IngredientType.FILLING, "dinosaur", 300f }
        });
    }
    
    @Test
    public void testIngredientConstructor() {
        assertEquals("Тип ингредиента должен совпадать", type, ingredient.getType());
        assertEquals("Название ингредиента должно совпадать", name, ingredient.getName());
        assertEquals("Цена ингредиента должна совпадать", price, ingredient.getPrice(), 0.0f);
    }
    
    @Test
    public void testIngredientGetters() {
        assertEquals("Метод getType должен возвращать правильный тип", type, ingredient.getType());
        assertEquals("Метод getName должен возвращать правильное название", name, ingredient.getName());
        assertEquals("Метод getPrice должен возвращать правильную цену", price, ingredient.getPrice(), 0.0f);
    }
} 