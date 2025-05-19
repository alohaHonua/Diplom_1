package praktikum;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import static org.junit.Assert.*;
import static praktikum.IngredientType.*;


@RunWith(Parameterized.class)
public class IngredientParameterizedTest {
    private Ingredient ingredient;

    private final IngredientType type;
    private final String name;
    private final float price;

    public IngredientParameterizedTest(IngredientType type, String name, float price) {
        this.type = type;
        this.name = name;
        this.price = price;
    }

    @Parameterized.Parameters(name = "type = {0}, name = {1}, price = {2}")
    public static Object[][] data(){
        return new Object[][]{
                {SAUCE, "hot souce", 100f},
                {FILLING, "dinosaur", 200f}
        };
    }

    @Before
    public void createNewIngredient(){
       ingredient = new Ingredient(type, name, price);
    }

    @Test
    public void checkGetTypeTest(){
        assertEquals("Ожидаемый тип ингредиента не совпадает с фактическим", type, ingredient.getType());
    }

    @Test
    public void checkGetNameTest(){
        assertEquals("Ожидаемое имя ингредиента не совпадает с фактическим", name, ingredient.getName());
    }

    @Test
    public void checkGetPriceTest(){
        assertEquals("Ожидаемая цена ингредиента не совпадает с фактической", price, ingredient.getPrice(), 0);
    }
}
