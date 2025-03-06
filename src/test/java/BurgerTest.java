import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import org.assertj.core.api.SoftAssertions;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;
import ru.practikum.yandex.Bun;
import ru.practikum.yandex.Burger;
import ru.practikum.yandex.Ingredient;
import ru.practikum.yandex.IngredientType;

import java.util.List;

@RunWith(MockitoJUnitRunner.class)
public class BurgerTest {

    @Mock
    private Bun mockBun;

    @Mock
    private Ingredient mockIngredient1;

    @Mock
    private Ingredient mockIngredient2;

    private Burger burger;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);

        // Настройка значений для моков
        when(mockBun.getPrice()).thenReturn(50.0f);
        when(mockBun.getName()).thenReturn("Sesame Bun");

        when(mockIngredient1.getPrice()).thenReturn(20.0f);
        when(mockIngredient1.getName()).thenReturn("Lettuce");
        when(mockIngredient1.getType()).thenReturn(IngredientType.FILLING);

        when(mockIngredient2.getPrice()).thenReturn(30.0f);
        when(mockIngredient2.getName()).thenReturn("Ketchup");
        when(mockIngredient2.getType()).thenReturn(IngredientType.SAUCE);

        burger = new Burger();
        burger.setBuns(mockBun);
    }

    @Test
    public void addIngredientTest() {
        int initialSize = burger.ingredients.size();

        burger.addIngredient(mockIngredient1);
        burger.addIngredient(mockIngredient2);

        assertEquals("Размер ингредиентов после добавления должен увеличиться на 2", initialSize + 2, burger.ingredients.size());
    }

    @Test
    public void removeIngredientTest() {
        burger.addIngredient(mockIngredient1);
        burger.addIngredient(mockIngredient2);
        int initialSize = burger.ingredients.size();

        burger.removeIngredient(0);

        assertEquals("Размер ингредиентов после удаления одного должен уменьшиться на 1", initialSize - 1, burger.ingredients.size());
    }

    @Test
    public void moveIngredientTest() {
        // Создание экземпляра бургера и добавление ингредиентов
        burger.addIngredient(mockIngredient1);
        burger.addIngredient(mockIngredient2);

        // Перемещение с первой позиции на вторую
        burger.moveIngredient(0, 1);

        List<Ingredient> ingredients = burger.ingredients;

        SoftAssertions softAssertions = new SoftAssertions();

        softAssertions.assertThat(ingredients.get(0))
                .as("Первый ингредиент должен быть перемещен на вторую позицию")
                .isEqualTo(mockIngredient2);

        softAssertions.assertThat(ingredients.get(1))
                .as("Второй ингредиент должен быть перемещен на первую позицию")
                .isEqualTo(mockIngredient1);

        softAssertions.assertAll();
    }

    @Test
    public void getPriceTest() {
        burger.addIngredient(mockIngredient1);
        burger.addIngredient(mockIngredient2);

        float expectedPrice = mockBun.getPrice() * 2 + mockIngredient1.getPrice() + mockIngredient2.getPrice();
        assertEquals("Цена должна быть равна цене булочки в два раза плюс цена ингредиентов", expectedPrice, burger.getPrice(), 0.01);
    }

    @Test
    public void getReceiptTest() {
        burger.addIngredient(mockIngredient1);
        burger.addIngredient(mockIngredient2);

        String expectedReceipt = String.format("(==== %s ====)%n= filling Lettuce =%n= sauce Ketchup =%n(==== %s ====)%n%nPrice: %f%n",
                mockBun.getName(), mockBun.getName(), burger.getPrice());

        assertEquals("Чек должен содержать правильное отображение ингредиентов и итоговую цену", expectedReceipt, burger.getReceipt());
    }
}
