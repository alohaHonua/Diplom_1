package praktikum;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import static praktikum.IngredientType.FILLING;
import static praktikum.IngredientType.SAUCE;

@RunWith(Parameterized.class)
public class IngredientParameterizedTest {
    private final IngredientType type;
    private final String name;
    private final float price;

    public IngredientParameterizedTest(IngredientType type, String name, float price) {
        this.type = type;
        this.name = name;
        this.price = price;
    }
    @Parameterized.Parameters
    public static Object[][] getParameters() {
        return new Object[][]{
                {SAUCE, "Соус Spicy-X",90.0f},
                {SAUCE, "Соус фирменный Space Sauce", 80.0f},
                {SAUCE, "Соус традиционный галактический", 15.0f},
                {SAUCE, "Соус с шипами Антарианского плоскоходца", 88.0f},
                {FILLING, "Мясо бессмертных моллюсков Protostomia", 1337.0f},
                {FILLING, "Говяжий метеорит (отбивная)", 3000.0f},
                {FILLING, "Биокотлета из марсианской Магнолии", 424.0f},
                {FILLING, "Филе Люминесцентного тетраодонтимформа", 988.0f},
                {FILLING, "Хрустящие минеральные кольца", 300.0f},
                {FILLING, "Плоды Фалленианского дерева", 874.0f},
                {FILLING, "Кристаллы марсианских альфа-сахаридов", 762.0f},
                {FILLING, "Мини-салат Экзо-Плантаго", 4400.0f},
                {FILLING, "Сыр с астероидной плесенью", 4142f}
        };
    }
    @Test
    public void testPriceIngredient() {
        Ingredient ingredient = new Ingredient(type, name, price);
        Assert.assertEquals(price, ingredient.getPrice(), 0.0f);
    }
    @Test
    public void testNameIngredient() {
        Ingredient ingredient = new Ingredient(type, name, price);
        Assert.assertEquals(name, ingredient.getName());
    }
    @Test
    public void testTypeIngredient() {
        Ingredient ingredient = new Ingredient(type, name, price);
        Assert.assertEquals(type, ingredient.getType());

    }
}
