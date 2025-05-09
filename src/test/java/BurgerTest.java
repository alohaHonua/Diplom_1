import praktikum.Burger;
import org.junit.Test;
import praktikum.Bun;
import praktikum.Ingredient;
import praktikum.IngredientType;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class BurgerTest {
    @Test
    public void setBunsTest() {
        Burger burger = new Burger();
        Bun bun = new Bun("Космос-булка", 10.9f);
        burger.setBuns(bun);
        assertEquals("Булка создалась с нужными параметрами", bun, burger.bun);
    }

    @Test
    public void addIngredientTest() {
        Burger burger = new Burger();
        Ingredient ingredient = new Ingredient(IngredientType.FILLING, "Космические перцы", 13.11f);
        burger.addIngredient(ingredient);
        assertTrue("Новый ингредиент корректно добавился", burger.ingredients.contains(ingredient));
    }

    @Test
    public void removeIngredientTest() {
        Burger burger = new Burger();
        Ingredient ingredient = new Ingredient(IngredientType.FILLING, "Космические перцы", 13.11f);
        burger.addIngredient(ingredient);
        burger.removeIngredient(0);
        assertTrue("Ингредиент корректно удален", burger.ingredients.isEmpty());
    }

    @Test
    public void moveIngredientTest() {
        Burger burger = new Burger();
        Ingredient[] ingredientsArray = new Ingredient[]{
                new Ingredient(IngredientType.FILLING, "Космические перцы", 13.11f),
                new Ingredient(IngredientType.SAUCE, "Томатный соус", 5.0f)
        };

        for (Ingredient ingredient : ingredientsArray) {
            burger.addIngredient(ingredient);
        }
        burger.moveIngredient(0, 1);
        assertEquals("Ингредиент на позиции 0 должен быть Томатный соус",
                "Томатный соус", burger.ingredients.get(0).getName());
        assertEquals("Ингредиент на позиции 1 должен быть Космические перцы",
                "Космические перцы", burger.ingredients.get(1).getName());
    }

    @Test
    public void getPriceTest() {
        Burger burger = new Burger();
        Bun bun = new Bun("Космос-булка", 10.5f);
        burger.setBuns(bun);
        Ingredient[] ingredientsArray = new Ingredient[]{
                new Ingredient(IngredientType.FILLING, "Космические перцы", 13.11f),
                new Ingredient(IngredientType.SAUCE, "Томатный соус", 5f)
        };
        for (Ingredient ingredient : ingredientsArray) {
            burger.addIngredient(ingredient);
        }
        float expectedPrice = 10.5f * 2 + 13.11f + 5f;
        assertEquals("Цена считается корректно", expectedPrice, burger.getPrice(), 0.001f);
    }
    @Test
    public void getReceiptTest(){
        Burger burger = new Burger();
        Bun bun = new Bun("Космос-булка", 10.5f);
        burger.setBuns(bun);
        Ingredient ingredient = new Ingredient(IngredientType.FILLING, "Космические перцы", 13.11f);
        burger.addIngredient(ingredient);
        String expectedReceipt = String.format("(==== %s ====)\n", bun.getName()) +
                String.format("= %s %s =\n", ingredient.getType().toString().toLowerCase(), ingredient.getName()) +
                String.format("(==== %s ====)\n\n", bun.getName()) +
                String.format("Price: %f\n", burger.getPrice());

        assertEquals("Чек отображается корректно", expectedReceipt, burger.getReceipt());
    }



}

