public abstract class Products {
    private int cod;
    private String name;
    private double price;
    private int stock;

    public Products(int cod, String name) {
        this.cod = cod;
        this.name = name;
    }

    public int getCod() {
        return cod;
    }

    public void setCod(int cod) {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getStoke() {
        return stock;
    }

    public void putInStock(int amount) {
        stock = stock + amount;
    }

    public void takeOutOfStoke(int amount) {
        while (true) {
            if (amount > stock) {
                System.out.println("Error, you cannot take a quantity of products that is greater " +
                        "than the quantity currently in stock");
            } else break;
        }
        stock = stock - amount;
    }
}
