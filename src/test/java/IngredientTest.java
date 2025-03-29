import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import praktikum.Ingredient;
import praktikum.IngredientType;

import static org.mockito.Mockito.when;
import static org.mockito.Mockito.verify;
import java.util.Arrays;
import java.util.Collection;


@RunWith(Parameterized.class)
public class IngredientTest {

    private final IngredientType type;
    private final String name;
    private final float price;

    @Mock
    private Ingredient ingredientMock;

    public IngredientTest(IngredientType type, String name, float price) {
        this.type = type;
        this.name = name;
        this.price = price;
    }

    @Parameterized.Parameters(name = "Тип ингредиента={0}, Название={1}, Цена={2}")
    public static Collection<Object[]> getTestData() {
        return Arrays.asList(new Object[][]{
                {IngredientType.SAUCE,   "BBQ Sauce",        2.5f},
                {IngredientType.FILLING, "Cheddar Cheese",   5.0f},
                {IngredientType.SAUCE,   "Garlic Sauce",     3.0f},
                {IngredientType.FILLING, "Grilled Chicken",  7.99f},
        });
    }

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void ingredientConstructorTest() {
        Ingredient realIngredient = new Ingredient(type, name, price);

        Assert.assertEquals("Некорректный тип ингредиента", type, realIngredient.getType());
        Assert.assertEquals("Некорректное имя ингредиента", name, realIngredient.getName());
        Assert.assertEquals("Некорректная цена ингредиента", price, realIngredient.getPrice(), 0.001f);
    }

    @Test
    public void getIngredientNameTest() {
        when(ingredientMock.getName()).thenReturn("Mocked Cheese");

        Assert.assertEquals("Неверное имя ингредиента", "Mocked Cheese", ingredientMock.getName());
        verify(ingredientMock).getName();
    }

    @Test
    public void getIngredientPriceTest() {
        when(ingredientMock.getPrice()).thenReturn(99.99f);

        Assert.assertEquals("Неверная цена ингредиента", 99.99f, ingredientMock.getPrice(), 0.0f);
        verify(ingredientMock).getPrice();
    }

    @Test
    public void getIngredientTypeTest() {
        when(ingredientMock.getType()).thenReturn(IngredientType.FILLING);

        Assert.assertEquals("Неверный тип ингредиента", IngredientType.FILLING, ingredientMock.getType());
        verify(ingredientMock).getType();
    }
}
