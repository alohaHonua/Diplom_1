package praktikum;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import data.TestData;

@RunWith(MockitoJUnitRunner.class)
public class TestBurger {
	
	@Mock
	Bun bun;
	
	@Mock
	Ingredient ingredient;
	@Mock
	Ingredient ingr;

	@Test
	public void testAddIngridient() {
		Burger burger = new Burger();
		burger.addIngredient(ingredient);
		assertFalse(burger.ingredients.isEmpty());
	}
	
	@Test
	public void testRemoveIngridient() {
		Burger burger = new Burger();
		burger.addIngredient(ingredient);
		burger.removeIngredient(burger.ingredients.size()-1);
		assertTrue(burger.ingredients.isEmpty());
	}
	
	@Test
	public void testMoveIngridient() {
		Burger burger = new Burger();
		burger.addIngredient(ingredient);
		int firstIngredient = burger.ingredients.get(0).hashCode();
		burger.addIngredient(ingr);
        burger.moveIngredient(0, 1);
		assertEquals(firstIngredient, burger.ingredients.get(1).hashCode());
	}
	
	@Test
	public void testGetPrice() {
		Burger burger = new Burger();
		burger.addIngredient(ingredient);
		burger.setBuns(bun);
		Mockito.when(bun.getPrice()).thenReturn(TestData.PRICE);
		Mockito.when(ingredient.getPrice()).thenReturn(TestData.PRICE);
		assertEquals ((Float)(TestData.PRICE*(2+burger.ingredients.size())), (Float)burger.getPrice());
	}
	
	@Test
	public void testGetReciept() {
		Burger burger = new Burger();
		burger.setBuns(bun);
		burger.addIngredient(ingredient);
		Mockito.when(bun.getName()).thenReturn(TestData.BUN_NAME);
		Mockito.when(bun.getPrice()).thenReturn(TestData.PRICE);
		Mockito.when(ingredient.getType()).thenReturn(IngredientType.SAUCE);
		Mockito.when(ingredient.getName()).thenReturn(TestData.INGREDIENT_NAME);
		Mockito.when(ingredient.getPrice()).thenReturn(TestData.PRICE);
        assertEquals(TestData.RECIEPT, burger.getReceipt());
	}
	
	

}
