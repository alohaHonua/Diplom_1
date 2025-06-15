import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import praktikum.Bun;
import praktikum.Burger;
import praktikum.Ingredient;
import praktikum.IngredientType;
import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class BurgerGetReceiptTest {
        private Bun bun;
        private Ingredient[] ingredients;
        private String expectedReceipt;

        public BurgerGetReceiptTest(Bun bun, Ingredient[] ingredients, String expectedReceipt) {
            this.bun = bun;
            this.ingredients = ingredients;
            this. expectedReceipt = expectedReceipt;
        }

    @Parameterized.Parameters(name ="Bun, Ingredient, expectedReceipt")
    public static Object [][] data() {
            return new Object[][] {
                    {new Bun("black bun", 100f),
                         new Ingredient[]{
                            new Ingredient(IngredientType.FILLING, "cutlet", 100f),
                            new Ingredient(IngredientType.SAUCE, "hot sauce", 100f)},
                            "(==== black bun ====)"+ System.lineSeparator() +
                            "= filling cutlet =" + System.lineSeparator() +
                            "= sauce hot sauce =" + System.lineSeparator() +
                            "(==== black bun ====)" + System.lineSeparator() +
                                    System.lineSeparator() +
                            "Price: 400,000000" + System.lineSeparator()}, //проверка бургера с булочкой с соусом и начинкой
                    {new Bun("black bun", 100f),
                         new Ingredient[]{
                            new Ingredient(IngredientType.SAUCE, "hot sauce", 100f),
                            new Ingredient(IngredientType.SAUCE, "sour cream", 200f)},
                            "(==== black bun ====)" + System.lineSeparator() +
                            "= sauce hot sauce =" + System.lineSeparator() +
                            "= sauce sour cream =" + System.lineSeparator() +
                            "(==== black bun ====)" + System.lineSeparator() +
                                    System.lineSeparator() +
                            "Price: 500,000000" + System.lineSeparator()}, //проверка бургера с булочкой и двумя соусами
                    {new Bun("black bun", 100f),
                         new Ingredient[]{new Ingredient(IngredientType.FILLING, "cutlet", 100f)},
                            "(==== black bun ====)"+ System.lineSeparator() +
                            "= filling cutlet ="+ System.lineSeparator() +
                            "(==== black bun ====)"+ System.lineSeparator() +
                                    System.lineSeparator() +
                            "Price: 300,000000" + System.lineSeparator()}, //проверка бургера с булочкой с начинкой
                    {new Bun("black bun", 100f),
                            new Ingredient[]{},
                            "(==== black bun ====)"+ System.lineSeparator() +
                            "(==== black bun ====)"+ System.lineSeparator() +
                                    System.lineSeparator() +
                            "Price: 200,000000" + System.lineSeparator()} //проверка бургера с булочкой без ингредиентов
            };
    }

    @Test
    public void testGetReceiptForBurger() {
            Burger burger = new Burger();
            if (bun != null) {
                burger.setBuns(bun);
            }
            for (Ingredient ingredient:ingredients) {
                burger.addIngredient(ingredient);
    }
    String actualReceipt = burger.getReceipt();
        System.out.println("Expected:\n" + expectedReceipt);
        System.out.println("Actual:\n" + actualReceipt);
    assertEquals(expectedReceipt,actualReceipt);
    }

    @Test(expected = NullPointerException.class)
    public void shouldThrowNPEWhenBunIsNull() {
        new Burger().getReceipt();
    }
}