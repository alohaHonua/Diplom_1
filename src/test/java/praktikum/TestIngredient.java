package praktikum;

import static org.junit.Assert.*;

import org.junit.Test;

import data.TestData;

public class TestIngredient {
	Ingredient ingredient= new Ingredient(IngredientType.SAUCE, TestData.INGREDIENT_NAME, TestData.PRICE);

	@Test
	public void testGetIngredientType() {
		assertEquals(IngredientType.SAUCE, ingredient.getType());
	}
	
	@Test
	public void testGetName() {
		assertEquals(TestData.INGREDIENT_NAME, ingredient.getName());
	}
 	
	@Test
	public void testGetPrice() {
		assertEquals((Float)TestData.PRICE, (Float)ingredient.getPrice());
		}

}
