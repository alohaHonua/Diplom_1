package praktikum.enums;

public enum Buns {
    FLU_BUN("Флюоресцентная булка R2-D3", 988.0f),
    CRATOR_BUN("Краторная булка N-200i", 1255.0f);
    private final String name;
    private final Float price;

    Buns(String name, Float price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {return name;}
    public Float getPrice() {return price;}
}
