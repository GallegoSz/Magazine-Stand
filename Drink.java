class Drink extends Products{
    private String type;

    public Drink(int cod, String name, String type) {
        super(cod, name);
        this.type = type;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
