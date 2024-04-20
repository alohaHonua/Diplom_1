package praktikum;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.mockito.MockitoAnnotations;

@RunWith(Parameterized.class)
public class TestDatabaseBun {
    Database base = new Database();
    private final String name;
    private final float price;
    private final int index;
    
	public TestDatabaseBun(String name, float price, int index) {
		super();
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
	           {"black bun",100,0},
	           {"white bun",200,1},
	           {"red bun",300,2},
	   };
	} 
	

	@Test
	public void testBunName() {
	assertEquals(name, base.availableBuns().get(index).getName());
	}
	
	@Test
	public void testBunPrice() {
	assertEquals((Float)price, (Float)base.availableBuns().get(index).getPrice());
	}

}
