package com.example;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class BurgerTest {

    private Burger burger;

    @Mock
    private Bun mockBun;

    @Mock
    private Ingredient mockIngredientSauce;

    @Mock
    private Ingredient mockIngredientFilling;

    float bunPrice = 100.0f;
    float IngredientSaucePrice = 10.0f;

    @BeforeEach
    public void setUp() {
        burger = new Burger();
    }

    @Test
    public void testSetBuns() {
        burger.setBuns(mockBun);

        assertEquals(mockBun, burger.bun);
    }

    @Test
    public void testAddIngredient() {
        burger.addIngredient(mockIngredientSauce);

        assertTrue(burger.ingredients.contains(mockIngredientSauce),
                String.format("Ингредиент %s должен быть в бургере.", mockIngredientSauce.getName()));
    }

    @Test
    public void testRemoveIngredient() {
        burger.addIngredient(mockIngredientSauce);

        burger.removeIngredient(0);

        assertFalse(burger.ingredients.contains(mockIngredientSauce),
                String.format("Ингредиента %s не должно быть в бургере.", mockIngredientSauce.getName()));
    }

    @Test
    public void testMoveIngredient() {
        burger.addIngredient(mockIngredientSauce);
        burger.addIngredient(mockIngredientFilling);

        burger.moveIngredient(0, 1);

        assertEquals(mockIngredientSauce, burger.ingredients.get(1), "Ингредиент должен быть в позиции 1");
        assertEquals(mockIngredientFilling, burger.ingredients.get(0), "Ингредиент должен быть в позиции 0.");
    }

    @Test
    public void testGetPrice() {
        float IngredientFillingPrice = 20.0f;
        float expectedPrice = bunPrice * 2 + IngredientFillingPrice + IngredientSaucePrice;

        when(mockBun.getPrice()).thenReturn(bunPrice);
        when(mockIngredientSauce.getPrice()).thenReturn(IngredientSaucePrice);
        when(mockIngredientFilling.getPrice()).thenReturn(IngredientFillingPrice);

        burger.setBuns(mockBun);
        burger.addIngredient(mockIngredientSauce);
        burger.addIngredient(mockIngredientFilling);

        float actualPrice = burger.getPrice();

        Mockito.verify(mockBun, Mockito.times(1)).getPrice();
        assertEquals(expectedPrice, actualPrice,
                String.format("Цена должна быть %f, а не %f", expectedPrice, actualPrice));
    }

    @Test
    public void testGetReceipt() {
        String expectedReceipt = String.format("(==== %s ====)%n", "bun") +
                String.format("= %s %s =%n", "sauce", "ketchup") +
                String.format("(==== %s ====)%n", "bun") +
                String.format("%nPrice: %f%n", 210.0f);

        when(mockBun.getName()).thenReturn("bun");
        when(mockBun.getPrice()).thenReturn(this.bunPrice);
        when(mockIngredientSauce.getName()).thenReturn("ketchup");
        when(mockIngredientSauce.getType()).thenReturn(IngredientType.SAUCE);
        when(mockIngredientSauce.getPrice()).thenReturn(this.IngredientSaucePrice);

        burger.setBuns(mockBun);
        burger.addIngredient(mockIngredientSauce);

        String actualReceipt = burger.getReceipt();

        assertEquals(expectedReceipt, actualReceipt);
    }
}