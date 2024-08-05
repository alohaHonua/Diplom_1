import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import praktikum.Ingredient;
import praktikum.IngredientType;

@RunWith(Parameterized.class)
public class TestIngredientClass {

    public IngredientType type;
    public String name;
    public float price;

    public TestIngredientClass(IngredientType type, String name, float price){
        this.type = type;
        this.name = name;
        this.price = price;
    }

    @Parameterized.Parameters
    public static Object[][] putData(){
        return new Object[][]{
                {IngredientType.SAUCE, "Морские острова", 12.567F},
                {IngredientType.FILLING, "рЫБНАЯ котлета", 34.067F},
        };
    }

    @Test
    public void testGetPriceIngredient(){
        Ingredient ingredient = new Ingredient(type, name, price);
        float actual = ingredient.getPrice();
        System.out.println("Фактический результат " + actual);
        float expected = price;
        System.out.println("Ожидаемый результат " + expected);
        Assert.assertEquals(expected, price, 0);
    }

    @Test
    public void testGetNameIngredient(){
        Ingredient ingredient = new Ingredient(type, name, price);
        String actual = ingredient.getName();
        System.out.println("Фактический результат " + actual);
        String expected = name;
        System.out.println("Ожидаемый результат " + expected);
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testGetTypeIngredient(){
        Ingredient ingredient = new Ingredient(type, name, price);
        IngredientType actual = ingredient.getType();
        System.out.println("Фактический результат " + actual);
        IngredientType expected = type;
        System.out.println("Ожидаемый результат " + expected);
        Assert.assertEquals(expected, actual);
    }
}
