package praktikum;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;
import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

public class BurgerTest {

    private Burger burger;
    private Bun bun;
    private Ingredient ingredient1;
    private Ingredient ingredient2;
    private Ingredient ingredient3;

    @Before
    public void setup() {
        // МОК булочки
        bun = Mockito.mock(Bun.class);
        when(bun.getPrice()).thenReturn(100.0f);
        when(bun.getName()).thenReturn("black bun");

        // МОКИ ингредиентов
        ingredient1 = Mockito.mock(Ingredient.class);
        when(ingredient1.getPrice()).thenReturn(100.0f);
        when(ingredient1.getName()).thenReturn("hot sauce");
        when(ingredient1.getType()).thenReturn(IngredientType.SAUCE);

        ingredient2 = Mockito.mock(Ingredient.class);
        when(ingredient2.getPrice()).thenReturn(100.0f);
        when(ingredient2.getName()).thenReturn("cutlet");
        when(ingredient2.getType()).thenReturn(IngredientType.FILLING);

        ingredient3 = Mockito.mock(Ingredient.class);
        when(ingredient3.getPrice()).thenReturn(200.0f);
        when(ingredient3.getName()).thenReturn("dinosaur");
        when(ingredient3.getType()).thenReturn(IngredientType.FILLING);

        // Инициализация бургера
        burger = new Burger();
        burger.setBuns(bun);
        burger.addIngredient(ingredient1);
        burger.addIngredient(ingredient2);
    }

    @Test
    public void testSetBuns() {

        assertEquals("Установилась неверная булочка", "black bun", burger.bun.getName());
    }

    @Test
    public void testAddIngredient() {
        burger.addIngredient(ingredient3);

        assertEquals("Размер списка ингредиентов после добавления не увеличился",3, burger.ingredients.size());
        assertEquals("Добавленный ингредиент находится не в конце списка", ingredient3, burger.ingredients.get(2));
    }

    @Test
    public void testRemoveIngredient() {
        burger.removeIngredient(0);

        assertEquals("Размер списка ингредиентов после удаления не уменьшился",1, burger.ingredients.size());
        assertEquals("Ингредиенты после удаления не на своем месте", ingredient2, burger.ingredients.get(0));
    }

    @Test
    public void testMoveIngredient() {
        burger.addIngredient(ingredient3); // Добавляем третий ингредиент
        burger.moveIngredient(2, 0); // Перемещаем его на первую позицию

        assertEquals("Ингредиенты после перемещения не на своем месте в списке", ingredient3, burger.ingredients.get(0));
        assertEquals("Ингредиенты после перемещения не на своем месте в списке", ingredient1, burger.ingredients.get(1));
        assertEquals("Ингредиенты после перемещения не на своем месте в списке", ingredient2, burger.ingredients.get(2));
    }

    @Test
    public void testGetPrice() {
        float expectedPrice = (100.0f * 2) + 100.0f + 100.0f;

        assertEquals("Расчет общей стоимости бургера не точен", expectedPrice, burger.getPrice(), 0.01f);
    }

    @Test
    public void testGetReceipt() {

        String expectedReceipt = String.format("(==== %s ====)%n", bun.getName()) +
                String.format("= %s %s =%n", ingredient1.getType().toString().toLowerCase(), ingredient1.getName()) +
                String.format("= %s %s =%n", ingredient2.getType().toString().toLowerCase(), ingredient2.getName()) +
                String.format("(==== %s ====)%n", bun.getName()) +
                String.format("%nPrice: %f%n", burger.getPrice());

        assertEquals("Чек сформирован некорректно", expectedReceipt, burger.getReceipt());
    }
}