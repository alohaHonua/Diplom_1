package praktikum;

import java.util.ArrayList;
import java.util.List;

/**
 * Класс с методами по работе с базой данных.
 */
public class Database {

    private final List<Bun> buns = new ArrayList<>();
    private final List<Ingredient> ingredients = new ArrayList<>();

    public Database() {
        buns.add(new Bun("Флюоресцентная булка R2-D3", 988));
        buns.add(new Bun("Краторная булка N-200i", 1255));

        ingredients.add(new Ingredient(IngredientType.SAUCE, "Spicy-X", 90));
        ingredients.add(new Ingredient(IngredientType.SAUCE, "Фирменный Space Sauce", 80));
        ingredients.add(new Ingredient(IngredientType.SAUCE, "Традиционный галактический", 15));
        ingredients.add(new Ingredient(IngredientType.SAUCE, "С шипами Антарианского плоскоходца", 88));

        ingredients.add(new Ingredient(IngredientType.FILLING, "Мясо бессмертных моллюсков Protostomia", 1337));
        ingredients.add(new Ingredient(IngredientType.FILLING, "Говяжий метеорит (отбивная)", 3000));
        ingredients.add(new Ingredient(IngredientType.FILLING, "Биокотлета из марсианской Магнолии", 424));
        ingredients.add(new Ingredient(IngredientType.FILLING, "Филе Люминесцентного тетраодонтимформа", 988));
        ingredients.add(new Ingredient(IngredientType.FILLING, "Хрустящие минеральные кольца", 300));
        ingredients.add(new Ingredient(IngredientType.FILLING, "Плоды Фалленианского дерева", 874));
        ingredients.add(new Ingredient(IngredientType.FILLING, "Кристаллы марсианских альфа-сахаридов", 762));
        ingredients.add(new Ingredient(IngredientType.FILLING, "Мини-салат Экзо-Плантаго", 4400));
        ingredients.add(new Ingredient(IngredientType.FILLING, "Сыр с астероидной плесенью", 4142));
    }

    public List<Bun> availableBuns() {
        return buns;
    }

    public List<Ingredient> availableIngredients() {
        return ingredients;
    }

}