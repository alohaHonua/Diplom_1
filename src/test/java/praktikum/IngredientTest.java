package praktikum;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import static org.junit.Assert.*;

@RunWith(Parameterized.class)
public class IngredientTest {
    Ingredient ingredient;

    private final IngredientType type;
    private final String name;
    private final float price;

    public IngredientTest(IngredientType type, String name, float price) {
        this.type = type;
        this.name = name;
        this.price = price;
    }

    @Parameterized.Parameters(name = "Тип: {0}, Название: {1}, Цена: {2}")
    public static Object[][] getData() {
        return new Object[][]{
                {IngredientType.SAUCE, "hot sauce", 100},
                {IngredientType.FILLING, "dinosaur", 200},
                {null, "sour cream", 200},
                {IngredientType.FILLING, null, 300},
                {null, null, 0},
        };
    }

    @Before
    public void setUp(){
        ingredient = new Ingredient(type, name, price);
    }

    @Test
    public void getPriceTest() {
        assertEquals(String.format("Цена должна соответствовать %s", price), price, ingredient.getPrice(), 0);
    }

    @Test
    public void getNameTest() {
        assertEquals(String.format("Название должно соответствовать %s", name), name, ingredient.getName());
    }

    @Test
    public void getTypeTest() {
        assertEquals(String.format("Тип должен соответствовать %s", type), type, ingredient.getType());
    }
}