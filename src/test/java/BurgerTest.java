import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.assertj.core.api.SoftAssertions;
import praktikum.*;



@RunWith(MockitoJUnitRunner.class)
public class BurgerTest {

    private Burger burger;
    private Database database;
    private SoftAssertions softAssertions;

    @Mock
    private Bun mockBun;
    private Ingredient mockSauce;
    private Ingredient mockFilling;
    private Ingredient mockIngredient1;
    private Ingredient mockIngredient2;

    @Before
    public void setUp() {
        burger = new Burger();
        database = new Database(); // Инициализируем базу данных с булочками и ингредиентами
        softAssertions = new SoftAssertions();
    }

    @Test
    public void testSetBuns() {
        mockBun = database.availableBuns().get(1); // Используем белую булочку из базы данных

        burger.setBuns(mockBun);

        softAssertions.assertThat(burger.bun.getName())
                .as("Метод setBuns() устанавливает правильное имя булочки")
                .isEqualTo("white bun");
        softAssertions.assertThat(burger.bun.getPrice())
                .as("Метод setBuns() устанавливает правильную цену булочки")
                .isEqualTo(200f);
    }

    @Test
    public void testAddIngredient() {
        mockSauce = database.availableIngredients().get(1); // Используем "sour cream" из базы данных

        burger.setBuns(database.availableBuns().get(1)); // Устанавливаем белую булочку
        burger.addIngredient(mockSauce);

        softAssertions.assertThat(burger.ingredients.size())
                .as("Метод addIngredient() добавляет ингредиент в список")
                .isEqualTo(1);
        softAssertions.assertThat(burger.ingredients.get(0).getName())
                .as("Метод addIngredient() добавляет правильный ингредиент")
                .isEqualTo("sour cream");
    }

    @Test
    public void testRemoveIngredient() {
        burger.setBuns(database.availableBuns().get(1)); // Устанавливаем белую булочку
        mockSauce = database.availableIngredients().get(1); // Используем "sour cream"
        mockFilling = database.availableIngredients().get(3); // Используем "cutlet"

        burger.addIngredient(mockSauce);
        burger.addIngredient(mockFilling);

        burger.removeIngredient(0);

        softAssertions.assertThat(burger.ingredients.size())
                .as("Метод removeIngredient() корректно удаляет ингредиент")
                .isEqualTo(1);
    }

    @Test
    public void testMoveIngredient() {
        mockIngredient1 = database.availableIngredients().get(1); // "sour cream"
        mockIngredient2 = database.availableIngredients().get(0); // "hot sauce"

        burger.setBuns(database.availableBuns().get(1)); // Устанавливаем белую булочку
        burger.addIngredient(mockIngredient1);
        burger.addIngredient(mockIngredient2);

        burger.moveIngredient(0, 1); // Перемещение первого ингредиента на вторую позицию

        softAssertions.assertThat(burger.ingredients.get(0).getName())
                .as("Метод moveIngredient() перемещает ингредиенты")
                .isEqualTo("hot sauce");
        softAssertions.assertThat(burger.ingredients.get(1).getName())
                .as("Метод moveIngredient() корректно обновляет список ингредиентов")
                .isEqualTo("sour cream");
    }

    @Test
    public void testGetPrice() {
        burger.setBuns(database.availableBuns().get(1)); // Устанавливаем белую булочку
        mockSauce = database.availableIngredients().get(1); // "sour cream"

        burger.addIngredient(mockSauce);
        burger.addIngredient(mockSauce); // Добавляем второй ингредиент

        float price = burger.getPrice();

        // Ожидаем, что цена будет складываться: 2 * цена булочки + 2 * цена соуса
        softAssertions.assertThat(price)
                .as("Метод getPrice() корректно считает общую цену")
                .isEqualTo(800f);
    }

    @Test
    public void testGetReceipt() {
        // Устанавливаем булочку
        Bun mockBun = database.availableBuns().get(1); // "white bun" с ценой 200
        burger.setBuns(mockBun);

        // Создаем ингредиенты
        Ingredient mockSauce = database.availableIngredients().get(1); // "sour cream" с ценой 200
        burger.addIngredient(mockSauce);
        burger.addIngredient(mockSauce); // Добавляем второй соус

        String expectedReceipt = "(==== white bun ====)\r\n" +
                "= sauce sour cream =\r\n" +
                "= sauce sour cream =\r\n" +
                "(==== white bun ====)\r\n" +
                "Price: 800,0\r\n";

        // Получаем фактический чек
        String actualReceipt = burger.getReceipt();
        // Проверяем, что фактический чек соответствует ожидаемому
        Assert.assertEquals(expectedReceipt, actualReceipt);
    }

    @After
    public void tearDown() {

        softAssertions.assertAll();
    }
}
