package praktikum;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class BurgerParametrizedTest {

    //параметры булочку
    private final String nameBun;
    private final float priceBun;
    //параметры ингредиента
    private final IngredientType typeIngr;
    private final String nameIngr;
    private final float priceIngr;

    public BurgerParametrizedTest(String nameBun, float priceBun, IngredientType typeIngr, String nameIngr, float priceIngr) {
        this.nameBun = nameBun;
        this.priceBun = priceBun;
        this.typeIngr = typeIngr;
        this.nameIngr = nameIngr;
        this.priceIngr = priceIngr;
    }

    @Parameterized.Parameters(name = "nameBun = {0}, priceBun = {1}, typeIngr = {2}, nameIngr = {3},priceIngr = {4}")
    public static Object[][] data(){
        return new Object[][]{
                {"Black", 100F, IngredientType.SAUCE, "BBQ", 45F},
                {"White", 200F, IngredientType.FILLING, "cutlet", 100F}
        };
    }

    @Test
    public void checkGetReceipt() {
        Burger burger = new Burger();//создаем бургер
        Bun bun = new Bun(nameBun, priceBun);//создаем булочку
        Ingredient ingredient = new Ingredient(typeIngr, nameIngr, priceIngr);//создаем ингредиент
        burger.setBuns(bun);//добавляем булочку в бургер
        burger.addIngredient(ingredient);//добавляем ингредиент в бургер

        String expectedReceipt = String.format("(==== %s ====)%n", bun.getName()) + String.format("= %s %s =%n", ingredient.getType().toString().toLowerCase(),
                ingredient.getName()) +
                String.format("(==== %s ====)%n", bun.getName()) +
                String.format("%nPrice: %f%n", burger.getPrice());
        String actualReceipt = burger.getReceipt();
        assertEquals("Ожидаемый чек не совпадает с фактическим", expectedReceipt, actualReceipt);

    }
}
