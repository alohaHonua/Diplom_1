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
        String s = burgerStub.getReceipt();
        assertEquals(s, burgerStub.getReceipt());
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
        Ingredient I = burgerStub.ingredients.get(0);
        burgerStub.moveIngredient(0, 1);
        assertEquals(I, burgerStub.ingredients.get(1));
    }
    @Test
    public void getPrice() {
        float price = burgerStub.getPrice();
        assertEquals(price,burgerStub.getPrice(),0.0f);
    }
}
