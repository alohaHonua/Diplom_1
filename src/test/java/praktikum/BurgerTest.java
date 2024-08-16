package praktikum;

import org.junit.Assert;
import org.junit.Test;
import org.junit.jupiter.api.DisplayName;
import org.mockito.Mock;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class BurgerTest {

    @Mock
    Ingredient ingredient;
//
//    @Mock
//    Bun bun;

    @Test
    @DisplayName("Проверка того, что булочка передана в бургер")
    public void setBuns() {
        Burger burger = new Burger();
        burger.setBuns(new Bun("Bulka", 45.67F));

//        @Step("Проверим через наименование булки")
        Assert.assertTrue("Bulka".equals(burger.bun.getName()));
    }

    @Test
    @DisplayName("Добавление ингредиента")
    public void addIngredient() {
        Burger burger = new Burger();
        burger.addIngredient(ingredient);
        burger.addIngredient(ingredient);
//        @Step("Проверим что добавили именно два ингредиента")
        Assert.assertTrue(burger.ingredients.size() == 2);
    }

    @Test
    @DisplayName("Проверка на удаление ингредиента")
    public void removeIngredient() {
        Burger burger = new Burger();
        burger.addIngredient(ingredient);
        burger.addIngredient(ingredient);
        burger.removeIngredient(1);
        Assert.assertTrue(burger.ingredients.size() == 1);
    }

    @Test
    @DisplayName("Расчет стоимости бургера")
    public void getPrice() {
        Burger burger = new Burger();
        Database database = new Database();
        List<Ingredient> ingredients = database.availableIngredients();
//        Mockito.when(ingredient.getPrice()).thenReturn(100F);
//        Mockito.when(bun.getPrice()).thenReturn(170F);
        burger.addIngredient(ingredients.get(0));
        burger.addIngredient(ingredients.get(4));
        burger.setBuns(database.availableBuns().get(1));
        float priceBurgerPlan = 100 + 200 + 200 * 2;
        float priceBurger = burger.getPrice();
        assertEquals(priceBurger, priceBurgerPlan, 0.001F);
    }
}
