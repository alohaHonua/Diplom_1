package praktikum;

import java.util.ArrayList;
import java.util.List;

/**
 * Модель бургера.
 * Бургер состоит из булочек и ингредиентов (начинка или соус).
 * Ингредиенты можно перемещать и удалять.
 * Можно распечать чек с информацией о бургере.
 */
public class Burger {

    public Bun bun;
    public List<Ingredient> ingredients = new ArrayList<>();

    public void setBuns(Bun bun) {
        this.bun = bun;
    }

    public void addIngredient(Ingredient ingredient) {
        ingredients.add(ingredient);
    }

    public Ingredient removeIngredient(int index) {
        Ingredient removed = ingredients.remove(index);
        return removed;
    }


    public void moveIngredient(int index, int newIndex) {
        if (newIndex <= ingredients.size()) { // Проверяем, что newIndex не превышает размер списка
            ingredients.add(newIndex, ingredients.remove(index));
        } else {
            throw new IllegalArgumentException("Новый индекс выходит за пределы");
        }
    }


    public float getPrice() {
        float price = bun.getPrice() * 2;

        for (Ingredient ingredient : ingredients) {
            price += ingredient.getPrice();
        }

        return price;
    }

    public String getReceipt() {
        StringBuilder receipt = new StringBuilder(String.format("(==== %s ====)%n", bun.getName()));

        for (Ingredient ingredient : ingredients) {
            receipt.append(String.format("= %s %s =%n", ingredient.getType().toString().toLowerCase(),
                    ingredient.getName()));
        }

        receipt.append(String.format("(==== %s ====)%n", bun.getName()));
        receipt.append(String.format("%nPrice: %f%n", getPrice()));

        return receipt.toString();
    }
    public List<Ingredient> getIngredients() {
        return ingredients;
    }

}