import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import praktikum.Ingredient;
import praktikum.IngredientType;

@RunWith(Parameterized.class)
public class IngredientParameterizedTests {
    private final IngredientType type;
    private final IngredientType expectedType;
    private final String name;
    private final String expectedName;
    private final float price;
    private final float expectedPrice;

    public IngredientParameterizedTests(IngredientType type, IngredientType expectedType, String name, String expectedName, float price, float expectedPrice){
        this.type = type;
        this.expectedType = expectedType;
        this.name = name;
        this.expectedName = expectedName;
        this.price = price;
        this.expectedPrice = expectedPrice;
    }

    @Parameterized.Parameters
    public static Object[][] ingredientData(){
        return new Object[][]{
                {IngredientType.SAUCE, IngredientType.SAUCE, "Соус Spicy-X", "Соус Spicy-X", 90f, 90f},
                {IngredientType.SAUCE, IngredientType.SAUCE, "Соус как соус", "Соус как соус", 88.8888f, 88.8888f},
                {IngredientType.FILLING, IngredientType.FILLING, "Мясо бессмертных моллюсков Protostomia", "Мясо бессмертных моллюсков Protostomia", 1337f, 1337f},
                {IngredientType.FILLING, IngredientType.FILLING, "Говяжий метеорит (отбивная)", "Говяжий метеорит (отбивная)", 3000.000f, 3000.000f},
        };
    }

    @Test
    public void getPriceTest(){
        Ingredient ingredient = new Ingredient(type, name, price);
        Assert.assertEquals(expectedPrice, ingredient.getPrice(), 0);
    }

    @Test
    public void getNameTest(){
        Ingredient ingredient = new Ingredient(type, name, price);
        Assert.assertEquals(expectedName, ingredient.getName());
    }

    @Test
    public void getTypeTest(){
        Ingredient ingredient = new Ingredient(type, name, price);
        Assert.assertEquals(expectedType, ingredient.getType());
    }
}
