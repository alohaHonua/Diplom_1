package praktikum;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.List;

import static org.junit.Assert.*;
import static praktikum.IngredientType.*;

@RunWith(Parameterized.class)
public class IngredientTest {
    private final IngredientType TYPE;
    private final String NAME;
    private final float PRICE;

    public IngredientTest (IngredientType type, String name, float price) {
        this.TYPE = type;
        this.NAME = name;
        this.PRICE = price;
    }

    @Parameterized.Parameters
    public static Object[][] getBuns() {
        return new Object[][] {
                {IngredientType.SAUCE, "hot sauce", 100 },
                {IngredientType.SAUCE, "sour cream", 200 },
                {IngredientType.SAUCE, "chili sauce", 300},

                {IngredientType.FILLING, "cutlet", 100},
                {IngredientType.FILLING, "dinosaur", 200},
                {IngredientType.FILLING, "sausage", 300},
        };
    }

    @Test
    public void checkGetPrice() {
        //Создаем ингредиент
        Ingredient ingredient = new Ingredient(TYPE, NAME, PRICE);
        //Проверяем, что полученная цена совпадает с ожидаемой
        assertEquals("Полученная цена ингредиента не совпадает с ожидаемой", PRICE, ingredient.getPrice(),0);
    }

    @Test
    public void checkGetName() {
        //Создаем ингредиент
        Ingredient ingredient = new Ingredient(TYPE, NAME, PRICE);
        //Проверяем, что полученное название совпадает с ожидаемым
        assertEquals("Полученное название ингредиента не совпадает с ожидаемым", NAME, ingredient.getName());

    }


    @Test
    public void checkGetType() {
        //Создаем ингредиент
        Ingredient ingredient = new Ingredient(TYPE, NAME, PRICE);
        //Проверяем, что полученный тип ингредиента совпадает с ожидаемым
        assertEquals("Полученный тип ингредиента не совпадает с ожидаемым", TYPE, ingredient.getType());

    }

}