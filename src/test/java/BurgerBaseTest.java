import org.junit.Before;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import praktikum.Bun;
import praktikum.Burger;
import praktikum.Ingredient;

public class BurgerBaseTest {
    protected Burger burger;

    @Mock
    protected Bun bun;

    @Mock
    protected Ingredient ingredient1;

    @Mock
    protected Ingredient ingredient2;

    @Before
    public void setUp() {
        MockitoAnnotations.openMocks(this);
        burger = new Burger();
    }
}