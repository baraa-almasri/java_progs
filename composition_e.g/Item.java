package composition_e.g;

public class Item{

    private String name;
    private double price;

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
    ////


    public void setPrice(double price) {
        if(price > 0)
            this.price = price;
        else
            this.price = 0;
    }
    public double getPrice() {
        return price;
    }

    public Item(){
        this.name = "EMPTY";
        this.price = 0.0;
    }



    public Item(String n, double m){
        this.name = n;
        this.setPrice(m);
    }
    public String toString(){
        return ( "\n" + this.name + " | " + "$" + this.price);
    }


}