class Magazine extends Products{
    private String publisher;

    public Magazine(int cod, String name, String publisher) {
        super(cod, name);
        this.publisher = publisher;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }
}