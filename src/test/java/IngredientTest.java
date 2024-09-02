import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import praktikum.Ingredient;
import praktikum.IngredientType;
import static praktikum.IngredientType.FILLING;
import static praktikum.IngredientType.SAUCE;

@RunWith(Parameterized.class)

public class IngredientTest {
public IngredientType type;
    private final String name;
    private final float price;

    public IngredientTest(IngredientType type,String name, float price) {
this.type=type;
        this.name= name;
        this.price = price;
    }

    @Parameterized.Parameters // добавили аннотацию
    public static Object[][] getTypeIngridient(){
        return new Object[][]{
                {SAUCE,"QQQ", 123},
                {FILLING,"AAA", 456}

        };
    }


@Test
public void testModelIngridient() {
    Ingredient ingredient = new Ingredient(type, name, price);
    Assert.assertEquals(type, ingredient.getType());
}
    @Test
    public void testModelIngridientName() {
        Ingredient ingredient = new Ingredient(IngredientType.SAUCE, "QQQ", 456);
        Assert.assertEquals("QQQ", ingredient.getName());
    }

    @Test
    public void testModelIngridientPrice() {
        Ingredient ingredient = new Ingredient(IngredientType.SAUCE, "QQQ", 123);
        Assert.assertEquals(ingredient.getPrice(), 123, 0);
    }

}

