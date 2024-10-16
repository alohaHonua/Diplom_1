package praktikum;

public class TestConstants {
    public static final float BLACK_BUN_PRICE = 100f;
    public static final String BLACK_BUN_NAME = "black bun";

    public static final float WHITE_BUN_PRICE = 200f;
    public static final String WHITE_BUN_NAME = "White Bun";

    public static final float INGREDIENT1_PRICE = 100f;
    public static final String INGREDIENT1_NAME = "hot sauce";
    public static final IngredientType INGREDIENT1_TYPE = IngredientType.SAUCE;

    public static final float INGREDIENT2_PRICE = 200f;
    public static final String INGREDIENT2_NAME = "cutlet";
    public static final IngredientType INGREDIENT2_TYPE = IngredientType.FILLING;

    public static final float INGREDIENT3_PRICE = 300f;
    public static final String INGREDIENT3_NAME = "sausage";
    public static final IngredientType INGREDIENT3_TYPE = IngredientType.FILLING;


    public static final float EXPECTED_PRICE_WITHOUT_INGREDIENTS = BLACK_BUN_PRICE * 2;
    public static final float EXPECTED_PRICE_WITH_1INGREDIENT = BLACK_BUN_PRICE * 2 + INGREDIENT3_PRICE;
    public static final float EXPECTED_PRICE_WITH_2INGREDIENTS = BLACK_BUN_PRICE * 2 + INGREDIENT1_PRICE + INGREDIENT2_PRICE;

    public static final float DELTA = 0.01f;

    public static final int FIRST_INDEX = 0;
    public static final int SECOND_INDEX = 1;
    public static final int INVALID_INDEX = 5;

    public static final int EXPECTED_INGREDIENTS_COUNT = 1; // Для теста с одним ингредиентом
    public static final int EMPTY_INGREDIENTS_COUNT = 0; // Для теста с пустым списком ингредиентов
    public static final int EXPECTED_INGREDIENTS_COUNT_AFTER_REMOVAL = 1; // Количество ингредиентов после удаления

    public static final String EXPECTED_RECEIPT_WITHOUT_INGREDIENTS = "(==== black bun ====)\n(==== black bun ====)\n\nPrice: 200.000000\n";
    public static final String EXPECTED_RECEIPT_WITH_INGREDIENT =     "(==== black bun ====)\n= filling cutlet =\n(==== black bun ====)\n\nPrice: 400.000000\n";

    // Цена для теста с отрицательной ценой ингредиента
    public static final float INVALID_PRICE = -10f;
    // Пустое имя ингредиента для негативного теста
    public static final String EMPTY_INGREDIENT_NAME = "";
}