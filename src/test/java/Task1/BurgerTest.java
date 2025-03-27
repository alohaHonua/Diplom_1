package Task1;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;
import praktikum.Bun;
import praktikum.Burger;
import praktikum.Ingredient;
import praktikum.IngredientType;

import static org.junit.Assert.assertEquals;

@RunWith(MockitoJUnitRunner.class)
public class BurgerTest {
    private final Burger burgerStub= new Burger();
    @Before
    public void setUp() {
        burgerStub.setBuns(new Bun("black bun", 100));
        burgerStub.addIngredient(new Ingredient(IngredientType.SAUCE, "hot sauce", 100));
        burgerStub.addIngredient(new Ingredient(IngredientType.FILLING, "hot sauce", 100));
    }
    @Test
    public void getReceiptTest() {
        // Создаем ожидаемый формат чека на основе текущего состояния burgerStub
        String expectedReceipt = String.format("(==== %s ====)%n", "black bun") +
                "= sauce hot sauce =\r\n" +
                "= filling hot sauce =\r\n" +
                String.format("(==== %s ====)%n", "black bun") +
                String.format("%nPrice: %.6f%n", burgerStub.getPrice());

        String actualReceipt = burgerStub.getReceipt();
        assertEquals(expectedReceipt, actualReceipt);
    }

    @Test
    public void setBuns() {
        Bun bun = new Bun("black bun", 100);
        burgerStub.setBuns(bun);
        assertEquals(bun, burgerStub.bun);
    }
    @Test
    public void addIngredient() {
        Ingredient I = new Ingredient(IngredientType.SAUCE, "hot sauce", 100);
        burgerStub.addIngredient(I);
        assertEquals(I, burgerStub.ingredients.get(burgerStub.ingredients.size() - 1));
    }
    @Test
    public void removeIngredient() {
        int size = burgerStub.ingredients.size();
        burgerStub.removeIngredient(0);
        assertEquals(size-1, burgerStub.ingredients.size());
    }
    @Test
    public void moveIngredient() {
        Ingredient firstIngredient = burgerStub.ingredients.get(0);
        Ingredient secondIngredient = burgerStub.ingredients.get(1);

        burgerStub.moveIngredient(0, 1);

        // Проверяем, что элементы поменялись местами
        assertEquals(firstIngredient, burgerStub.ingredients.get(1));
        assertEquals(secondIngredient, burgerStub.ingredients.get(0));
    }
    // Проверка, что цена считается корректно
    @Test
    public void getPrice() {
        float expectedPrice = 2 * burgerStub.bun.getPrice() +
                burgerStub.ingredients.get(0).getPrice() +
                burgerStub.ingredients.get(1).getPrice();

        float actualPrice = burgerStub.getPrice();
        assertEquals(expectedPrice, actualPrice, 0.0f);
    }
}