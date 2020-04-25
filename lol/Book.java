package lol;

public class Book {
    private String name;
    private Author author;
    private double price;
    private int quantity;

    public Book(Author author, String name, double price, int quantity){
        setAuthor(author);
        setName(name);
        setPrice(price);
        setQuantity(quantity);
    }

    /////
    public void setAuthor(Author author){
        this.author = author;
    }
    public Author getAuthor() {
        return author;
    }
    ////
    public void setName(String name) {
        this.name = name;
    }
    public String getName() {
        return this.name;
    }
    ////
    public void setPrice(double price) {
        this.price = price;
    }
    public double getPrice() {
        return this.price;
    }
    ////
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
    public int getQuantity() {
        return quantity;
    }
    ////
    public String toString(){
        return ("Author Name: " + this.name + "\nPrice: " + this.price + "\nQuantity: " + this.quantity + "\nAuthor Ditails: " + this.author + "\n");
    }

}
