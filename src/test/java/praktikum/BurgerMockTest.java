package praktikum;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.List;

import static org.junit.Assert.*;

import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class BurgerMockTest {
    @Mock
    Bun bun;
    @Mock
    Ingredient ingredient;
    @Mock
    Ingredient ingredient1;

    Burger burger = new Burger();

    @Test
    public void checkGetPriceTest(){
        burger.setBuns(bun);//добавляем булки в бургер
        when(bun.getPrice()).thenReturn(100F);//присваиваем через мок цену булке
        when(ingredient.getPrice()).thenReturn(20F);//присваиваем через мок цену первому ингредиенту
        when(ingredient1.getPrice()).thenReturn(25.5F);//присваиваем через мок цену второму ингредиенту
        burger.addIngredient(ingredient);//добавляем первый ингредиент в бургер
        burger.addIngredient(ingredient1);//добавляем второй ингредиент в бургер
        float expectedPrice = bun.getPrice() * 2 + ingredient.getPrice() + ingredient1.getPrice();//ожидаемый прайс бургера
        float actualPrice = burger.getPrice();//фактический прайс бургера
        assertEquals("Ожидаемая цена бургера не совпадает с фактической", expectedPrice, actualPrice, 0);
    }

    @Test
    public void checkGetReceiptTest() {
        burger.setBuns(bun);
        when(bun.getName()).thenReturn("Black");
        when(bun.getPrice()).thenReturn(100F);

        burger.addIngredient(ingredient);
        when(ingredient.getType()).thenReturn(IngredientType.SAUCE);
        when(ingredient.getName()).thenReturn("BBQ");
        when(ingredient.getPrice()).thenReturn(45F);

        String expectedReceipt = String.format("(==== %s ====)%n", bun.getName()) + String.format("= %s %s =%n", ingredient.getType().toString().toLowerCase(),
                ingredient.getName()) +
                String.format("(==== %s ====)%n", bun.getName()) +
                String.format("%nPrice: %f%n", burger.getPrice());
        String actualReceipt = burger.getReceipt();
        assertEquals("Ожидаемый чек не совпадает с фактическим", expectedReceipt, actualReceipt);
    }

    @Test
    public void checkAddIngredientTest(){
        burger.addIngredient(ingredient);
        burger.addIngredient(ingredient1);
        List<Ingredient> expectedIngredients = List.of(ingredient, ingredient1);
        List<Ingredient> actualIngredients =  burger.ingredients;
        assertEquals("Ожидаемые и фактические ингредиенты не совпадают",expectedIngredients, actualIngredients);
    }

    @Test
    public void checkRemoveIngredientTest(){
        burger.addIngredient(ingredient);
        burger.addIngredient(ingredient1);
        burger.removeIngredient(0);
        List<Ingredient> expectedIngredients = List.of(ingredient1);
        List<Ingredient> actualIngredients =  burger.ingredients;
        assertEquals("Ожидаемые и фактические ингредиенты не совпадают",expectedIngredients, actualIngredients);
        System.out.println(expectedIngredients);
    }

    @Test
    public void checkMoveIngredientTest(){
        burger.addIngredient(ingredient);
        burger.addIngredient(ingredient1);
        burger.moveIngredient(0, 1);
        List<Ingredient> expectedIngredients = List.of(ingredient1, ingredient);
        List<Ingredient> actualIngredients =  burger.ingredients;
        assertEquals("Ожидаемые и фактические ингредиенты не совпадают",expectedIngredients, actualIngredients);
    }

}
