import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.Spy;
import org.mockito.junit.MockitoJUnitRunner;
import praktikum.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@RunWith(MockitoJUnitRunner.class)
public class BugerNewTest {

    @Mock
    Bun bun;
    @Mock
    Ingredient ingredient;
    @Mock
    Ingredient ingredient2;
    @Spy
    Burger burger;
    @Spy
    List<Ingredient> ingredients = new ArrayList<>();

    @Before
    public void setIngredients(){
        Mockito.when(ingredient.getType()).thenReturn(IngredientType.FILLING);
        Mockito.when(ingredient.getName()).thenReturn("cutlet");
        Mockito.when(ingredient.getPrice()).thenReturn(100F);
        Mockito.when(ingredient2.getType()).thenReturn(IngredientType.FILLING);
        Mockito.when(ingredient2.getName()).thenReturn("dinosaur");
        Mockito.when(ingredient2.getPrice()).thenReturn(200F);

        Mockito.when(bun.getName()).thenReturn("супербулка");
        Mockito.when(bun.getPrice()).thenReturn(300F);
    }

    @Test
    public void addIngredientTest(){
        //добавили в методы класса Ingredient данные
        System.out.println(ingredient.getName());
        System.out.println(ingredient.getPrice());
        System.out.println(ingredient.getType());
        //надобавляли ингредиентов
        burger.addIngredient(ingredient);
        //вызвали метод с добавленными ингредиентами из класса бургер
        Assert.assertEquals(ingredient, burger.ingredients.get(0));
        //проверили, что то, что мы поместили в ингредиенты возвращается
        //через класс бургер при вызове списка ингредиентов
    }

    @Test
    public void removeIngredientTest(){
        burger.addIngredient(ingredient);
        burger.addIngredient(ingredient2);
        //добавили ингредиенты
        burger.removeIngredient(0);
        //убрали список под 0 индексом
        Assert.assertEquals(ingredient2, burger.ingredients.get(0));
        //проверили, что теперь ингредиенты под 1 индексом после удаления списка под 0 индексом
        //заняли его место - и стали ингредиентами под индексом 0
    }

    @Test
    public void moveIngredientTest(){
        burger.addIngredient(ingredient);
        burger.addIngredient(ingredient2);
        burger.moveIngredient(0, 1);
        //поменяли списки ингредиентов местами
        Assert.assertEquals(ingredient, burger.ingredients.get(1));
        Assert.assertEquals(ingredient2, burger.ingredients.get(0));
        //проверили, что список под индексом 0 теперь стоит под индексом 1
        //проверили, что список под индексом 1 стоит под индексом 0
    }

    @Test
    public void testGetPrice(){
        burger.setBuns(bun);
        //поместили булочки с ценами
        burger.addIngredient(ingredient);
        burger.addIngredient(ingredient2);
        //поместили ингредиенты с ценами
        float actual = burger.getPrice();
        System.out.println("ОР " + actual);
        float expected = bun.getPrice() * 2 + ingredient.getPrice() + ingredient2.getPrice();
        System.out.println("ФР " + expected);
        Assert.assertEquals(expected, actual, 0.0);
    }

    @Test
    public void testGetReceipt(){
        //доделать
        burger.setBuns(bun);
        Mockito.when(ingredient.getName()).thenReturn("hot sauce");
        Mockito.when(ingredient2.getName()).thenReturn("dinosaur");
        String actual = burger.getReceipt();
        System.out.println("ФР\n" + actual);
        String expected =
                String.format("(==== %s ====)%n", bun.getName()) +
                        String.format(ingredient.getName()) +
                        String.format("(==== %s ====)%n", bun.getName());
        System.out.println("ОР " + expected);
    }
}
