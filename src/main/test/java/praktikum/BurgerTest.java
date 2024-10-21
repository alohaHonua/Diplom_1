package praktikum;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.List;

import static org.junit.Assert.assertEquals;

@RunWith(MockitoJUnitRunner.class)
public class BurgerTest {
    // Объявляю переменные, которые будут использоваться в тестах
    // Создаю заглушки для объектов Bun и Ingredient
    @Mock
    private Bun bun;
    @Mock
    private Ingredient ingredient;
    @Mock
    private Ingredient sauce;
    @Mock
    private Ingredient filling;
    private Burger burger;

    @Before
    public void createNewInstance() {
        burger = new Burger();
    }

    // Проверяю, корректно ли установлена булочка в бургер
    @Test
    public void setBuns() {
        burger.setBuns(bun);
        Bun actual = burger.bun;

        assertEquals("Incorrect introduction of the bun dependency into the burger", bun, actual);
    }

    // Добавляю ингредиент в бургер и потом проверяю, содержится ли он в списке ингредиентов
    @Test
    public void addIngredient() {
        burger.addIngredient(ingredient);
        List<Ingredient> expected = List.of(ingredient);
        List<Ingredient> actual = burger.ingredients;

        assertEquals("Incorrect addition of an ingredient in the list", expected, actual);
    }

    // Добавляю ингредиент в бургер, потом удаляю его. Проверяю, удалился ли он из списка
    @Test
    public void removeIngredient() {
        burger.addIngredient(ingredient);
        burger.removeIngredient(0);
        List<Ingredient> actual = burger.ingredients;

        assertEquals("Incorrect removal of an ingredient in the list", List.of(), actual);
    }

    // Проверяю что добавленные ингредиенты можно перемещать внутри списка
    @Test
    public void moveIngredient() {
        burger.addIngredient(filling);
        burger.addIngredient(sauce);
        burger.moveIngredient(0, 1);
        Ingredient actual = burger.ingredients.get(1);

        assertEquals("Incorrect movement of an ingredient in the list", filling, actual);
    }

    // Создаю чек для бургера а потом проверяю что фактическая строка совпадает с расчитанной
    @Test
    public void getReceipt() {
        Mockito.when(bun.getName()).thenReturn("original");
        Mockito.when(bun.getPrice()).thenReturn(200.0f);
        burger.setBuns(bun);

        Mockito.when(ingredient.getType()).thenReturn(IngredientType.SAUCE);
        Mockito.when(ingredient.getName()).thenReturn("chili");
        Mockito.when(ingredient.getPrice()).thenReturn(20.0f);
        burger.addIngredient(ingredient);

        StringBuilder receipt = new StringBuilder(String.format("(==== %s ====)%n", bun.getName()));
        List<Ingredient> ingredients = burger.ingredients;

        for (Ingredient ingredient : ingredients) {
            receipt.append(String.format("= %s %s =%n", ingredient.getType().name().toLowerCase(),
                    ingredient.getName()));
        }

        receipt.append(String.format("(==== %s ====)%n", bun.getName()));
        receipt.append(String.format("%nPrice: %f%n", burger.getPrice()));

        String expected = receipt.toString();
        String actual = burger.getReceipt();

        assertEquals("Incorrect burger receipt", expected, actual);
    }
}