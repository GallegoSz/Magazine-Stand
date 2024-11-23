class Drink extends Products{
    private String type;

    public Drink(String name, String type, double price) {
        super(name, price);
        this.type = type;
        setPrice(price);
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
