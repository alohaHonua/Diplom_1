import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import praktikum.Bun;
import praktikum.Burger;
import praktikum.Ingredient;
import praktikum.IngredientType;

import java.util.List;

@RunWith(MockitoJUnitRunner.class)
public class BurgerTest {
    @Mock
    Bun bun;
    @Mock
    Ingredient ingredient;
    @Mock
    Ingredient movealbleIngredient;

    Burger burger;
    private final int FIRST_INGREDIENT_INDEX = 0;
    private final int SIZE_OF_EMPTY_LIST = 0;

    @Before
    public void setup() {
        burger = new Burger();
    }

    @Test
    public void setBunsTest() {
        burger.setBuns(bun);
        Assert.assertEquals(bun, burger.bun);
    }

    @Test
    public void addIngredientTest() {
        burger.addIngredient(ingredient);
        Assert.assertEquals(ingredient, burger.ingredients.get(FIRST_INGREDIENT_INDEX));
    }

    @Test
    public void removeIngredientTest() {
        burger.ingredients.add(ingredient); //добавить ингредиент
        burger.removeIngredient(FIRST_INGREDIENT_INDEX); //удалить ингредиент
        Assert.assertEquals(SIZE_OF_EMPTY_LIST, burger.ingredients.size());
    }

    @Test
    public void moveIngredientTest() {
        burger.ingredients.add(ingredient);
        burger.ingredients.add(movealbleIngredient);
        burger.ingredients.add(ingredient);
        burger.ingredients.add(ingredient);
        int originalIngredientIndex = burger.ingredients.indexOf(movealbleIngredient);
        int movedIngredientIndex = burger.ingredients.indexOf(movealbleIngredient)+2;
        burger.moveIngredient(originalIngredientIndex, movedIngredientIndex);
        Assert.assertEquals(movealbleIngredient, burger.ingredients.get(movedIngredientIndex));
    }

    @Test
    public void getPriceTest() {
        Mockito.when(bun.getPrice()).thenReturn(100f);
        Mockito.when(ingredient.getPrice()).thenReturn(100f);
        burger.bun = bun;
        burger.ingredients = List.of(ingredient);
        float expectedPrice = (bun.getPrice() * 2) + ingredient.getPrice();
        Assert.assertEquals(expectedPrice, burger.getPrice(), 0.1f);
    }

    @Test
    public void getReceiptTest() {
        //Создание необходимых стабов
        burger.bun = bun;
        burger.ingredients = List.of(ingredient);
        Mockito.when(bun.getName()).thenReturn("ТЕСТОВАЯ БУЛКА");
        Mockito.when(ingredient.getType()).thenReturn(IngredientType.FILLING);
        Mockito.when(ingredient.getName()).thenReturn("ТЕСТОВЫЙ ИНГРЕДИЕНТ");
        Mockito.when(bun.getPrice()).thenReturn(100f);
        Mockito.when(ingredient.getPrice()).thenReturn(100f);

        //Создание ожидаемого чека
        String expectedReceipt = String.format("(==== %s ====)%n", "ТЕСТОВАЯ БУЛКА") + String.format("= %s %s =%n", IngredientType.FILLING.toString().toLowerCase(), "ТЕСТОВЫЙ ИНГРЕДИЕНТ") +
                String.format("(==== %s ====)%n", "ТЕСТОВАЯ БУЛКА") +
                String.format("%nPrice: %f%n", burger.getPrice());

        //метод compareTo возвращает 0, если объекты одинаковые
        Assert.assertEquals(0, burger.getReceipt().compareTo(expectedReceipt));

    }
}
