package praktikum;

import static org.junit.Assert.*;

import org.junit.Test;

import data.TestData;


public class TestBun {
	
	Bun bun = new Bun(TestData.BUN_NAME, TestData.PRICE);

	@Test
	public void testGetName() {
		assertEquals(TestData.BUN_NAME, bun.getName());
	}
	
	@Test
	public void testGetPrice() {
		assertEquals((Float)TestData.PRICE, (Float)bun.getPrice());
		}

}
