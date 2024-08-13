package testburger;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import praktikum.*;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.assertThat;
import static org.hamcrest.Matchers.containsInAnyOrder;


@RunWith(MockitoJUnitRunner.class)
public class TestBurger {

    @Mock
    Bun mockedBun;

    @Mock
    Ingredient mockedIngredient;

    @Test
    public void setBunTest(){
        Burger burger = new Burger();
        burger.setBuns(mockedBun);

        assertThat(burger.bun, is(mockedBun));

    }

    @Test
    public void addIngredientTest(){
        Burger burger = new Burger();
        burger.addIngredient(mockedIngredient);

        assertThat(burger.ingredients, containsInAnyOrder(mockedIngredient));

    }

    @Test
    public void removeIngredientTest(){
        Database database = new Database();
        Burger burger = new Burger();
        burger.addIngredient(database.availableIngredients().get(0));
        burger.addIngredient(database.availableIngredients().get(1));
        burger.removeIngredient(1);

        assertThat(burger.ingredients.size(), is(1));

    }

    @Test
    public void moveIngredientTest(){
        Database database = new Database();
        Burger burger = new Burger();
        burger.addIngredient(database.availableIngredients().get(0));
        burger.addIngredient(database.availableIngredients().get(1));
        burger.addIngredient(database.availableIngredients().get(2));
        burger.moveIngredient(0, 1);

        assertThat(burger.ingredients.get(1), is(database.availableIngredients().get(0)));

    }

    @Test
    public void getPriceTest(){
        final float bunPrice = 100;
        final float ingPrice = 10;
        final float totalPrice = 210;
        Burger burger = new Burger();
        Mockito.when(mockedBun.getPrice()).thenReturn(bunPrice);
        Mockito.when(mockedIngredient.getPrice()).thenReturn(ingPrice);
        burger.setBuns(mockedBun);
        burger.addIngredient(mockedIngredient);

        assertThat(burger.getPrice(), is(totalPrice));

    }

    @Test
    public void getReceiptTest(){
        final String testBun = "testBun";
        final String testType = "testType";
        final String testIngredient = "testIngredient";

        Burger burger = new Burger();
        Mockito.when(mockedBun.getName()).thenReturn(testBun);
        Mockito.when(mockedIngredient.getType()).thenReturn(IngredientType.valueOf("SAUCE"));
        Mockito.when(mockedIngredient.getName()).thenReturn(testIngredient);

        burger.setBuns(mockedBun);
        burger.addIngredient(mockedIngredient);

        assertThat(burger.getReceipt(),
                allOf(containsString("(==== testBun ====)"),
                      containsString("= sauce testIngredient ="),
                      containsString("Price:")));

    }

}
