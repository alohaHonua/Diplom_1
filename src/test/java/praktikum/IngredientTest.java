package praktikum;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

@RunWith(Parameterized.class)

public class IngredientTest {
    private Ingredient ingredient;

    private final IngredientType type;
    private final String name;
    private final float price;

    private float delta = 0.01f;

    public IngredientTest(IngredientType type, String name, float price){
        this.type = type;
        this.name = name;
        this.price = price;
    }

    @Parameterized.Parameters(name = "type: {0}, name: {1}, price: {2}")
    public static Collection<Object[]> getData() {
        return Arrays.asList(new Object[][]{
                {IngredientType.FILLING, "С маком", 10.0f},
                {IngredientType.SAUCE, "Стандартная", 50.5f}
        });
    }

    @Before
    public void setUp() {
        ingredient = new Ingredient(type,name,price);
    }

    @Test
    public void  getPriceTest(){
        Assert.assertEquals("Ожидаемая цена:" + price + " =- " + delta, price, ingredient.getPrice(), delta);
    }

    @Test
    public void  getNameTest(){
        Assert.assertEquals("Ожидаемое имя: " + name,  name, ingredient.getName());
    }

    @Test
    public void  getTypeTest(){
        Assert.assertEquals("Ожидаемый тип: " + type,  type, ingredient.getType());
    }



}
