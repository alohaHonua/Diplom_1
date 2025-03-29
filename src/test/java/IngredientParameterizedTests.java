import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import praktikum.Ingredient;
import praktikum.IngredientType;

@RunWith(Parameterized.class)
public class IngredientParameterizedTests {
    private final IngredientType type;
    private final String name;
    private final float price;

    public IngredientParameterizedTests(IngredientType type, String name, float price){
        this.type = type;
        this.name = name;
        this.price = price;
    }

    @Parameterized.Parameters
    public static Object[][] ingredientData(){
        return new Object[][]{
                {IngredientType.SAUCE, "Соус Spicy-X", 90f},
                {IngredientType.SAUCE, "Соус как соус", 88.8888f},
                {IngredientType.FILLING, "Мясо бессмертных моллюсков Protostomia", 1337f},
                {IngredientType.FILLING, "Говяжий метеорит (отбивная)", 3000.000f},
        };
    }

    @Test
    public void getPriceTest(){
        Ingredient ingredient = createIngredient();
        Assert.assertEquals(price, ingredient.getPrice(), 0);
    }

    @Test
    public void getNameTest(){
        Ingredient ingredient = createIngredient();
        Assert.assertEquals(name, ingredient.getName());
    }

    @Test
    public void getTypeTest(){
        Ingredient ingredient = createIngredient();
        Assert.assertSame(type, ingredient.getType());
    }

    private Ingredient createIngredient(){
        return new Ingredient(type, name, price);
    }
}
