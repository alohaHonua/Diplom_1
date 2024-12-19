package praktikum;
import org.junit.Before;
import org.apache.commons.lang3.RandomStringUtils;

import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import java.util.List;
import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

public class IngredientTest {
    private String nameIngr;
    private float priceIngr;
    Ingredient ingredient;

    @Before
    public void setUp() {
        nameIngr = "TestNameIngredient_" + RandomStringUtils.randomAlphabetic(4);
        priceIngr = (float) (Math.random() * 300);
        priceIngr = Math.round(priceIngr * 100) / 100.0f; // Округление до сотых
        ingredient = new Ingredient(IngredientType.SAUCE, nameIngr, priceIngr);
    }

    @Test
    public void testIngredientGetName() {
        // Проверка что метод возвращает строку "Мяу"
        assertEquals(nameIngr, ingredient.getName());
        System.out.println(nameIngr);
    }

    @Test
    public void testIngredientGetPrice() {
        // Проверка что метод возвращает строку "Мяу"
        assertEquals(priceIngr, ingredient.getPrice(), 0.01f);
        System.out.println(priceIngr);
    }

    @Test
    public void testIngredientGetType() {
        // Проверка что метод возвращает строку "Мяу"
        assertEquals(IngredientType.SAUCE, ingredient.getType());
        System.out.println(IngredientType.SAUCE);
    }


}
