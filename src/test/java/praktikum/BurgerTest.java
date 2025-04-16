package praktikum;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

public class BurgerTest {

    private Burger burger;
    private Bun bunMock;
    private Ingredient ketchupStub;
    private Ingredient baconMock;

    @Before
    public void setUp() {
        burger = new Burger();

        // мок для булочки (проверим взаимодействие с getPrice и getName)
        bunMock = mock(Bun.class);
        when(bunMock.getName()).thenReturn("Черная булочка");
        when(bunMock.getPrice()).thenReturn(0.111f);

        // стаб — реальный объект ингредиента
        ketchupStub = new Ingredient(IngredientType.SAUCE, "Кетчуп", 0.52f);

        // мок ингредиента
        baconMock = mock(Ingredient.class);
        when(baconMock.getType()).thenReturn(IngredientType.FILLING);
        when(baconMock.getName()).thenReturn("Бекон");
        when(baconMock.getPrice()).thenReturn(115.0f);
    }

    // Проверяем установку булки через мок
    @Test
    public void setBuns_WithMockTest() {
        burger.setBuns(bunMock);
        assertEquals("Булочка должна быть установлена", bunMock, burger.bun);
    }

    // Проверяем добавление ингредиента-стаба
    @Test
    public void addIngredient_WithStubTest() {
        burger.addIngredient(ketchupStub);
        assertEquals("Ингредиент должен быть добавлен", 1, burger.ingredients.size());
        assertEquals("Добавлен неправильный ингредиент", ketchupStub, burger.ingredients.get(0));
    }

    // Проверяем удаление ингредиента
    @Test
    public void removeIngredientTest() {
        burger.addIngredient(ketchupStub);
        burger.removeIngredient(0);
        assertTrue("Список ингредиентов должен быть пуст", burger.ingredients.isEmpty());
    }

    // Проверяем перемещение ингредиентов
    @Test
    public void moveIngredientTest() {
        burger.addIngredient(ketchupStub);
        burger.addIngredient(baconMock);
        burger.moveIngredient(1, 0);
        assertEquals("Ингредиенты перемешаны неправильно", baconMock, burger.ingredients.get(0));
    }

    // Проверяем корректный расчет стоимости бургера
    @Test
    public void getPrice_WithMixTest() {
        burger.setBuns(bunMock);             // 0.111 * 2
        burger.addIngredient(ketchupStub);   // 0.52
        burger.addIngredient(baconMock);     // 115.0
        float expected = 0.111f * 2 + 0.52f + 115.0f;
        assertEquals("Цена бургера рассчитана неверно", expected, burger.getPrice(), 0.001f);
    }

    // Проверяем генерацию чека — используются моки и стабы
    @Test
    public void getReceipt_WithMocksAndStubsTest() {
        burger.setBuns(bunMock);
        burger.addIngredient(ketchupStub);
        burger.addIngredient(baconMock);

        String receipt = burger.getReceipt();
        String expectedPrice = String.format("Price: %.6f", burger.getPrice());

        assertTrue("Чек должен содержать имя булки", receipt.contains("(==== Черная булочка ====)"));
        assertTrue("Чек должен содержать соус", receipt.contains("= sauce Кетчуп ="));
        assertTrue("Чек должен содержать начинку", receipt.contains("= filling Бекон ="));
        assertTrue("Чек должен содержать итоговую цену", receipt.contains(expectedPrice));
    }
}
