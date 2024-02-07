package praktikum;

import java.util.List;

public class Praktikum {
    public static void main(String[] args) {
        // Инициализировать базу данных
        Database database = new Database();
        // Создание нового бургера
        Burger burger = new Burger();
        // Получить список доступных булок из базы данных
        List<Bun> buns = database.availableBuns();
        // Получить список доступных ингредиентов из базы данных
        List<Ingredient> ingredients = database.availableIngredients();
        // Собрать бургер
        burger.setBuns(buns.get(0));
        burger.addIngredient(ingredients.get(1));
        burger.addIngredient(ingredients.get(4));
        burger.addIngredient(ingredients.get(3));
        burger.addIngredient(ingredients.get(5));

        // Переместить слой с ингредиентом
        burger.moveIngredient(2, 1);

        // Удалить ингредиент
        burger.removeIngredient(3);

        // Распечатать рецепт бургера
        System.out.println(burger.getReceipt());
    }
}