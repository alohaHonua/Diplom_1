package praktikum.enums;

import praktikum.IngredientType;

public enum Ingredients {
    SAUCE_SPICY(IngredientType.SAUCE, "Coус Spicy-X", 90.0f),
    SAUCE_SPACE(IngredientType.SAUCE, "Соус фирменный Space Sauce", 80.0f),
    FILLING_BEEF(IngredientType.FILLING, "Говяжий метеорит (отбивная)", 3000.0f),
    FILLING_MARS(IngredientType.FILLING, "Биокотлета из марсианской Магнолии", 424.0f);

    private final IngredientType type;
    private final String name;
    private final Float price;

    Ingredients(IngredientType type, String name, Float price) {
        this.type = type;
        this.name = name;
        this.price = price;
    }

    public IngredientType getType() {return type;}
    public String getName() {return name;}
    public Float getPrice() {return price;}
}
