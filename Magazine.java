class Magazine extends Products{
    private String publisher;

    public Magazine(String name, String publisher, double price) {
        super(name, price);
        this.publisher = publisher;
        setPrice(price);
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }
}