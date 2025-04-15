package praktikum;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import static org.junit.Assert.*;

@RunWith(Parameterized.class)
public class IngredientTest {

    private final IngredientType type;
    private final String name;
    private final float price;

    public IngredientTest(IngredientType type, String name, float price) {
        this.type = type;
        this.name = name;
        this.price = price;
    }

    @Parameterized.Parameters
    public static Object[][] getTestData() {
        return new Object[][] {
                {IngredientType.SAUCE, "Соус традиционный галактический", 15},
                {IngredientType.SAUCE, "Соус фирменный космический", 80},
                {IngredientType.SAUCE, "Соус с шипами Антарианского плоскоходца", 88},
                {IngredientType.FILLING, "Говяжий метеорит (отбивная)", 300},
                {IngredientType.FILLING, "Биокотлета из марсианской Магнолии", 424},
                {IngredientType.FILLING, "Филе Люминесцентного тетраодонтимформа", 988}
        };
    }

    @Test
    public void testGetPrice() {
        Ingredient ingredient = new Ingredient(type, name, price);
        assertEquals("Цена должна соответствовать значению из конструктора", price, ingredient.getPrice(), 0);
    }

    @Test
    public void testGetName() {
        Ingredient ingredient = new Ingredient(type, name, price);
        assertEquals("Название должно соответствовать значению из конструктора", name, ingredient.getName());
    }

    @Test
    public void testGetType() {
        Ingredient ingredient = new Ingredient(type, name, price);
        assertEquals("Тип должен соответствовать значению из конструктора", type, ingredient.getType());
    }

    @Test
    public void testConstructorInitializesFields() {
        Ingredient ingredient = new Ingredient(type, name, price);

        assertNotNull("Тип ингредиента не должен быть null", ingredient.getType());
        assertNotNull("Название ингредиента не должно быть null", ingredient.getName());
        assertTrue("Цена ингредиента должна быть >= 0", ingredient.getPrice() >= 0);
    }

    @Test
    public void testIngredientNamesAreCorrect() {
        Ingredient ingredient = new Ingredient(type, name, price);
        assertFalse("Название ингредиента не должно быть пустым", ingredient.getName().isEmpty());
        assertTrue("Название ингредиента должно начинаться с заглавной буквы",
                Character.isUpperCase(ingredient.getName().charAt(0)));
    }
}