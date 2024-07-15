package praktikum;

import org.hamcrest.MatcherAssert;
import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.equalTo;

public class IngredientTests {
    private Ingredient testIngredient;
    private IngredientType testIngredientType = IngredientType.SAUCE;
    private String testName = "testSauceName";
    private float testPrice = 50f;

    @Before
    public void setUp() {
        this.testIngredient = new Ingredient(
                testIngredientType,
                testName,
                testPrice
        );
    }

    @Test
    public void shouldReturnCorrectPrice() {
        MatcherAssert.assertThat(
                "Цена ингредиента некорректна",
                testIngredient.getPrice(),
                equalTo(testPrice)
        );
    }

    @Test
    public void shouldReturnCorrectName() {
        MatcherAssert.assertThat(
                "Название ингредиента некорректно",
                testIngredient.getName(),
                equalTo(testName)
        );
    }

    @Test
    public void shouldReturnCorrectType() {
        MatcherAssert.assertThat(
                "Тип ингредиента некорректен",
                testIngredient.getType(),
                equalTo(testIngredientType)
        );
    }
}