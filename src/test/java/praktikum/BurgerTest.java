package praktikum;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.*;

public class BurgerTest {
    
    private Burger burger;
    
    @Mock
    private Bun mockBun;
    
    @Mock
    private Ingredient mockIngredient1;
    
    @Mock
    private Ingredient mockIngredient2;
    
    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        burger = new Burger();
        
        // Настраиваем поведение моков
        when(mockBun.getName()).thenReturn("Тестовая булочка");
        when(mockBun.getPrice()).thenReturn(100.0f);
        
        when(mockIngredient1.getName()).thenReturn("Тестовый соус");
        when(mockIngredient1.getPrice()).thenReturn(50.0f);
        when(mockIngredient1.getType()).thenReturn(IngredientType.SAUCE);
        
        when(mockIngredient2.getName()).thenReturn("Тестовая начинка");
        when(mockIngredient2.getPrice()).thenReturn(150.0f);
        when(mockIngredient2.getType()).thenReturn(IngredientType.FILLING);
    }
    
    @Test
    public void setBunsSetsCorrectBun() {
        burger.setBuns(mockBun);
        assertEquals("Метод setBuns должен правильно устанавливать булочку",
                mockBun, burger.bun);
    }
    
    @Test
    public void addIngredientIncreasesListSize() {
        burger.addIngredient(mockIngredient1);
        assertEquals("Список ингредиентов должен содержать 1 элемент после добавления",
                1, burger.ingredients.size());
    }
    
    @Test
    public void addIngredientAddsCorrectElement() {
        burger.addIngredient(mockIngredient1);
        assertEquals("Добавленный ингредиент должен быть в списке",
                mockIngredient1, burger.ingredients.get(0));
    }
    
    @Test
    public void removeIngredientDecreasesListSize() {
        burger.addIngredient(mockIngredient1);
        burger.addIngredient(mockIngredient2);
        burger.removeIngredient(0);
        assertEquals("Список ингредиентов должен содержать 1 элемент после удаления",
                1, burger.ingredients.size());
    }
    
    @Test
    public void removeIngredientRemovesCorrectElement() {
        burger.addIngredient(mockIngredient1);
        burger.addIngredient(mockIngredient2);
        burger.removeIngredient(0);
        assertEquals("В списке должен остаться второй ингредиент",
                mockIngredient2, burger.ingredients.get(0));
    }
    
    @Test
    public void moveIngredientMovesFirstElementToSecondPosition() {
        burger.addIngredient(mockIngredient1);
        burger.addIngredient(mockIngredient2);
        burger.moveIngredient(0, 1);
        assertEquals("Вторым ингредиентом должен стать первый после перемещения",
                mockIngredient1, burger.ingredients.get(1));
    }
    
    @Test
    public void moveIngredientMovesSecondElementToFirstPosition() {
        burger.addIngredient(mockIngredient1);
        burger.addIngredient(mockIngredient2);
        burger.moveIngredient(0, 1);
        assertEquals("Первым ингредиентом должен стать второй после перемещения",
                mockIngredient2, burger.ingredients.get(0));
    }
    
    @Test
    public void getPriceCalculatesTotalPrice() {
        burger.setBuns(mockBun);
        burger.addIngredient(mockIngredient1);
        burger.addIngredient(mockIngredient2);
        float expectedPrice = 100.0f * 2 + 50.0f + 150.0f;
        float actualPrice = burger.getPrice();
        assertEquals("Метод getPrice должен правильно рассчитывать общую цену бургера",
                expectedPrice, actualPrice, 0.001f);
    }
    
    @Test
    public void getPriceCallsBunGetPrice() {
        burger.setBuns(mockBun);
        burger.getPrice();
        verify(mockBun, times(1)).getPrice();
    }
    
    @Test
    public void getPriceCallsIngredientGetPrice() {
        burger.setBuns(mockBun);
        burger.addIngredient(mockIngredient1);
        burger.addIngredient(mockIngredient2);
        burger.getPrice();
        verify(mockIngredient1, times(1)).getPrice();
        verify(mockIngredient2, times(1)).getPrice();
    }
    
    @Test
    public void getReceiptContainsBunName() {
        burger.setBuns(mockBun);
        String receipt = burger.getReceipt();
        assertTrue("Чек должен содержать название булочки",
                receipt.contains("Тестовая булочка"));
    }
    
    @Test
    public void getReceiptContainsSauceName() {
        burger.setBuns(mockBun);
        burger.addIngredient(mockIngredient1);
        String receipt = burger.getReceipt();
        assertTrue("Чек должен содержать название соуса",
                receipt.contains("Тестовый соус"));
    }
    
    @Test
    public void getReceiptContainsFillingName() {
        burger.setBuns(mockBun);
        burger.addIngredient(mockIngredient2);
        String receipt = burger.getReceipt();
        assertTrue("Чек должен содержать название начинки",
                receipt.contains("Тестовая начинка"));
    }
    
    @Test
    public void getReceiptContainsSauceType() {
        burger.setBuns(mockBun);
        burger.addIngredient(mockIngredient1);
        String receipt = burger.getReceipt();
        assertTrue("Чек должен содержать тип ингредиента sauce",
                receipt.contains("sauce"));
    }
    
    @Test
    public void getReceiptContainsFillingType() {
        burger.setBuns(mockBun);
        burger.addIngredient(mockIngredient2);
        String receipt = burger.getReceipt();
        assertTrue("Чек должен содержать тип ингредиента filling",
                receipt.contains("filling"));
    }
    
    @Test
    public void getReceiptContainsPrice() {
        burger.setBuns(mockBun);
        String receipt = burger.getReceipt();
        assertTrue("Чек должен содержать общую стоимость",
                receipt.contains("Price: "));
    }
    
    @Test
    public void getReceiptCallsBunGetName() {
        burger.setBuns(mockBun);
        burger.getReceipt();
        verify(mockBun, times(2)).getName();
    }
    
    @Test
    public void getReceiptCallsIngredientGetName() {
        burger.setBuns(mockBun);
        burger.addIngredient(mockIngredient1);
        burger.addIngredient(mockIngredient2);
        burger.getReceipt();
        verify(mockIngredient1, times(1)).getName();
        verify(mockIngredient2, times(1)).getName();
    }
    
    @Test
    public void getReceiptCallsIngredientGetType() {
        burger.setBuns(mockBun);
        burger.addIngredient(mockIngredient1);
        burger.addIngredient(mockIngredient2);
        burger.getReceipt();
        verify(mockIngredient1, times(1)).getType();
        verify(mockIngredient2, times(1)).getType();
    }
} 