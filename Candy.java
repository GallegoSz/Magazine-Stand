class Candy extends Products {
    private String brand;

    public Candy(int cod, String name, String brand) {
        super(cod, name);
        this.brand = brand;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }
}
