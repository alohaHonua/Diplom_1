package praktikum;

import datagenerator.DataGenerator;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class BurgerTest {
    private Burger burger;

    @Mock
    private Bun bun;
    @Mock
    private Ingredient ingredient1, ingredient2, ingredient3;

    @Before
    public void createBurger() {
        burger = new Burger();
    }

    @Test
    public void setBunTest() {
        burger.setBuns(bun);

        assertEquals("Не соответствует булочка", bun.getName(), burger.bun.getName());
    }

    @Test
    public void addIngredientTest() {
        burger.addIngredient(ingredient1);
        burger.addIngredient(ingredient2);
        assertEquals("Количество ингредиентов не соответствует ожидаемому", 2, burger.ingredients.size());
        assertEquals("Ingredient1 не соответствует ожидаемому", ingredient1.getName(), burger.ingredients.get(0).getName());
        assertEquals("Ingredient2 не соответствует ожидаемому", ingredient2.getName(), burger.ingredients.get(1).getName());;
    }

    @Test
    public void removeIngredientTest() {
        burger.addIngredient(ingredient1);
        burger.addIngredient(ingredient2);
        burger.addIngredient(ingredient3);

        burger.removeIngredient(2);

        assertEquals("Ингредиент не был удален",2, burger.ingredients.size());
    }

    @Test
    public void moveIngredientTest() {
        burger.addIngredient(ingredient1);
        burger.addIngredient(ingredient2);
        burger.addIngredient(ingredient3);

        burger.moveIngredient(1, 2);

        assertEquals("Ингредиент не был перемещен", ingredient2, burger.ingredients.get(2));
        assertEquals("Ингредиент не был перемещен", ingredient3, burger.ingredients.get(1));
    }

    @Test
    public void getPriceTest() {
        burger.setBuns(bun);
        burger.addIngredient(ingredient1);
        burger.addIngredient(ingredient2);

        float bunPrice = DataGenerator.generateRandomBunPrice();
        float ingredient1Price = DataGenerator.generateRandomIngredientPrice();
        float ingredient2Price = DataGenerator.generateRandomIngredientPrice();

        when(bun.getPrice()).thenReturn(bunPrice);
        when(ingredient1.getPrice()).thenReturn(ingredient1Price);
        when(ingredient2.getPrice()).thenReturn(ingredient2Price);

        float expectedBurgerPrice = bunPrice*2 + ingredient1Price + ingredient2Price;

        assertEquals("Не соответствует общая цена бургера", expectedBurgerPrice, burger.getPrice(), 0.0);
    }

    @Test
    public void getReceiptTest() {
        burger.setBuns(bun);
        burger.addIngredient(ingredient1);

        String bunName = DataGenerator.generateBunName();
        float bunPrice = DataGenerator.generateRandomBunPrice();
        float ingredient1Price = DataGenerator.generateRandomIngredientPrice();
        String ingredientName = DataGenerator.generateIngredientName();

        when(bun.getName()).thenReturn(bunName);
        when(bun.getPrice()).thenReturn(bunPrice);
        when(ingredient1.getPrice()).thenReturn(ingredient1Price);
        when(ingredient1.getName()).thenReturn(ingredientName);
        when(ingredient1.getType()).thenReturn(IngredientType.SAUCE);

        StringBuilder expectedReceipt = new StringBuilder(String.format("(==== %s ====)%n", bun.getName()));

        expectedReceipt.append(String.format("= %s %s =%n", ingredient1.getType().toString().toLowerCase(),
                ingredient1.getName()));
        expectedReceipt.append(String.format("(==== %s ====)%n", bun.getName()));
        expectedReceipt.append(String.format("%nPrice: %f%n", burger.getPrice()));

        assertEquals("Не соответствует чек с информацией о бургере",expectedReceipt.toString(),burger.getReceipt());
    }

}
