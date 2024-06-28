package ingredient;

import net.datafaker.Faker;
import org.junit.Assert;
import org.junit.Test;
import praktikum.Ingredient;
import praktikum.IngredientType;

public class IngredientsTest {
    Faker faker = new Faker();
    private final IngredientType typeOfIngredientSAUCE = IngredientType.SAUCE;
    private final IngredientType typeOfIngredientFILLING = IngredientType.FILLING;
    private final String nameOfIngredient = faker.food().ingredient();
    private final float priceOFIngredient = faker.random().nextFloat();
    Ingredient ingredient = new Ingredient(typeOfIngredientSAUCE, nameOfIngredient, priceOFIngredient);

    @Test
    public void getPriceTest() {
        Assert.assertEquals(priceOFIngredient, ingredient.getPrice(), 0);
    }

    @Test
    public void getNameTest() {
        Assert.assertEquals(nameOfIngredient, ingredient.getName());
    }

    @Test
    public void getTypeTestTypeOfIngredientSAUCE() {
        Assert.assertEquals(typeOfIngredientSAUCE, ingredient.getType());
    }
    @Test
    public void getTypeTestTypeOfIngredientFILLING() {
        Ingredient ingredient = new Ingredient(typeOfIngredientFILLING, nameOfIngredient, priceOFIngredient);
        Assert.assertEquals(typeOfIngredientFILLING, ingredient.getType());
    }
}
