package praktikum;

/**
 * Перечисление с типами ингредиентов.
 * SAUCE – соус
 * FILLING – начинка
 */
public enum IngredientType implements IIngredientType {
    SAUCE,
    FILLING;

    @Override
    public IIngredientType getType() {
        return null;
    }
}