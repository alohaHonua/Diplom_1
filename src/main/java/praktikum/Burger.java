package praktikum;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

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

    public void removeIngredient(int index) {
        ingredients.remove(index);
    }

    public void moveIngredient(int index, int newIndex) {
        ingredients.add(newIndex, ingredients.remove(index));
    }

    public float getPrice() {
        float price = bun.getPrice() * 2;

        for (Ingredient ingredient : ingredients) {
            price += ingredient.getPrice();
        }

        return price;
    }
    public String getReceipt() {
        StringBuilder receipt = new StringBuilder();
        receipt.append("(==== ").append(bun.getName()).append(" ====)\n");
        for (Ingredient ingredient : ingredients) {
            receipt.append("= ").append(ingredient.getType().toString().toLowerCase()).append(" ").append(ingredient.getName()).append(" =\n");
        }
        receipt.append("(==== ").append(bun.getName()).append(" ====)\n");
        receipt.append("\nPrice: ").append(String.format(Locale.US, "%.6f", getPrice())).append("\n");
        return receipt.toString();
    }
}