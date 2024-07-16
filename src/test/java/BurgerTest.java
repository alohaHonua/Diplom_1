import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import praktikum.Bun;
import praktikum.Burger;
import praktikum.Ingredient;
import praktikum.IngredientType;


@RunWith(MockitoJUnitRunner.class)
public class BurgerTest {

    @Mock
    Ingredient ingredientOne;
    @Mock
    Ingredient ingredientTwo;
    @Mock
    Bun bun;
    @Mock
    Ingredient filling;
    @Mock
    Ingredient sauce;

    Burger burger = new Burger();

    @Test
    public void setBunTest(){
        burger.setBuns(bun);
        Assert.assertEquals(bun, burger.bun);
    }

    @Test
    public void addIngredientTest() {
        burger.addIngredient(ingredientOne);
        Assert.assertFalse(burger.ingredients.isEmpty());
    }

    @Test
    public void removeIndexTest() {
        burger.addIngredient(ingredientOne);
        burger.removeIngredient(0);
        Assert.assertTrue(burger.ingredients.isEmpty());
    }

    @Test
    public void moveIngredientTest() {
        var firstIndex = 0;
        var secondIndex = 1;
        burger.addIngredient(filling);
        burger.addIngredient(sauce);
        burger.moveIngredient(firstIndex,secondIndex);
        Assert.assertEquals(filling, burger.ingredients.get(secondIndex));
        Assert.assertEquals(sauce, burger.ingredients.get(firstIndex));
    }

    @Test
    public void getPriceTest() {
        Mockito.when(bun.getPrice()).thenReturn(Constants.firstbunprice);
        Mockito.when(ingredientOne.getPrice()).thenReturn(Constants.firstsouseprice);
        Mockito.when(ingredientTwo.getPrice()).thenReturn(Constants.secondsouseprice);
        burger.setBuns(bun);
        burger.addIngredient(ingredientOne);
        burger.addIngredient(ingredientTwo);
        Assert.assertEquals((Constants.firstbunprice *2+Constants.firstsouseprice +Constants.secondsouseprice), burger.getPrice(), 0.1);
    }

    @Test
    public void getReceiptTest(){
        burger.setBuns(bun);
        burger.addIngredient(ingredientOne);
        burger.addIngredient(ingredientTwo);
        Mockito.when(bun.getName()).thenReturn(Constants.buntwo);
        Mockito.when(bun.getPrice()).thenReturn(Constants.buntwoprice);
        Mockito.when(ingredientOne.getType()).thenReturn(IngredientType.SAUCE);
        Mockito.when(ingredientTwo.getType()).thenReturn(IngredientType.FILLING);
        Mockito.when(ingredientOne.getName()).thenReturn(Constants.firstsause);
        Mockito.when(ingredientTwo.getName()).thenReturn(Constants.firstfilling);
        Mockito.when(ingredientOne.getPrice()).thenReturn(Constants.firstsouseprice);
        Mockito.when(ingredientTwo.getPrice()).thenReturn(Constants.firstfillingprice);
        String str = String.format("(==== "+Constants.buntwo+" ====)%n") +
                String.format("= "+ IngredientType.SAUCE.toString().toLowerCase()+" "+Constants.firstsause +" =%n")+
                String.format("= "+IngredientType.FILLING.toString().toLowerCase()+" "+Constants.firstfilling +" =%n")+
                String.format("(==== "+Constants.buntwo+" ====)%n")+
                String.format("%n")+
                String.format("Price: %f%n",(Constants.buntwoprice *2+Constants.firstsouseprice+Constants.firstfillingprice));

        Assert.assertEquals(str, burger.getReceipt());


    }
}
