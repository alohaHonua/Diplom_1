package praktikum;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import parameters.Constants;

import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.assertThat;

public class BurgerTest {

    Burger burger = new Burger();
    @Mock
    Bun bun;
    @Mock
    Ingredient ingredient;
    @Mock
    Ingredient ingredient1;
    @Before
    public void init() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void setBunsTest() {
        Burger burger = new Burger();

        burger.setBuns(bun);
        assertThat(burger.bun, is(notNullValue()));
    }

    @Test
    public void addIngredientTest() {
        Burger burger = new Burger();

        burger.addIngredient(ingredient);
        assertThat(burger.ingredients.size(), is(Constants.ONE_INGREDIENT));
    }

    @Test
    public void removeIngredientTest() {
        Burger burger = new Burger();

        int pinIngredientsSize = burger.ingredients.size();
        burger.addIngredient(ingredient);
        burger.removeIngredient(burger.ingredients.size()-1);
        assertThat(burger.ingredients.size(), is(pinIngredientsSize));
    }

    @Test
    public void moveIngredientTest() {
        Burger burger = new Burger();

        burger.addIngredient(ingredient);
        burger.addIngredient(ingredient1);
        burger.moveIngredient(burger.ingredients.size()-1, Constants.NEW_INDEX);
        assertThat(burger.ingredients.indexOf(ingredient1) , is(Constants.NEW_INDEX));
    }

    @Test
    public void getPriceTest() {

        Mockito.when(bun.getPrice()).thenReturn(Constants.BUN_PRICE);
        Mockito.when(ingredient.getPrice()).thenReturn(Constants.INGREDIENT_1_PRICE);

        Burger burger = new Burger();

        burger.setBuns(bun);

        burger.addIngredient(ingredient);

        float expPrice = Constants.BUN_PRICE * 2 + Constants.INGREDIENT_1_PRICE;
        assertThat(burger.getPrice(), is(expPrice));

        Mockito.verify(bun).getPrice();
        Mockito.verify(ingredient).getPrice();

    }

    @Test
    public void getReceipt() {

        Mockito.when(bun.getName()).thenReturn(Constants.BUN_NAME);
        Mockito.when(bun.getPrice()).thenReturn(Constants.BUN_PRICE);

        Mockito.when(ingredient.getType()).thenReturn(IngredientType.SAUCE);
        Mockito.when(ingredient.getName()).thenReturn(Constants.INGREDIENT_1_NAME);
        Mockito.when(ingredient.getPrice()).thenReturn(Constants.INGREDIENT_1_PRICE);


        burger.setBuns(bun);
        burger.addIngredient(ingredient);
        String actMessage = burger.getReceipt();

        Mockito.verify(bun, Mockito.times(2)).getName();
        Mockito.verify(bun).getPrice();
        Mockito.verify(ingredient).getName();
        Mockito.verify(ingredient).getPrice();
        Mockito.verify(ingredient).getType();

        //проверка на наличие в тексте рецепта назаваний булочки и ингредиента
        assertThat(actMessage,allOf(containsString(Constants.BUN_NAME), containsString(Constants.INGREDIENT_1_NAME)));
        //проверка на наличие в тексте рецепта корректного прайса
        float expPrice = Constants.BUN_PRICE * 2 + Constants.INGREDIENT_1_PRICE;
        assertThat(actMessage,containsString(String.valueOf(expPrice).replace('.', ',')));
    }
}