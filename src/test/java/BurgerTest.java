import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import praktikum.*;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

@RunWith(MockitoJUnitRunner.class)
public class BurgerTest {

    Database database = new Database();
    Burger burger;
    int sizeOfIngredientsBurger;

    @Before
    public void createNewBurger() {

        burger = new Burger();

        //Заполнение бургера ингредиентами
        for(int i = 0; i <= 3; i++) {
            burger.addIngredient(database.availableIngredients().get(i));
        }

        sizeOfIngredientsBurger = burger.ingredients.size();
    }

    @Mock
    Bun bun;

    @Test
    public void addIngredientsTest(){

        int actual = burger.ingredients.size();

        assertEquals(4, actual);
    }

    @Test
    public void removeIngredientTest() {
        burger.removeIngredient(3);
        assertEquals(sizeOfIngredientsBurger - 1, burger.ingredients.size());
    }

    @Test
    public void moveIngredientTest(){

        Ingredient ingredientBeforeMoving = burger.ingredients.get(3);
        burger.moveIngredient(3, 0);
        Ingredient ingredientAfterMoving = burger.ingredients.get(0);

        assertEquals(ingredientAfterMoving, ingredientBeforeMoving);
    }


    @Test
    public void getPriceTest() {
        burger.setBuns(bun);
        Mockito.when(bun.getPrice()).thenReturn(43.0f);

        float actualPrice = burger.getPrice();

        assertEquals(786.0f, actualPrice, 0.0f);
    }


    @Test
    public void getReceiptTest(){

        burger.setBuns(bun);
        List<Ingredient> ingredientList = new ArrayList<>(burger.ingredients);
        assertEquals("(==== " + bun.getName() + " ====)\r\n" +
                "= sauce " + ingredientList.get(0).getName() + " =\r\n" +
                "= sauce " + ingredientList.get(1).getName() + " =\r\n" +
                "= sauce " + ingredientList.get(2).getName() + " =\r\n" +
                "= filling " + ingredientList.get(3).getName() + " =\r\n" +
                "(==== " + bun.getName() + " ====)\r\n" +
                "\r\n" +
                "Price: 700,000000\r\n", burger.getReceipt());
    }



}
