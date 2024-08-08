import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import praktikum.IngredientType;
import praktikum.Ingredient;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class IngredientTests {

    private final IngredientType type;
    private final String name;
    private final float price;

    public IngredientTests(IngredientType type, String name, float price) {
        this.type = type;
        this.name = name;
        this.price = price;
    }

    @Parameterized.Parameters
    public static Object[][] IngredientData(){
        return new Object[][]{
                {IngredientType.SAUCE, "Соус Spicy-X", 90F},
                {IngredientType.FILLING, "Мясо бессмертных моллюсков Protostomia", 1337F},
        };
    }

    @Test
    public void getIngredientType(){
        Ingredient ingredient = new Ingredient(type, name, price);
        IngredientType actualIngredient = ingredient.getType();
        assertEquals("Тип ингредиента не совпадает: ", actualIngredient, type);
    }

    @Test
    public void getIngredientName(){
        Ingredient ingredient = new Ingredient(type, name, price);
        String actualName = ingredient.getName();
        assertEquals("Наименование ингредиента не совпадает: ", actualName, name);
    }

    @Test
    public void getIngredientPrice(){
        Ingredient ingredient = new Ingredient(type, name, price);
        float actualPrice = ingredient.getPrice();
        assertEquals("Стоимость ингредиента не совпадает: ", actualPrice, price, 0.05);
    }

}
