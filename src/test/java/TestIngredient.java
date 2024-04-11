import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import praktikum.Ingredient;
import praktikum.IngredientType;

import static org.junit.Assert.assertEquals;
import static praktikum.IngredientType.FILLING;
import static praktikum.IngredientType.SAUCE;


@RunWith(Parameterized.class)
public class TestIngredient {
    private final IngredientType type;
    private final String name;
    private  final float price;
    private Ingredient ingredient;

    public TestIngredient(IngredientType type, String name, float price){
        this.type = type;
        this.name = name;
        this.price = price;
    }
    @Parameterized.Parameters()
    public static Object[][] getTestData() {
        return new Object[][]{
                {SAUCE, "hot sauce", 100},
                {SAUCE, "sour cream", 200},
                {SAUCE, "chili sauce", 300},
                {FILLING, "cutlet", 100},
                {FILLING, "dinosaur", 200},
                {FILLING, "sausage", 300}
        };
    }

    @Before
    public void setUp(){
        ingredient = new Ingredient(type, name, price);
    }

    @Test
    public void getTypeTest(){
        assertEquals(ingredient.getType(), type);
    }
    @Test
    public void getNameTest(){
        assertEquals( ingredient.getName(), name);
    }

    @Test
    public void getPriceTest(){
        assertEquals(ingredient.getPrice(), price, 0);
    }

}
