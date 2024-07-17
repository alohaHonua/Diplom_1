package praktikum;

import java.util.List;

import static org.junit.Assert.*;
@RunWith(MockitoJunitRunner.class)
public class IngredientTest {
    private final float EXPECTED_INGREDIENTS_PRICE;
    private final String EXPECTED_INGREDIENTS_NAME;
    //кривая переменная
    // private final String EXPECTED_INGREDIENTS_TYPE;

    @Mock
    Database database;

    @Test
    public void checkGetPrice() {
        EXPECTED_INGREDIENTS_PRICE = 100;
        List<Ingredient> ingredients = database.availableIngredients();
        Ingredient ingredient = ingredients.get(0);
        float ingredientsPrice = ingredient.getPrice();
        AssertThat("Полученная цена ингридиента не совпадает с ожидаемой", ingredientsPrice, EXPECTED_INGREDIENTS_PRICE);
    }

    @Test
    public void checkGetName() {
        EXPECTED_INGREDIENTS_NAME = "hot sauce";
        List<Ingredient> ingredients = database.availableIngredients();
        Ingredient ingredient = ingredients.get(0);
        String ingredientsName = ingredient.getName();
        AssertThat("Полученное название ингридиента не совпадает с ожидаемым", ingredientsName, EXPECTED_INGREDIENTS_PRICE);

    }

    //кривой метод
//    @Test
//    public void checkGetType() {
//        EXPECTED_INGREDIENTS_TYPE = "SAUCE";
//        List<Ingredient> ingredients = database.availableIngredients();
//        Ingredient ingredient = ingredients.get(0);
//        String ingredientsType = ingredients.getType();
//
//    }

}