import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import praktikum.Ingredient;
import praktikum.IngredientType;

import static praktikum.IngredientType.*;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class IngridientParamTest {

    private final IngredientType type;
    private final String name;
    private final float price;


    public IngridientParamTest(IngredientType type, String name, float price) {
        this.type = type;
        this.name = name;
        this.price = price;
    }

    @Parameterized.Parameters()
    public static Object[][] getTypeNamePrice(){
            return new Object[][]{
                    {SAUCE, "Батон", 1.5F},
                    {FILLING, "Broun", 5}
            };
    }

@Test
public void checkGetPrice() {
    Ingredient ingredient = new Ingredient(type, name, price);
    float delta = 0.1F;
    float actualPrice = ingredient.getPrice();
    assertEquals(price, actualPrice, delta);
}

@Test
public void checkGetName() {
    Ingredient ingredient = new Ingredient(type, name, price);
    String actualName = ingredient.getName();
    assertEquals(name, actualName);
}

@Test
    public void checkGetType() {
        Ingredient ingredient = new Ingredient(type, name, price);
        IngredientType actualIngredient = ingredient.getType();
        assertEquals(type, actualIngredient);
}
}