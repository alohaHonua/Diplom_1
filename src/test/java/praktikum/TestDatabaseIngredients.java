package praktikum;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.mockito.MockitoAnnotations;

@RunWith(Parameterized.class)
public class TestDatabaseIngredients {
    Database base = new Database();
    private final IngredientType type;
    private final String name;
    private final float price;
    private final int index;

	public TestDatabaseIngredients(IngredientType type, String name, float price, int index) {
		super();
		this.type = type;
		this.name = name;
		this.price = price;
		this.index = index;
	}

	@Before
    public void init() {
        MockitoAnnotations.initMocks(this);
    }
    
	@Parameterized.Parameters
	public static Object[][] testAnimalsParam() {
	   return new Object[][] {
	           {IngredientType.SAUCE, "hot sauce", 100, 0},
	           {IngredientType.SAUCE, "sour cream", 200, 1},
	           {IngredientType.SAUCE, "chili sauce", 300, 2},
	           {IngredientType.FILLING, "cutlet", 100, 3},
	           {IngredientType.FILLING, "dinosaur", 200, 4},
	           {IngredientType.FILLING, "sausage", 300, 5},
	   };
	} 
	
	@Test
	public void testIngredientsType() {
	assertEquals(type, base.availableIngredients().get(index).getType());
	}
	
	@Test
	public void testIngredientsName() {
	assertEquals(name, base.availableIngredients().get(index).getName());
	}
	
	@Test
	public void testIngrediwntsPrice() {
	assertEquals((Float)price, (Float)base.availableIngredients().get(index).getPrice());
	}

}
