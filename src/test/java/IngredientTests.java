package praktikum;

import org.hamcrest.MatcherAssert;
import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.equalTo;

public class IngredientTests {
    private Ingredient ingredientSauce;
    private Ingredient ingredientFilling;
    private IngredientType ingredientTypeOne = IngredientType.SAUCE;
    private IngredientType ingredientTypeTwo = IngredientType.FILLING;
    private String ingredientNameSauce = "Соус";
    private String ingredientNameFilling = "Начинка";
    private float ingredientPrice = 100500f;

    //  !--- Создаем новый ингредиент типа соус---!
    @Before
    public void createIngredientSauce() {
        this.ingredientSauce = new Ingredient(ingredientTypeOne, ingredientNameSauce, ingredientPrice);
    }


    //  !--- Создаем новый ингредиент типа начинка---!
    @Before
    public void createIngredientFilling() {
        this.ingredientFilling = new Ingredient(ingredientTypeTwo, ingredientNameFilling, ingredientPrice);
    }


    //  !--- Проверяем тип ингредиента (Соус) ---!
    @Test
    public void getTypeSauсeIsSuccessTest() {
        MatcherAssert.assertThat("Неверный тип ингредиента", ingredientSauce.getType(), equalTo(ingredientTypeOne));
    }

    //  !--- Проверяем тип ингредиента (Начинка) ---!
    @Test
    public void getTypeFillingIsSuccessTest() {
        MatcherAssert.assertThat("Неверный тип ингредиента", ingredientFilling.getType(), equalTo(ingredientTypeTwo));
    }


    //  !--- Проверяем имя ингредиента (Соус)---!
    @Test
    public void getNameSauceIsSuccessTest() {
        MatcherAssert.assertThat("Неверное имя ингредиента", ingredientSauce.getName(), equalTo(ingredientNameSauce));
    }

    //  !--- Проверяем имя ингредиента (Начинка)---!
    @Test
    public void getNameFillingIsSuccessTest() {
        MatcherAssert.assertThat("Неверное имя ингредиента", ingredientFilling.getName(), equalTo(ingredientNameFilling));
    }


    //  !--- Проверяем цену ингредиента (Соус)---!
    @Test
    public void getPriceSauceIsSuccessTest() {
        MatcherAssert.assertThat("Неверная цена ингредиента", ingredientSauce.getPrice(), equalTo(ingredientPrice));
    }


    //  !--- Проверяем цену ингредиента (Начинка)---!
    @Test
    public void getPriceFillingIsSuccessTest() {
        MatcherAssert.assertThat("Неверная цена ингредиента", ingredientFilling.getPrice(), equalTo(ingredientPrice));
    }
}