import praktikum.Burger;
import praktikum.Database;
import praktikum.Ingredient;

import java.util.List;

public class BaseObjectBurger {

    public Ingredient getIndexListFromAddRemoveIngredient(Burger burger, int index){
        Database database = new Database();
        List<Ingredient> getDataBase = database.availableIngredients();
        //впихнули в список данных переменной getDataBase то, что впихнулось в метод availableIngredients()
        //то есть список доступных ингридентов
        Ingredient getIndexList = getDataBase.get(index);
        //впихнули в переменную getIndexList список из БД под номером из переменной index
        System.out.println("Что сейчас в переменной getIndexList? " + getIndexList);
        burger.addIngredient(getIndexList);
        //добавили в список ингридентов список данных из номера индекса переменной getIndexList
        //теперь под 0 индексом добавленный из переменной getIndexList список
        return getIndexList;
    }

    public List<Integer> getIndexListFromMoveIngredient(Burger burger, int index, int addIndexNext, int newIndex){
        Database database = new Database();
        List<Ingredient> getDataBase = database.availableIngredients();
        Ingredient getIndexList = getDataBase.get(index);
        Ingredient getNextIndexList = getDataBase.get(addIndexNext);
        //впихнули в переменную getNextIndexList список из БД под номером из переменной addIndexNext
        System.out.println("Что сейчас в переменной getIndexList? " + getIndexList);
        System.out.println("Что сейчас в переменной getNextIndexList? " + getNextIndexList);
        burger.addIngredient(getIndexList);
        burger.addIngredient(getNextIndexList);
        //добавили в список ингридентов список данных из номера индекса переменной getNextIndexList
        //теперь под 1 индексом добавленный из переменной getNextIndexList список
        burger.moveIngredient(addIndexNext, newIndex);
        //переместили данные с индексом addIndexNext в индекс newIndexMove - переписали их

        return List.of(addIndexNext, newIndex);//возвращает список значений переменных -
        // значение из переменной addIndexNext и значение из переменной newIndex
    }
}
