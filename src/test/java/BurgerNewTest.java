import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.Spy;
import org.mockito.junit.MockitoJUnitRunner;
import praktikum.*;

@RunWith(MockitoJUnitRunner.class)
public class BurgerNewTest {

    @Mock
    Bun bun;
    @Mock
    Ingredient ingredient;
    @Mock
    Ingredient ingredient2;
    @Spy
    Burger burger;


    @Before
    public void setIngredients(){
        //добавили в методы класса Ingredient данные
        Mockito.when(ingredient.getType()).thenReturn(IngredientType.FILLING);
        Mockito.when(ingredient.getName()).thenReturn("cutlet");
        Mockito.when(ingredient.getPrice()).thenReturn(100F);

        //добавили в метод класса Бургер данные о булках
        Mockito.when(bun.getName()).thenReturn("супербулка");
        Mockito.when(bun.getPrice()).thenReturn(300F);
    }

    @Test
    public void setBunsTest(){
        burger.setBuns(bun);
        Assert.assertEquals(bun, burger.bun);
        //поместили в класс бургер булки и проверили, что там есть булки
    }

    @Test
    public void addIngredientTest(){
        //надобавляли ингредиентов в сам метод
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
        //поместили ингредиенты с ценами
        float actual = burger.getPrice();
        System.out.println("ОР " + actual);
        float expected = bun.getPrice() * 2 + ingredient.getPrice();
        //перемножили цену двух булок с ценами на игредиенты
        System.out.println("ФР " + expected);
        Assert.assertEquals(expected, actual, 0.0);
    }

    @Test
    public void testGetReceipt(){
        burger.setBuns(bun);
        //положили булки
        burger.addIngredient(ingredient);
        //положили ингредиенты
        String actual = burger.getReceipt();
        System.out.println("ФР\n" + actual);
        String expected =
                String.format("(==== %s ====)%n", bun.getName()) +
                String.format("= %s %s =%n",
                        ingredient.getType().toString().toLowerCase(), ingredient.getName()) +
                String.format("(==== %s ====)%n", bun.getName()) +
                String.format(String.format("%nPrice: %f%n", burger.getPrice()));
        System.out.println("ОР \n" + expected);
        Assert.assertEquals(expected, actual);
        //сравнили результаты
    }
}
