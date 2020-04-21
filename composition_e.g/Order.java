package composition_e.g;
public class Order{

    private int orderID;
    private Item PurchasedItem ;

    public Order(int id, Item p){
        this.orderID = id;
        this.PurchasedItem = p;
    }
    public Order(){
        this.orderID = 0;
        this.PurchasedItem = null;
    }
    public String toString(){
        return ("OderID: " + (orderID) + PurchasedItem );
    }

}