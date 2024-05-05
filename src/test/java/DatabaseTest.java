import org.junit.Before;
import org.junit.Test;
import praktikum.Database;

public class DatabaseTest {
    private Database database;

    @Before
    public void init() {
        database = new Database();
    }

    @Test
    //Проверка, что при запросе доступных булочек не выпадает ошибка
    public void bunsTest() {
        database.availableBuns();
    }

    @Test
    //Проверка, что при запросе доступных ингредиентов не выпадает ошибка
    public void ingredientsTest() {
        database.availableIngredients();
    }

}
