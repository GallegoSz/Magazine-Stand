class Candy extends Products {
    private String brand;

    public Candy(String name, String brand, double price) {
        super(name, price);
        this.brand = brand;
        setPrice(price);
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }
}
