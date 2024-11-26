import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.MockitoAnnotations;
import org.mockito.Spy;
import org.mockito.junit.MockitoJUnitRunner;
import praktikum.*;

import static org.hamcrest.CoreMatchers.*;


@RunWith(MockitoJUnitRunner.class)

public class BurgerTest {

    @Before
    public void init() {
        MockitoAnnotations.openMocks(this);
    }

    Burger burger = new Burger();

    @Spy
    Bun bun =new Bun("white bun", 200) ;

    @Spy
    Ingredient ingredient = new Ingredient(IngredientType.SAUCE, "hot sauce", 100);

    @Test

    public void checkGetPrice() {

        burger.addIngredient(ingredient);
        float actual = bun.getPrice() * 2 + ingredient.getPrice();
        burger.setBuns(bun);
        float priceBurger = burger.getPrice();
        Assert.assertEquals(priceBurger, actual, 0);
    }



    @Test

    public void checkGetReceipt (){
        burger.setBuns(bun);
        burger.addIngredient(ingredient);
        String receipt = burger.getReceipt();
        Assert.assertNotNull(receipt);
        Assert.assertThat(receipt,allOf(startsWith("(===="),containsString("Price:")));
    }
}

