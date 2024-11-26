import org.junit.Assert;
import org.junit.Test;
import praktikum.Ingredient;
import praktikum.IngredientType;

public class IngredientTest {

    public IngredientType type = IngredientType.SAUCE;
    public String name = "hot sauce";
    public float price = 100;

    Ingredient ingredient = new Ingredient(type, name, price);


    @Test

    public void checkGetPrice() {
        float priceIngredient = ingredient.getPrice();
        Assert.assertEquals(price, priceIngredient,0);
    }

    @Test

    public void checkGetName (){
        String nameIngredient = ingredient.getName();
        Assert.assertEquals(name,nameIngredient);
    }

    @Test

    public void checkGetType (){
        IngredientType typeIngredient = ingredient.getType();
        Assert.assertEquals(type,typeIngredient);
    }
}

