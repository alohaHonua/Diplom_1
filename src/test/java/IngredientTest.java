import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import praktikum.Ingredient;
import praktikum.IngredientType;

@RunWith(Parameterized.class)
public class IngredientTest {
    IngredientType type;
    String name;
    float price;

    public IngredientTest(IngredientType type, String name, float price){
        this.type = type;
        this.name = name;
        this.price = price;
    }
    @Parameterized.Parameters
    public static Object[][] data() {
        return new Object[][]{
                {IngredientType.FILLING, "Филе Люминесцентного тетраодонтимформа", 988},
                {IngredientType.SAUCE, "Соус традиционный галактический", 15}
        };
    }
    @Test
    public void getPriceTest(){
        Ingredient ingredient = new Ingredient(type, name, price);
        Assert.assertEquals(price, ingredient.getPrice(),0);
    }
    @Test
    public void getNameTest(){
        Ingredient ingredient = new Ingredient(type, name, price);
        Assert.assertEquals(name, ingredient.getName());
    }
    @Test
    public void getTypeTest(){
        Ingredient ingredient = new Ingredient(type, name, price);
        Assert.assertEquals(type, ingredient.getType());
    }
}
