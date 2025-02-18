import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import praktikum.Ingredient;
import praktikum.IngredientType;

@RunWith(Parameterized.class)
public class IngredientTest {
    private static final String SAUSE_NAME = "Соус Spicy-X";
    private static final float SAUSE_PRICE = 80;
    private static final String FILLING_NAME = "Мясо бессмертных моллюсков Protostomia";
    private static final float FILLING_PRICE = 1300;

    private int ordinal;
    private praktikum.IngredientType ingredientType;
    private String name;
    private float price;

    public IngredientTest(IngredientType ingredientType, String name, float price) {
        this.ingredientType = ingredientType;
        this.name = name;
        this.price = price;
    }

    @Parameterized.Parameters(name = " IngredientType ({0}) , name ({1}) , price ({2})")
    public static Object[][] setParams() {
        return new Object[][]{
                {IngredientType.SAUCE, SAUSE_NAME, SAUSE_PRICE},
                {IngredientType.FILLING, FILLING_NAME, FILLING_PRICE},
        };
    }

    @Test
    public void nameIngredientTest() {
        Ingredient ingredient = new Ingredient(ingredientType, name, price);
        Assert.assertEquals("Наименование инградиента возвращается не верно"
                , name, ingredient.getName());
    }

    @Test
    public void priceIngredientTest() {
        Ingredient ingredient = new Ingredient(ingredientType, name, price);
        Assert.assertEquals("Цена инградиента возвращается не верно"
                , Float.valueOf(price), ingredient.getPrice(),0);
    }

    @Test
    public void typeIngredientTest() {
        Ingredient ingredient = new Ingredient(ingredientType, name, price);
        Assert.assertEquals("Тип инградиента возвращается не верно"
                , ingredientType, ingredient.getType());
    }

}