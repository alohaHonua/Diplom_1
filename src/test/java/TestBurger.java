import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.Spy;
import org.mockito.junit.MockitoJUnitRunner;
import praktikum.*;

import java.util.List;

@RunWith(MockitoJUnitRunner.class)
public class TestBurger {

   // @Mock
    //Bun bun;
  @Mock
  Ingredient ingredient1;
    @Spy
    Burger burger;

//    @Test
//    public void testAddIngredient(){
//        burger.addIngredient(ingredient);
//        Mockito.verify(burger, Mockito.times(1)).addIngredient(ingredient);
//    }

    @Test
    public void testSetBuns(){
        Database database = new Database();
        List<Bun> bunsGetDataBase = database.availableBuns();
        Bun getIndexList = bunsGetDataBase.get(0);
        burger.setBuns(getIndexList);
        Mockito.verify(burger, Mockito.times(1)).setBuns(getIndexList);
//        burger.setBuns(bun);
//        Mockito.verify(burger, Mockito.times(1)).setBuns(bun);
    }
    @Test
    public void testAddIngredient(){
        //Database database = new Database();
        //List<Ingredient> getDataBase = database.availableIngredients();
        //Ingredient getIndexList = getDataBase.get(0);
        //System.out.println(getIndexList);
        //burger.addIngredient(getIndexList);//проверили что данные вообще добавляются
        BaseObjectBurger baseObjectBurger = new BaseObjectBurger();
        Ingredient getIndexList = baseObjectBurger.getIndexListFromAddRemoveIngredient(burger, 0);
        Mockito.verify(burger, Mockito.times(1)).addIngredient(getIndexList);
    }

    @Test
    public void testRemoveIngredient(){
        //Database database = new Database();
        //List<Ingredient> getDataBase = database.availableIngredients();
        //Ingredient getIndexList = getDataBase.get(1);
        //System.out.println(getIndexList);
        //burger.addIngredient(getIndexList);//добавили данные из БД через метод
        BaseObjectBurger baseObjectBurger = new BaseObjectBurger();
        baseObjectBurger.getIndexListFromAddRemoveIngredient(burger, 1);
        //добавили в список данные
        //хранящиеся под 1 индексом в БД
        burger.removeIngredient(0);//и сразу удалили. Индекс 0, так как пока
        //в списке только один список с 0ым индексом
        Mockito.verify(burger, Mockito.times(1)).removeIngredient(0);
    }

    @Test
    public void testMoveIngredient(){
        //Database database = new Database();
        //List<Ingredient> getDataBase = database.availableIngredients();
        //Ingredient getIndexList = getDataBase.get(1);
        //Ingredient getNextIndexList = getDataBase.get(2);//получили список с ингредиентами
        //System.out.println(getIndexList);
        //burger.addIngredient(getIndexList);//поместили данные из 1 индекса в игриденты, теперь эти данные
        //имеют 0 индекс
        //burger.addIngredient(getNextIndexList);//поместили данные из 1 индекса в игриденты, теперь эти данные
        //имеют 1 индекс
        //burger.moveIngredient(1, 0);//сделали данные под индексом 1 первыми
        //поставив их на 0 индекс и стерев старые данные
        BaseObjectBurger baseObjectBurger = new BaseObjectBurger();
        List<Integer> result = baseObjectBurger.getIndexListFromMoveIngredient(burger, 1, 0, 0);
        int index = result.get(0);//вытянули из переменной result возвращаемое методом getIndexListFromMoveIngredient
        int newIndex = result.get(1);//тоже вытянули значение переменной result выданное методом getIndexListFromMoveIngredient
        Mockito.verify(burger, Mockito.times(1)).moveIngredient(index, newIndex);
    }

    @Test
    public void testGetPrice(){
          Database database = new Database();
        List<Bun> bunsGetDataBase = database.availableBuns();
        Bun getIndex = bunsGetDataBase.get(0);
        //впихнули в переменную getIndex список под 0 индексом из БД
        System.out.println("Что же сейчас лежит в setBun? " + getIndex);
        burger.setBuns(getIndex);
        List<Ingredient> ingredients = database.availableIngredients();
        burger.addIngredient(ingredients.get(0));
        burger.addIngredient(ingredients.get(1));
        float actual = burger.getPrice();
        System.out.println("Ожидаемый результат " + actual);
        float expected = bunsGetDataBase.get(0).price * 2 + ingredients.get(0).price + ingredients.get(1).price;
        System.out.println("Сложение цены булочки из метода bunsGetDataBase.get(0) и ингредиентов из метода burger.getPrice() "
                + expected);
        Assert.assertEquals(expected, actual, 0);
//          List<Bun> bunDataBase = database.availableBuns();
//          String nameBun = String.valueOf(bunDataBase.get(0).name);
//          float priceBun = Float.parseFloat(String.valueOf(bunDataBase.get(0).price));
//          System.out.println("Имя булочки " + nameBun);
//          System.out.println("Цена булочки " + priceBun);
//          List<Ingredient> ingredientsDataBase = database.availableIngredients();
//          IngredientType ingredientType = ingredientsDataBase.get(0).type;
//          String nameIngredient = String.valueOf(ingredientsDataBase.get(0).name);
//          float priceIngredient = Float.parseFloat(String.valueOf(ingredientsDataBase.get(0).price));
//          System.out.println("Тип ингредиента " + ingredientType);
//          System.out.println("Название игредиента " + nameIngredient);
//          System.out.println("Цена " + priceIngredient);


    }

    @Test
    public void getReceipt(){

    }
}
