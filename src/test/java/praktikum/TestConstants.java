package praktikum;

public class TestConstants {
    public static final float BUN_PRICE = 100f;
    public static final float INGREDIENT1_PRICE = 50f;
    public static final float INGREDIENT2_PRICE = 75f;
    public static final float EXPECTED_PRICE = BUN_PRICE * 2 + INGREDIENT1_PRICE + INGREDIENT2_PRICE;
    public static final float DELTA = 0.01f;
    public static final int FIRST_INDEX = 0;
    public static final int SECOND_INDEX = 1;
    public static final int INVALID_INDEX = 5;
    public static final String BUN_NAME = "black bun";
    public static final String EXPECTED_RECEIPT = "(==== black bun ====)\n(==== black bun ====)\n\nPrice: 200.00\n";
}
