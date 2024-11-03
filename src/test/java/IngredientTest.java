import org.junit.Test;
import praktikum.Ingredient;
import praktikum.IngredientType;

import static org.junit.Assert.*;

public class IngredientTest {
    @Test//Проверяем что конструктор верно присваивает тип, имя и цену ингредиенту
    public void testConstructorSetsFieldsCorrectly(){
        //Создаем объект Ingredient c тестовым именем
        Ingredient ingredient = new Ingredient(IngredientType.FILLING, "Мясо бессмертных моллюсков Protostomia", 1337 );

        //Проверяем, что тип ингредиента присвоен верно
        assertEquals(IngredientType.FILLING, ingredient.getType());

        //Проверяем, что имя ингредиента присвоено верно
        assertEquals("Мясо бессмертных моллюсков Protostomia", ingredient.getName());

        //Проверяем, что цена ингредиента присвоена верно
        assertEquals(1337, ingredient.getPrice(), 0.0f);
    }

    @Test//Проверяем, что тип ингредиента присваивается верно
    public void testGetTypeReturnCorrectValue(){
        //Создаем объект с тестовым типом
        Ingredient ingredient = new Ingredient(IngredientType.SAUCE, "Spicy-X", 90);

        //Проверяем, что тип ингредиента присвоен верно
        assertEquals(IngredientType.SAUCE, ingredient.getType());
    }

    @Test//Проверяем, что название ингредиента присваивается верно
    public void testGetNameReturnCorrectValue(){
        //Создаем объект c тестовым именем
        Ingredient ingredient = new Ingredient(IngredientType.FILLING, "Говяжий метеорит (отбивная)", 3000);

        //Проверяем, что название ингредиента присвоено верно
        assertEquals("Говяжий метеорит (отбивная)", ingredient.getName());
    }

    @Test//Проверяем, что цена ингредиента присваивается верно
    public void testGetPriceReturnCorrectValue(){
        //Создаем объект с тестовой ценой
        Ingredient ingredient = new Ingredient(IngredientType.FILLING, "Сыр с астероидной плесенью", 4142);

        //Проверяем, что цена ингредиента присваивается верно
        assertEquals(4142, ingredient.getPrice(), 0.0f);
    }
}
