import org.junit.Test;
import praktikum.Bun;
import praktikum.Database;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;


public class DatabaseTest {

    List<String> expectedBunsName = List.of("black bun", "white bun", "red bun");
    List<Float> expectedBunsPrice = List.of(100.00F, 200.00F, 300.00F);

    @Test
    public void availableBunsTest(){
        Database database = new Database();
        List<Bun> availableBuns = database.availableBuns();
        List<String> actualBunsName = new ArrayList<>();
        List<Float> actualBunsPrice = new ArrayList<>();
        for( Bun bun: availableBuns){
            actualBunsName.add(bun.getName());
            actualBunsPrice.add(bun.getPrice());
        }
        assertEquals(expectedBunsPrice, actualBunsPrice);
        assertEquals(expectedBunsName, actualBunsName);
    }
}
