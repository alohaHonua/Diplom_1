package praktikum;

import java.util.List;
import static org.junit.Assert.*;

@RunWith(MockitoJunitRunner.class)
public class BunTest {
    private final String EXPECTED_BUNS_NAME; //что с ним?
    private final float EXPECTED_BUNS_PRICE; //а с этим что?

    @Mock
    Database database;

    //Проверка получения имени булочки
    @Test
    public void checkGetName() {
        EXPECTED_BUNS_NAME = "black bun";
        List<Bun> buns = database.availableBuns();
        Bun bun = buns.get(0);
        String BunsName = bun.getName();
        assertThat("Полученное название булки не совпадает с ожидаемым", BunsName, EXPECTED_BUNS_NAME);

    }

    //Проверка получения цены булочки
    @Test
    public void checkGetPrice() {
        EXPECTED_BUNS_PRICE = 100;
        List<Bun> buns = database.availableBuns();
        Bun bun = buns.get(0);
        float BunsPrice = bun.getPrice();
        assertThat("Полученная цена булочки не совпадает с ожидаемой", BunsPrice, EXPECTED_BUNS_PRICE);
    }
}